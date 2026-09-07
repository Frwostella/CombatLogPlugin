package jre.frwostella.combatLogPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jspecify.annotations.NonNull;

public class CombatLogPlugin extends JavaPlugin {

    private static CombatLogPlugin instance;
    private CombatManager combatManager;

    public static CombatLogPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        combatManager = new CombatManager(this);

        getServer().getPluginManager().registerEvents(
                new CombatListener(combatManager), this
        );

        getLogger().info("CombatLog Enabled!");
    }

    public CombatManager getCombatManager() {
        return combatManager;
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, Command command, @NonNull String label, String @NonNull [] args) {

        if (command.getName().equalsIgnoreCase("combatlog")) {

            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {

                if (!sender.hasPermission("combatlog.reload")) {
                    sender.sendMessage(color("&cNo permission."));
                    return true;
                }

                reloadConfig();
                sender.sendMessage(color("&aCombatLog config reloaded!"));
                return true;
            }

            sender.sendMessage(color("&eUsage: /combatlog reload"));
            return true;
        }

        return false;
    }

    private String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}