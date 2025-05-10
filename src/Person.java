public abstract class Person {
    private String idNumber;
    private String lastName;
    private String firstName;
    private String userCategory;
    private String college;

    public Person(String idNumber, String lastName, String firstName,
                  String userCategory, String college){
        this.idNumber=idNumber;
        this.lastName=lastName;
        this.firstName=firstName;
        this.userCategory=userCategory;
        this.college=college;
    }

    public String getIdNumber(){
        return idNumber;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return "Role: " + getRole() + "\nName: " + getFullName() + "\nID Number: " + idNumber + "\nCollege: " + college;
    }

}