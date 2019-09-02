package tk.themcbros.puddingmod.fluids;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidAttributes;
import tk.themcbros.puddingmod.PuddingMod;
import tk.themcbros.puddingmod.init.ModBlocks;
import tk.themcbros.puddingmod.init.ModFluids;
import tk.themcbros.puddingmod.init.ModItems;

public abstract class PuddingFluid extends FlowingFluid {

	public PuddingFluid() {
    }

    public Fluid getFlowingFluid() {
        return ModFluids.FLOWING_PUDDING;
    }

    public Fluid getStillFluid() {
        return ModFluids.PUDDING;
    }

    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public Item getFilledBucket() {
        return ModItems.PUDDING_BUCKET;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(World world, BlockPos pos, IFluidState state, Random random) {
        if (!state.isSource() && !(Boolean)state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                world.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        } else if (random.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.UNDERWATER, (double)((float)pos.getX() + random.nextFloat()), (double)((float)pos.getY() + random.nextFloat()), (double)((float)pos.getZ() + random.nextFloat()), 0.0D, 0.0D, 0.0D);
        }

    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public IParticleData getDripParticleData() {
        return ParticleTypes.DRIPPING_WATER;
    }

    protected boolean canSourcesMultiply() {
        return true;
    }

    protected void beforeReplacingBlock(IWorld world, BlockPos pos, BlockState state) {
        TileEntity tileEntity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
        Block.spawnDrops(state, world.getWorld(), pos, tileEntity);
    }

    public int getSlopeFindDistance(IWorldReader world) {
        return 4;
    }

    public BlockState getBlockState(IFluidState state) {
        return (BlockState) ModBlocks.PUDDING.getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
    }

    public boolean isEquivalentTo(Fluid fluid) {
        return fluid == ModFluids.PUDDING || fluid == ModFluids.FLOWING_PUDDING;
    }

    public int getLevelDecreasePerBlock(IWorldReader world) {
        return 1;
    }

    public int getTickRate(IWorldReader world) {
        return 5;
    }

    public boolean func_215665_a(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
    }

    protected float getExplosionResistance() {
        return 100.0F;
    }
    
    @Override
    protected FluidAttributes createAttributes(Fluid fluid) {
    	return FluidAttributes.builder("pudding", 
    			new ResourceLocation(PuddingMod.MOD_ID, "block/pudding_still"), 
    			new ResourceLocation(PuddingMod.MOD_ID, "block/pudding_flow"))
    			.luminosity(2)
    			.temperature(290)
    			.color(0xe0c363)
    			.rarity(Rarity.UNCOMMON)
    			.density(2000)
    			.viscosity(100)
    			.build();
    }

    public static class Flowing extends PuddingFluid {
        public Flowing() {
        }

        protected void fillStateContainer(Builder<Fluid, IFluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(new IProperty[]{LEVEL_1_8});
        }

        public int getLevel(IFluidState state) {
            return (Integer)state.get(LEVEL_1_8);
        }

        public boolean isSource(IFluidState state) {
            return false;
        }
    }

    public static class Source extends PuddingFluid {
        public Source() {
        }

        public int getLevel(IFluidState state) {
            return 8;
        }

        public boolean isSource(IFluidState state) {
            return true;
        }
    }

}
