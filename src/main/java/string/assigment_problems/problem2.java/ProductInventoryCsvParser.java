ProductInventoryCsvParser.java

package string.assigment_problems;

import java.util.Scanner;

public class ProductInventoryCsvParser {

    static void parseInventoryRecord(String csvLine) {
        String[] parts = csvLine.split(",");

        if (parts.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String product = parts[0].trim();
        String sku = parts[1].trim();
        String quantity = parts[2].trim();

        System.out.println("Product: " + product
                + " | SKU: " + sku
                + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter inventory record: ");
        String csvLine = sc.nextLine();

        parseInventoryRecord(csvLine);

        sc.close();
    }
}