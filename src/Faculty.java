public class Faculty extends Person{
    public Faculty (String idNumber, String lastName, String firstName,
                   String userCategory, String college){
        super(idNumber,lastName,firstName,"Faculty",college);
    }

    public String getRole(){
        return "Faculty";
    }
}

