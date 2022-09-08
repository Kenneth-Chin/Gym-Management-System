// Kenneth Chin Wei Yow TP059382
// Kelwin Chew TP059457

package oodj_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class OODJ_Assignment {

    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<Customer> Customers = readCustomerFile();
        ArrayList<Trainer> Trainers = readTrainerFile();
        ArrayList<Manager> Managers = readManagerFile();
        ArrayList<TrainingSession> TrainingSessions = readTrainingSessionFile();
        ArrayList<Payment> Payments = readPaymentFile();
        ArrayList<Feedback> Feedbacks = readFeedbackFile();
        Gym APUGym = new Gym(Customers, Trainers, Managers, TrainingSessions, Payments, Feedbacks);
        
        startForm sf = new startForm(APUGym);
        sf.setVisible(true);
    }
    
    public static ArrayList<Customer> readCustomerFile() throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/oodj_assignment/text_files/customer.txt"));
        s.useDelimiter(",|\n");
        
        ArrayList<Customer> Customers = new ArrayList<>();
        while(s.hasNext()){
            String userID = s.next();
            String userName = s.next();
            String userPassword = s.next();
            String userPhoneNumber = s.next();
            String userEmail = s.next();
            String userGender = s.next();
            LocalDate userDateOfBirth = LocalDate.parse(s.next());
            LocalDate userJoinDate = LocalDate.parse(s.next());
            double customerWeight = s.nextDouble();
            double customerHeight = s.nextDouble();
            String customerFitnessLevel = s.next();
            String customerSubscriptionPlan = s.next();
            String subscriptionDate = s.next();
            LocalDate customerSubscriptionDate;
            if(subscriptionDate.equals("-")){
                customerSubscriptionDate = null;
            } else{
                customerSubscriptionDate = LocalDate.parse(subscriptionDate);
            }
            double customerTotalSpending = Double.parseDouble(s.next().strip());
            Customer newCustomer = new Customer(userID, userName, userPassword, 
                    userPhoneNumber, userEmail, userGender, userDateOfBirth, 
                    userJoinDate, customerWeight, customerHeight, 
                    customerFitnessLevel, customerSubscriptionPlan, 
                    customerSubscriptionDate, customerTotalSpending);
            Customers.add(newCustomer);
        }
        return Customers;
    }
    
    public static ArrayList<Trainer> readTrainerFile() throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/oodj_assignment/text_files/trainer.txt"));
        s.useDelimiter(",|\n");
        
        ArrayList<Trainer> Trainers = new ArrayList<>();
        while(s.hasNext()){
            String userID = s.next();
            String userName = s.next();
            String userPassword = s.next();
            String userPhoneNumber = s.next();
            String userEmail = s.next();
            String userGender = s.next();
            LocalDate userDateOfBirth = LocalDate.parse(s.next());
            LocalDate userJoinDate = LocalDate.parse(s.next());
            String trainerPosition = s.next();
            int trainerKPI = s.nextInt();
            int trainerYearOfExperience = s.nextInt();
            double trainerHourlyRate = s.nextDouble();
            double trainerMonthlySalary = s.nextDouble();
            String[] trainerCustomerID = s.next().strip().split("-");
            Trainer newTrainer = new Trainer(userID, userName, userPassword, 
                    userPhoneNumber, userEmail, userGender, userDateOfBirth, 
                    userJoinDate, trainerPosition, trainerKPI, 
                    trainerYearOfExperience, trainerHourlyRate, 
                    trainerMonthlySalary, trainerCustomerID);
            Trainers.add(newTrainer);
        }
        return Trainers;
    }
    
    public static ArrayList<Manager> readManagerFile() throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/oodj_assignment/text_files/manager.txt"));
        s.useDelimiter(",|\n");
        
        ArrayList<Manager> Managers = new ArrayList<>();
        while(s.hasNext()){
            String userID = s.next();
            String userName = s.next();
            String userPassword = s.next();
            String userPhoneNumber = s.next();
            String userEmail = s.next();
            String userGender = s.next();
            LocalDate userDateOfBirth = LocalDate.parse(s.next());
            LocalDate userJoinDate = LocalDate.parse(s.next().strip());
            
            Manager newManager = new Manager(userID, userName, userPassword, 
                    userPhoneNumber, userEmail, userGender, userDateOfBirth, 
                    userJoinDate);
            Managers.add(newManager);
        }
        return Managers;
    }
    
    public static ArrayList<TrainingSession> readTrainingSessionFile() throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/oodj_assignment/text_files/training_session.txt"));
        s.useDelimiter(",|\n");
        
        ArrayList<TrainingSession> TrainingSessions = new ArrayList<>();
        while(s.hasNext()){
            String trainingSessionID = s.next();
            String trainingSessionName = s.next();
            String trainingSessionLevel = s.next();
            String trainerID = s.next();
            String[] customerID;
            String unfilteredCustomerID = s.next();
            if(unfilteredCustomerID.isBlank()) customerID = new String[0];
            else customerID = unfilteredCustomerID.split("-");
            LocalDate trainingSessionDate = LocalDate.parse(s.next());
            LocalTime trainingSessionStart = LocalTime.parse(s.next());
            LocalTime trainingSessionEnd = LocalTime.parse(s.next());
            String trainingSessionStatus = s.next().strip();
            TrainingSession newTrainingSession = new TrainingSession(
                    trainingSessionID, trainingSessionName, 
                    trainingSessionLevel, trainerID, customerID, 
                    trainingSessionDate, trainingSessionStart, 
                    trainingSessionEnd, trainingSessionStatus);
            TrainingSessions.add(newTrainingSession);
        }
        return TrainingSessions;
    }
    
    public static ArrayList<Payment> readPaymentFile() throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/oodj_assignment/text_files/payment.txt"));
        s.useDelimiter(",|\n");
        
        ArrayList<Payment> Payments = new ArrayList<>();
        while(s.hasNext()){
            String paymentID = s.next();
            String paymentItem = s.next();
            String paymentMethod = s.next();
            double paymentAmount = s.nextDouble();
            String customerID = s.next();
            String staffID = s.next();
            LocalDateTime paymentDateTime = LocalDateTime.parse(s.next());
            String paymentStatus = s.next().strip();
            Payment newPayment = new Payment(paymentID, paymentItem, 
                    paymentMethod, paymentAmount, customerID, staffID, 
                    paymentDateTime, paymentStatus);
            Payments.add(newPayment);
        }
        return Payments;
    }
    
    public static ArrayList<Feedback> readFeedbackFile() throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/oodj_assignment/text_files/feedback.txt"));
        s.useDelimiter(",|\n");
        
        ArrayList<Feedback> Feedbacks = new ArrayList<>();
        while(s.hasNext()){
            String feedbackID = s.next();
            String trainingSessionID = s.next();
            String customerID = s.next();
            String feedbackType = s.next();
            String feedbackComment = s.next();
            int feedbackRating = Integer.parseInt(s.next().strip());
            Feedback newFeedback = new Feedback(feedbackID, trainingSessionID, 
                    customerID, feedbackType, feedbackComment, feedbackRating);
            Feedbacks.add(newFeedback);
        }
        return Feedbacks;
    }
}
