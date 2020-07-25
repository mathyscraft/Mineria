package com.mineria.mod.util.handler;

import com.mineria.mod.References;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CustomSoundsHandler
{
	public static SoundEvent RECORD_UNACCEPTABLE;
	
	public static void registerSounds()
	{
		RECORD_UNACCEPTABLE = registerSound("record.unacceptable");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(References.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
