package Aplication;

import java.util.Locale;
import java.util.Scanner;

import Model.Entities.Account;
import Model.Exception.WithdrawException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withDrawLimit = sc.nextDouble();
			System.out.println();
			Account account = new Account(number, holder, balance, withDrawLimit);

			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println(account.toString());

		} catch (WithdrawException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}

		sc.close();
	}

}
