package ATM;

import java.sql.*;

import java.util.Scanner;

public class Atminterface {

	public static void main(String[] args) 
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","Sandy214ls@mysql");
			Statement ss1=con.createStatement();
			ResultSet ls=ss1.executeQuery("select * from customer");
	    	   
			if(ls.next()){
				String name = ls.getString("cname");
				int pas=ls.getInt("pass_code");
				int acc = ls.getInt("ac_no");
				int balance = ls.getInt("balance") ;
		
				int deposit= 0 ;
				int withdrawl = 0;
		
		
				Scanner ss= new Scanner(System.in);
				System.out.println("Enter Your Acc no :");
				int acc1 = ss.nextInt();
	 	
				System.out.println("Enter Your Pin :");
				int pin = ss.nextInt();
	 	
				if(acc1 == acc && pas == pin){
					System.out.println("Welcome " + name );
					boolean flag=true;
					
					while(flag) {
						System.out.println("---------------------------------- ");
						System.out.println("Press 1 to Check your balance : ");
						System.out.println("Press 2 to deposit : ");
						System.out.println("Press 3 to Withdrawl : ");
						System.out.println("Press 4 to Transaction : ");
						System.out.println("Press 5 to Exit: ");
						System.out.println("---------------------------------- ");
						int opt = ss.nextInt();
						switch(opt) {
	 			
							case 1:  
								System.out.println("Your current balance is :" + balance);
								break;
	 			
							case 2: 	
								System.out.println("Enter Your Deposit Amount :  ");
								deposit= ss.nextInt();
					
								ss1.executeUpdate("update customer set balance=balance+"+ deposit + " where ac_no=" + acc);
	 			
								System.out.println(" Your Amount Successfully deposited! ");
								break;
 			
							case 3:
 				
								System.out.println("Enter Your Withdrawl Amount : ");
								withdrawl = ss.nextInt();
								if(withdrawl > balance){
									System.out.println("Your balance is insufficient");
									System.out.println("Check your available balance");
								}else {
									ss1.executeUpdate("update customer set balance=balance-"
									+ withdrawl + " where ac_no=" + acc);
					
									System.out.println("Your Amount Successfully Taken  ");
									break;
								}
	 		
							case 4:
	 		
								System.out.println("Welcome to A1 ATM");
								System.out.println("Available balance is " + balance);
								System.out.println("Amount deposited     " + deposit);
								System.out.println("Amount taken         " + withdrawl);
								System.out.println("Thank You for Using Our ATM");
								break;
							case 5:
								System.out.println("Thank YOu");
								flag=false;
								break;
							default:
								System.out.println("Press the number below 5");
								break;
						}
					}
				}else{
					System.out.println("Please Enter Valid Account number and Pin Number ");
				}
			}
		ss1.close();
		con.close();
	 	}catch(Exception e){
			System.out.println("Failed");
		}   
		
	}
}