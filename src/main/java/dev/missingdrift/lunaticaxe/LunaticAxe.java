package dev.missingdrift.lunaticaxe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LunaticAxe extends JavaPlugin implements Listener {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getScheduler().runTaskLater(this, () -> {
            System.out.println("" +
                    "  _    _   _ _   _    _  _____ ___ ____      _    __  _______ \n" +
                    " | |  | | | | \\ | |  / \\|_   _|_ _/ ___|    / \\   \\ \\/ / ____|\n" +
                    " | |  | | | |  \\| | / _ \\ | |  | | |       / _ \\   \\  /|  _|  \n" +
                    " | |__| |_| | |\\  |/ ___ \\| |  | | |___   / ___ \\  /  \\| |___ \n" +
                    " |_____\\___/|_| \\_/_/   \\_\\_| |___\\____| /_/   \\_\\/_/\\_\\_____|\n" +
                    "                                                              \n" +
                    " Author: MissingDrift\n" +
                    " Version: 1.0\n" +
                    "\n" +
                    " Caricamento del plugin...\n");
            try {
                Thread.sleep(5000);
                System.out.println("" +
                        "[LUNATICAXE] Caricamento in corso (1/3)\n" +
                        "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000);
                System.out.println("" +
                        "[LUNATICAXE] Validamento in corso (2/3)\n" +
                        "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
                System.out.println("" +
                        "[LUNATICAXE] Valori applicati correttamente (3/3)\n");
                System.out.println("" +
                        "[LUNATICAXE] Plugin caricato correttamente");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 20 * 5);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();
        Material axeType = player.getInventory().getItemInMainHand().getType();

        if (axeType.name().endsWith("_AXE")) {
            String configPath = axeType.name().toLowerCase() + "_damage";
            double damage = config.getDouble(configPath);
            event.setDamage(damage);
        }
    }
}