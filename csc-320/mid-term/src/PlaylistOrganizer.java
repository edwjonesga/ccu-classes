
import java.util.List;
public class PlaylistOrganizer {
    /*
     * You are working on an **automated playlist manager** that organizes songs
     * in a music streaming app. Each song has a unique ranking based on user ratings.
     * 
     * Implement a method that sorts the songs efficiently so that they appear
     * in ascending order of ranking.
     * 
     * Points: 45
     */

    class Song {
        private String name;
        private String artist;
        private int ranking;

        public Song(String name, String artist, int ranking) {
            this.name = name;
            this.artist = artist;
            this.ranking = ranking;
        }

        public int getRanking() {
            return ranking;
        }

        @Override
        public String toString() {
            return name + " by " + artist + " (Ranking: " + ranking + ")";
        }
    }

    /**
     * Sorts the playlist based on song rankings. Be sure that the sort modifies the specified list.
     * Do not use sort libraries available in java.
     * @param songs List of songs to be sorted.
     */
    public static void sortPlaylist(List<Song> songs) {
        // TODO: Implement a divide-and-conquer sorting method based on getRanking()
    }
}
