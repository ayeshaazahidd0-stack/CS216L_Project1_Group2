package MusicPlaylistManager;
public class StackNode {
    SongNode songData;
    StackNode next;

    public StackNode(SongNode song) {
        // Deep copy of student/song node data to maintain isolation
        this.songData = new SongNode(song.id, song.title, song.artist, song.duration);
        this.next = null;
    }
}