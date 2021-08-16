package net.kunmc.lab.followeractionpoint.command.lib;

import java.util.ArrayList;
import java.util.List;

public class SubCommands {
    private List<CommandObject> list = new ArrayList<>();

    public void add(CommandObject subcommand) {
        this.list.add(subcommand);
    }

    public CommandObject getMatchSubcommand(String name) {
        // サブコマンド登録なし
        if (list.size() == 0) {
            return null;
        }

        // 一致したコマンドを探す
        for (CommandObject subcommand : list) {
            // 一致あり
            if (subcommand.isMatch(name)) {
                return subcommand;
            }
        }

        // 一致なし
        return null;
    }

    public List<String> commandNameList() {
        List<String> result = new ArrayList<>();

        list.forEach(subCommand -> {
            result.add(subCommand.name());
        });

        return result;
    }
}
