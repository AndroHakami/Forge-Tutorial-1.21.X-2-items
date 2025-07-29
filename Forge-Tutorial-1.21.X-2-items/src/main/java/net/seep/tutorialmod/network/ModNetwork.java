package net.seep.tutorialmod.network;


import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.EventNetworkChannel;
import net.minecraftforge.network.ChannelBuilder;
import net.seep.tutorialmod.TutorialMod;


public class ModNetwork {
    public static EventNetworkChannel NETWORK;

    public static void register() {
        NETWORK = ChannelBuilder.named(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "main"))
                .networkProtocolVersion(1)
                .eventNetworkChannel()
                .register();

        NETWORK.registerMessage(UsePowerPacket.class,
                UsePowerPacket::encode,
                UsePowerPacket::new,
                UsePowerPacket::handle,
                Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }
}
