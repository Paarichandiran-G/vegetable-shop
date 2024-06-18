package Views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import Controllers.consumerController;
import Controllers.productController;
import Resources.ProductDTO;
import Util.Input;

public class Consumer extends Input {
    public static void consumer() {
        System.out.println("--Welcome--");
        while (true) {
            try {
                System.out.println("+-----------------------------------------------------+");
                System.out.println("|              1.View Available Products              |");
                System.out.println("|              2.Exit                                 |");
                System.out.println("+-----------------------------------------------------+");
                System.out.println();
                int n = sc.nextInt();
                if (n == 1) {
                    System.out.println("Available Products");
                    ArrayList<ProductDTO> available = consumerController.consumerview();
                    System.out.println("+" + "-".repeat(15) + "+" + "-".repeat(27) + "+" + "-".repeat(24) + "+"+ "-".repeat(20) + "+" + "-".repeat(22) + "+");
                    System.out.printf("| %-13s | %-25s | %-22s | %-18s | %-20s |\n", "product_id", "product name","variety", "1kgprice", "Availability");
                    System.out.println("+" + "-".repeat(15) + "+" + "-".repeat(27) + "+" + "-".repeat(24) + "+"
                            + "-".repeat(20) + "+" + "-".repeat(22) + "+");
                    for (ProductDTO product : available) {
                        System.out.printf("| %-13s | %-25s | %-22s | %-18s | %-20s |\n", product.getProduct_id(),
                                product.getProduct_name(), product.getVariety(), product.get_1qtyprice(),
                                product.getAvailability());
                    }
                    System.out.println("+" + "-".repeat(15) + "+" + "-".repeat(27) + "+" + "-".repeat(24) + "+"
                            + "-".repeat(20) + "+" + "-".repeat(22) + "+");
                    System.out.println();
                    System.out.println("+--------------------------------+");
                    System.out.println("|            1.Buy               |");
                    System.out.println("|            2.Exit              |");
                    System.out.println("+--------------------------------+");
                    int k = sc.nextInt();
                    if (k == 1) {
                        System.out.println();
                        System.out.println("--Enter The Product_id--");
                        System.out.println();
                        int p = sc.nextInt();
                        System.out.println();
                        System.out.println("--Enter You Want Quantity--");
                        System.out.println();
                        int q = sc.nextInt();
                        System.out.println();
                        consumerController.sell(p, q);
                        System.out.println();
                        System.out.println("--Sucessfully Buyed--");
                    } else {
                        System.out.println("-- Thank You ! --");
                        return;
                    }
                } else {
                    System.out.println("-- Thank You ! --");
                    return;
                }

            } 
            catch(SQLException err){
                System.out.println("--Database error--");
            }
            catch(InputMismatchException err){
                System.out.println("--Invalid input--");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
