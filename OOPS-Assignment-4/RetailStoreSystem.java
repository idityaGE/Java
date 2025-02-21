
import java.util.*;

abstract class PaymentCard {

    protected String cardNumber;
    protected double balance;

    public PaymentCard(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | New Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

class CreditCard extends PaymentCard {

    private double cardLimit;

    public CreditCard(String cardNumber, double balance, double cardLimit) {
        super(cardNumber, balance);
        this.cardLimit = cardLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + cardLimit) {
            balance -= amount;
            System.out.println("Payment Successful: " + amount);
        } else {
            System.out.println("Insufficient Funds in Credit Card!");
        }
    }
}

class DebitCard extends PaymentCard {

    public DebitCard(String cardNumber, double balance) {
        super(cardNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Payment Successful: " + amount);
        } else {
            System.out.println("Insufficient Balance in Debit Card!");
        }
    }
}

class Customer {

    private String name;
    private String membershipType;
    private List<PaymentCard> paymentCards;
    private List<String> stores;

    public Customer(String name, String membershipType) {
        this.name = name;
        this.membershipType = membershipType;
        this.paymentCards = new ArrayList<>();
        this.stores = new ArrayList<>();
    }

    public void addPaymentCard(PaymentCard card) {
        paymentCards.add(card);
    }

    public void makePayment(double amount) {
        if (paymentCards.isEmpty()) {
            System.out.println("No Payment Cards Available!");
            return;
        }
        System.out.println("Select Payment Card:");
        for (int i = 0; i < paymentCards.size(); i++) {
            System.out.println(i + ". Card Balance: " + paymentCards.get(i).getBalance());
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice >= 0 && choice < paymentCards.size()) {
            paymentCards.get(choice).withdraw(amount);
        } else {
            System.out.println("Invalid Selection!");
        }
    }

    public void joinStore(String storeName) {
        stores.add(storeName);
        System.out.println(name + " joined store: " + storeName);
    }

    public void displayDetails() {
        System.out.println("Customer: " + name + ", Membership: " + membershipType);
        System.out.println("Stores: " + stores);
    }
}

public class RetailStoreSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        while (true) {
            System.out.println("1. Add Customer\n2. Add Payment Card\n3. Make Payment\n4. Join Store\n5. Display Customers\n6. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.next();
                    System.out.print("Enter Membership Type (Regular/Premium): ");
                    String membership = sc.next();
                    customers.add(new Customer(name, membership));
                    System.out.println("Customer Added!");
                    break;
                case 2:
                    if (customers.isEmpty()) {
                        System.out.println("No Customers Available!");
                        break;
                    }
                    System.out.println("Select Customer (0 to " + (customers.size() - 1) + "): ");
                    int custIndex = sc.nextInt();
                    if (custIndex < 0 || custIndex >= customers.size()) {
                        System.out.println("Invalid Selection!");
                        break;
                    }
                    System.out.println("Choose Card Type: 1. Credit Card 2. Debit Card");
                    int cardChoice = sc.nextInt();
                    System.out.print("Enter Card Number: ");
                    String cardNum = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    if (cardChoice == 1) {
                        System.out.print("Enter Credit Limit: ");
                        double cardLimit = sc.nextDouble();
                        customers.get(custIndex).addPaymentCard(new CreditCard(cardNum, balance, cardLimit));
                    } else if (cardChoice == 2) {
                        customers.get(custIndex).addPaymentCard(new DebitCard(cardNum, balance));
                    } else {
                        System.out.println("Invalid Card Type!");
                        continue;
                    }
                    System.out.println("Payment Card Added!");
                    break;
                case 3:
                    if (customers.isEmpty()) {
                        System.out.println("No Customers Available!");
                        break;
                    }
                    System.out.println("Select Customer: ");
                    custIndex = sc.nextInt();
                    System.out.print("Enter Payment Amount: ");
                    double amount = sc.nextDouble();
                    customers.get(custIndex).makePayment(amount);
                    break;
                case 4:
                    if (customers.isEmpty()) {
                        System.out.println("No Customers Available!");
                        break;
                    }
                    sc.nextLine(); // Consume the newline character left by nextInt()
                    System.out.print("Enter Store Name: ");
                    String storeName = sc.nextLine();
                    System.out.println("Select Customer: ");
                    custIndex = sc.nextInt();
                    if (custIndex < 0 || custIndex >= customers.size()) {
                        System.out.println("Invalid Selection!");
                        break;
                    }
                    customers.get(custIndex).joinStore(storeName);
                    break;
                case 5:
                    for (Customer cust : customers) {
                        cust.displayDetails();
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
