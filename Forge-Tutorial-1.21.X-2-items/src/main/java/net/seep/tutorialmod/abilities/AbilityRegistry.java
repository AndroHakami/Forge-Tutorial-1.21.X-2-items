package net.seep.tutorialmod.abilities;

import java.util.HashMap;
import java.util.Map;

public class AbilityRegistry {
    private static final Map<String, Ability> ABILITIES = new HashMap<>();

    public static void registerAll() {
        register(new FireBlastAbility());
    }

    public static void register(Ability ability) {
        ABILITIES.put(ability.getName(), ability);
    }

    public static Ability get(String name) {
        return ABILITIES.get(name);
    }
}
