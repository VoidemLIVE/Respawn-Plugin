package net.greenwoodmc.respawnplugin.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class resplugTabComplete implements TabCompleter {

    private static final String[] COMMANDS = new String[]{"reload", "setspawn"};
    private static final String[] SPAWNS = new String[]{"guest", "vip", "staff"};

    public resplugTabComplete() {
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList();
            StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS), completions);
            Collections.sort(completions);
            return completions;
        }
        else if (args.length == 2) {
            List<String> completions1 = new ArrayList();
            StringUtil.copyPartialMatches(args[1], Arrays.asList(SPAWNS), completions1);
            Collections.sort(completions1);
            return completions1;
            }
        return null;
    }
}
