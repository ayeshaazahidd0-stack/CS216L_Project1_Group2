package MusicPlaylistManager;

public class PlayListLinkedList {
    private SongNode head;
    private SongNode tail;

    public PlayListLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addSong(int id, String title, String artist, double duration) {
        SongNode newNode = new SongNode(id, title, artist, duration);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("-> Song added to playlist successfully.");
    }

    public boolean removeSong(int id) {
        SongNode current = head;

        while (current != null) {
            if (current.id == id) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                current.next = null;
                current.prev = null;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public SongNode searchByTitle(String title) {
        SongNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title.trim())) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void sortByDuration() {
        if (head == null || head.next == null) {
            System.out.println("-> Playlist has insufficient songs to sort.");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            SongNode current = head;
            while (current.next != null) {
                if (current.duration > current.next.duration) {
                    int tempId = current.id;
                    String tempTitle = current.title;
                    String tempArtist = current.artist;
                    double tempDuration = current.duration;

                    current.id = current.next.id;
                    current.title = current.next.title;
                    current.artist = current.next.artist;
                    current.duration = current.next.duration;

                    current.next.id = tempId;
                    current.next.title = tempTitle;
                    current.next.artist = tempArtist;
                    current.next.duration = tempDuration;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("-> Playlist sorted by duration (Shortest to Longest).");
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("-> The playlist is empty.");
            return;
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("             CURRENT PLAYLIST              ");
        System.out.println("-------------------------------------------");
        System.out.printf("%-5s %-20s %-15s %-10s\n", "ID", "Title", "Artist", "Duration");
        System.out.println("-------------------------------------------");
        SongNode current = head;
        while (current != null) {
            System.out.printf("%-5d %-20s %-15s %-10.2f min\n", current.id, current.title, current.artist, current.duration);
            current = current.next;
        }
        System.out.println("-------------------------------------------");
    }
}