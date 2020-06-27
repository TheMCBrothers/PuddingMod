package tk.themcbros.puddingmod;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import tk.themcbros.puddingmod.init.ModBlocks;
import tk.themcbros.puddingmod.init.ModFluids;
import tk.themcbros.puddingmod.init.ModItems;
import tk.themcbros.puddingmod.init.ModTags;

public abstract class PuddingFluid extends FlowableFluid {
    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_PUDDING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.PUDDING;
    }

    @Override
    protected boolean isInfinite() {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {

    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView worldView) {
        return 1;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.PUDDING_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluidState.isIn(ModTags.Fluids.PUDDING);
    }

    @Override
    public int getTickRate(WorldView worldView) {
        return 0;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return ModBlocks.PUDDING.getDefaultState().with(FluidBlock.LEVEL, method_15741(fluidState));
    }

    public static class Flowing extends WaterFluid {
        public Flowing() {
        }

        protected void appendProperties(StateManager.Builder<Fluid, FluidState> properties) {
            super.appendProperties(properties);
            properties.add(LEVEL);
        }

        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        public boolean isStill(FluidState fluidState_1) {
            return false;
        }
    }

    public static class Still extends WaterFluid {
        public Still() {
        }

        public int getLevel(FluidState fluidState) {
            return 8;
        }

        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }

}
