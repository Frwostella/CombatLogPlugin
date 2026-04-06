package jre.frwostella.combatLogPlugin;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class CombatManager {

    private final CombatLogPlugin plugin;

    private final Map<UUID, Long> combatMap = new HashMap<>();
    private final Map<UUID, UUID> lastOpponent = new HashMap<>();

    public CombatManager(CombatLogPlugin plugin) {
        this.plugin = plugin;
        startTask();
    }

    public void tag(Player p1, Player p2) {
        int combatTime = plugin.getConfig().getInt("combat-time");

        long expireTime = System.currentTimeMillis() + (combatTime * 1000);

        boolean wasInCombat1 = isInCombat(p1);
        boolean wasInCombat2 = isInCombat(p2);

        combatMap.put(p1.getUniqueId(), expireTime);
        combatMap.put(p2.getUniqueId(), expireTime);

        lastOpponent.put(p1.getUniqueId(), p2.getUniqueId());
        lastOpponent.put(p2.getUniqueId(), p1.getUniqueId());

        // Only send message ONCE when entering combat
        if (!wasInCombat1) {
            p1.sendMessage(color(plugin.getConfig().getString("messages.tagged")));
        }
        if (!wasInCombat2) {
            p2.sendMessage(color(plugin.getConfig().getString("messages.tagged")));
        }
    }

    public boolean isInCombat(Player player) {
        if (!combatMap.containsKey(player.getUniqueId())) return false;

        long timeLeft = combatMap.get(player.getUniqueId()) - System.currentTimeMillis();

        if (timeLeft <= 0) {
            remove(player);
            player.sendMessage(color(plugin.getConfig().getString("messages.safe")));
            return false;
        }

        return true;
    }

    public void handleDeath(Player dead) {
        UUID opponentUUID = lastOpponent.get(dead.getUniqueId());
        if (opponentUUID == null) return;

        Player opponent = Bukkit.getPlayer(opponentUUID);
        if (opponent != null) {
            remove(opponent);
            opponent.sendMessage(color(plugin.getConfig().getString("messages.safe")));
        }

        remove(dead);
    }

    public void remove(Player player) {
        combatMap.remove(player.getUniqueId());
        lastOpponent.remove(player.getUniqueId());
    }

    public int getTimeLeft(Player player) {
        if (!combatMap.containsKey(player.getUniqueId())) return 0;

        return (int) ((combatMap.get(player.getUniqueId())
                - System.currentTimeMillis()) / 1000);
    }

    private void startTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (UUID uuid : combatMap.keySet()) {
                    Player player = Bukkit.getPlayer(uuid);
                    if (player == null) continue;

                    if (!isInCombat(player)) continue;

                    int timeLeft = getTimeLeft(player);

                    String msg = plugin.getConfig()
                            .getString("messages.actionbar")
                            .replace("%time%", String.valueOf(timeLeft));

                    player.spigot().sendMessage(
                            ChatMessageType.ACTION_BAR,
                            new TextComponent(color(msg))
                    );
                }
            }
        }.runTaskTimer(plugin, 0L, 20L);
    }

    private String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}