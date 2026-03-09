package io.github.andriyko69.goofyskeletons;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = GoofySkeletons.MOD_ID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue INACCURACY_FACTOR = BUILDER
            .comment("How much the skeletons will miss their shots. Higher value means more inaccuracy.")
            .translation("goofyskeletons.config.inaccuracyFactor")
            .defineInRange("inaccuracyFactor", 10, 0, 20);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static int inaccuracyFactor;

    private static void bake() {
        inaccuracyFactor = INACCURACY_FACTOR.get();
    }

    @SubscribeEvent
    public static void onLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == SPEC) {
            bake();
        }
    }

    @SubscribeEvent
    public static void onReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == SPEC) {
            bake();
        }
    }
}
