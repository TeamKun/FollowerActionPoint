package net.kunmc.lab.followeractionpoint.command.lib;

import net.kunmc.lab.followeractionpoint.command.lib.Argument.Arguments;
import net.kunmc.lab.followeractionpoint.command.lib.Argument.ArgumentsList;
import net.kunmc.lab.followeractionpoint.util.ArrayUtil;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandObject {

    private String name;

    private CommandProcessor commandProcessor;

    private SubCommands subCommands = new SubCommands();

    private ArgumentsList argumentsList = new ArgumentsList();

    public CommandObject(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public CommandObject addSubcommand(CommandObject subcommand) {
        subCommands.add(subcommand);
        return this;
    }

    public CommandObject addArguments(Arguments arguments) {
        this.argumentsList.add(arguments);
        return this;
    }

    public CommandObject setFinalizer(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
        return this;
    }

    public boolean isMatch(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    public CommandResult execute(CommandSender sender, String[] args) {

        // 引数なし
        if (args.length == 0) {
            if (commandProcessor == null) {
                // エラー: 不明なコマンド
                return CommandResult.unknownCommandError(sender);
            }
            return commandProcessor.execute(sender, null);
        }

        // 引数あり
        // サブコマンドの確認
        CommandObject subcommand = subCommands.getMatchSubcommand(args[0]);
        if (subcommand != null) {
            // 引数の先頭を削除してサブコマンドを実行
            return subcommand.execute(sender, ArrayUtil.removeFirst(args));
        }

        Arguments arguments = argumentsList.getMatchArguments(args);
        // 値の確認
        if (arguments != null) {
            return arguments.execute(sender);
        }

        // エラー: 不明なコマンド
        return CommandResult.incorrectArgsTypeError(sender);
    }
}
