package com.inf.gemsandtrinkets.item.custom;

import com.inf.gemsandtrinkets.block.ModBlocks;
import com.inf.gemsandtrinkets.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient) {
            BlockPos pos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= pos.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(pos.down(i));

                if(isValuable(state)) {
                    outputValuable(pos.down(i), player, state.getBlock());
                    foundBlock = true;
                    
                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.literal("No rubies found!"), false);
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputValuable(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString()
                + " at " + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ()),
                false);
    }

    private boolean isValuable(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.gemsandtrinkets.ruby_detector_1"));
        tooltip.add(Text.translatable("tooltip.gemsandtrinkets.ruby_detector_2"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
