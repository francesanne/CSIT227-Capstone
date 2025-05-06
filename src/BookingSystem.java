public class BookingSystem {
    private String[] rooms = {"R001", "R002", "R003", "R004", "R005"};
    private boolean[] roomAvailability = {true, true, true, true, true};

    public void displayAvailableRooms() {
        System.out.println("Available rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (roomAvailability[i]) {
                System.out.println(rooms[i] + " - Available");
            } else {
                System.out.println(rooms[i] + " - Booked");
            }
        }
    }

    public void bookRoom(String roomNumber, String studentName) {
        int roomIndex = -1;

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(roomNumber)) {
                roomIndex = i;
                break;
            }
        }

        if (roomIndex != -1) {
            if (roomAvailability[roomIndex]) {
                roomAvailability[roomIndex] = false;
                System.out.println(studentName + " successfully booked room " + roomNumber + ".");
            } else {
                System.out.println("Room " + roomNumber + " is already booked.");
            }
        } else {
            System.out.println("Invalid room number. Please try again.");
        }
    }

    public void displayUpdatedRooms() {
        System.out.println("Updated room availability:");
        for (int i = 0; i < rooms.length; i++) {
            if (roomAvailability[i]) {
                System.out.println(rooms[i] + " - Available");
            } else {
                System.out.println(rooms[i] + " - Booked");
            }
        }
    }
}
