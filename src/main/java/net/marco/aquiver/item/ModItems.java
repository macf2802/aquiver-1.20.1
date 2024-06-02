package net.marco.aquiver.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.marco.aquiver.Aquiver;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item QUIVER = registerItem("quiver", new Item(new FabricItemSettings()));

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(QUIVER);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Aquiver.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Aquiver.LOGGER.info("Registering Mod Items for " + Aquiver.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
