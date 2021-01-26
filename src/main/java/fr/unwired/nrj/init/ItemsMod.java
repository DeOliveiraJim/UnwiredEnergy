package fr.unwired.nrj.init;



import fr.unwired.nrj.References;
import fr.unwired.nrj.items.ItemMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=References.MODID)
public class ItemsMod
{
	public static Item energystone;
	public static Item energystone_ingot;
	
	public static void init()
	{
		energystone = new ItemMod("energystone");
		energystone_ingot = new ItemMod("energystone_ingot");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(energystone,energystone_ingot);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(energystone);
		registerRender(energystone_ingot);
	}
	
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}