package net.greenwoodmc.respawnplugin.util.colour.patterns;

import net.greenwoodmc.respawnplugin.util.colour.IridiumColorAPI;

import java.util.regex.Matcher;

public class RainbowPattern implements net.greenwoodmc.respawnplugin.util.colour.patterns.Pattern {
    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("<RAINBOW([0-9]{1,3})>(.*?)</RAINBOW>");

    public RainbowPattern() {
    }

    public String process(String string) {
        String saturation;
        String content;
        for (Matcher matcher = this.pattern.matcher(string); matcher.find(); string = string.replace(matcher.group(), IridiumColorAPI.rainbow(content, Float.parseFloat(saturation)))) {
            saturation = matcher.group(1);
            content = matcher.group(2);
        }

        return string;
    }
}

