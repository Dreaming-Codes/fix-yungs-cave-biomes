package codes.dreaming.fixyungscavebiomes.mixin;

import com.yungnickyoung.minecraft.yungscavebiomes.block.entity.RareIceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RareIceBlockEntity.class, priority = 99999, remap = false)
public class RareIceBlockEntityMixin {
    // Tick is only used for doing a random sound which is causing a server crash, so we just cancel it
    @Inject(method = "tick", at = @At(value = "HEAD"), cancellable = true)
    private static void tick(Level level, BlockPos blockPos, BlockState blockState, RareIceBlockEntity rareIceBlockEntity, CallbackInfo ci) {
        ci.cancel();
    }
}
