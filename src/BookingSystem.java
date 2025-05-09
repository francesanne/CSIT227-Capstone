public class BookingSystem {
    private String[] rooms = {"DR1", "DR2", "DR3", "CH1", "C2"};
    private boolean[] roomAvailability = {true, true, true, true, true};


    public boolean isRoomAvailable(String roomNumber) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(roomNumber)) {
                return roomAvailability[i];
            }
        }
        return false;
    }

    public void bookRoom(String roomNumber, String studentName) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(roomNumber)) {
                if (roomAvailability[i]) {
                    roomAvailability[i] = false;
                    System.out.println(studentName + " successfully booked " + roomNumber);
                    FileHandler.saveBookingHistory(roomNumber, studentName);
                } else {
                    System.out.println("Room " + roomNumber + " is already booked.");
                }
                return;
            }
        }

        System.out.println("Invalid room number.");
    }
}