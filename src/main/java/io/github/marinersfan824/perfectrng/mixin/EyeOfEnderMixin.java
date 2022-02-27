package io.github.marinersfan824.perfectrng.mixin;

import net.minecraft.entity.thrown.EyeOfEnderEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EyeOfEnderEntity.class)
public class EyeOfEnderMixin {
    @Shadow private boolean dropsItem;

    @Inject(method = "initTargetPos", at = @At("TAIL"))
    public void overrideEyes(BlockPos blockPos, CallbackInfo info) {
        dropsItem = true;
    }
}
