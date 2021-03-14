import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Grocery {
	private String name;

	// in kg
	private double quantitiy;

	private double price;
	
	

	// getters and setters for each field

	public Grocery() {
		
	}

	public Grocery(String name, double quantitiy, double price) {
		super();
		this.name = name;
		this.quantitiy = quantitiy;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantitiy() {
		return quantitiy;
	}

	public void setQuantitiy(double quantitiy) {
		this.quantitiy = quantitiy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

	@Override
	public int hashCode() {
		int hash=0;
		
		//Name of item after removing extra spaces and converting into lower case
		//so that we can have same hash code for names in upper case and lower case.
		//for example "Wheat "=="wheat"
		String name=this.getName().strip().toLowerCase();
		
		//length of name of item
		int len=this.getName().length();
		
		
		for(int i=0;i<len;i++)
			hash+=(int)name.charAt(i);
		
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.hashCode()==obj.hashCode()) {
			return true;
		}
		
		return false;
	}
	
	
}

public class GroceryList {
	// customer budget
	private double budget;
	
	// list of grocery
	private Set<Grocery> list ;
	public GroceryList() {
		budget=0;
		list = new HashSet<>();
	}
	public static void main(String[] args) {
		
		GroceryList gList=new GroceryList();
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Your Budget:");
		gList.budget = Double.valueOf(sc.nextLine());

		

		addItem(gList,sc);

		// check any item within the budget is left.
		if (gList.budget != 0) {
			for (Grocery i : gList.list) {
				if (i.getPrice() <= gList.budget)
					System.out.println("Amount Left Can buy You " + i.getName());
			}
			
			int choice = 0;

			System.out.println("\n\n1.Add item again : ");
			System.out.println("2.Continue : ");

			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();

			if (choice == 1)
				addItem(gList,sc);
		}
		
		

		System.out.println("\n\nGrocery List is ");
		System.out.println("Name \tQuantity \tPrice");
		for (Grocery i : gList.list) {
			System.out.println(i.getName() + "\t\t" + i.getQuantitiy() + "\t" + i.getPrice());
		}

	}

	private static void addItem(GroceryList gList, Scanner sc) {
		
		int choice;
		
		// condition for breaking loop.
		boolean flag = true;
		do {

			System.out.println("1.Add an Item");
			System.out.println("2.Exit");
			System.out.print("Enter Your Choice : ");
			choice = Integer.valueOf(sc.nextLine());

			switch (choice) {
			case 1:
				Grocery item = new Grocery();
				System.out.print("\nEnter product : ");
				item.setName(sc.nextLine());

				System.out.print("\nEnter quantity : ");
				item.setQuantitiy(Double.valueOf(sc.nextLine()));

				System.out.print("\nEnter price : ");
				item.setPrice(Double.valueOf(sc.nextLine()));

				if (item.getPrice() <= gList.budget) {
					
					//checking if the item is already present or not
					boolean add=gList.list.contains(item);
					
					
					//if already present then increase just quantity and price.
					if(add) {
						//getting the previous Grocery details
						Grocery pre=gList.getGrocery(item);
						
						gList.list.remove(item);
					
						
						Grocery updatedItem = new Grocery(item.getName(),item.getQuantitiy()+pre.getQuantitiy(),item.getPrice()+pre.getPrice());
						gList.list.add(updatedItem);
						
					}
					else
						gList.list.add(item);
					gList.budget -= item.getPrice();
					System.out.println("\nAmount Left : " + gList.budget);
				} else
					System.out.println("\nCan't Buy the product ###(because budget left is " + gList.budget + ")");
				break;
			case 2:
				flag = false;
				break;
			default:
				System.out.println("invalid input");
			}

		} while (flag);
	}
	private Grocery getGrocery(Grocery item) {
		for(Grocery i:this.list) {
			if(i.equals(item)) {
				return i;
			}
		}
		return null;
	}
}
