package MusicPlaylistManager;
import java.util.Scanner;

public class MusicPlaylistManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayListLinkedList playlist = new PlayListLinkedList();
        RecentlyPlayedStack playedStack = new RecentlyPlayedStack();

        while (true) {
            System.out.println("\n===========================================");
            System.out.println("      MUSIC PLAYLIST MANAGER (CS216L)      ");
            System.out.println("===========================================");
            System.out.println("1. Add Song to Playlist");
            System.out.println("2. Remove Song by I1D");
            System.out.println("3. Search Song by Title (Linear Search)");
            System.out.println("4. Sort Playlist by Duration (Bubble Sort)");
            System.out.println("5. Play Song (Pushes to Recently Played)");
            System.out.println("6. View Recently Played History (Stack)");
            System.out.println("7. Display Full Playlist");
            System.out.println("8. Exit");
            System.out.print("Choose an option (1-8): ");

            if (!scanner.hasNextInt()) {
                System.out.println("-> Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Song ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Song Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Artist Name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter Duration (in minutes, e.g. 3.5): ");
                    double duration = scanner.nextDouble();

                    if (duration <= 0) {
                        System.out.println("-> Duration must be greater than 0.");
                    } else {
                        playlist.addSong(id, title, artist, duration);
                    }
                    break;

                case 2:
                    System.out.print("Enter Song ID to remove: ");
                    int removeId = scanner.nextInt();
                    if (playlist.removeSong(removeId)) {
                        System.out.println("-> Song removed successfully.");
                    } else {
                        System.out.println("-> Song ID not found.");
                    }
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter Song Title to search: ");
                    String searchTitle = scanner.nextLine();
                    SongNode found = playlist.searchByTitle(searchTitle);
                    if (found != null) {
                        System.out.println("-> Song Found! ID: " + found.id + " | Title: " + found.title + " | Artist: " + found.artist + " | Duration: " + found.duration + " mins");
                    } else {
                        System.out.println("-> Song not found in playlist.");
                    }
                    break;

                case 4:
                    playlist.sortByDuration();
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.print("Enter Song Title to play: ");
                    String playTitle = scanner.nextLine();
                    SongNode songToPlay = playlist.searchByTitle(playTitle);
                    if (songToPlay != null) {
                        playedStack.push(songToPlay);
                        System.out.println("-> Now Playing: \"" + songToPlay.title + "\" by " + songToPlay.artist);
                    } else {
                        System.out.println("-> Song not found in playlist.");
                    }
                    break;

                case 6:
                    playedStack.displayHistory();
                    break;

                case 7:
                    playlist.displayPlaylist();
                    break;

                case 8:
                    System.out.println("Exiting Music Playlist Manager. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("-> Invalid option! Choice must be between 1 and 8.");
            }
        }
    }
}