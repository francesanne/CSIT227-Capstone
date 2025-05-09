import javax.swing.*; import java.awt.event.ActionEvent; import java.awt.event.ActionListener;
public class RoomBooking extends JFrame {
    private JPanel pnlMain;
    private JRadioButton rbDiscussionRoom;
    private JRadioButton rbCollaborativeHub;
    private JTextField tfIdNumber;
    private JTextField tfLastName;
    private JTextField tfFirstName;
    private JComboBox cbUserCategory;
    private JComboBox cbCollege;
    private JTextField tfGroupSize;
    private JComboBox cbRoomNumber;
    private JRadioButton rbSchedule1;
    private JRadioButton rbSchedule2;
    private JRadioButton rbSchedule3;
    private JRadioButton rbSchedule4;
    private JRadioButton rbSchedule5;
    private JRadioButton rbSchedule6;
    private JButton btnSubmitBooking;
    private JButton btnViewAvailableRooms;

    private JRadioButton[] rbRooms = {rbDiscussionRoom, rbCollaborativeHub};
    private JRadioButton[] rbSchedules = {rbSchedule1, rbSchedule2, rbSchedule3, rbSchedule4, rbSchedule5, rbSchedule6};

    private BookingSystem bookingSystem = new BookingSystem();

    RoomBooking() {
        ButtonGroup roomGroup = new ButtonGroup();
        for (JRadioButton rb : rbRooms) {
            roomGroup.add(rb);
        }

        ButtonGroup scheduleGroup = new ButtonGroup();
        for (JRadioButton rb : rbSchedules) {
            scheduleGroup.add(rb);
        }

        btnSubmitBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processBooking();
            }
        });

        btnViewAvailableRooms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler.viewBookingHistory();
            }
        });
    }

    private void processBooking() {
        try {
            int groupSize = Integer.parseInt(tfGroupSize.getText());
            String roomNumber = cbRoomNumber.getSelectedItem().toString();
            String representativeName = tfFirstName.getText() + " " + tfLastName.getText();

            Room selectedRoom = rbDiscussionRoom.isSelected() ? new DiscussionRoom(roomNumber, groupSize)
                    : new CollaborativeHub(roomNumber, groupSize);

            if (!selectedRoom.isValidGroupSize(groupSize)) {
                JOptionPane.showMessageDialog(null, "Invalid group size for selected room.");
                return;
            }

            bookingSystem.bookRoom(roomNumber, representativeName);
            JOptionPane.showMessageDialog(null, "Booking successful!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input format for group size.");
        }
    }

    public static void main(String[] args) {
        RoomBooking app = new RoomBooking();
        app.setContentPane(app.pnlMain);
        app.setSize(650, 700);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
