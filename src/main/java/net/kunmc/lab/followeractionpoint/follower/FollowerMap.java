package net.kunmc.lab.followeractionpoint.follower;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class FollowerMap {
    private HashMap<Player, Integer> map;

    public FollowerMap() {
        Csv.readCsv();
    }
}
