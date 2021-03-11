package net.ND1712.techmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BatteryBlock extends BaseHorizontalBlock{
	
	private static final VoxelShape SHAPE = VoxelShapes.or(
Block.makeCuboidShape(1, 0, 1.5, 15, 12, 12),
Block.makeCuboidShape(1, 0, 12, 5, 12, 14.5),
Block.makeCuboidShape(11, 0, 12, 15, 12, 14.5));
    public static final IntegerProperty CHARGE_LEVEL = Blockstates.CHARGE;
	public BatteryBlock(Properties properties) {
		super(properties);
	    runCalculation(SHAPE);
		this.setDefaultState(this.stateContainer.getBaseState().with(CHARGE_LEVEL, Integer.valueOf(0)));

	}
	
	
	
	@Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
    	super.fillStateContainer(builder);
    	builder.add(CHARGE_LEVEL);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(state.get(HORIZONTAL_FACING));
	}
}