package net.greenwoodmc.respawnplugin.commands;

import net.greenwoodmc.respawnplugin.RespawnPlugin;
import net.greenwoodmc.respawnplugin.util.TextUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class resplug implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        } else {
            Player player = (Player) sender;
            FileConfiguration config = JavaPlugin.getPlugin(RespawnPlugin.class).getConfig();
            String ver;
            String arg1;
            String arg2;
            JavaPlugin plug = JavaPlugin.getPlugin(RespawnPlugin.class);
            if (cmd.getName().equalsIgnoreCase("resplug")) {
                if (args.length >= 1) {
                    arg1 = args[0];
                    arg2 = args[1];
                    if (arg1.equalsIgnoreCase("reload") || (arg1.equalsIgnoreCase("rl"))){
                        if (player.hasPermission("resplug.main.reload")) {
                            ver = config.getString("reloadMsg");
                            plug.reloadConfig();
                            player.sendMessage(TextUtil.color(ver));
                        } else {
                            player.sendMessage(TextUtil.color(config.getString("noPerm")));
                        }
                    }
                    if (arg1.equalsIgnoreCase("setspawn") || (arg1.equalsIgnoreCase("ss"))){
                        if (player.hasPermission("resplug.main.setspawn")) {
                            double xcoord = player.getLocation().getX();
                            double ycoord = player.getLocation().getY();
                            double zcoord = player.getLocation().getZ();
                            float yaw = player.getLocation().getYaw();
                            float pitch = player.getLocation().getPitch();
                            String world = player.getLocation().getWorld().getName();

                            if (arg2.equalsIgnoreCase("guest")) {
                                config.set("spawns.guest.x", xcoord);
                                config.set("spawns.guest.y", ycoord);
                                config.set("spawns.guest.z", zcoord);
                                config.set("spawns.guest.yaw", yaw);
                                config.set("spawns.guest.pitch", pitch);
                                config.set("spawns.guest.world", world);
                                plug.saveConfig();
                            }
                            if (arg2.equalsIgnoreCase("vip")) {
                                config.set("spawns.vip.x", xcoord);
                                config.set("spawns.vip.y", ycoord);
                                config.set("spawns.vip.z", zcoord);
                                config.set("spawns.vip.yaw", yaw);
                                config.set("spawns.vip.pitch", pitch);
                                config.set("spawns.vip.world", world);
                                plug.saveConfig();
                            }
                            if (arg2.equalsIgnoreCase("staff")) {
                                config.set("spawns.staff.x", xcoord);
                                config.set("spawns.staff.y", ycoord);
                                config.set("spawns.staff.z", zcoord);
                                config.set("spawns.staff.yaw", yaw);
                                config.set("spawns.staff.pitch", pitch);
                                config.set("spawns.staff.world", world);
                                plug.saveConfig();
                            }
                            player.sendMessage(TextUtil.color("&eSpawn set for &d" + arg2));

                        } else {
                            player.sendMessage(TextUtil.color(config.getString("noPerm")));
                        }
                    }
                }
            }
        }
        return false;
    }
}
