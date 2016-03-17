package com.misteriosM.PayDayModMM.main;

import com.misteriosM.PayDayModMM.blocks.PayDayBlocks;
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
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	PayDayBlocks.init();
    }
    
    @EventHandler
    public void init (FMLInitializationEvent event){
    
    }

    @EventHandler
    public void postInit (FMLPostInitializationEvent event){

    }
}

