/**
 * HashMap
 */

import java.util.Set;
import java.util.HashMap;
public class HashMapEx {
    public static void main(String[] args) {

        HashMap<String, String> trackList = new HashMap<String, String>();
        
        trackList.put("Song 1", "Sample Lyric 1");
        trackList.put("Song 2", "Sample Lyric 2");
        trackList.put("Song 3", "Sample Lyric 3");
        trackList.put("Song 4", "Sample Lyric 4");

        Set<String> keys = trackList.keySet();
        for(String key: keys){
            System.out.println("Track: " + key + " Lyrics: " + trackList.get(key));
        }
    }
}