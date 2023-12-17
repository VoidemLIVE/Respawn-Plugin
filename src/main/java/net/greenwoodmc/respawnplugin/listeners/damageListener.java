package net.greenwoodmc.respawnplugin.listeners;

import net.greenwoodmc.respawnplugin.RespawnPlugin;
import net.greenwoodmc.respawnplugin.util.TextUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class damageListener implements Listener {
    public damageListener() {
    }

    @EventHandler
    public void onDmg(EntityDamageEvent ev) {
        FileConfiguration config = JavaPlugin.getPlugin(RespawnPlugin.class).getConfig();
        if (ev.getEntity() != null && ev.getEntity() instanceof Player) {
            Player player = (Player)ev.getEntity();
            double health = player.getHealth();
            if (!(health - ev.getDamage() > 0.0D)) {
                // Respawn player
                double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                ev.setDamage(0.1D);
                player.setHealth(maxHealth);
                // Set spawns depending on rank (more could be added idk, for now all donators same spawn)
                if (player.hasPermission("resplug.guest")) {
                    double xcoord = config.getDouble("spawns.guest.x");
                    double ycoord = config.getDouble("spawns.guest.y");
                    double zcoord = config.getDouble("spawns.guest.z");
                    float yaw = (float) config.getDouble("spawns.guest.yaw");
                    float pitch = (float) config.getDouble("spawns.guest.pitch");
                    Location loc = Bukkit.getWorld(config.getString("spawns.guest.world")).getSpawnLocation();
                    loc.setX(xcoord);
                    loc.setY(ycoord);
                    loc.setZ(zcoord);
                    loc.setYaw(yaw);
                    loc.setPitch(pitch);
                    player.teleport(loc);
                }
                if (player.hasPermission("resplug.vip")) {
                    double xcoord = config.getDouble("spawns.vip.x");
                    double ycoord = config.getDouble("spawns.vip.y");
                    double zcoord = config.getDouble("spawns.vip.z");
                    float yaw = (float) config.getDouble("spawns.vip.yaw");
                    float pitch = (float) config.getDouble("spawns.vip.pitch");
                    Location loc = Bukkit.getWorld(config.getString("spawns.vip.world")).getSpawnLocation();
                    loc.setX(xcoord);
                    loc.setY(ycoord);
                    loc.setZ(zcoord);
                    loc.setYaw(yaw);
                    loc.setPitch(pitch);
                    player.teleport(loc);
                }
                if (player.hasPermission("resplug.staff")) {
                    double xcoord = config.getDouble("spawns.staff.x");
                    double ycoord = config.getDouble("spawns.staff.y");
                    double zcoord = config.getDouble("spawns.staff.z");
                    float yaw = (float) config.getDouble("spawns.staff.yaw");
                    float pitch = (float) config.getDouble("spawns.staff.pitch");
                    Location loc = Bukkit.getWorld(config.getString("spawns.staff.world")).getSpawnLocation();
                    loc.setX(xcoord);
                    loc.setY(ycoord);
                    loc.setZ(zcoord);
                    loc.setYaw(yaw);
                    loc.setPitch(pitch);
                    player.teleport(loc);
                }
                String deathString = config.getString("deathMsg");
                String newString = deathString.replaceAll("%PLAYER%", player.getName());
                Bukkit.broadcastMessage(TextUtil.color(newString));
            }
        }
    }
}
