package oodj_assignment;

import java.time.*;
        
public class Customer extends User {
    private double customerWeight;
    private double customerHeight;
    private String customerFitnessLevel;
    private String customerSubscriptionPlan;
    private LocalDate customerSubscriptionDate;
    private double customerTotalSpending;
    
    public Customer(String userID, String userName, String userPassword, 
            String userPhoneNumber, String userEmail, String userGender, 
            LocalDate userDateOfBirth, LocalDate userJoinDate, 
            double customerWeight, double customerHeight, 
            String customerFitnessLevel, String customerSubscriptionPlan, 
            LocalDate customerSubscriptionDate, double customerTotalSpending){
        super(userID, userName, userPassword, userPhoneNumber, userEmail, 
                userGender, userDateOfBirth, userJoinDate);
        this.customerWeight = customerWeight;
        this.customerHeight = customerHeight;
        this.customerFitnessLevel = customerFitnessLevel;
        this.customerSubscriptionPlan = customerSubscriptionPlan;
        this.customerSubscriptionDate = customerSubscriptionDate;
        this.customerTotalSpending = customerTotalSpending;
    }
    
    public Customer(String userID, String userName, String userPassword, 
            String userPhoneNumber, String userEmail, String userGender, 
            LocalDate userDateOfBirth, double customerWeight, double customerHeight){
        super(userID, userName, userPassword, userPhoneNumber, userEmail, 
                userGender, userDateOfBirth, LocalDate.now());
        this.customerWeight = customerWeight;
        this.customerHeight = customerHeight;
        this.customerFitnessLevel = "Beginner";
        this.customerSubscriptionPlan = "Free";
        this.customerSubscriptionDate = null;
        this.customerTotalSpending = 0;
    }
    
    public double getCustomerWeight(){
        return customerWeight;
    }
    
    public double getCustomerHeight(){
        return customerHeight;
    }
    
    public String getCustomerFitnessLevel(){
        return customerFitnessLevel;
    }
    
    public String getCustomerSubscriptionPlan(){
        return customerSubscriptionPlan;
    }
    
    public void setCustomerSubscriptionPlan(String customerSubscriptionPlan){
        this.customerSubscriptionPlan = customerSubscriptionPlan;
    }
    
    public String getCustomerSubscriptionDate(){
        return customerSubscriptionDate.toString();
    }
    
    public void setCustomerSubscriptionDate(LocalDate customerSubscriptionDate){
        this.customerSubscriptionDate = customerSubscriptionDate;
    }
    
    public double getCustomerTotalSpending(){
        return customerTotalSpending;
    }
    
    public void incrementCustomerTotalSpending(double spending){
        customerTotalSpending += spending;
    }
    
    public String getCustomerRecordLine(){
        String subscriptionDate = null;
        if(customerSubscriptionDate == null){
            subscriptionDate = "-";
        } else{
            subscriptionDate = customerSubscriptionDate.toString();
        }
        return String.join(",", String.valueOf(customerWeight), 
                String.valueOf(customerHeight), 
                customerFitnessLevel, 
                customerSubscriptionPlan, 
                subscriptionDate, 
                String.format("%.2f", customerTotalSpending));
    }
}
