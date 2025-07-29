package net.seep.tutorialmod.common.player;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.seep.tutorialmod.abilities.Ability;
import net.seep.tutorialmod.abilities.AbilityRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerPowerProvider implements ICapabilityProvider {
    public static Capability<PlayerPower> PLAYER_POWER = CapabilityManager.get(new CapabilityToken<>() {});

    private final PlayerPower instance = new PlayerPower();
    private final LazyOptional<PlayerPower> optional = LazyOptional.of(() -> instance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == PLAYER_POWER ? optional.cast() : LazyOptional.empty();
    }

    public static void attach(Player player) {
        player.getCapability(PLAYER_POWER).ifPresent(power -> {
            // Assign a default power, for example
            if (!power.hasPower()) {
                power.setPower(AbilityRegistry.get("Fire Blast"));
            }
        });
    }

    public CompoundTag save() {
        CompoundTag tag = new CompoundTag();
        if (instance.getPower() != null) {
            tag.putString("Power", instance.getPower().getName());
        }
        return tag;
    }

    public void load(CompoundTag tag) {
        if (tag.contains("Power")) {
            String name = tag.getString("Power");
            Ability ability = AbilityRegistry.get(name);
            instance.setPower(ability);
        }
    }
}
