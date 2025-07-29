package net.seep.tutorialmod.network;


import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.seep.tutorialmod.common.player.PlayerPowerProvider;

public class UsePowerPacket {
    public UsePowerPacket() {}

    public UsePowerPacket(RegistryFriendlyByteBuf buf) {}

    public void encode(RegistryFriendlyByteBuf buf) {}

    public void handle(ServerPlayer player) {
        player.getCapability(PlayerPowerProvider.PLAYER_POWER).ifPresent(power -> {
            if (power.getPower() != null && power.getPower().canActivate(player)) {
                power.getPower().activate(player);
            }
        });
    }
}
;