package net.seep.tutorialmod.common.player;

import net.seep.tutorialmod.abilities.Ability;

public class PlayerPower {
    private Ability assignedPower;

    public Ability getPower() {
        return assignedPower;
    }

    public void setPower(Ability ability) {
        this.assignedPower = ability;
    }

    public boolean hasPower() {
        return assignedPower != null;
    }
}
