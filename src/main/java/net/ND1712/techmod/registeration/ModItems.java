package net.ND1712.techmod.registeration;

import net.ND1712.techmod.technology_mod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			technology_mod.MOD_ID);
	
	public static final RegistryObject<BlockItem> BATTERY_BLOCK = ITEMS.register("battery_block",
			() -> new BlockItem(ModBlocks.BATTERY_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	
	public static final RegistryObject<Item> GREEN_LAVA_BUCKET = ITEMS.register("green_lava_bucket",
		    () -> new BucketItem(ModFluids.GREEN_LAVA, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC))
);


}
