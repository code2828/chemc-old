package com.byethost8.code2828.mcmods.chemc;

import com.byethost8.code2828.mcmods.chemc.items.Chlorine;
import com.byethost8.code2828.mcmods.chemc.items.Hydrogen;
import com.byethost8.code2828.mcmods.chemc.items.HydrogenChloride;
import com.byethost8.code2828.mcmods.chemc.items.Lithium;
import com.byethost8.code2828.mcmods.chemc.items.Nitrogen;
import com.byethost8.code2828.mcmods.chemc.items.Oxygen;
import com.byethost8.code2828.mcmods.chemc.tools.CheMCItemTier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CheMC.modid)
public class CheMC {
    public static final String modid = "chemc";
    public static final Properties ItemPropertiesGas = new Properties().group(ItemGroup.MATERIALS);
    public static final Properties ItemPropertiesIngot = new Properties().group(ItemGroup.MATERIALS);
    public static Item i_h = new Hydrogen(ItemPropertiesGas).setRegistryName("chemc", "hydrogen");
    public static Item i_o = new Oxygen(ItemPropertiesGas).setRegistryName("chemc", "oxygen");
    public static Item i_n = new Nitrogen(ItemPropertiesGas).setRegistryName("chemc", "nitrogen");
    public static Item i_cl = new Chlorine(ItemPropertiesGas).setRegistryName("chemc", "chlorine");
    public static Item i_hcl = new HydrogenChloride(ItemPropertiesGas).setRegistryName("chemc", "hydrogen_chloride");
    public static Item i_li = new Lithium(ItemPropertiesIngot).setRegistryName("chemc", "lithium_ingot");
    public static PickaxeItem pickaxe_lithium = (PickaxeItem) new PickaxeItem(CheMCItemTier.SOFT_METAL, 3, -2,
            new Properties()).setRegistryName("chemc", "lithium_pickaxe");
    public static SwordItem sword_lithium = (SwordItem) new SwordItem(CheMCItemTier.SOFT_METAL, 3, 0, new Properties())
            .setRegistryName("chemc", "lithium_sword");
    public static AxeItem axe_lithium = (AxeItem) new AxeItem(CheMCItemTier.SOFT_METAL, 6, -2.8F, new Properties())
            .setRegistryName("chemc", "lithium_axe");
    public static HoeItem hoe_lithium = (HoeItem) new HoeItem(CheMCItemTier.SOFT_METAL, 1, -2.9F, new Properties())
            .setRegistryName("chemc", "lithium_hoe");
    public static ShovelItem shovel_lithium = (ShovelItem) new ShovelItem(CheMCItemTier.SOFT_METAL, 1, -3.1F,
            new Properties()).setRegistryName("chemc", "lithium_shovel");
    public static OreBlock ore_lithium = (OreBlock) new OreBlock(
            AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK_TERRACOTTA).harvestLevel(1)
                    .hardnessAndResistance(1, 1).setLightLevel((light) -> {
                        return 1;
                    })).setRegistryName("chemc", "lithium_ore");
    public static BlockItem i_ore_lithium = (BlockItem) new BlockItem(ore_lithium,
            new Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ore_lithium.getRegistryName());
    public static Block block_lithium = new Block(
            AbstractBlock.Properties.create(Material.IRON, MaterialColor.PINK_TERRACOTTA).harvestLevel(1)
                    .hardnessAndResistance(1.2F, 1).setLightLevel((light) -> {
                        return 1;
                    })).setRegistryName("chemc", "lithium_block");
    public static BlockItem i_block_lithium = (BlockItem) new BlockItem(block_lithium,
            new Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block_lithium.getRegistryName());;

    public CheMC() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    // You can use EventBusSubscriber to automatically subscribe events on the
    // contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            blockRegistryEvent.getRegistry().registerAll(ore_lithium, block_lithium);
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            // register a new item here
            itemRegistryEvent.getRegistry().registerAll(i_h, i_o, i_n, i_cl, i_hcl, i_li, sword_lithium,
                    pickaxe_lithium, axe_lithium, shovel_lithium, hoe_lithium, i_ore_lithium, i_block_lithium);
        }
    }
}
