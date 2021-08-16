package net.kunmc.lab.followeractionpoint.follower;

import net.kunmc.lab.followeractionpoint.FollowerActionPoint;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Csv {

    private static final String FILE_PATH = "follower.csv";
    /**
     * 問題csvを読み込み
     */
     static List<String[]> readCsv() {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(FollowerActionPoint.plugin.getResource(FILE_PATH), StandardCharsets.UTF_8));

            List<String[]> csvInput = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                csvInput.add(data);
            }
            return csvInput;

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
