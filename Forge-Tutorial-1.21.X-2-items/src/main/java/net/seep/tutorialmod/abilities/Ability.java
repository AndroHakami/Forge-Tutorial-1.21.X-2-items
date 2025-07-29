package net.seep.tutorialmod.abilities;

import net.minecraft.world.entity.player.Player;

public interface Ability {
    String getName();
    void activate(Player player);
    boolean canActivate(Player player);
}