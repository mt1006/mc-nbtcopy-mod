package com.mt1006.nbt_copy;

import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NBTcopy.MOD_ID)
public class NBTcopy
{
	public static final String MOD_ID = "nbt_copy";
	public static final String VERSION = "1.0";
	public static final String FOR_VERSION = "1.16.5";
	public static final String FOR_LOADER = "Forge";
	public static final Logger LOGGER = LogManager.getLogger();

	public NBTcopy()
	{
		LOGGER.info(getFullName() + " - Author: mt1006 (mt1006x)");
	}

	public static String getFullName()
	{
		return "NBTcopy v" + VERSION + " for Minecraft " + FOR_VERSION + " [" + FOR_LOADER + "]";
	}

	public static ITextComponent withCopyButton(ITextComponent component, String textToCopy)
	{
		ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, textToCopy);
		HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("nbt_copy.copy_button_info"));
		return component.copy().append(new TranslationTextComponent("nbt_copy.copy_button")
				.setStyle(Style.EMPTY.withClickEvent(clickEvent).withHoverEvent(hoverEvent)));
	}
}
