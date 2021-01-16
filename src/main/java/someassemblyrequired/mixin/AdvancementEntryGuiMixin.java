package someassemblyrequired.mixin;

import net.minecraft.advancements.Advancement;
import net.minecraft.client.gui.advancements.AdvancementEntryGui;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import someassemblyrequired.SomeAssemblyRequired;

@Mixin(AdvancementEntryGui.class)
public class AdvancementEntryGuiMixin {

	@Shadow @Final private Advancement advancement;

	// func_238417_a_ == trimToWidth (yarn)
	@ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;func_238417_a_(Lnet/minecraft/util/text/ITextProperties;I)Lnet/minecraft/util/text/ITextProperties;"))
	private int increaseTrimWidth(int maxWidth) {
		if (advancement.getId().getNamespace().equals(SomeAssemblyRequired.MODID)) {
			maxWidth = Math.max(200, maxWidth);
		}

		return maxWidth;
	}
}
