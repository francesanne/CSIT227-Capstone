import java.io.*;
import javax.swing.*;

public class FileHandler {
    private static final String BOOKING_FILE = "booking_history.txt";

    public static void saveBookingHistory(String roomNumber, String representativeName, String scheduleTime) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("booking_history.txt", true))) {
            bw.write(representativeName + " booked Room " + roomNumber + " at " + scheduleTime);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewBookingHistory() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKING_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            sb.append("No booking history found.");
        } catch (IOException e) {
            sb.append("Error reading booking history.");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Booking History", JOptionPane.INFORMATION_MESSAGE);
    }
}

