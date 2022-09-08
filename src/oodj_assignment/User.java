package oodj_assignment;

import java.time.*;

public abstract class User {
    private String userID;
    private String userName;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userGender;
    private LocalDate userDateOfBirth;
    private LocalDate userJoinDate;
    
    public User(String userID, String userName, String userPassword, 
            String userPhoneNumber, String userEmail, String userGender, 
            LocalDate userDateOfBirth, LocalDate userJoinDate){
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userDateOfBirth = userDateOfBirth;
        this.userJoinDate = userJoinDate;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public boolean verifyPassword(String oldPassword){
        return userPassword.equals(oldPassword);
    }
    
    public void resetPassword(String oldPassword, String newPassword){
        if(oldPassword.equals(userPassword) && !newPassword.equals(userPassword)){
            userPassword = newPassword;
        }
    }
    
    public boolean verifyUserLogin(String userName, String userPassword){
        return this.userName.equals(userName) && this.userPassword.equals(userPassword);
    }
    
    public String getUserPhoneNumber(){
        return userPhoneNumber;
    }
    
    public void setUserPhoneNumber(String userPhoneNumber){
        this.userPhoneNumber = userPhoneNumber;
    }
    
    public String getUserEmail(){
        return userEmail;
    }
    
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }
    
    public String getUserGender(){
        return userGender;
    }
    
    public void setUserGender(String userGender){
        this.userGender = userGender;
    }
    
    public String getUserDateOfBirth(){
        return userDateOfBirth.toString();
    }
    
    public String getUserJoinDate(){
        return userJoinDate.toString();
    }
    
    public String getUserRecordLine(){
        return String.join(",", userID, 
                userName, 
                userPassword, 
                userPhoneNumber, 
                userEmail, 
                userGender, 
                userDateOfBirth.toString(), 
                userJoinDate.toString());
    }
}
