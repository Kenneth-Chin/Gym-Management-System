package oodj_assignment;

import java.time.*;
        
public class Trainer extends User {
    private String trainerPosition;
    private int trainerKPI;
    private int trainerYearOfExperience;
    private double trainerHourlyRate;
    private double trainerMonthlySalary;
    private String[] trainerCustomerID;
    
    public Trainer(String userID, String userName, String userPassword, 
            String userPhoneNumber, String userEmail, String userGender, 
            LocalDate userDateOfBirth, LocalDate userJoinDate, 
            String trainerPosition, int trainerKPI, 
            int trainerYearOfExperience, double trainerHourlyRate, 
            double trainerMonthlySalary, String[] trainerCustomerID){
        super(userID, userName, userPassword, userPhoneNumber, userEmail, 
                userGender, userDateOfBirth, userJoinDate);
        this.trainerPosition = trainerPosition;
        this.trainerKPI = trainerKPI;
        this.trainerYearOfExperience = trainerYearOfExperience;
        this.trainerHourlyRate = trainerHourlyRate;
        this.trainerMonthlySalary = trainerMonthlySalary;
        this.trainerCustomerID = trainerCustomerID;
    }
    
    public Trainer(String userID, String userName, String userPassword, 
            String userPhoneNumber, String userEmail, String userGender, 
            LocalDate userDateOfBirth){
        super(userID, userName, userPassword, userPhoneNumber, userEmail, 
                userGender, userDateOfBirth, LocalDate.now());
        this.trainerPosition = "Junior";
        this.trainerKPI = 0;
        this.trainerYearOfExperience = 0;
        this.trainerHourlyRate = 10;
        this.trainerMonthlySalary = 2000;
        this.trainerCustomerID = new String[0];
    }
    
    public String getTrainerPosition(){
        return trainerPosition;
    }

    public int getTrainerKPI(){
        return trainerKPI;
    }

    public int getTrainerYearOfExperience(){
        return trainerYearOfExperience;
    }

    public double getTrainerHourlyRate(){
        return trainerHourlyRate;
    }

    public double getTrainerMonthlySalary(){
        return trainerMonthlySalary;
    }

    public String[] getTrainerCustomerID(){
        return trainerCustomerID;
    }
    
    public String getTrainerRecordLine(){
        return String.join(",", 
                trainerPosition, 
                String.valueOf(trainerKPI), 
                String.valueOf(trainerYearOfExperience), 
                String.format("%.2f", trainerHourlyRate), 
                String.format("%.2f", trainerMonthlySalary), 
                String.join("-", trainerCustomerID));
    }
}
