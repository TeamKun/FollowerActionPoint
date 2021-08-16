package net.kunmc.lab.followeractionpoint.command.lib.Argument;

import net.kunmc.lab.followeractionpoint.command.lib.CommandProcessor;
import net.kunmc.lab.followeractionpoint.command.lib.CommandResult;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Arguments {
    private List<Argument> list = new ArrayList<>();
    private CommandProcessor commandProcessor;

    public Arguments(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public Arguments addArgument(String name, Argument.ArgumentType type) {
        list.add(new Argument(name, type));
        return this;
    }

    public boolean isMatchArgsLength(String[] args) {
        return list.size() == args.length;
    }

    Arguments setArguments(String[] args) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).setValue(args[i])) {
                return null;
            }
        }

        return this;
    }

    public CommandResult execute(CommandSender sender) {
        return commandProcessor.execute(sender, list);
    }

    public Argument get(int index) {
        return list.get(index);
    }

    public int size() {
        return this.list.size();
    }
}
