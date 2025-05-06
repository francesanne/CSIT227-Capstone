public class StandardRoom extends Room {

    public StandardRoom(String roomNumber, int capacity) {
        super(roomNumber, capacity);
    }

    @Override
    public String getRoomType() {
        return "Standard Room";
    }

    @Override
    public String getFeatures() {
        String features = "None";
        return features;
    }
}
