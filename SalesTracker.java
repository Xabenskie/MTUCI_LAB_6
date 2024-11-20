import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SalesTracker {
	private Map<String, Integer> salesMap;

	public SalesTracker() {
		salesMap = new TreeMap<>();
	}

	// Method to add a sold product
	public void addSale(String product) {
		salesMap.put(product, salesMap.getOrDefault(product, 0) + 1);
	}

	// Method to print the list of sold products
	public void printSales() {
		System.out.println("List of sold products:");
		for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	// Method to calculate the total sales count
	public int getTotalSales() {
		return salesMap.values().stream().mapToInt(Integer::intValue).sum();
	}

	// Method to find the most popular product
	public String getMostPopularProduct() {
		return salesMap.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.orElse("No products sold");
	}

	public static void main(String[] args) {
		SalesTracker tracker = new SalesTracker();
		Scanner scanner = new Scanner(System.in);
		String command;

		System.out.println("Type 'exit' to quit the program.");

		while (true) {
			System.out.print("Enter the name of the sold product: ");
			command = scanner.nextLine();

			if (command.equalsIgnoreCase("exit")) {
				break;
			}

			tracker.addSale(command);
		}

		// Output results
		tracker.printSales();
		System.out.println("Total sales count: " + tracker.getTotalSales());
		System.out.println("Most popular product: " + tracker.getMostPopularProduct());

		scanner.close();
	}
}
