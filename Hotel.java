import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Hotel {​
    // constant for Y and N value
    private static final String Y = "Y";
    private static final String N = "N";
    // Default tax rate 20%
    private static final double DEFAULT_TAX_RATE = 20;
    public static void main(String[] args) throws FileNotFoundException {​
        Scanner input = new Scanner(System.in);
        // Ask for different tax rate question
        System.out.print("Specify Custom Tax Rate [Y|N]: ");
        boolean isCustomTax = readYN(input);
        // Get custom tax rate from input
        double tax = DEFAULT_TAX_RATE;
        if(isCustomTax) {​
            System.out.print("Specify Tax Rate (%): ");
            tax = input.nextDouble();
            // validate tax rate
            if (tax > 100 || tax < 0) {​
                System.out.println("the tax is must be higher than 0 and lower than 100");
            }​
        }​
        double totalIncome = 0;
        double totalTax = 0;
        System.out.println(); // Empty line as in the doc
        // read the rooms.txt file and calculate total income and tax
        Scanner file = new Scanner(new FileReader("rooms.txt"));
        while (file.hasNext()) {​
            String roomType = file.next();
            int bookings = file.nextInt();
            double price = file.nextDouble();
            double income = bookings * price;
            double finalTax = income / 100 * tax;
            System.out.printf("Room Type: %s, Bookings: %d, Room Price: £%.2f, Income: £%.2f, Tax: £%.2f\n", roomType, bookings, price, income, finalTax);
            totalIncome += income;
            totalTax += tax;
        }​
        // output the result of the total income and tax
        System.out.println(); // Empty line as in the doc
        System.out.printf("the total income is £%.2f%n", totalIncome);
        System.out.printf("the total tax is £%.2f", totalTax);
    }​
    // Helper method to read Y and N from input, otherwise is going to re-request the input
    private static boolean readYN(Scanner input) {​
        String answer;
        boolean yn;
        while (true) {​
            answer = input.nextLine().trim().toLowerCase();
            if (answer.equalsIgnoreCase(Y)) {​
                yn = true;
                break;
            }​ else if (answer.equalsIgnoreCase(N)) {​
                yn = false;
                break;
            }​ else {​
                System.out.print("input either Y or N: ");
            }​
        }​
        return yn;
    }​
}​
    
    
  
  

