package net.lilbabywipes.fentmod;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Optional;

public class utils {
    public static boolean hasItem(PlayerInventory inventory, Item item) {
        return inventory.main.stream().anyMatch(stack -> stack.isOf(item));
    }

    public static Optional<ItemStack> getItemFromInventory(PlayerInventory inventory, Item item) {
        boolean hasItem = inventory.main.stream().anyMatch(stack -> stack.isOf(item));
        if (hasItem) {
            List<ItemStack> inv = inventory.main.stream().toList();
            for (int i = 0; i < inventory.size(); i++) {
                if (inv.get(i).isOf(item)) {
                    return Optional.of(inv.get(i));
                }
            }
        }

        return Optional.empty();
    }

}
