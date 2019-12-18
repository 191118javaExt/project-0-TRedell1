package com.revature;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.BankAccountDao;
import com.revature.daos.BankAccountDaoImpl;
import com.revature.daos.BankUserDao;
import com.revature.daos.BankUserDaoImpl;
import com.revature.models.User;
import com.revature.services.BankUserService;

public class Driver {
	
	@SuppressWarnings("resource")
	public static void main (String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		BankUserService bus = new BankUserService();
		String email;
		int password;
		//User currentUser = null;
		
		System.out.println("Log in:");
		System.out.println("email");
		email = input.nextLine();
		
		System.out.println("password: ");
		password = input.nextLine().split(" ")[0].hashCode();
		//password = input.nextLine().hashCode();
		
		User u = bus.findbyUsernameAndPassword(email, password);
		//User u = bus.login(email, password);
		
		if (u == null) {
			System.out.println("Oops try again");
		}
		else {
			if (bus.login(email, password) == true) {
				System.out.println("You're logged in! Now its time to get that money!");
			}
		}

		Scanner in = new Scanner(System.in);

        int userChoice;

        boolean quit = false;

        float balance = 0f;

        do {
        		
              System.out.println("1. Deposit money");

              System.out.println("2. Withdraw money");

              System.out.println("3. Check balance");

              System.out.print("Your choice, 0 to quit: ");

              userChoice = in.nextInt();

              switch (userChoice) {

              case 1:

                    float amount;

                    System.out.print("Amount to deposit: ");

                    amount = in.nextFloat();

                    if (amount <= 0)

                         System.out.println("Can't deposit nonpositive amount.");

                    else {

                         balance += amount;

                         System.out.println("$" + amount + " has been deposited.");

                    }

                    break;

              case 2:

                    System.out.print("Amount to withdraw: ");

                    amount = in.nextFloat();

                    if (amount <= 0 || amount > balance)

                         System.out.println("Withdrawal can't be completed.");

                    else {

                         balance -= amount;

                         System.out.println("$" + amount + " has been withdrawn.");

                    }

                    break;

              case 3:

                    System.out.println("Your balance: $" + balance);

                    break;

              case 0:

                    quit = true;

                    break;

              default:

                    System.out.println("Wrong choice.");

                    break;

              }

              System.out.println();

        } while (!quit);

        System.out.println("Spend smart and Have a great day!");

  }

	
//		if(u.getEmail().equals(email) && u.getPassword()==(password)) {
//			System.out.println("You are logged in");
//		}

		// Uncomment to show connection to the database 
//		System.out.println("find all emails");
//		BankUserDao userDao = new BankUserDaoImpl();
//		userDao.findAll().forEach(user-> {
//			System.out.println(user);
//		});
//		List<User> users = new ArrayList();
//		users = userDao.findAll();
//		for (int i = 0; i < users.size(); i++) {
//			System.out.println(users);
//		}
//		
		// Uncomment both codes to show the bank accounts and user information 
		
//		int id = 4;
//		System.out.println("find email by userid");
//		System.out.println(userDao.findById(id));
//		
//		System.out.println("find all accounts");
//		BankAccountDao accountDao = new BankAccountDaoImpl();
//		accountDao.findAll().forEach(acc-> {
//			System.out.println(acc);
//		});
//		
//		int accid = 4;
//		System.out.println("find account by account id");
//		System.out.println(accountDao.findById(accid));
	
	}


