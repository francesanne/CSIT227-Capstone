public abstract class Room {
    private final String roomNumber;
    private final int capacity;

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
    public abstract String getRoomType();
    public abstract boolean isValidGroupSize(int groupSize);

    public String toString(){
        return "Room Type: " + getRoomType() +
                "\nRoom Number: " + getRoomNumber() +
                "\nCapacity:  " + getCapacity();
    }
}
