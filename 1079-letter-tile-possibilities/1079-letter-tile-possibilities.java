import java.util.*;

class Solution {
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        HashSet<String> set = new HashSet<>();

        backtrack(tiles, used, set, "");

        return set.size() - 1;
    }

    public void backtrack(String tile, boolean[] used,
                          HashSet<String> set, String curr) {

        if (set.contains(curr)) {
            return;
        }

        set.add(curr);

        for (int i = 0; i < tile.length(); i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;

            backtrack(tile, used, set, curr + tile.charAt(i));

            used[i] = false;
        }
    }
}