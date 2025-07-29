package net.seep.tutorialmod.abilities;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.particles.ParticleTypes;

public class FireBlastAbility implements Ability {
    @Override
    public String getName() {
        return "Fire Blast";
    }

    @Override
    public void activate(Player player) {
        Level level = player.level();
        level.addParticle(ParticleTypes.FLAME,
                player.getX(), player.getY() + 1, player.getZ(),
                0, 0.1, 0);
        // Add logic (e.g. deal damage, shoot fireball, etc.)
    }

    @Override
    public boolean canActivate(Player player) {
        return true; // cooldown check here later
    }
}
