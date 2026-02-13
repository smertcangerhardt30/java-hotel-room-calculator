import java.util.Scanner;

public class HotelRoom {

    String hotelName;
    int roomNumber;
    String roomType;
    double nightPrice;
    int capacity;
    double rating;
    boolean isSeaView;

    public void readInformation() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Hotel Name: ");
        hotelName = scan.nextLine();

        System.out.println("Room Number: ");
        roomNumber = scan.nextInt();
        scan.nextLine();

        System.out.println("Room Type (Single/Double/Suite): ");
        roomType = scan.nextLine();

        System.out.println("Night Price: ");
        nightPrice = scan.nextDouble();

        System.out.println("Capacity: ");
        capacity = scan.nextInt();

        System.out.println("Rating (0.0 - 10.0): ");
        rating = scan.nextDouble();
        scan.nextLine();

        System.out.println("Sea View (yes/no): ");
        String seaViewCheck = scan.nextLine();

        if (seaViewCheck.equalsIgnoreCase("yes")) {
            isSeaView = true;
        } else {
            isSeaView = false;
        }
    }

    public void calculateStayCost(int numberOfNights, int numberOfGuests) {

        double totalCost = nightPrice * numberOfNights;

        if (numberOfGuests > capacity) {
            totalCost += ((numberOfGuests - capacity) * 150) * numberOfNights;
        }

        if (rating >= 9.0) {
            totalCost *= 1.1;
        } else if (rating < 5.0) {
            totalCost *= 0.8;
        }

        if (isSeaView == true) {
            totalCost += 500;
        }

        System.out.println("This room will cost " + totalCost + " TL for " + numberOfNights + " nights and "
                + numberOfGuests + " guests.");

    }

    public void comparePrice(HotelRoom other) {

        if (this.nightPrice > other.nightPrice) {
            System.out.println(this.hotelName + "  room " + this.roomNumber + " is more expensive than "
                    + other.hotelName + " room " + other.roomNumber + ".");
        } else if (this.nightPrice < other.nightPrice) {
            System.out.println(other.hotelName + " room " + other.roomNumber + " is more expensive than "
                    + this.hotelName + " room " + this.roomNumber + ".");
        } else {
            System.out.println("Both rooms have the same price.");
        }
    }

    public void printInformation() {
        String seaViewInfo;

        if (isSeaView == true) {
            seaViewInfo = "has a sea view.";
        } else {
            seaViewInfo = "does not have a sea view.";
        }

        System.out.println("Hotel Name: " + hotelName + "\nRoom Number: " + roomNumber + "\nRoom Type: " + roomType
                + "\nNight Price: " + nightPrice + "\nCapacity: " + capacity + "\nRating: " + rating
                + "\nThis room " + seaViewInfo);
    }

    public static void main(String[] args) {

        HotelRoom r1 = new HotelRoom();
        HotelRoom r2 = new HotelRoom();

        r1.hotelName = "Blue Wave Hotel";
        r1.roomNumber = 305;
        r1.roomType = "Deluxe";
        r1.nightPrice = 1200.0;
        r1.capacity = 2;
        r1.rating = 9.1;
        r1.isSeaView = true;

        r1.printInformation();
        r1.calculateStayCost(3, 2);

        r2.readInformation();
        r2.printInformation();
        r2.calculateStayCost(2, 4);
        r1.comparePrice(r2);
    }

}
