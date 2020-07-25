package com.mineria.mod.items;

import com.mineria.mod.Mineria;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class XPOrbItem extends Item
{
	public XPOrbItem(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Mineria.mineriaTab);
		this.setMaxStackSize(16);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand)
	{
		ActionResult<ItemStack> actionr = super.onItemRightClick(world, entity, hand);
		ItemStack itemstack = actionr.getResult();
		int x = (int) entity.posX;
		int y = (int) entity.posY;
		int z = (int) entity.posZ;
		
		if (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).capabilities.isCreativeMode : false))
		{
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).addExperience((int) 1);
		}
		
		else
		{
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).addExperience((int) 1);
				itemstack.shrink(1);
		}
		return actionr;
	}
}