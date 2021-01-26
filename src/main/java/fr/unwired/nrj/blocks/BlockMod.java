package fr.unwired.nrj.blocks;

import java.util.Random;

import fr.unwired.nrj.References;
import fr.unwired.nrj.init.BlocksMod;
import fr.unwired.nrj.init.ItemsMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlockMod extends Block
{

	public BlockMod(String name, Material materialIn, float resistance, float hardness)
	{
		super(materialIn);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setResistance(resistance);
		setHardness(hardness);
	}
	
	public Item getItemDropped() {
			

		return Item.getItemFromBlock(this);

		
	}
	
	public int quantityDropped() {
		
		return 1;
	}
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		
		return 0;
	}
	

}