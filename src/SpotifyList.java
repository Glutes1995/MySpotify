import java.util.ArrayList;
import java.util.Scanner;

public class SpotifyList {

    //list instancevariable of type Song
    private final ArrayList<Song> spotifyList = new ArrayList<>();

    //Adds song to list
    public void addSongToList(Scanner scanner) {
        System.out.println("Type the song you would like to add");
        String title = scanner.nextLine();
        if (isOnList(title)) {
            System.out.println("That song is already on the list");
            return;
        }
        Song song = new Song(title);
        spotifyList.add(song);
        System.out.println(title + " has been added");
    }

    //Removes song from list
    public void removeSongFromList(Scanner scanner) {
        if (isListEmpty()) return;
        System.out.println("Type the song you would like to remove");
        String title = scanner.nextLine();
        if (!isOnList(title)) {
            System.out.println("Song not found");
            return;
        }
        for (Song song : spotifyList) {
            if (title.equalsIgnoreCase(song.getTitle())) {
                spotifyList.remove(song);
                System.out.println(title + " has been removed");
                return;
            }
        }
    }

    //Shows all songs in the list and their placement
    public String toString() {
        String songs;
        if (spotifyList.isEmpty()) {
            songs = "Your spotify list is empty\n";
        } else {
            songs = "Here is your spotify list\n";
        }
        for (int i = 0; i < spotifyList.size(); i++) {
            songs += (i + 1) + ". " + spotifyList.get(i) + "\n";
        }
        return songs;
    }

    //Searches for song title
    public void searchForSong(Scanner scanner) {
        if (isListEmpty()) return;
        System.out.println("Type the song you are looking for");
        String title = scanner.nextLine();
        if (!isOnList(title)) {
            System.out.println("Song not found");
        } else {
            showSongPlacement(title);
        }
    }

    //Edits song title
    public void editSongTitle(Scanner scanner) {
        if (isListEmpty()) return;
        System.out.println("Type the song you would like to edit");
        String title = scanner.nextLine();
        if (!isOnList(title)) {
            System.out.println("The song you are trying to edit, does not exist!");
            return;
        }
        System.out.println("Type in the new title");
        String newTitle = scanner.nextLine();
        for (Song song : spotifyList) {
            if (title.equalsIgnoreCase(song.getTitle())) {
                song.setTitle(newTitle);
                System.out.println("The song " + title + " has been changed to " + newTitle);
            }
        }
    }

    //Checks if song is on list
    public boolean isOnList(String title) {
        for (Song song : spotifyList) {
            if (title.equalsIgnoreCase(song.getTitle())) return true;
        }
        return false;
    }

    //shows the songs placement on list
    public void showSongPlacement(String title) {
        int i = 0;
        for (Song song : spotifyList) {
            i++;
            if (title.equalsIgnoreCase(song.getTitle())) {
                System.out.println(song.getTitle() + " is number " + i + ". on your list");
            }
        }

    }

    //checks if list is empty
    public boolean isListEmpty() {
        if (spotifyList.isEmpty()) {
            System.out.println("Your spotify list is empty");
            return true;
        }
        return false;
    }
}