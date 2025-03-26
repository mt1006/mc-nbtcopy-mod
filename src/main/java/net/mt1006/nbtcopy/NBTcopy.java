package net.mt1006.nbtcopy;

import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.*;

public class NBTcopy implements ModInitializer
{
	public static boolean skipButton = false;

	@Override public void onInitialize() {}

	public static MutableComponent withCopyButton(Component component, String textToCopy)
	{
		ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, textToCopy);
		HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("nbtcopy.copy_button_info"));
		return component.copy().append(Component.translatable("nbtcopy.copy_button")
				.setStyle(Style.EMPTY.withClickEvent(clickEvent).withHoverEvent(hoverEvent)));
	}
}
