package net.seep.tutorialmod.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.seep.tutorialmod.TutorialMod;
import net.seep.tutorialmod.network.ModNetwork;
import net.seep.tutorialmod.network.UsePowerPacket;

import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeybindHandler {
    public static final KeyMapping USE_POWER_KEY = new KeyMapping(
            "key.tutorialmod.use_power",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.gameplay"
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(USE_POWER_KEY);
    }

    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = net.minecraftforge.api.distmarker.Dist.CLIENT)
    public static class ClientInputHandler {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (USE_POWER_KEY.isDown() && Minecraft.getInstance().player != null) {
                ModNetwork.NETWORK.sendToServer(new UsePowerPacket());


            }
        }
    }
}
