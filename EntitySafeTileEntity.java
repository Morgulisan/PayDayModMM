package com.misteriosM.PayDayModMM;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class EntitySafeTileEntity extends TileEntity {
	
	public int drillTime;
	public int fuse;
	private boolean isBeeingDrilled = false;
	private boolean isDrillbroken = false;
	private boolean isBeeingExploded = false;
	private boolean isOpen = false;
	
	public EntitySafeTileEntity(){
		this.drillTime = 200;
	}
	
	private void onUpdate(){
		if(isBeeingDrilled && !isDrillbroken){
			--this.drillTime;	
		}
		if(isBeeingExploded){
			--this.fuse;
		}
		
		if(this.drillTime < 0){
			isBeeingDrilled = false;
			isBeeingExploded = false;
			isOpen = true;
		}
		if(this.fuse < 0){
			isBeeingDrilled = false;
			isBeeingExploded = false;
			isOpen = true;
		}
	}
	
	public boolean shouldRefresh(){
		return false;
	}
}
