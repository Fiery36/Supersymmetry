#!/usr/bin/env python3
import os
import re
import subprocess
import toml
import json
from collections import defaultdict

# Find the latest tag (excluding "latest")
def get_latest_tag():
    tags = subprocess.check_output(["git", "tag", "-l", "--sort=-v:refname"]).decode().strip().split("\n")
    for tag in tags:
        if tag != "latest":
            return tag
    return None

# Get mod details from toml file
def parse_mod_file(file_path):
    try:
        data = toml.load(file_path)
        name = data.get("name", "Unknown")
        filename = data.get("filename", "")
        
        # Extract version from filename
        version_match = re.search(r"-([^-]+(?:-[^-]+)*?)\.jar$", filename)
        version = version_match.group(1) if version_match else "Unknown"
        
        return {
            "name": name,
            "version": version
        }
    except Exception as e:
        print(f"Error parsing {file_path}: {e}")
        return None

# Get all mods in a specific git reference
def get_mods_at_ref(ref):
    result = {}
    try:
        # Get list of mod files at the specific ref
        mod_files = subprocess.check_output(
            ["git", "ls-tree", "-r", "--name-only", ref, "mods/"], 
            stderr=subprocess.DEVNULL
        ).decode().strip().split("\n")
        
        for file_path in mod_files:
            if not file_path.endswith(".toml"):
                continue
                
            # Get file content at ref
            file_content = subprocess.check_output(
                ["git", "show", f"{ref}:{file_path}"]
            ).decode()
            
            # Write to temp file for toml parsing
            temp_file = f"/tmp/{os.path.basename(file_path)}"
            with open(temp_file, "w") as f:
                f.write(file_content)
                
            mod_info = parse_mod_file(temp_file)
            if mod_info:
                result[os.path.basename(file_path)] = mod_info
                
            # Clean up temp file
            os.remove(temp_file)
    except subprocess.CalledProcessError:
        print(f"Error getting mod files at ref {ref}")
    
    return result

# Get current mods
def get_current_mods():
    result = {}
    for file_name in os.listdir("mods"):
        if file_name.endswith(".toml"):
            mod_info = parse_mod_file(os.path.join("mods", file_name))
            if mod_info:
                result[file_name] = mod_info
    return result

# Generate changelog
def generate_changelog():
    tag = get_latest_tag()
    if not tag:
        print("No tags found excluding 'latest'")
        return "No previous tag found to compare against."
    
    print(f"Found latest tag: {tag}")
    
    # Get mods at the tag and current state
    tag_mods = get_mods_at_ref(tag)
    current_mods = get_current_mods()
    
    # Compare mods
    changes = {
        "updates": [],
        "additions": [],
        "removals": []
    }
    
    # Find updates and additions
    for file_name, current_mod in current_mods.items():
        if file_name in tag_mods:
            # Mod exists in both - check if version changed
            if current_mod["version"] != tag_mods[file_name]["version"]:
                changes["updates"].append({
                    "name": current_mod["name"],
                    "old_version": tag_mods[file_name]["version"],
                    "new_version": current_mod["version"]
                })
        else:
            # Mod exists only in current - it's an addition
            changes["additions"].append({
                "name": current_mod["name"],
                "version": current_mod["version"]
            })
    
    # Find removals
    for file_name, tag_mod in tag_mods.items():
        if file_name not in current_mods:
            changes["removals"].append({
                "name": tag_mod["name"]
            })
    
    # Generate markdown
    markdown = "## Mod Changes\n\n"
    
    if changes["updates"]:
        markdown += "### Mod Updates\n"
        for update in changes["updates"]:
            markdown += f"* {update['name']} {update['old_version']} -> {update['new_version']}\n"
        markdown += "\n"
    
    if changes["additions"]:
        markdown += "### Mod Additions\n"
        for addition in changes["additions"]:
            markdown += f"* {addition['name']} -> {addition['version']}\n"
        markdown += "\n"
    
    if changes["removals"]:
        markdown += "### Mod Removals\n"
        for removal in changes["removals"]:
            markdown += f"* {removal['name']}\n"
    
    return markdown

# Main execution
if __name__ == "__main__":
    changelog = generate_changelog()
    print(changelog)
    
    # Output the changelog for GitHub Actions if we're in a GitHub Actions environment
    if "GITHUB_OUTPUT" in os.environ:
        with open(os.environ["GITHUB_OUTPUT"], "a") as f:
            delimiter = "EOF" + os.urandom(8).hex()
            f.write(f"changelog<<{delimiter}\n{changelog}\n{delimiter}\n")
    
    # Also write to a file for easier access
    with open("modpack-changelog.md", "w") as f:
        f.write(changelog)
