package io.github.andriyko69.goofyskeletons;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(GoofySkeletons.MOD_ID)
public class GoofySkeletons {
    public static final String MOD_ID = "goofyskeletons";

    public GoofySkeletons(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
