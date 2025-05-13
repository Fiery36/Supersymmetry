package preInit

import preInit.PipeOperationWalker
import gregtech.api.cover.CoverRayTracer
import gregtech.api.items.toolitem.IGTTool
import gregtech.api.items.toolitem.ToolHelper
import gregtech.api.items.toolitem.behavior.IToolBehavior
import gregtech.api.pipenet.tile.IPipeTile
import gregtech.api.util.input.KeyBind
import net.minecraft.client.resources.I18n
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.SoundCategory
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

import static preInit.PipeOperationWalker.TraverseOption.*

@Singleton
class PipeNetWalkerBehaviour implements IToolBehavior {

    @Override
    EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos,
                                    EnumFacing side, float hitX, float hitY, float hitZ,
                                    EnumHand hand) {
        if (KeyBind.TOOL_AOE_CHANGE.isKeyDown(player)) {
            def te = world.getTileEntity(pos)
            if (te instanceof IPipeTile) {
                def pipe = te as IPipeTile

                def rayTraceResult = pipe.getPipeBlock().getServerCollisionRayTrace(player, pos, world)

                def gridSide = CoverRayTracer.traceCoverSide(rayTraceResult)

                def option = pipe.isConnected(gridSide)
                        ? (player.sneaking
                        ? (pipe.isFaceBlocked(gridSide) ? UNBLOCKING : BLOCKING)
                        : DISCONNECTING)
                        : (player.sneaking ? null : CONNECTING)

                if (!option) return EnumActionResult.FAIL

                def toolStack = player.getHeldItem(hand)
                def toolTag = ToolHelper.getToolTag(toolStack)
                int maxWalks = toolTag.getInteger(ToolHelper.MAX_DURABILITY_KEY) - toolTag.getInteger(ToolHelper.DURABILITY_KEY)

                if (!maxWalks) return EnumActionResult.FAIL

                int walkedBlocks = PipeOperationWalker.collectPipeNet(world, pos, pipe, gridSide, option, maxWalks)

                onActionDone(toolStack, player, world, hand, walkedBlocks)

                return EnumActionResult.SUCCESS
            }
        }
        return EnumActionResult.PASS
    }

    static void onActionDone(ItemStack stack, EntityPlayer player, World world, EnumHand hand, int walked) {
        def tool = stack.item as IGTTool
        ToolHelper.damageItem(stack, player, walked)
        if (tool.sound) {
            world.playSound(null, player.posX, player.posY, player.posZ, tool.sound, SoundCategory.PLAYERS, 1.0F, 1.0F)
        }
        player.swingArm(hand)
    }
}
