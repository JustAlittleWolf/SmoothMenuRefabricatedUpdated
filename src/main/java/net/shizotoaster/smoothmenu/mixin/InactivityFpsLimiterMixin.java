package net.shizotoaster.smoothmenu.mixin;

import net.minecraft.client.option.InactivityFpsLimiter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(InactivityFpsLimiter.class)
public class InactivityFpsLimiterMixin {
    @Shadow
    private int maxFps;

    @ModifyConstant(method = "update", constant = @Constant(intValue = 60))
    private int modifyMenuFpsLimit(int original) {
        return Math.max(maxFps, 60);
    }
}
