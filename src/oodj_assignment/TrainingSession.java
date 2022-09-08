package oodj_assignment;

import java.util.*;
import java.time.*;

public class TrainingSession {
    private String trainingSessionID;
    private String trainingSessionName;
    private String trainingSessionLevel;
    private String trainerID;
    private String[] customerID;
    private LocalDate trainingSessionDate;
    private LocalTime trainingSessionStart;
    private LocalTime trainingSessionEnd;
    private String trainingSessionStatus;
    
    public TrainingSession(String trainingSessionID, String trainingSessionName, 
            String trainingSessionLevel, String trainerID, String[] customerID, 
            LocalDate trainingSessionDate, LocalTime trainingSessionStart, 
            LocalTime trainingSessionEnd, String trainingSessionStatus){
        this.trainingSessionID = trainingSessionID;
        this.trainingSessionName = trainingSessionName;
        this.trainingSessionLevel = trainingSessionLevel;
        this.trainerID = trainerID;
        this.customerID = customerID;
        this.trainingSessionDate = trainingSessionDate;
        this.trainingSessionStart = trainingSessionStart;
        this.trainingSessionEnd = trainingSessionEnd;
        this.trainingSessionStatus = trainingSessionStatus;
    }
    
    public String getTrainingSessionID(){
        return trainingSessionID;
    }
    
    public String getTrainingSessionName(){
        return trainingSessionName;
    }
    
    public String getTrainingSessionLevel(){
        return trainingSessionLevel;
    }
    
    public String getTrainerID(){
        return trainerID;
    }
    
    public String getTrainerName(ArrayList<Trainer> Trainers){
        String trainerName = null;
        for(Trainer tr: Trainers){
            if(tr.getUserID().equals(trainerID)){
                trainerName = tr.getUserName();
            }
        }
        return trainerName;
    }
    
    public double getTrainerHourlyRate(ArrayList<Trainer> Trainers){
        double trainerHourlyRate = 0;
        for(Trainer tr: Trainers){
            if(tr.getUserID().equals(trainerID)){
                trainerHourlyRate = tr.getTrainerHourlyRate();
            }
        }
        return trainerHourlyRate;
    }
    
    public String[] getCustomerID(){
        return customerID;
    }
    
    public String[] getCustomerName(ArrayList<Customer> Customers){
        String[] customerName = new String[customerID.length];
        for(int i=0; i<customerID.length; i++){
            for(Customer cust: Customers){
                if(cust.getUserID().equals(customerID[i])){
                    customerName[i] = cust.getUserName();
                }
            }
        }
        return customerName;
    }
    
    public void addCustomerBooking(String bookedCustomerID){
        String[] newCustomerID = Arrays.copyOf(customerID, customerID.length+1);
        newCustomerID[customerID.length] = bookedCustomerID;
        customerID = newCustomerID;
    }
    
    public void removeCustomerBooking(String bookedCustomerID){
        String[] newCustomerID = new String[customerID.length - 1];
        int idx = 0;
        for(int i=0; i<customerID.length; i++){
            if(customerID[i].equals(bookedCustomerID)) idx = i;
        }
        System.arraycopy(customerID, 0, newCustomerID, 0, idx);
        System.arraycopy(customerID, idx+1, newCustomerID, idx, customerID.length-idx-1);
        customerID = newCustomerID;
    }
    
    public String getTrainingSessionDate(){
        return trainingSessionDate.toString();
    }
    
    public String getTrainingSessionDuration(){
        return trainingSessionStart.toString() + " - " + trainingSessionEnd.toString();
    }
    
    public double getTrainingSessionDurationHours(){
        return Duration.between(trainingSessionStart, trainingSessionEnd).toMinutes() / 60;
    }
    
    public String getTrainingSessionStatus(){
        return trainingSessionStatus;
    }
    
    public void setTrainingSessionStatus(String trainingSessionStatus){
        this.trainingSessionStatus = trainingSessionStatus;
    }
    
    public String getTrainingSessionRecordLine(){
        return String.join(",", trainingSessionID, 
                trainingSessionName, 
                trainingSessionLevel, 
                trainerID, 
                String.join("-", customerID), 
                trainingSessionDate.toString(), 
                trainingSessionStart.toString(), 
                trainingSessionEnd.toString(), 
                trainingSessionStatus);
    }
}
