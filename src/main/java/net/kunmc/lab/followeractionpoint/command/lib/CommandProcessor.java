package net.kunmc.lab.followeractionpoint.command.lib;

import net.kunmc.lab.followeractionpoint.command.lib.Argument.Argument;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface CommandProcessor {
    @NotNull CommandResult execute(CommandSender sender, List<Argument> argument);
}
