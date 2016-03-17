package com.misteriosM.PayDayModMM;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockSafe extends Block{
	
	public static final IProperty[] DATA = new IProperty[] {PropertyBool.create("open"), PropertyBool.create("drilling"),PropertyBool.create("exploding"),PropertyDirection.create("facing")};
	private boolean isBeeingDrilled = false;
	private int drillTimeLeft;
	private Item loot;
	
	public BlockSafe(Material material, MapColor color) {
		super(material, MapColor.goldColor);
		this.drillTimeLeft = 300;	
		this.setDefaultState(this.blockState.getBaseState().withProperty(DATA[0], Boolean.valueOf(false)).withProperty(DATA[1], Boolean.valueOf(false)).withProperty(DATA[2], Boolean.valueOf(false)).withProperty(DATA[3], EnumFacing.NORTH));
	    }
	
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public boolean isOpaqueCube(IBlockState p_149662_1_)
    {
        return false;
    }
    
    
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new EntitySafeTileEntity();
    }
    
    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(pos.north()).getBlock();
            Block block1 = worldIn.getBlockState(pos.south()).getBlock();
            Block block2 = worldIn.getBlockState(pos.west()).getBlock();
            Block block3 = worldIn.getBlockState(pos.east()).getBlock();
            EnumFacing enumfacing = (EnumFacing)state.getValue(DATA[3]);

            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(DATA[3], enumfacing), 2);
        }
    }
    
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }
    
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {DATA[0],DATA[1],DATA[2],DATA[3]});
    }
    
    public int getMetaFromState(IBlockState state) { return 0; }
    public IBlockState getStateFromMeta(int meta) { return this.getDefaultState();}

}
