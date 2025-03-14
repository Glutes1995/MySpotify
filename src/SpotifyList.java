import java.util.ArrayList;
import java.util.Scanner;

public class SpotifyList {

    //list instancevariable of type Song
    private final ArrayList<Song> spotifyList = new ArrayList<>();

    //Adds song to list
    public void addSongToList(Scanner scanner) {
        System.out.println("Type the song you would like to add");
        String title = scanner.nextLine();
        Song song = new Song(title);
        spotifyList.add(song);
        System.out.println(title + " has been added");
    }

    //Removes song from list
    public void removeSongFromList(Scanner scanner) {
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

    //Shows all songs in the list
    public String toString() {
        String songs = "";
        if (spotifyList.isEmpty()) songs += "Your spotify list is empty\n";
        if (!spotifyList.isEmpty()) songs = "Here is your spotify list\n";
        for (int i = 0; i < spotifyList.size(); i++) {
            songs += (i + 1) + ". " + spotifyList.get(i) + "\n";
        }
        return songs;
    }

    //Searches for song title
    public String searchForSong(Scanner scanner) {
        String searchResult = "Song not found";
        int i = 1;
        System.out.println("Type the song you are looking for");
        String title = scanner.nextLine();
        for (Song song : spotifyList) {
            if (title.equalsIgnoreCase(song.getTitle())) {
                searchResult = song.getTitle() + " is number " + i + ". on your list";
            }
            i++;
        }
        return searchResult;
    }

    //Edit song title
    public void editSongTitle(Scanner scanner) {
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

    public boolean isOnList(String title) {
        for (Song song : spotifyList) {
            if (title.equalsIgnoreCase(song.getTitle())) return true;
        }
        return false;
    }

    public ArrayList<Song> getSpotifyList() {
        return spotifyList;
    }
}