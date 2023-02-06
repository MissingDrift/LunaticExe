package dev.missingdrift.lunaticaxe.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class onEntityDamage {
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();
        Material axeType = player.getInventory().getItemInMainHand().getType();
    }
}
