package com.meisa.tennomc.common.blocks;

import com.meisa.tennomc.common.lib.Blueprint;
import com.meisa.tennomc.common.lib.Resource;
import com.meisa.tennomc.common.util.InventoryStuff;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class Foundry extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.FACING;

    public Foundry(Properties properties) {
        super(properties);
    }

    @Nonnull
    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand hand, @Nonnull BlockRayTraceResult rayTraceResult) {

        Item item = player.getItemInHand(hand).getItem();
        if (item instanceof Blueprint) {
            Blueprint blueprint = (Blueprint) item;

            if (blueprint.hasEnoughResources(player.inventory)) {
                player.addItem(new ItemStack(blueprint.outputItem.asItem()));
                player.getMainHandItem().shrink(1);

                for (Resource resource : blueprint.resources) {
                    InventoryStuff.removeItems(player.inventory, resource.asItem(), resource.amount);
                }
            } else {
                if (player.level.isClientSide) { player.sendMessage(new StringTextComponent("Not enough resources"), player.getUUID()); }
            }
        }

        return super.use(state, world, pos, player, hand, rayTraceResult);
    }

    @Nonnull
    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return super.getShape(state, worldIn, pos, context);
    }

    @Nonnull
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Nonnull
    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(@Nonnull BlockState state, @Nonnull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Nonnull
    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(@Nonnull BlockState state, @Nonnull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
