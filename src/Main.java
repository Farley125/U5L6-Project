import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankApp app = new BankApp();
        // call methods from your BankApp object to handle program logic
        boolean twoAccounts = false;
        String cardNumber = "1";
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to the Chiti Bank App!\nWhat is your full name?  ");
        String name = sc.nextLine();
        CreditCard card1 = new CreditCard(name, Integer.toString(((int) (Math.random() * 9999) + 1)));
        CreditCard card2 = new CreditCard();
        System.out.println("Welcome to Chiti Bank, your pin is " + card1.getPersonalPIN() + "\n\n");
        Bank firstAccount = new Bank();
        BagelShop firstShop = new BagelShop(name, 1000, 2, firstAccount);

        boolean isDone = false;
        while (isDone == false) {
            System.out.println("1 to make a purchase or return\n2 to make a payment on your card\n3 to open up another credit card\n4 to compare your balances\n5 if you're a business owner\n6 to go bankrupt\n7 if you're finished");
            String input = sc.nextLine();
            if (input.equals("1")) {
                System.out.print("Are you making a return or a purchase? (1 for returns, 2 for purchases) ");
                input = sc.nextLine();
                if (twoAccounts == true) {
                    System.out.print("Which card would you like to use? (1 or 2) ");
                    cardNumber = sc.nextLine();
                }
                if (input.equals("1")) {
                    System.out.print("How many bagels are you returning? ");
                    input = sc.nextLine();
                    System.out.print("What is your pin number? ");
                    String input2 = sc.nextLine();
                    if (firstShop.returnBagels((card1 + cardNumber, Integer.parseInt(input), input2)) {
                        System.out.println("Return was successful!");
                    } else System.out.println("Wrong PIN.");
                } else {
                    System.out.print("How many bagels would you like to purchase? ");
                    input = sc.nextLine();
                    System.out.print("What is your pin number? ");
                    String input2 = sc.nextLine();
                    if (firstShop.payForBagels(card1, Integer.parseInt(input), input2)) {
                        card1.chargeCard(firstShop.getBagelPrice() * Integer.parseInt(input));
                        System.out.println("Purchase was successful!");
                    } else System.out.println("Wrong PIN.");
                }
            } else if (input.equals("2")) {
                System.out.print("Input your pin. ");
                input = sc.nextLine();
                if (card1.checkPIN(input)) {
                    System.out.print("Current bank statement $" + card1.getBalanceOwed() + " owed.\nHow much would you like to pay back? ");
                    input = sc.nextLine();
                    firstAccount.makePayment(card1, Integer.parseInt(input));
                } else System.out.println("Wrong PIN.");
            } else if (input.equals("3")) {
                System.out.print("What is your full name?  ");
                String name2 = sc.nextLine();
                card2 = new CreditCard(name2, Integer.toString(((int) (Math.random() * 9999) + 1)));
                System.out.println("Welcome to Chiti Bank, your pin is " + card1.getPersonalPIN() + "\n\n");
                twoAccounts = true;
            } else if (input.equals("4")) {
                System.out.println("The account with the lower balance.\n" + firstAccount.lowerBalance(card1, card2));
            } else if (input.equals("5")) {
                System.out.print("Are you depositing funds, or checking inventory? (1 for deposits, 2 to check inventory) ");
                input = sc.nextLine();
                if (input.equals("1")) {
                    firstShop.depositProfits();
                    System.out.println(firstAccount);
                    } else {
                    System.out.println(firstShop);
                    }
            }
        }
    }
}

