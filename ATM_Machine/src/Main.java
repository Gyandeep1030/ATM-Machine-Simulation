import java.util.Scanner;

// Created an ATM Class
class ATM{
    float Balance;
    int PIN = 1234;                     // let PIN is 1234
    int attempt = 3;
    Scanner sc = new Scanner(System.in);  // Declare Scanner at class level


    // Function TO Check PIN.
    public void checkPIN(){
        System.out.println("Enter your 4 Digit PIN");

        int EnterPIN = sc.nextInt();

        if (EnterPIN == PIN) {
            menu();
        }
        else {
            attempt--;
            if (attempt > 0) {
                System.out.println(" xxx Wrong PIN xxx");
                checkPIN();
            }
            else {
                System.out.println("Too many incorrect attempts. Exiting.");
            }
            return;
        }
    }

    // Function to Show Main Menu To User
    public void menu(){
        System.out.println("Enter Your Choice : ");
        System.out.println("1  - To Check Balance");
        System.out.println("2  - To Withdraw Money");
        System.out.println("3  - To Deposit Money");
        System.out.println("4  - PIN_Change");
        System.out.println("5  - Exit");

        // Taking Input
        int Choice = sc.nextInt();

        // Option Selection Condition
        if (Choice == 1){
            check_Balance();
        }
        else  if (Choice == 2){
            withdraw_Money();
        }
        else if (Choice == 3){
            deposit_Money();
        }
        else if (Choice == 4){
            PIN_Change();
        }
        else if (Choice == 5){
            return;
        }
        else {
            System.out.println("Select Valid Option");
        }
    }
    // Function To Check Balance
    public void check_Balance(){
        System.out.println("Balance = " + Balance);
        menu();
    }

    // Function to Withdraw money
    public void withdraw_Money(){
        System.out.println("Enter Amount You Want To Withdraw");
        int amount = sc.nextInt();

        if (Balance < amount){
            System.out.println("Insufficient Balance");
        }
        else {
            Balance = Balance - amount ;
            System.out.println("----- Collect Your Cash -----  Withdrawal Successful");
        }
        menu();
    }

    // Function To Deposit Money
    public void deposit_Money(){
        System.out.println("Enter The Amount You Want To Deposit");
        int amount = sc.nextInt();
        Balance = Balance + amount;
        System.out.println("Deposit Successfull");
        menu();
    }
    // Function To Change PIN

    public void PIN_Change(){
        
        menu();
    }

}



public class Main {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPIN();
    }
}