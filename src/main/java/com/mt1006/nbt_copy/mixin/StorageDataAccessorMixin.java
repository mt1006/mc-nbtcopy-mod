package com.mt1006.nbt_copy.mixin;

import com.mt1006.nbt_copy.NBTcopy;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.data.EntityDataAccessor;
import net.minecraft.server.commands.data.StorageDataAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StorageDataAccessor.class)
public abstract class StorageDataAccessorMixin
{
	@Shadow public abstract Component getPrintSuccess(Tag tag);
	@Unique private static boolean skipButton = false;

	@Inject(method = "getPrintSuccess(Lnet/minecraft/nbt/Tag;)Lnet/minecraft/network/chat/Component;", at = @At(value = "HEAD"), cancellable = true)
	private void atGetPrintSuccess(Tag tag, CallbackInfoReturnable<Component> cir)
	{
		if (!skipButton)
		{
			skipButton = true;
			Component component = NBTcopy.withCopyButton(getPrintSuccess(tag), tag.getAsString());
			skipButton = false;

			cir.setReturnValue(component);
			cir.cancel();
		}
	}
}
