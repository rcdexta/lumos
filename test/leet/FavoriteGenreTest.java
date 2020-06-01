package leet;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FavoriteGenreTest {

    @Test
    void findForUser() {
        Map<String, List<String>> userSongs = new HashMap<String, List<String>>() {{
            put("David", asList("song1", "song2", "song3", "song4", "song8"));
            put("Emma", asList("song5", "song6", "song7"));
        }};

        Map<String, List<String>> songGenres = new HashMap<String, List<String>>() {{
                    put("Rock", asList("song1", "song3"));
                    put("Dubstep", Collections.singletonList("song7"));
                    put("Techno", asList("song2", "song4"));
                    put("Pop", asList("song5", "song6"));
                    put("Jazz", asList("song8", "song9"));
        }};

        Map<String, List<String>> forUser = FavoriteGenre.findForUser(userSongs, songGenres);

        assertEquals(asList("Rock", "Techno"), forUser.get("David"));
        assertEquals(asList("Pop"), forUser.get("Emma"));

    }
}