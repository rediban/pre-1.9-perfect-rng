package io.github.marinersfan824.perfectrng.mixin;

import net.minecraft.network.packet.s2c.play.PlayerSpawnPositionS2CPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerSpawnPositionS2CPacket.class)
public class SpawnPosPacketMixin {

    @Inject(method = "getPos", at = @At(value = "TAIL"), cancellable = true)
    private void setSpawnClient(CallbackInfoReturnable<BlockPos> cir) {
        World world = MinecraftServer.getServer().getWorld();
        if (world.getSeed() == 225874918561344128L) {
            BlockPos pos2 = new BlockPos(-417.5, 67, -455.5);

            cir.setReturnValue(pos2);
        }
    }
}
