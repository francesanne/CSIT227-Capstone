import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingSystem bookingSystem = new BookingSystem();

        System.out.println("===CIT-U Library Room Booking System===");

        bookingSystem.displayAvailableRooms();

        System.out.print("Enter the room number you want to book (ex: R001): ");
        String roomNumber = scanner.nextLine();

        System.out.print("Enter your name: ");
        String studentName = scanner.nextLine();

        bookingSystem.bookRoom(roomNumber, studentName);
        bookingSystem.displayUpdatedRooms();

        scanner.close();
    }
}
