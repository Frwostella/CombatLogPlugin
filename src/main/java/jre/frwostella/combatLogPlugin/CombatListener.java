package jre.frwostella.combatLogPlugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.projectiles.ProjectileSource;

public class CombatListener implements Listener {

    private final CombatManager manager;

    public CombatListener(CombatManager manager) {
        this.manager = manager;
    }

    @EventHandler(ignoreCancelled = true)
    public void onHit(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player victim)) return;

        Player attacker = null;

        if (event.getDamager() instanceof Player) {
            attacker = (Player) event.getDamager();
        }

        if (event.getDamager() instanceof Projectile projectile && event.getFinalDamage() > 0) {
            ProjectileSource shooter = projectile.getShooter();

            if (shooter instanceof Player) {
                attacker = (Player) shooter;
            }
        }

        if (attacker == null) return;

        manager.tag(victim, attacker);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player dead = event.getEntity();
        manager.handleDeath(dead);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (manager.isInCombat(player)) {
            String action = CombatLogPlugin.getInstance()
                    .getConfig().getString("logout-action");
            if (action == null) return;

            if (action.equalsIgnoreCase("kill")) {
                player.setHealth(0.0);
            } else if (action.equalsIgnoreCase("command")) {
                String _cmd = CombatLogPlugin.getInstance()
                        .getConfig()
                        .getString("logout-command");
                if (_cmd == null) return;
                String cmd = _cmd.replace("%player%", player.getName());

                Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(), cmd
                );
            }
        }

        manager.remove(player);
    }
}