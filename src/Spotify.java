import java.util.Scanner;

public class Spotify {

    public static void runSpotify() {

        System.out.println("*--------------------------*");
        System.out.println("*    Welcome to Spotify    *");
        System.out.println("*--------------------------*");

        SpotifyList spotifyList = new SpotifyList();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            Menu.spotifyMenu();
            int userInput = inputCheck(scanner);
            switch (userInput) {
                case 1 -> spotifyList.addSong(scanner);
                case 2 -> spotifyList.removeSong(scanner);
                case 3 -> spotifyList.showSong();
                case 4 -> spotifyList.moveSong(scanner);
                case 5 -> spotifyList.searchForSong(scanner);
                case 6 -> spotifyList.editSong(scanner);
                case 7 -> isRunning = false;
                default -> System.out.println("You can only choose between 1-7\n" +
                        "Watch your fat fingers!");
            }
        }
        scanner.close();
        System.out.println("Closing spotify");
    }

    //checks if input is an integer - returns 0 if not an integer
    public static int inputCheck(Scanner scanner) {

        int userInput = 0;
            String input = scanner.nextLine();
            try {
                userInput = Integer.parseInt(input);
            } catch (NumberFormatException ignore) {} //ignores wrong inputs (non integers)
        return userInput;
    }
}