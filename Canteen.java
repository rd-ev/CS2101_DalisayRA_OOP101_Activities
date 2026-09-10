import java.util.Scanner;

class Canteen {
	public static void main (String[] args){

		System.out.println("=====    M E N U    =====");
		System.out.println("1. Burger        - $80.00");
		System.out.println("2. Pizza         - $120.00");
		System.out.println("3. Pasta         - $100.00");
		System.out.println("4. Sandwich      - $70.00");
		System.out.println("5. Milktea       - $90.00 \n");

		Scanner input = new Scanner(System.in);

		char orderAgain;
		int totalItems = 0;
		double beforeDiscount = 0;
		double totalDiscount = 0;
		double finalAmount = 0;

		do {
			System.out.print("Enter item number: ");
			int itemNumber = input.nextInt();

			System.out.print("Enter quantity: ");
			int quantity = input.nextInt();

			if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10) {
				System.out.println("");
				System.out.println("Invalid order! Please enter a valid item and quantity.");
				System.out.println("");

				do {
					System.out.print("Do you want to order again? (Y/N): ");
					orderAgain = input.next().charAt(0);
					System.out.println("");
				} while (orderAgain != 'Y' && orderAgain != 'N');

				continue;
			}

			System.out.print("Are you a student? (Y/N): ");
			char student = input.next().charAt(0);
			System.out.println("");

			if (student != 'Y' && student != 'N') {
				System.out.println("Invalid order!");
				System.out.println("");
				
				do {
					System.out.print("Do you want to order again? (Y/N): ");
					orderAgain = input.next().charAt(0);
					System.out.println("");
				} while (orderAgain != 'Y' && orderAgain != 'N');

				continue;
			}

			double price = 0;
			switch (itemNumber) {
				case 1:
					price = 80.00;
					break;
				case 2:
					price = 120.00;
					break;
				case 3:
					price = 100.00;
					break;
				case 4:
					price = 70.00;
					break;
				case 5:
					price = 90.00;
					break;
			}

			double subtotal = price * quantity;
			double discount = 0;
			double orderTotal;

			if (student == 'Y') {
				if (subtotal >= 500) {
					discount = subtotal * 0.15;
				} else {
					discount = subtotal * 0.10;
				}
			} else {
				if (subtotal >= 500) {
					discount = subtotal * 0.05;
				} else {
					discount = 0.0;
				}
			}

			orderTotal = subtotal - discount;

			System.out.printf("Subtotal: $%.2f%n", subtotal);
			System.out.printf("Discount: $%.2f%n", discount);
			System.out.printf("Order total: $%.2f%n", orderTotal);
			System.out.println("");

			System.out.print("Do you want to order again? (Y/N): ");
			orderAgain = input.next().charAt(0);
			System.out.println("");

			while (orderAgain != 'Y' && orderAgain != 'N') {
    			System.out.print("Do you want to order again? (Y/N): ");
    			orderAgain = input.next().charAt(0);
   				System.out.println("");
			}

			totalItems += quantity;
			beforeDiscount += subtotal;
			totalDiscount += discount;
			finalAmount += orderTotal;

		} while (orderAgain == 'Y');

		System.out.println("===== ORDER SUMMARY =====");
		System.out.println("Total items: " + totalItems);
		System.out.printf("Total before discount: $%.2f%n", beforeDiscount);
		System.out.printf("Total discount: $%.2f%n", totalDiscount);
		System.out.printf("Final amount: $%.2f%n", finalAmount);
		System.out.println("Thank you for ordering!");

	}
}