package oodj_assignment;

import java.util.*;

public class Feedback {
    private String feedbackID;
    private String trainingSessionID;
    private String customerID;
    private String feedbackType;
    private String feedbackComment;
    private int feedbackRating;
    
    public Feedback(String feedbackID, String trainingSessionID, 
            String customerID, String feedbackType, 
            String feedbackComment, int feedbackRating){
        this.feedbackID = feedbackID;
        this.trainingSessionID = trainingSessionID;
        this.customerID = customerID;
        this.feedbackType = feedbackType;
        this.feedbackComment = feedbackComment;
        this.feedbackRating = feedbackRating;
    }
    
    public String getFeedbackID(){
        return feedbackID;
    }
    
    public String getTrainingSessionID(){
        return trainingSessionID;
    }
    
    public String getCustomerID(){
        return customerID;
    }
    
    public String getCustomerName(ArrayList<Customer> Customers){
        String customerName = null;
        for(Customer cust: Customers){
            if(cust.getUserID().equals(customerID)){
                customerName = cust.getUserName();
            }
        }
        return customerName;
    }
    
    public String getFeedbackType(){
        return feedbackType;
    }
    
    public String getFeedbackComment(){
        return feedbackComment;
    }
    
    public int getFeedbackRating(){
        return feedbackRating;
    }
    
    public String getFeedbackRecordLine(){
        return String.join(",", feedbackID, 
                trainingSessionID, 
                customerID, 
                feedbackType, 
                feedbackComment, 
                String.valueOf(feedbackRating));
    }
}
