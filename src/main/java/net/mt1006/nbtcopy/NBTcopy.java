package net.mt1006.nbtcopy;

import net.minecraft.network.chat.*;
import net.minecraftforge.fml.common.Mod;

@Mod("nbtcopy")
public class NBTcopy
{
	public static boolean skipButton = false;

	public static MutableComponent withCopyButton(Component component, String textToCopy)
	{
		ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, textToCopy);
		HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("nbtcopy.copy_button_info"));
		return component.copy().append(Component.translatable("nbtcopy.copy_button")
				.setStyle(Style.EMPTY.withClickEvent(clickEvent).withHoverEvent(hoverEvent)));
	}
}
