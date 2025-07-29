package net.seep.tutorialmod.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.seep.tutorialmod.TutorialMod;
import net.seep.tutorialmod.common.player.PlayerPowerProvider;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class CommonEvents {

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Player> event) {
        event.addCapability(
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "player_power"),
                new PlayerPowerProvider()
        );
    }

    @SubscribeEvent
    public static void clonePlayer(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(PlayerPowerProvider.PLAYER_POWER).ifPresent(oldCap -> {
            event.getEntity().getCapability(PlayerPowerProvider.PLAYER_POWER).ifPresent(newCap -> {
                newCap.setPower(oldCap.getPower());
            });
        });
    }
}
