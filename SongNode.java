package MusicPlaylistManager;
public class SongNode {
    int id;
    String title;
    String artist;
    double duration;
    SongNode next;
    SongNode prev;

    public SongNode(int id, String title, String artist, double duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.next = null;
        this.prev = null;
    }
}