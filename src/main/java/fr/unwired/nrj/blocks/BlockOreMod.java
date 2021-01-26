package fr.unwired.nrj.blocks;

import java.util.Random;

import fr.unwired.nrj.init.BlocksMod;
import fr.unwired.nrj.init.ItemsMod;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOreMod extends BlockOre {
	
	private static boolean multipleQty = false;
	private static int minDrop;
	private static int maxDrop;
	
	public BlockOreMod(String name , int harvestLevel,float resistance, float hardness) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", harvestLevel);
		setResistance(resistance);
		setHardness(hardness);
			
	}
	
	public BlockOreMod(String name , int harvestLevel , int minDrop, int maxDrop, float resistance, float hardness) {
		
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", harvestLevel);
		setResistance(resistance);
		setHardness(hardness);
		multipleQty = true;
		this.minDrop = minDrop;
		this.minDrop = maxDrop;
		
					
	}
	
	public Item getItemDropped(IBlockState state ,Random rand , int fortune) {
		
			return Item.getItemFromBlock(this);
		
	}
	
	public int quantityDropped(Random rand) {
		
		return this.multipleQty ? MathHelper.getInt(rand, 1,4) : 1;
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		
		if(this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
			if(this  == BlocksMod.energystone_ore_block) {
				return MathHelper.getInt(rand, 1,5);	
			}
		}
		else {
			
		}
		return 0;
	}

}
