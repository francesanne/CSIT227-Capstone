import java.io.*;
public class FileHandler {
    private static final String BOOKING_FILE = "booking_history.txt";

    public static void saveBookingHistory(String roomNumber, String representativeName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKING_FILE, true))) {
            bw.write(representativeName + " booked Room " + roomNumber);
            bw.newLine();
            return;
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

    public static void viewBookingHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKING_FILE))) {
            String record;
            while ((record = br.readLine()) != null) {
                System.out.println(record);
            }
            br.close();
            br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("Booking history file not found. No records available.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }


    }
}
