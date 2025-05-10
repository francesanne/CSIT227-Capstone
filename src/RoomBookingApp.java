import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomBookingApp extends JFrame {
    private JPanel pnlMain;
    private JRadioButton rbDiscussionRoom;
    private JRadioButton rbCollaborativeHub;
    private JTextField tfIdNumber;
    private JTextField tfLastName;
    private JTextField tfFirstName;
    private JComboBox<String> cbUserCategory;
    private JComboBox<String> cbCollege;
    private JTextField tfGroupSize;
    private JComboBox<String> cbRoomNumber;
    private JRadioButton rbSchedule1;
    private JRadioButton rbSchedule2;
    private JRadioButton rbSchedule3;
    private JRadioButton rbSchedule4;
    private JRadioButton rbSchedule5;
    private JRadioButton rbSchedule6;
    private JButton btnSubmitBooking;
    private JButton btnViewAvailableRooms;

    private JRadioButton[] rbSchedules;
    private JRadioButton[] rbRooms;

    private RoomBookingManager bookingSystem = new RoomBookingManager();


    public RoomBookingApp() {
        rbSchedules = new JRadioButton[]{rbSchedule1, rbSchedule2, rbSchedule3, rbSchedule4, rbSchedule5, rbSchedule6};
        rbRooms = new JRadioButton[]{rbDiscussionRoom, rbCollaborativeHub};

        rbDiscussionRoom.setActionCommand("Discussion");
        rbCollaborativeHub.setActionCommand("Collab");

        ButtonGroup scheduleGroup = new ButtonGroup();
        for (JRadioButton rb : rbSchedules) {
            if (rb != null) {
                scheduleGroup.add(rb);
            }
        }

        ButtonGroup roomGroup = new ButtonGroup();
        for (JRadioButton rb : rbRooms) {
            if (rb != null) {
                roomGroup.add(rb);
            }
        }

        btnSubmitBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    processBooking();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                }
            }
        });

        btnViewAvailableRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileHandler.viewBookingHistory();
            }
        });
    }

    private void processBooking() {

        if (tfIdNumber.getText().isEmpty() || tfLastName.getText().isEmpty() ||
                tfFirstName.getText().isEmpty() || tfGroupSize.getText().isEmpty() ||
                cbRoomNumber.getSelectedItem() == null || cbUserCategory.getSelectedItem() == null ||
                cbCollege.getSelectedItem() == null || !isAnySelected(rbRooms) || !isAnySelected(rbSchedules)) {
            JOptionPane.showMessageDialog(null, "Please complete all fields.");
            return;
        }


        int id;
        try {
            id = Integer.parseInt(tfIdNumber.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID number must be a valid integer.");
            return;
        }


        int groupSize;
        try {
            groupSize = Integer.parseInt(tfGroupSize.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Group size must be a valid integer.");
            return;
        }

        int scheduleIndex = getSelectedIndex(rbSchedules);
        if (scheduleIndex == -1) {
            JOptionPane.showMessageDialog(null, "Please select a schedule.");
            return;
        }


        String roomType = getSelectedRoomType(rbRooms);
        if (roomType == null) {
            JOptionPane.showMessageDialog(null, "Please select a room type.");
            return;
        }


        String roomNumber = cbRoomNumber.getSelectedItem().toString();
        String lastName = tfLastName.getText();
        String firstName = tfFirstName.getText();
        String repName = firstName + " " + lastName;
        String userCategory = cbUserCategory.getSelectedItem().toString();


        Room selectedRoom;
        if (roomType.equals("Discussion")) {
            selectedRoom = new DiscussionRoom(roomNumber, groupSize);
        } else {
            selectedRoom = new CollaborativeHub(roomNumber, groupSize);
        }


        if (!selectedRoom.isValidGroupSize(groupSize)) {
            JOptionPane.showMessageDialog(null, "Invalid group size for the selected room type.");
            return;
        }


        if (!bookingSystem.isRoomAvailable(roomNumber, scheduleIndex)) {
            JOptionPane.showMessageDialog(null, "Room is already booked at the selected schedule.");
            return;
        }


        bookingSystem.bookRoom(roomNumber, repName, scheduleIndex);


        String validGroupSize;
        if (selectedRoom instanceof DiscussionRoom) {
            validGroupSize = "3-5 Persons";
        } else {
            validGroupSize = "3 Persons";
        }

        String successMessage = "Booking Successful!\n" +
                "Room Type: " + selectedRoom.getRoomType() + "\n" +
                "Valid Group Size: " + validGroupSize + "\n" +
                "Room Number: " + selectedRoom.getRoomNumber() + "\n" +
                "Number of People: " + groupSize + "\n" +
                "User Category: " + userCategory;

        JOptionPane.showMessageDialog(null, successMessage);
    }

    private boolean isAnySelected(JRadioButton[] buttons) {
        for (JRadioButton rb : buttons) {
            if (rb != null && rb.isSelected()) {
                return true;
            }
        }
        return false;
    }

    private int getSelectedIndex(JRadioButton[] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] != null && buttons[i].isSelected()) {
                return i;
            }
        }
        return -1;
    }

    private String getSelectedRoomType(JRadioButton[] buttons) {
        for (JRadioButton rb : buttons) {
            if (rb != null && rb.isSelected()) {
                return rb.getActionCommand();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RoomBookingApp app = new RoomBookingApp();
        app.setContentPane(app.pnlMain);
        app.setSize(650, 700);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}