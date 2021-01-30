package someassemblyrequired.mixin;

import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ItemModelsProperties.class)
public interface ItemModelsPropertiesAccessor {

	@Invoker("registerGlobalProperty")
	static IItemPropertyGetter sam$registerGlobalProperty(ResourceLocation id, IItemPropertyGetter propertyGetter) {
		throw new IllegalStateException();
	}
}
