public class Student {
    private String name;
    private String studentID;
    private String bookedRoom;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.bookedRoom = ""; // Initially, the student has no booked room
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(String bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentID);
        if (!bookedRoom.isEmpty()) {
            System.out.println("Booked Room: " + bookedRoom);
        } else {
            System.out.println("No room booked.");
        }
    }
}
