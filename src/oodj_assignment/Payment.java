package oodj_assignment;

import java.util.*;
import java.time.*;


public class Payment {
    private String paymentID;
    private String paymentItem;
    private String paymentMethod;
    private double paymentAmount;
    private String customerID;
    private String staffID;
    private LocalDateTime paymentDateTime;
    private String paymentStatus;
    
    public Payment(String paymentID, String paymentItem, String paymentMethod, 
            double paymentAmount, String customerID, String staffID, 
            LocalDateTime paymentDateTime, String paymentStatus){
        this.paymentID = paymentID;
        this.paymentItem = paymentItem;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.customerID = customerID;
        this.staffID = staffID;
        this.paymentDateTime = paymentDateTime;
        this.paymentStatus = paymentStatus;
    }
    
    public String getPaymentID(){
        return paymentID;
    }
    
    public String getPaymentItem(){
        return paymentItem;
    }
    
    
    public String getPaymentMethod(){
        return paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    
    public double getPaymentAmount(){
        return paymentAmount;
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
    
    public String getStaffID(){
        return staffID;
    }
    
    public String getStaffName(ArrayList<Trainer> Trainers, ArrayList<Manager> Managers){
        String staffName = null;
        if(staffID.startsWith("MA")){
            for(Manager ma: Managers){
                if(ma.getUserID().equals(staffID)){
                    staffName = ma.getUserName();
                }
            }
        } else if(staffID.startsWith("TR")){
            for(Trainer tr: Trainers){
                if(tr.getUserID().equals(staffID)){
                    staffName = tr.getUserName();
                }
            }
        }
        return staffName;
    }
    
    public String getPaymentDateTime(){
        return paymentDateTime.toString();
    }
    
    public void setPaymentDateTime(LocalDateTime paymentDateTime){
        this.paymentDateTime = paymentDateTime;
    }
    
    public String getPaymentStatus(){
        return paymentStatus;
    }
    
    public void setPaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }
    
    public String getPaymentRecordLine(){
        return String.join(",", paymentID, 
                paymentItem, 
                paymentMethod, 
                String.format("%.2f", paymentAmount), 
                customerID, 
                staffID, 
                paymentDateTime.toString(), 
                paymentStatus);
    }
   
}
