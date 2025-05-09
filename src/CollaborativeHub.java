public class CollaborativeHub extends Room {

    public CollaborativeHub(String roomNumber, int capacity) {
        super(roomNumber, capacity);
    }

    @Override
    public String getRoomType() {
        return "Standard Room";
    }

    @Override
    public boolean isValidGroupSize(int groupSize){
        return groupSize == 3;
    }

    @Override
    public String toString(){
        return super.toString() + "\nValid Group Size: 3 Persons";
    }
}
