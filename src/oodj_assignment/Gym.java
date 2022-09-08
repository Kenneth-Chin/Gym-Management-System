package oodj_assignment;

import java.io.*;
import java.util.*;
        
public class Gym {
    private ArrayList<Customer> Customers;
    private ArrayList<Trainer> Trainers;
    private ArrayList<Manager> Managers;
    private ArrayList<TrainingSession> TrainingSessions;
    private ArrayList<Payment> Payments;
    private ArrayList<Feedback> Feedbacks;
    
    public Gym(ArrayList<Customer> Customers, ArrayList<Trainer> Trainers, 
            ArrayList<Manager> Managers, ArrayList<TrainingSession> TrainingSessions,
            ArrayList<Payment> Payments, ArrayList<Feedback> Feedbacks){
        this.Customers = Customers;
        this.Trainers = Trainers;
        this.Managers = Managers;
        this.TrainingSessions = TrainingSessions;
        this.Payments = Payments;
        this.Feedbacks = Feedbacks;
    }
    
    public ArrayList<Customer> getCustomers(){
        return Customers;
    }
    
    public ArrayList<Trainer> getTrainers(){
        return Trainers;
    }
    
    public ArrayList<Manager> getManagers(){
        return Managers;
    }
    
    public ArrayList<TrainingSession> getTrainingSessions(){
        return TrainingSessions;
    }
    
    public ArrayList<Payment> getPayments(){
        return Payments;
    }
    
    public ArrayList<Feedback> getFeedbacks(){
        return Feedbacks;
    }
    
    public void saveAllRecords(){
        File f;
        BufferedWriter bw;
        
        try{
            f = new File("src/oodj_assignment/text_files/customer.txt");
            bw = new BufferedWriter(new FileWriter(f));
            for(Customer cust: Customers){
                bw.write(cust.getUserRecordLine() + "," + cust.getCustomerRecordLine() + "\n");
            }
            bw.close();
            
            f = new File("src/oodj_assignment/text_files/trainer.txt");
            bw = new BufferedWriter(new FileWriter(f));
            for(Trainer tr: Trainers){
                bw.write(tr.getUserRecordLine() + "," + tr.getTrainerRecordLine() + "\n");
            }
            bw.close();
            
            f = new File("src/oodj_assignment/text_files/manager.txt");
            bw = new BufferedWriter(new FileWriter(f));
            for(Manager ma: Managers){
                bw.write(ma.getUserRecordLine() + "\n");
            }
            bw.close();
            
            f = new File("src/oodj_assignment/text_files/training_session.txt");
            bw = new BufferedWriter(new FileWriter(f));
            for(TrainingSession ts: TrainingSessions){
                bw.write(ts.getTrainingSessionRecordLine() + "\n");
            }
            bw.close();
            
            f = new File("src/oodj_assignment/text_files/payment.txt");
            bw = new BufferedWriter(new FileWriter(f));
            for(Payment pay: Payments){
                bw.write(pay.getPaymentRecordLine() + "\n");
            }
            bw.close();
            
            f = new File("src/oodj_assignment/text_files/feedback.txt");
            bw = new BufferedWriter(new FileWriter(f));
            for(Feedback fe: Feedbacks){
                bw.write(fe.getFeedbackRecordLine() + "\n");
            }
            bw.close();
        } catch(IOException e){
            System.out.println(e);
        }   
    }
}
