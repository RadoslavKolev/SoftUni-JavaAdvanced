package lection.bankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);

                    System.out.printf(
                        "Account ID%d created%n",
                        account.getId()
                    );
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);

                    if (accounts.containsKey(id)) {
                        accounts.get(id).deposit(amount);

                        System.out.printf(
                            "Deposited %.0f to ID%d%n",
                            amount, id
                        );
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    int checkId = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (accounts.containsKey(checkId)) {
                        double interest = accounts.get(checkId).getInterest(years);
                        System.out.printf("%.2f%n", interest);
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;
                default:
                    System.out.println("No such command!");
            }

            input = scanner.nextLine();
        }
    }
}
