package com.bankingServices.dsp.bank;

public class Bank implements BankInterface {

    private static long balance = 0;

    public static long getBalance() {
        return balance;
    }

    @Override
    public void creditBalance(int amount) {
        balance += amount;
    }

    @Override
    public boolean debitBalance(int amount) {
        if(balance<amount){
            return false;
        }
        balance -= amount;
        return true;
    }
}
