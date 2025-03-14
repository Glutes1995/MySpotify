import java.util.Scanner;

public class Spotify {

    public static void runSpotify() {

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

            int userInput = inputCheck(scanner);
            switch (userInput) {
                case 1 -> spotifyList.addSongToList(scanner);
                case 2 -> spotifyList.removeSongFromList(scanner);
                case 3 -> System.out.println(spotifyList);
                case 4 -> System.out.println(spotifyList.searchForSong(scanner));
                case 5 -> spotifyList.editSongTitle(scanner);
                case 6 -> {
                    break menuLoop;
                }
                default -> System.out.println("You can only choose between 1-6\n" +
                        "Watch your fat fingers!");
            }
        }
        scanner.close();
        System.out.println("Closing spotify");
    }
    //checks if input is an integer - outputs 0 if not an integer
    public static int inputCheck(Scanner scanner) {

        int userInput = 0;
            String input = scanner.nextLine();
            try {
                userInput = Integer.parseInt(input);
            } catch (NumberFormatException ignore) {} //ignores wrong inputs (non integers)
        return userInput;
    }
}