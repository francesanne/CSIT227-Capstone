public abstract class Room {
    private String roomNumber;
    private int capacity;

    public Room(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean canAccommodate(int numStudents) {
        return numStudents <= capacity;
    }

    public abstract String getRoomType();
    public abstract String getFeatures();
}
