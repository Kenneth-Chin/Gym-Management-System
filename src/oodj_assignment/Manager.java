package oodj_assignment;

import java.time.*;

public class Manager extends User {
    public Manager(String userID, String userName, String userPassword, 
            String userPhoneNumber, String userEmail, String userGender, 
            LocalDate userDateOfBirth, LocalDate userJoinDate){
        super(userID, userName, userPassword, userPhoneNumber, userEmail, 
                userGender, userDateOfBirth, userJoinDate);
    }
}
