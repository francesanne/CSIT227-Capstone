import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RoomBookingApp app = new RoomBookingApp();
        app.setContentPane(app.pnlMain);
        app.setSize(650, 700);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
