
/*
Implement a Banking System
Description:
HashMap stores customer accounts (AccountNumber -> Balance).
TreeMap sorts customers by balance.
Queue processes withdrawal requests.
 */

package org.example.Management;

import java.util.*;

public class BankingSystemImplementation {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding accounts
        bank.addAccount("sbi101", 5000);
        bank.addAccount("sbi102", 3000);
        bank.addAccount("sbi103", 7000);

        //  money deposit
        bank.deposit("sbi101", 2000);
        bank.deposit("sbi102", 1000);

        // Requesting for withdrawals
        bank.requestWithdrawal("sbi101");
        bank.requestWithdrawal("sbi102");

        // Processing withdrawals
        bank.processWithdrawals(1500);

        // Displaying accounts according to  balance
        bank.displayAccountsSortedByBalance();
    }
}

class BankingSystem {
    private Map<String, BankAccount> accounts = new HashMap<>();
    private TreeMap<Double, String> balanceSortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    // for Adding a new account
    public void addAccount(String accountNumber, double initialBalance) {
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.put(accountNumber, account);
        balanceSortedAccounts.put(initialBalance, accountNumber);
    }

    // method for Deposit money
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            balanceSortedAccounts.remove(account.getBalance()); // Remove old balance
            account.deposit(amount);
            balanceSortedAccounts.put(account.getBalance(), accountNumber);
            System.out.println("Deposited " + amount + " to " + accountNumber);
        } else {
            System.out.println(accountNumber+ " : Account not found");
        }
    }

    // Request for  withdraw
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for " + accountNumber);
        } else {
            System.out.println("Account not found");
        }
    }

    // Processing withdrawal requests
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            BankAccount account = accounts.get(accountNumber);
            balanceSortedAccounts.remove(account.getBalance());

            if (account.withdraw(amount)) {
                System.out.println("Withdrawn " + amount + " from " + accountNumber);
            } else {
                System.out.println("Insufficient balance for " + accountNumber);
            }

            balanceSortedAccounts.put(account.getBalance(), accountNumber);
        }
    }

    // Displaying all accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, String> entry : balanceSortedAccounts.entrySet()) {
            System.out.println(accounts.get(entry.getValue()));
        }
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Balance: " + balance;
    }
}
