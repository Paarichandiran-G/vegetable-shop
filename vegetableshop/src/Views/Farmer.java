package Views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.productController;
import Resources.ProductDTO;
import Resources.UserDTO;
import Util.Cookie;
import Util.Input;

public class Farmer extends Input {
	public static void farmer() {
		while (true) {
			try {
				System.out.println("+----------------------------------------+");
				System.out.println("|            1.Your Product Details      |");
				System.out.println("|            2.Sale Products             |");
				System.out.println("|            3.Exit                      |");
				System.out.println("+----------------------------------------+");
				int n = sc.nextInt();
				if (n == 1) {
					System.out.println("Product Details");
					ArrayList<ProductDTO> products = productController.product_details();
					System.out.println("+" + "-".repeat(27) + "+" + "-".repeat(24) + "+" + "-".repeat(20) + "+"
							+ "-".repeat(20) + "+" + "-".repeat(22) + "+");
					System.out.printf("| %-25s | %-22s | %-18s | %-18s | %-20s |\n", "product name", "variety", "qty",
							"cost", "date");
					System.out.println("+" + "-".repeat(27) + "+" + "-".repeat(24) + "+" + "-".repeat(20) + "+"
							+ "-".repeat(20) + "+" + "-".repeat(22) + "+");
					for (ProductDTO product : products) {
						System.out.printf("| %-25s | %-22s | %-18s | %-18s | %-20s |\n", product.getProduct_name(),
								product.getVariety(), product.getQty(), product.getCost(), product.getDate());
					}
					System.out.println("+" + "-".repeat(27) + "+" + "-".repeat(24) + "+" + "-".repeat(20) + "+"
							+ "-".repeat(20) + "+" + "-".repeat(22) + "+");
					System.out.println();
				} else if (n == 2) {

					System.out.println("--Enter Your Product Name--");
					System.out.println();
					sc.nextLine();
					String product_name = sc.nextLine();
					System.out.println();
					System.out.println("--Enter Your Product Variety--");
					System.out.println();
					String variety = sc.nextLine();
					System.out.println();
					System.out.println("--Enter Your Having Quantity--");
					System.out.println();
					int qty = sc.nextInt();
					System.out.println();
					System.out.println("--Enter Today Date (year/month/date)--");
					System.out.println();
					sc.nextLine();
					String date = sc.nextLine();
					System.out.println();
					System.out.println("--Total Cost Product--");
					System.out.println();
					int cost = sc.nextInt();
					System.out.println();
					System.out.println("--1kg Cost Of Product--");
					System.out.println();
					int _1qtyprice = sc.nextInt();
					productController.product(product_name, variety, qty, date, cost, _1qtyprice);

				} else {
					System.out.println("-- Thank You ! --");
					return;
				}
			} catch (SQLException err) {
				System.out.println("--Database error--");
			} catch (InputMismatchException err) {
				System.out.println("--Invalid input--");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
