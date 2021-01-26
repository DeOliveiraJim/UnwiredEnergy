package fr.unwired.nrj.init;

import fr.unwired.nrj.References;
import fr.unwired.nrj.blocks.BlockMod;
import fr.unwired.nrj.blocks.BlockOreMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlocksMod
{
	public static Block energystone_ore_block;
	public static Block energystone_block;
	
	public static void init()	{		
		energystone_ore_block = new BlockOreMod("energystone_ore_block", 2, 1, 4,5.0F,3.0F);
		energystone_block = new BlockMod("energystone_block",Material.ROCK,5.0F,5.0F);
		
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		event.getRegistry().registerAll(energystone_ore_block,energystone_block);
	
	}
	
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)	{
		event.getRegistry().registerAll(
				new ItemBlock(energystone_ore_block).setRegistryName(energystone_ore_block.getRegistryName()),
				new ItemBlock(energystone_block).setRegistryName(energystone_block.getRegistryName())
				);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)	{
		registerRender(Item.getItemFromBlock(energystone_ore_block));
		registerRender(Item.getItemFromBlock(energystone_block));

	}
	
	private static void registerRender(Item item)	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}