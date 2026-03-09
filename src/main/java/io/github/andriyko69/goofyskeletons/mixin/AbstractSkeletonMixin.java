package io.github.andriyko69.goofyskeletons.mixin;

import io.github.andriyko69.goofyskeletons.Config;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractSkeleton.class)
public class AbstractSkeletonMixin {

    @Redirect(method = "performRangedAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow;shoot(DDDFF)V"))
    public void performRangedAttack(AbstractArrow arrow, double x, double y, double z, float velocity, float inaccuracy) {
        arrow.shoot(x, y, z, velocity, inaccuracy + Config.inaccuracyFactor);
    }
}
