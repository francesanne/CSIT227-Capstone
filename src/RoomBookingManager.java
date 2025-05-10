public class RoomBookingManager {
    private final String[] rooms = {"DR1", "DR2", "DR3", "CH1", "CH2"};
    private final boolean[][] roomSchedules = new boolean[rooms.length][6];
    private final String[] scheduleTimes = {
            "8:00 AM - 9:30 AM",
            "9:30 AM - 11:00 AM",
            "12:30 PM - 2:00 PM",
            "2:00 PM - 3:30 PM",
            "3:30 PM - 5:00 PM",
            "5:00 PM - 6:30 PM"
    };

    private int getRoomIndex(String roomNumber) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(roomNumber)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isRoomAvailable(String roomNumber, int scheduleIndex) {
        int index = getRoomIndex(roomNumber);
        if (index == -1) {
            return false;
        }
        return !roomSchedules[index][scheduleIndex];
    }

    public void bookRoom(String roomNumber, String studentName, int scheduleIndex) {
        int index = getRoomIndex(roomNumber);
        if (index == -1) {
            System.out.println("Invalid room number.");
            return;
        }

        if (roomSchedules[index][scheduleIndex]) {
            System.out.println("Room already booked at " + scheduleTimes[scheduleIndex]);
            return;
        }

        roomSchedules[index][scheduleIndex] = true;
        System.out.println(studentName + " successfully booked " + roomNumber + " at " + scheduleTimes[scheduleIndex]);
        FileHandler.saveBookingHistory(roomNumber, studentName, scheduleTimes[scheduleIndex]);
    }
}