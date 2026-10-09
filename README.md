# Music Playlist Manager (CS216L Lab Assignment 1)

## Project Description
A console-based Java application designed to manage music playlists and recently played tracks. The system allows users to organize songs using a doubly linked list and track playback history using a stack data structure, complete with searching, sorting, and input validation features[cite: 2, 6, 7].

## Group Members
* Ayesha Zahid
* Amina Naseer
* Aqsa Zulfiqar
* Sukaina Raza Kazzmi

## Data Structures Used
* **Doubly Linked List (`PlayListLinkedList`)**: Manages the main playlist, allowing dynamic addition, deletion, and bidirectional traversal of songs.
* **Stack (`RecentlyPlayedStack`)**: Manages playback history using Last-In-First-Out (LIFO) ordering whenever a song is played[cite: 5, 6].

## Features
1. **Add Song**: Insert new songs with an ID, title, artist, and duration into the playlist[cite: 2].
2. **Remove Song**: Delete a song from the playlist using its unique Song ID[cite: 2].
3. **Linear Search**: Search for any song in the playlist by its title[cite: 2].
4. **Bubble Sort**: Sort the playlist by song duration in ascending order (shortest to longest)[cite: 2, 4].
5. **Play Song**: Simulate playing a track, which pushes the song record onto the recently played stack[cite: 2, 5].
6. **View History**: Display all recently played songs in LIFO order[cite: 2, 5].
7. **Display Playlist**: View all current songs stored in the playlist in a structured tabular format[cite: 2, 4].
8. **Exit**: Gracefully close the application[cite: 2].

## Time Complexity Table

| Operation | Data Structure / Algorithm | Time Complexity |
| :--- | :--- | :--- |
| **Insert (Add Song)** | Doubly Linked List (Tail insertion) | O(1) |
| **Delete (Remove Song)** | Doubly Linked List | O(n) |
| **Search (by Title)** | Linear Search | O(n) |
| **Sort (by Duration)** | Bubble Sort | O(n^2) |
| **Push (Play Song)** | Stack (Head insertion) | O(1) |
| **Display History** | Stack Traversal | O(n) |

## GitHub Repository Link
https://github.com/ayeshaazahidd0-stack/CS216L_Project1_Group2
