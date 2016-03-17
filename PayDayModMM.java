package com.misteriosM.PayDayModMM;

import com.misteriosM.PayDayModMM.proxies.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

@Mod(modid = PayDayModMM.MODID, version = PayDayModMM.VERSION)
public class PayDayModMM
{
    public static final String MODID = "PayDayModMM";
    public static final String VERSION = "0.01";
    @Mod.Instance
    public static PayDayModMM instance;
    @SidedProxy(clientSide = "com.misteriosM.PayDayModMM.proxies.ClientProxy", serverSide = "com.misteriosM.PayDayModMM.proxies.CommonProxy")
    public static CommonProxy proxy;
    
    public final static Block safeBlockDrillable = new BlockSafe(Material.ground, null).setHardness(50000F).setResistance(9000f).setStepSound(Block.soundTypeMetal).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("safe");
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	GameRegistry.registerBlock(safeBlockDrillable, "safe");
    	GameRegistry.registerTileEntity(EntitySafeTileEntity.class, "safe_entity");
    	proxy.registerRenderers();
    	
    }
    
    @EventHandler
    public void init (FMLInitializationEvent event){
    
    }

    @EventHandler
    public void postInit (FMLPostInitializationEvent event){

    }
}

