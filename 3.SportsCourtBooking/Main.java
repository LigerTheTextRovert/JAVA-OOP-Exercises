import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        ArrayList<Court> courtsList = new ArrayList<>();
        ArrayList<Player> playerList = new ArrayList<>();

        //first initialization for players list
        initPlayerList(playerList);

        //first initialization for courts
        initCourtList(courtsList);

        Scanner sc = new Scanner(System.in);

        boolean keepGoing = true;

        System.out.println("\n====  Welcome to Court management system  ====\n");
        while (keepGoing) {

            showMenu();

            int ans = sc.nextInt();
            sc.nextLine();

            if (ans == 1) {
                System.out.print("Enter your name: ");
                String playerName = sc.nextLine();

                Player player = findPlayerByName(playerList, playerName);

                if (player == null) {
                    player = new Player(playerName);
                    playerList.add(player);
                    System.out.println("New player created.");
                } else {
                    System.out.println("Welcome back, " + playerName + "!");
                }

                printAvailableCourts(courtsList);
                System.out.print("Enter your court's id :");
                int courtId = sc.nextInt();
                sc.nextLine();
                player.bookCourt(courtsList, courtId);
            }
            if (ans == 2) {
                System.out.print("Enter you user name :");
                String playerName = sc.nextLine();

                Player player = findPlayerByName(playerList, playerName);

                if (player == null) {
                    System.out.println("There is no player by this name!");
                    continue;
                } else {
                    System.out.println("Welcome back, " + playerName + "!");
                }
                System.out.println("Your booked courts list:");
                player.viewCurrentBooks();

                System.out.print("Enter the booked Court's id you wanna cancel :");
                int courtID = sc.nextInt();
                sc.nextLine();
                player.removeBookedCourt(courtID);
                System.out.println("Court with the id :" + courtID + " ,removed from you book list");
            }
            if (ans == 3) {
                printAvailableCourts(courtsList);
            }
            if (ans == 4) {
                System.out.print("Enter The type of the court :");
                String courtType = sc.nextLine();
                if (isCourtUnique(courtsList, courtType)) {
                    admin.addCourt(courtsList, new Court(courtType));
                } else {
                    System.out.println("You can not add a court with this type :(");
                }
            }
            if (ans == 5) {
                printAvailableCourts(courtsList);
                System.out.print("Enter the Id of the court you wanna remove :");
                int targetCourtID = sc.nextInt();
                sc.nextLine();
                admin.removeCourt(courtsList, targetCourtID);
                printAvailableCourts(courtsList);
            }
            if (ans == 6) {
                System.out.println("Closing The Panel");
                keepGoing = false;
            }
        }
        sc.close();
    }

    public static void showMenu() {
        System.out.println("\n~~~ Menu ~~~\n");
        System.out.println("1. Book a court");
        System.out.println("2. Cancel a book");
        System.out.println("3. Available courts");
        System.out.println("4. Add a court (Admin)");
        System.out.println("5. remove a court (Admin)");
        System.out.println("6. Exit");
        System.out.print("\nChose an option: ");
    }

    public static void initCourtList(ArrayList<Court> courtList) {
        courtList.add(new Court("football"));
        courtList.add(new Court("basketball"));
        courtList.add(new Court("tennis"));
    }

    public static void initPlayerList(ArrayList<Player> playerList) {
        playerList.add(new Player("John"));
        playerList.add(new Player("Sina"));
    }

    public static void printAvailableCourts(ArrayList<Court> list) {
        System.out.println("Current Court: ");
        for (Court c : list) {
            System.out.println(c.toString());
        }
    }

    public static boolean isCourtUnique(ArrayList<Court> list, String courtType) {
        for (Court c : list) {
            if (c.getType().equalsIgnoreCase(courtType)) return false;
        }
        return true;
    }

    public static Player findPlayerByName(ArrayList<Player> players, String name) {
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}