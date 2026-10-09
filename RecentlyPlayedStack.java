package MusicPlaylistManager;

public class RecentlyPlayedStack {
    private StackNode top;

    public RecentlyPlayedStack() {
        this.top = null;
    }

    public void push(SongNode song) {
        StackNode newNode = new StackNode(song);
        newNode.next = top;
        top = newNode;
    }

    public void displayHistory() {
        if (isEmpty()) {
            System.out.println("-> No recently played songs.");
            return;
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("          RECENTLY PLAYED SONGS (STACK)    ");
        System.out.println("-------------------------------------------");
        System.out.printf("%-5s %-20s %-15s %-10s\n", "ID", "Title", "Artist", "Duration");
        System.out.println("-------------------------------------------");

        StackNode current = top;
        while (current != null) {
            SongNode s = current.songData;
            System.out.printf("%-5d %-20s %-15s %-10.2f min\n", s.id, s.title, s.artist, s.duration);
            current = current.next;
        }
        System.out.println("-------------------------------------------");
    }

    public boolean isEmpty() {
        return top == null;
    }
}