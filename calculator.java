package javapractice;

import java.util.Scanner;

public class calculator {
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

	    // ask users to enter operator
	    System.out.println("Choose an operator: +, -, *, or /");
	    char op= input.next().charAt(0);

	    System.out.println("Enter first number :");
	    double n1 = input.nextDouble();

	    System.out.println("Enter second number:");
	    double n2 = input.nextDouble();

	    double result;
		switch (op) {
								// performs addition between numbers
	      case 1:
	        result = n1 + n2;
	        System.out.println(n1 + " + " + n2 + " = " + result);
	        break;

	        				// performs subtraction between numbers
	      case 2:
	        result = n1 - n2;
	        System.out.println(n1 + " - " + n2 + " = " + result);
	        break;

	      // performs multiplication between numbers
	      case 3:
	        result = n1 * n2;
	        System.out.println(n1 + " * " + n2 + " = " + result);
	        break;

	      // performs division between numbers
	      case 4:
	        result = n1 / n2;
	        System.out.println(n1 + " / " + n2 + " = " + result);
	        break;

	      default:
	        System.out.println("Invalid operator!");
	        break;
	    }

	    input.close();
	  }
	
	}


