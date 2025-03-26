package net.mt1006.nbtcopy;

import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.*;

public class NBTcopy implements ModInitializer
{
	public static boolean skipButton = false;

	@Override public void onInitialize() {}

	public static MutableComponent withCopyButton(Component component, String textToCopy)
	{
		ClickEvent clickEvent = new ClickEvent.CopyToClipboard(textToCopy);
		HoverEvent hoverEvent = new HoverEvent.ShowText(Component.translatable("nbtcopy.copy_button_info"));
		return component.copy().append(Component.translatable("nbtcopy.copy_button")
				.setStyle(Style.EMPTY.withClickEvent(clickEvent).withHoverEvent(hoverEvent)));
	}
}
