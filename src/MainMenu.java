import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

	private Scanner sc;
	private List<Product> ProductList = new ArrayList<Product>();
	Product p = new Product(0, null, 0, 0);

	public MainMenu() {
		this.sc = new Scanner(System.in);
	}

	private int menu() {
		System.out.println("Inventory Menu");
		System.out.println("1 Add product");
		System.out.println("2 View all products");
		System.out.println("3 Show total");
		int number = readMenu(1, 3);
		return number;
	}

	private int readMenu(int min, int max) {
		int number;
		while (true) {
			try {
				number = Integer.parseInt(sc.nextLine());
				if (number >= min && number <= max) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Choose a number from Menu");
				e.printStackTrace();
			}
		}
		return number;
	}

	private double readQuantity(int min, double max) {
		double quantity;
		while (true) {
			try {
				quantity = Double.parseDouble(sc.nextLine());
				if (quantity >= min && quantity <= max) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid value for quantity");
			}
		}
		return quantity;
	}

	private double readPrice(int min, double max) {
		double price;
		while (true) {
			try {
				price = Double.parseDouble(sc.nextLine());
				if (price >= min && price <= max) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid value for price");
			}
		}
		return price;
	}

	private void showAll() {
		System.out.println("List of products");
		System.out.println("ID\tName\tQuantity\tPrice");
		for (Product p : ProductList) {
			System.out.println(p.getId() + "\t" + p.getname() + "\t"
					+ p.getquantity() + "\t\t" + p.getPrice());

		}
	}

	private void sumUpTotal() {
		System.out.println("Total value: ");
		double sum = 0;
		for (Product p : ProductList) {
			sum += p.getquantity() * p.getPrice();
		}
		System.out.println(sum);
	}

	private void addProduct() {
		System.out.println("ID: ");
		int id = readMenu(0, Integer.MAX_VALUE);
		System.out.println("Product name: ");
		String name = sc.nextLine();
		System.out.println("Quantity: ");
		double quantity = readQuantity(0, Double.MAX_VALUE);
		System.out.println("Price: ");
		double price = readPrice(0, Double.MAX_VALUE);
		ProductList.add(new Product(id, name, quantity, price));
	}

	public void startMenu() {
		while (true) {
			int number = menu();
			switch (number) {
			case 1:
				addProduct();
				break;
			case 2:
				showAll();
				break;
			case 3:
				sumUpTotal();
				break;
			default:
				throw new AssertionError();
			}
		}
	}
}
