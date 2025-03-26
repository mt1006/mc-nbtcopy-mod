package net.mt1006.nbtcopy;

import net.minecraft.network.chat.*;
import net.neoforged.fml.common.Mod;

@Mod("nbtcopy")
public class NBTcopy
{
	public static boolean skipButton = false;

	public static MutableComponent withCopyButton(Component component, String textToCopy)
	{
		ClickEvent clickEvent = new ClickEvent.CopyToClipboard(textToCopy);
		HoverEvent hoverEvent = new HoverEvent.ShowText(Component.translatable("nbtcopy.copy_button_info"));
		return component.copy().append(Component.translatable("nbtcopy.copy_button")
				.setStyle(Style.EMPTY.withClickEvent(clickEvent).withHoverEvent(hoverEvent)));
	}
}
