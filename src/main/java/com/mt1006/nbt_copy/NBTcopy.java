package com.mt1006.nbt_copy;

import net.minecraft.network.chat.*;
import net.neoforged.fml.common.Mod;

@Mod("nbt_copy")
public class NBTcopy
{
	public static boolean skipButton = false;

	public static MutableComponent withCopyButton(Component component, String textToCopy)
	{
		ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, textToCopy);
		HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("nbt_copy.copy_button_info"));
		return component.copy().append(Component.translatable("nbt_copy.copy_button")
				.setStyle(Style.EMPTY.withClickEvent(clickEvent).withHoverEvent(hoverEvent)));
	}
}
