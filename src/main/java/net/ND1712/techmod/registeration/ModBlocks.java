package net.ND1712.techmod.registeration;

import net.ND1712.techmod.technology_mod;
import net.ND1712.techmod.blocks.BatteryBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			technology_mod.MOD_ID);
	
	public static final RegistryObject<BatteryBlock> BATTERY_BLOCK = BLOCKS.register("battery_block",
			() -> new BatteryBlock(AbstractBlock.Properties.create(Material.IRON)
			    .hardnessAndResistance(1.8F)
			    .harvestTool(ToolType.PICKAXE)
			    .harvestLevel(2)
			    .sound(SoundType.STONE)
			    .notSolid()
			    .setRequiresTool()));
	
	public static final RegistryObject<FlowingFluidBlock> GREEN_LAVA_BLOCK = BLOCKS.register("green_lava_block",
		    () -> new FlowingFluidBlock(ModFluids.GREEN_LAVA, Block.Properties.create(Material.WATER)
		    	.doesNotBlockMovement()
		    	.hardnessAndResistance(100.0F)
		    	.noDrops()));
}
