import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final int ID;
    List<Court> bookedCourts;

    public Player(String name) {
        Random rand = new Random();
        this.name = name;
        this.ID = rand.nextInt(5001)+1000;
        this.bookedCourts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public List<Court> getBookedCourts() {
        return bookedCourts;
    }

    public void bookCourt(List<Court> courtsList, int courtID) {
        for (Court c : courtsList) {
            if (c.getID() == courtID) {
                bookedCourts.add(c);
                c.setAvailable(false);
                System.out.println("Court : " + c.getID() + ", Booked successfully");
                return;
            }
        }
    }

    public void removeBookedCourt(int courtID) {
        for (Court c : bookedCourts) {
            if (courtID == c.getID()) {
                c.setAvailable(true);
                bookedCourts.remove(c);
                System.out.println("Booking for court " + c.getID() + " canceled.");
                return;
            }
        }
    }

    public void viewCurrentBooks() {
        if (bookedCourts.isEmpty()) {
            System.out.println("No courts booked yet.");
        } else {
            System.out.println("Your booked courts:");
            for (Court court : bookedCourts) {
                System.out.println(court.toString());
            }
        }
    }
}