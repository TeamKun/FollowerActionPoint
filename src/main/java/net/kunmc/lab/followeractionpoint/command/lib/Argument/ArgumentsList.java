package net.kunmc.lab.followeractionpoint.command.lib.Argument;

import java.util.ArrayList;
import java.util.List;

public class ArgumentsList {
    private List<Arguments> list = new ArrayList<>();

    public void add(Arguments arguments) {
        list.add(arguments);
    }

    public Arguments getMatchArguments(String[] args) {
        if (list.size() == 0) {
            return null;
        }

        for (Arguments arguments : list) {
            if (arguments.isMatchArgsLength(args)) {
                return arguments.setArguments(args);
            }
        }

        return null;
    }

    public List<String> argumentsNameList(int index) {
        List<String> result = new ArrayList<>();

        list.forEach(arguments -> {
            result.add(arguments.get(index).name());
        });

        return result;
    }

    public List<Arguments> get(int index) {
        List<Arguments> result = new ArrayList<>();

        list.forEach(arguments -> {
            if (arguments.size() >= index) {
                result.add(arguments);
            }
        });

        return result;
    }
}
