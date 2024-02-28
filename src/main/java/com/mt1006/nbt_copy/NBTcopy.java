package com.mt1006.nbt_copy;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.*;
import org.slf4j.Logger;

public class NBTcopy implements ModInitializer
{
	public static final String VERSION = "1.0";
	public static final String FOR_VERSION = "1.20.1";
	public static final String FOR_LOADER = "Fabric";
	public static final Logger LOGGER = LogUtils.getLogger();

	@Override public void onInitialize()
	{
		LOGGER.info(getFullName() + " - Author: mt1006 (mt1006x)");
	}

	public static String getFullName()
	{
		return "NBTcopy v" + VERSION + " for Minecraft " + FOR_VERSION + " [" + FOR_LOADER + "]";
	}

	public static MutableComponent withCopyButton(Component component, String textToCopy)
	{
		ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, textToCopy);
		HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("nbt_copy.copy_button_info"));
		return component.copy().append(Component.translatable("nbt_copy.copy_button")
				.setStyle(Style.EMPTY.withClickEvent(clickEvent).withHoverEvent(hoverEvent)));
	}
}