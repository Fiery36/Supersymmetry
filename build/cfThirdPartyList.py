import os
import re
from typing import Dict, List, Optional, Tuple

import json
import urllib.request

# I felt like actually parsing toml would take too much time so i guess thats worth it???? didnt actually test how much parsing toml takes. 
def get_mods_kvp(folder):
    mods = {}
    for filename in os.listdir(folder):
        if filename.endswith(".pw.toml"):
            mod_name = None
            project_id = None
            file_id = None
            with open(os.path.join(folder, filename)) as f:
                for line in f:
                    line = line.strip()
                    if "=" in line:
                        key, val = line.split("=", 1)
                        key = key.strip()
                        val = val.strip().strip('"')
                        if key == "name" and mod_name is None:
                            mod_name = val
                        if key == "project-id" and project_id is None:
                            project_id = int(val)
                        if key == "file-id" and file_id is None:
                            file_id = int(val)
            if mod_name and project_id is not None and file_id is not None:
                mods[mod_name.strip()] = (project_id, file_id)
    return mods



def extract_failed(log: str) -> Optional[List[str]]:
    pattern = re.compile(r'^(?:\((\d+/\d+)\)\s)?Failed to download (.*):\s*(.+)$', re.MULTILINE)

    matches = pattern.findall(log)
    if not matches:
        return None

    out = []
    for index, mod, err in matches:
        out.append(mod)
    return out


def cf_file_meta(project_id: int, file_id: int) -> Optional[Tuple[str,str]]:
    url = f"https://api.cfwidget.com/{project_id}"
    req = urllib.request.Request(
    url,
    headers={"User-Agent": "curl/8.4.0"} # really didnt like the default for some reason
    )
    with urllib.request.urlopen(req) as response:
        data = json.load(response)
    for version_meta in data.get("files", []):
        if version_meta.get("id") == file_id:
            url = version_meta.get("url")
            name = version_meta.get("name")
            return name,url
    return None

def get_broken_from_log(log:str,mods_path:str) -> Optional[Dict[str,Tuple[int,int]]]:
    kvp = get_mods_kvp(mods_path)
    broken_names = extract_failed(log)
    nameToId = {}
    if broken_names:
        for name in broken_names:
            if name in kvp:
                nameToId[name] = kvp[name]

    return nameToId if nameToId else None
