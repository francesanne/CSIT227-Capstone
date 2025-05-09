public class DiscussionRoom extends Room {
   public DiscussionRoom(String roomNumber, int capacity){
       super(roomNumber, capacity);
   }
    public String getRoomType(){
       return "Discussion Room";
    }
    public boolean isValidGroupSize(int groupSize){
       return groupSize >=3 && groupSize<=5;
    }
    public String toString(){
        return super.toString() + "\nValid Group Size: 3-5 Persons";
    }
}
