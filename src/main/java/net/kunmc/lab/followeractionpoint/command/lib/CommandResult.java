package net.kunmc.lab.followeractionpoint.command.lib;

import net.kunmc.lab.followeractionpoint.util.DecorationConst;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class CommandResult {

    private CommandSender sender;
    private boolean isError;
    private Component message;

    public CommandResult(CommandSender sender, boolean isError, Component message, SendTarget sendTarget) {
        this.sender = sender;
        this.isError = isError;
        this.message = message;

        if (sendTarget.equals(SendTarget.SENDER)) {
            sendMessageToSender();
            return;
        }

        broadcastMessage();
    }

    public static CommandResult unknownCommandError(CommandSender sender) {
        return new CommandResult(sender,
                true,
                Component.text(DecorationConst.RED + "ERROR: 不明なコマンドです"),
                SendTarget.SENDER);
    }

    public static CommandResult incorrectArgsTypeError(CommandSender sender) {
        return new CommandResult(sender,
                true,
                Component.text(DecorationConst.RED + "ERROR: 引数が不正です"),
                SendTarget.SENDER
                );
    }

    public static CommandResult playerNotFoundError(CommandSender sender) {
        return new CommandResult(sender,
                true,
                Component.text(DecorationConst.RED + "ERROR: 指定したプレイヤーは存在しません"),
                SendTarget.SENDER
        );
    }

    public boolean isError() {
        return this.isError;
    }

    public Component message() {
        return this.message;
    }

    public void sendMessageToSender() {
        this.sender.sendMessage(this.message);
    }

    public void broadcastMessage() {
        Bukkit.broadcast(this.message);
    }
}
