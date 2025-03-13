import java.util.Scanner;

public class SpotifyMain {
    public static void main(String[] args) {
        spotify();
    }
    public static void spotify() {

        System.out.println("*--------------------------*");
        System.out.println("*    Welcome to Spotify    *");
        System.out.println("*--------------------------*");

        SpotifyList spotifyList = new SpotifyList();
        Scanner scanner = new Scanner(System.in);

        menuLoop:
        while (true) {
            System.out.println("""
                         Menu
                    1. Add song
                    2. Remove song
                    3. Show list of songs
                    4. Search for song
                    5. Edit song title
                    6. Exit
                    """);

            String input = scanner.nextLine();
            switch (input) {
                case "1" -> spotifyList.addSongToList(scanner);
                case "2" -> spotifyList.removeSongFromList(scanner);
                case "3" -> System.out.println(spotifyList);
                case "4" -> System.out.println(spotifyList.searchForSong(scanner));
                case "5" -> spotifyList.editSongTitle(scanner);
                case "6" -> {
                    break menuLoop;
                }
                default -> System.out.println("You can only choose between 1-6\n" +
                        "Watch your fat fingers!");
            }
        }
        //System.out.println(spotifyList.getSpotifyList().isEmpty());
        scanner.close();
        System.out.println("Closing spotify");
    }
}