package someassemblyrequired.common.init;

import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import someassemblyrequired.SomeAssemblyRequired;
import someassemblyrequired.client.SandwichItemRenderer;
import someassemblyrequired.common.item.DrinkableBottleItem;
import someassemblyrequired.common.item.EnchantedGoldenAppleSlicesItem;
import someassemblyrequired.common.item.SandwichItem;
import someassemblyrequired.common.item.SpreadItem;

@SuppressWarnings("unused")
public class Items {

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SomeAssemblyRequired.MODID);

    private static final ItemGroup CREATIVE_TAB = new ItemGroup(SomeAssemblyRequired.MODID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            NonNullList<ItemStack> ingredients = NonNullList.create();
            for (Item item : new Item[]{BREAD_SLICE.get(), LETTUCE_LEAF.get(), BACON_STRIPS.get(), TOMATO_SLICES.get(), BREAD_SLICE.get()}) {
                ItemStack ingredient = new ItemStack(item);
                ingredient.getOrCreateTag().putBoolean("IsOnSandwich", true);
                ingredients.add(ingredient);
            }
            ItemStack sandwich = new ItemStack(SANDWICH.get());
            sandwich.getOrCreateChildTag("BlockEntityTag").put("Ingredients", new ItemStackHandler(ingredients).serializeNBT());
            return sandwich;
        }
    };

    // misc items
    public static final RegistryObject<Item> SANDWICH = REGISTRY.register("sandwich", () -> new SandwichItem(Blocks.SANDWICH.get(), new Item.Properties().maxStackSize(8).food(Foods.SANDWICH).setISTER(() -> SandwichItemRenderer::new)));
    public static final RegistryObject<Item> SPREAD = REGISTRY.register("spread", () -> new SpreadItem(new Item.Properties()));

    // sandwich assembly tables
    public static final RegistryObject<Item> OAK_SANDWICH_ASSEMBLY_TABLE = REGISTRY.register("oak_sandwich_assembly_table", () -> createBlockItem(Blocks.OAK_SANDWICH_ASSEMBLY_TABLE.get()));
    public static final RegistryObject<Item> SPRUCE_SANDWICH_ASSEMBLY_TABLE = REGISTRY.register("spruce_sandwich_assembly_table", () -> createBlockItem(Blocks.SPRUCE_SANDWICH_ASSEMBLY_TABLE.get()));
    public static final RegistryObject<Item> BIRCH_SANDWICH_ASSEMBLY_TABLE = REGISTRY.register("birch_sandwich_assembly_table", () -> createBlockItem(Blocks.BIRCH_SANDWICH_ASSEMBLY_TABLE.get()));
    public static final RegistryObject<Item> JUNGLE_SANDWICH_ASSEMBLY_TABLE = REGISTRY.register("jungle_sandwich_assembly_table", () -> createBlockItem(Blocks.JUNGLE_SANDWICH_ASSEMBLY_TABLE.get()));
    public static final RegistryObject<Item> ACACIA_SANDWICH_ASSEMBLY_TABLE = REGISTRY.register("acacia_sandwich_assembly_table", () -> createBlockItem(Blocks.ACACIA_SANDWICH_ASSEMBLY_TABLE.get()));
    public static final RegistryObject<Item> DARK_OAK_SANDWICH_ASSEMBLY_TABLE = REGISTRY.register("dark_oak_sandwich_assembly_table", () -> createBlockItem(Blocks.DARK_OAK_SANDWICH_ASSEMBLY_TABLE.get()));
    public static final RegistryObject<Item> CRIMSON_SANDWICH_ASSEMBLY_TABLE = REGISTRY.register("crimson_sandwich_assembly_table", () -> createBlockItem(Blocks.CRIMSON_SANDWICH_ASSEMBLY_TABLE.get()));
    public static final RegistryObject<Item> WARPED_SANDWICH_ASSEMBLY_TABLE = REGISTRY.register("warped_sandwich_assembly_table", () -> createBlockItem(Blocks.WARPED_SANDWICH_ASSEMBLY_TABLE.get()));

    // cutting boards
    public static final RegistryObject<Item> OAK_CUTTING_BOARD = REGISTRY.register("oak_cutting_board", () -> createBlockItem(Blocks.OAK_CUTTING_BOARD.get()));
    public static final RegistryObject<Item> SPRUCE_CUTTING_BOARD = REGISTRY.register("spruce_cutting_board", () -> createBlockItem(Blocks.SPRUCE_CUTTING_BOARD.get()));
    public static final RegistryObject<Item> BIRCH_CUTTING_BOARD = REGISTRY.register("birch_cutting_board", () -> createBlockItem(Blocks.BIRCH_CUTTING_BOARD.get()));
    public static final RegistryObject<Item> JUNGLE_CUTTING_BOARD = REGISTRY.register("jungle_cutting_board", () -> createBlockItem(Blocks.JUNGLE_CUTTING_BOARD.get()));
    public static final RegistryObject<Item> ACACIA_CUTTING_BOARD = REGISTRY.register("acacia_cutting_board", () -> createBlockItem(Blocks.ACACIA_CUTTING_BOARD.get()));
    public static final RegistryObject<Item> DARK_OAK_CUTTING_BOARD = REGISTRY.register("dark_oak_cutting_board", () -> createBlockItem(Blocks.DARK_OAK_CUTTING_BOARD.get()));
    public static final RegistryObject<Item> CRIMSON_CUTTING_BOARD = REGISTRY.register("crimson_cutting_board", () -> createBlockItem(Blocks.CRIMSON_CUTTING_BOARD.get()));
    public static final RegistryObject<Item> WARPED_CUTTING_BOARD = REGISTRY.register("warped_cutting_board", () -> createBlockItem(Blocks.WARPED_CUTTING_BOARD.get()));

    // toasters
    public static final RegistryObject<Item> REDSTONE_TOASTER = REGISTRY.register("redstone_toaster", () -> createBlockItem(Blocks.REDSTONE_TOASTER.get()));
    public static final RegistryObject<Item> STICKY_REDSTONE_TOASTER = REGISTRY.register("sticky_redstone_toaster", () -> createBlockItem(Blocks.STICKY_REDSTONE_TOASTER.get()));
    public static final RegistryObject<Item> KITCHEN_KNIFE = REGISTRY.register("kitchen_knife", () -> new Item(new Item.Properties().group(CREATIVE_TAB).maxStackSize(1)));

    // foods
    public static final RegistryObject<Item> BREAD_SLICE = REGISTRY.register("bread_slice", () -> createFoodItem(Foods.BREAD_SLICE));
    public static final RegistryObject<Item> TOASTED_BREAD_SLICE = REGISTRY.register("toasted_bread_slice", () -> createFoodItem(Foods.TOASTED_BREAD_SLICE));
    public static final RegistryObject<Item> CHARRED_BREAD_SLICE = REGISTRY.register("charred_bread_slice", () -> createFoodItem(Foods.CHARRED_FOOD));
    public static final RegistryObject<Item> CHARRED_MORSEL = REGISTRY.register("charred_morsel", () -> createFoodItem(Foods.CHARRED_MORSEL));
    public static final RegistryObject<Item> CHARRED_FOOD = REGISTRY.register("charred_food", () -> createFoodItem(Foods.CHARRED_FOOD));
    public static final RegistryObject<Item> APPLE_SLICES = REGISTRY.register("apple_slices", () -> createFoodItem(Foods.APPLE_SLICES));
    public static final RegistryObject<Item> GOLDEN_APPLE_SLICES = REGISTRY.register("golden_apple_slices", () -> new Item(new Item.Properties().group(CREATIVE_TAB).food(Foods.GOLDEN_APPLE_SLICES).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENCHANTED_GOLDEN_APPLE_SLICES = REGISTRY.register("enchanted_golden_apple_slices", () -> new EnchantedGoldenAppleSlicesItem(new Item.Properties().group(CREATIVE_TAB).food(Foods.ENCHANTED_GOLDEN_APPLE_SLICES).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CHOPPED_CARROT = REGISTRY.register("chopped_carrot", () -> createFoodItem(Foods.CHOPPED_CARROT));
    public static final RegistryObject<Item> CHOPPED_GOLDEN_CARROT = REGISTRY.register("chopped_golden_carrot", () -> createFoodItem(Foods.CHOPPED_GOLDEN_CARROT));
    public static final RegistryObject<Item> CHOPPED_BEETROOT = REGISTRY.register("chopped_beetroot", () -> createFoodItem(Foods.CHOPPED_BEETROOT));
    public static final RegistryObject<Item> PORK_CUTS = REGISTRY.register("pork_cuts", () -> createFoodItem(Foods.PORK_CUTS));
    public static final RegistryObject<Item> BACON_STRIPS = REGISTRY.register("bacon_strips", () -> createFoodItem(Foods.BACON_STRIPS));
    public static final RegistryObject<Item> TOASTED_CRIMSON_FUNGUS = REGISTRY.register("toasted_crimson_fungus", () -> createFoodItem(Foods.TOASTED_CRIMSON_FUNGUS));
    public static final RegistryObject<Item> SLICED_TOASTED_CRIMSON_FUNGUS = REGISTRY.register("sliced_toasted_crimson_fungus", () -> createFoodItem(Foods.SLICED_TOASTED_CRIMSON_FUNGUS));
    public static final RegistryObject<Item> TOASTED_WARPED_FUNGUS = REGISTRY.register("toasted_warped_fungus", () -> createFoodItem(Foods.TOASTED_WARPED_FUNGUS));
    public static final RegistryObject<Item> SLICED_TOASTED_WARPED_FUNGUS = REGISTRY.register("sliced_toasted_warped_fungus", () -> createFoodItem(Foods.SLICED_TOASTED_WARPED_FUNGUS));
    public static final RegistryObject<Item> TOMATO = REGISTRY.register("tomato", () -> createFoodItem(Foods.TOMATO));
    public static final RegistryObject<Item> TOMATO_SLICES = REGISTRY.register("tomato_slices", () -> createFoodItem(Foods.TOMATO_SLICES));
    public static final RegistryObject<Item> LETTUCE_HEAD = REGISTRY.register("lettuce_head", () -> createFoodItem(Foods.LETTUCE_HEAD));
    public static final RegistryObject<Item> LETTUCE_LEAF = REGISTRY.register("lettuce_leaf", () -> createFoodItem(Foods.LETTUCE_LEAF));

    // spreadables
    public static final RegistryObject<Item> MAYONNAISE_BOTTLE = REGISTRY.register("mayonnaise_bottle", () -> createSpreadItem(Foods.MAYONNAISE));
    public static final RegistryObject<Item> KETCHUP_BOTTLE = REGISTRY.register("ketchup_bottle", () -> createSpreadItem(Foods.KETCHUP));
    public static final RegistryObject<Item> SWEET_BERRY_JAM_BOTTLE = REGISTRY.register("sweet_berry_jam_bottle", () -> createSpreadItem(Foods.SWEET_BERRY_JAM));

    // seeds
    public static final RegistryObject<Item> LETTUCE_SEEDS = REGISTRY.register("lettuce_seeds", () -> createSeedItem(Blocks.LETTUCE.get()));
    public static final RegistryObject<Item> TOMATO_SEEDS = REGISTRY.register("tomato_seeds", () -> createSeedItem(Blocks.TOMATOES.get()));

    private static Item createBlockItem(Block block) {
        return new BlockItem(block, new Item.Properties().group(CREATIVE_TAB));
    }

    private static Item createFoodItem(Food food) {
        return new Item(new Item.Properties().group(CREATIVE_TAB).food(food));
    }

    private static Item createSpreadItem(Food food) {
        return new DrinkableBottleItem(new Item.Properties().group(CREATIVE_TAB).containerItem(net.minecraft.item.Items.GLASS_BOTTLE).maxStackSize(16).food(food), SoundEvents.ITEM_HONEY_BOTTLE_DRINK);
    }

    private static Item createSeedItem(Block crop) {
        return new BlockNamedItem(crop, new Item.Properties().group(CREATIVE_TAB));
    }

    public static void registerCompostables() {
        // 30%
        ComposterBlock.CHANCES.put(BREAD_SLICE.get(), 0.3F);
        ComposterBlock.CHANCES.put(TOASTED_BREAD_SLICE.get(), 0.3F);
        ComposterBlock.CHANCES.put(CHARRED_BREAD_SLICE.get(), 0.3F);
        ComposterBlock.CHANCES.put(CHARRED_FOOD.get(), 0.3F);
        ComposterBlock.CHANCES.put(CHARRED_MORSEL.get(), 0.3F);
        ComposterBlock.CHANCES.put(APPLE_SLICES.get(), 0.3F);
        ComposterBlock.CHANCES.put(CHOPPED_CARROT.get(), 0.3F);
        ComposterBlock.CHANCES.put(CHOPPED_BEETROOT.get(), 0.3F);
        ComposterBlock.CHANCES.put(SLICED_TOASTED_CRIMSON_FUNGUS.get(), 0.3F);
        ComposterBlock.CHANCES.put(SLICED_TOASTED_CRIMSON_FUNGUS.get(), 0.3F);
        ComposterBlock.CHANCES.put(LETTUCE_SEEDS.get(), 0.3F);
        ComposterBlock.CHANCES.put(LETTUCE_LEAF.get(), 0.3F);
        ComposterBlock.CHANCES.put(TOMATO_SEEDS.get(), 0.3F);
        ComposterBlock.CHANCES.put(TOMATO_SLICES.get(), 0.3F);

        // 65%
        ComposterBlock.CHANCES.put(TOASTED_CRIMSON_FUNGUS.get(), 0.65F);
        ComposterBlock.CHANCES.put(TOASTED_WARPED_FUNGUS.get(), 0.65F);
        ComposterBlock.CHANCES.put(LETTUCE_HEAD.get(), 0.65F);
        ComposterBlock.CHANCES.put(TOMATO.get(), 0.65F);
    }
}
