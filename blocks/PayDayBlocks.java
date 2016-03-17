package com.misteriosM.PayDayModMM.blocks;

import org.apache.logging.log4j.LogManager;

import com.misteriosM.PayDayModMM.main.PayDayModMM;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PayDayBlocks {
	
	private static Block safe;

	public static void init() {

		PayDayBlocks.safe = new BlockSafe(Material.rock, MapColor.goldColor).setUnlocalizedName("safe");

		register();
		setFireInfo();
		oredictregister();
	}

	private static void oredictregister() {
	}

	public static void setFireInfo() {

	}

	public static void register() {
		addBlock(PayDayBlocks.safe);
	}

	private static void addBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
		block.setCreativeTab(CreativeTabs.tabBlock);
		registerInventoryItem(block);
		LogManager.getLogger("TESTMOD").info(block + " " + block.getUnlocalizedName().substring(5));
	}

	
	
	/*
	 * Methods
	 */
	public static void registerInventoryItem(Block block) {
		registerInventoryItem(block, block.getUnlocalizedName().substring(5), 0);
	}

	public static void registerInventoryItem(Block block, String modelname, int meta) {

		ItemStack it = new ItemStack(block, 1, meta);
		String name = it.getUnlocalizedName().substring(5);
		registerInventoryItem(Item.getItemFromBlock(block), name, meta);
	}

	@SideOnly(Side.CLIENT)
	public static void registerInventoryItem(Item item, String modelname, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta,
				new ModelResourceLocation(PayDayModMM.MODID + ":" + modelname, "inventory"));
	}

	// private static void addMetaBlock(Block block) {
	// GameRegistry.registerBlock(block, ItemBlockMetaBlock.class,
	// block.getUnlocalizedName().substring(5));
	// block.setCreativeTab(CreativeTabs.tabBlock);
	// LogManager.getLogger("TESTMOD").info(block + " " +
	// block.getUnlocalizedName().substring(5));
}