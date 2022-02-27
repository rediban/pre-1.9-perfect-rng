package io.github.marinersfan824.perfectrng.mixin;

import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugHud.class)
public class DebugHudMixin {
    @Inject(at = @At("RETURN"), method = "getLeftText", cancellable = true)
    private void addDebugLine(CallbackInfoReturnable<List<String>> cir) {
        cir.getReturnValue().add("Pre 1.9 Perfect RNG Mod");
    }
}
