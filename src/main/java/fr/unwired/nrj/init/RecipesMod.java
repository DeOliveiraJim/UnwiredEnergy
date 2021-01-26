package fr.unwired.nrj.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesMod {

	public static void init() {
		GameRegistry.addSmelting(new ItemStack(BlocksMod.energystone_ore_block), new ItemStack(ItemsMod.energystone_ingot) , 1.5F);
	}
}
