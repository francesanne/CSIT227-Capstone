public class DiscussionRoom extends Room {
    private boolean hasTV;
    private boolean hasWhiteboard;

    public DiscussionRoom(String roomNumber, int capacity, boolean hasTV, boolean hasWhiteboard) {
        super(roomNumber, capacity);
        this.hasTV = hasTV;
        this.hasWhiteboard = hasWhiteboard;
    }

    public boolean hasTV() {
        return hasTV;
    }

    public boolean hasWhiteboard() {
        return hasWhiteboard;
    }


    public String getRoomType() {
        return "Discussion Room";
    }

    public String getFeatures() {
        String features = "";

        if (hasTV) {
            features += "TV";
        }

        if (hasWhiteboard) {
            if (!features.isEmpty()) {
                features += ", ";
            }
            features += "Whiteboard";
        }

        if (features.isEmpty()) {
            features = "None";
        }

        return features;
    }
}
