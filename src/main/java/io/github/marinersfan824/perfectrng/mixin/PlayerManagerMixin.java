package io.github.marinersfan824.perfectrng.mixin;

import io.github.marinersfan824.perfectrng.Main;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
    @Shadow @Final private MinecraftServer server;

    @Inject(method = "onPlayerConnect", at = @At(value = "TAIL"))
    private void setSpawnClient(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        World world = player.world;
        if (world.getSeed() == 225874918561344128L) {
            ServerPlayNetworkHandler serverPlayNetworkHandler = new ServerPlayNetworkHandler(server, connection, player);
            serverPlayNetworkHandler.requestTeleport(-417.5, 67, -455.5, player.yaw, player.pitch);
        }
        if (world.getLevelProperties().getTime() <= 20) {
            Main.numConverted = 0;
        }
    }
}
