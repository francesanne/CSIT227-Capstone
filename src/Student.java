public class Student extends Person {

    public Student(String idNumber, String lastName, String firstName,
                  String userCategory, String college){
        super(idNumber,lastName,firstName,"Student",college);
    }
    public String getRole(){
        return "Student";
    }

}
