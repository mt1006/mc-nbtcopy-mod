package com.mt1006.nbt_copy.mixin;

import com.mt1006.nbt_copy.NBTcopy;
import net.minecraft.command.impl.data.BlockDataAccessor;
import net.minecraft.nbt.INBT;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockDataAccessor.class)
public abstract class BlockDataAccessorMixin
{
	@Shadow public abstract ITextComponent getPrintSuccess(INBT tag);
	@Unique private static boolean skipButton = false;

	@Inject(method = "getPrintSuccess(Lnet/minecraft/nbt/INBT;)Lnet/minecraft/util/text/ITextComponent;", at = @At(value = "HEAD"), cancellable = true)
	private void atGetPrintSuccess(INBT tag, CallbackInfoReturnable<ITextComponent> cir)
	{
		if (!skipButton)
		{
			skipButton = true;
			ITextComponent component = NBTcopy.withCopyButton(getPrintSuccess(tag), tag.getAsString());
			skipButton = false;

			cir.setReturnValue(component);
			cir.cancel();
		}
	}
}
