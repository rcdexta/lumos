package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenre {

    public static Map<String, List<String>> findForUser(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {

        Map<String, String> songAndGenre = new HashMap<>();
        //O(g*s);
        for (String genre : songGenres.keySet()) {
            for (String song : songGenres.get(genre)) {
                songAndGenre.put(song, genre);
            }
        }

        Map<String, List<String>> userFavorites = new HashMap<>();


        //O(u*(s+g))
        for (String user: userSongs.keySet()) {
            userFavorites.put(user, new ArrayList<>());
            int max = 0;
            Map<String, Integer> genreCount = new HashMap<>();
            for (String song : userSongs.get(user)) {
                String genre = songAndGenre.get(song);
                Integer count = genreCount.getOrDefault(genre, 0);
                count++;
                max = Math.max(count, max);
                genreCount.put(genre, count);
            }

            for (String genre : genreCount.keySet()) {
                Integer count = genreCount.get(genre);
                if (count.equals(max)) {
                    userFavorites.get(user).add(genre);
                }
            }
        }

        return userFavorites;
    }
}
