package net.ND1712.techmod.registeration;

import org.apache.commons.lang3.Validate;

import net.ND1712.techmod.technology_mod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.DispenseFluidContainer;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

    public static final ResourceLocation FLUID_STILL = new ResourceLocation("minecraft:blocks/green_lava_still");
    public static final ResourceLocation FLUID_FLOWING = new ResourceLocation("minecraft:blocks/green_lava_flowing");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, technology_mod.MOD_ID);

    private static ForgeFlowingFluid.Properties makeProperties() {
        return new ForgeFlowingFluid.Properties(GREEN_LAVA, GREEN_LAVA_FLOWING,
                FluidAttributes.builder(FLUID_STILL, FLUID_FLOWING).color(0x3F1080FF))
                .bucket(ModItems.GREEN_LAVA_BUCKET).block(ModBlocks.GREEN_LAVA_BLOCK);
    }

    public static final RegistryObject<FlowingFluid> GREEN_LAVA = FLUIDS.register("green_lava",
    		() -> new ForgeFlowingFluid.Source(makeProperties()));
    public static final RegistryObject<FlowingFluid> GREEN_LAVA_FLOWING = FLUIDS.register("green_lava_flowing",
    		() -> new ForgeFlowingFluid.Flowing(makeProperties()));

    public void loadComplete(FMLLoadCompleteEvent event) {
        BlockState state = Fluids.WATER.getDefaultState().getBlockState();
        BlockState state2 = Fluids.WATER.getAttributes().getBlock(null,null,Fluids.WATER.getDefaultState());
        Validate.isTrue(state.getBlock() == Blocks.WATER && state2 == state);
        ItemStack stack = Fluids.WATER.getAttributes().getBucket(new FluidStack(Fluids.WATER, 1));
        Validate.isTrue(stack.getItem() == Fluids.WATER.getFilledBucket());
        event.enqueueWork(() -> DispenserBlock.registerDispenseBehavior(ModItems.GREEN_LAVA_BUCKET.get(), DispenseFluidContainer.getInstance()));
    }
}
