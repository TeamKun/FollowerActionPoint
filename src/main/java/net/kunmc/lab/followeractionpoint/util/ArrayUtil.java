package net.kunmc.lab.followeractionpoint.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {

    public static String[] removeFirst(String[] strings) {
        // 配列をリストに変換
        List<String> list = new ArrayList<String>(Arrays.asList(strings));

        // 一番目を消去
        list.remove(0);

        return (String[]) list.toArray(new String[list.size()]);
    }
}
