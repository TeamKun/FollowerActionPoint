package net.kunmc.lab.followeractionpoint.command.lib.Argument;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Argument {

    public enum ArgumentType {
        STRING,
        INT,
        FLOAT,
        ONLINE_PLAYER;
    }

    private String name;
    private ArgumentType type;
    private Object value;

    public Argument(String name, ArgumentType type) {
        this.name = name;
        this.type = type;
    }

    public String name() {
        if (type.equals(ArgumentType.ONLINE_PLAYER)) {
            return null;
        }
        return "<" + this.name + ">";
    }

    public String stringValue() {
        return (String) this.value;
    }

    public int intValue() {
        return (int) this.value;
    }

    public Float floatValue() {
        return (Float) this.value;
    }

    public Player playerValue() {
        return (Player) this.value;
    }

    public boolean setValue(String value) {
        switch (this.type) {
            case STRING:
                this.value = value;
                return false;
            case INT:
                return setInt(value);
            case FLOAT:
                return setFloat(value);
            case ONLINE_PLAYER:
                return setOnlinePLayer(value);
            default:
                return true;
        }
    }

    private boolean setInt(String value) {
        try {
            this.value = Integer.parseInt(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean setFloat(String value) {
        try {
            this.value = Float.parseFloat(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean setOnlinePLayer(String value) {
        Player player = Bukkit.getPlayer(value);
        if (player == null) {
            return true;
        }
        this.value = player;
        return false;
    }
}
