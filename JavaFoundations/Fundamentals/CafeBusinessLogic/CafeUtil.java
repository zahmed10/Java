import java.util.ArrayList;

public class CafeUtil {
    public String getStreakGoal() { //drinkNum is the number of drinks purchased the first week
        int num = 1;
        int sum;
        int num2;
        // num2 = 0;
        sum = 0;
        for (int i = 0; i < 10; i++) {
            int sumInit = num;
            num2= i + sumInit;
            sum += num2;
        }
        // String sum3 = (String)sum;
        String newString = Integer.toString(sum);
        return newString;
    }

    public void printPriceChart(String productName, double price, int maxNumber) {
        System.out.println(productName);
        String output = "";
        for (int i = 1; i <= maxNumber; i++) {
            double loopPrice = i * price;
            output = i + ": " + loopPrice;
            System.out.println(i + ": " + loopPrice);
        }
        // return output;
    }

    public double getOrderTotal(double arr[]) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    //Worked on the following methods with the help of classmates and the instructor. Code used is based off of instructor's
    // GitHub

    public void displayMenu(ArrayList<String> items, ArrayList<Double> price) {
        for (int i = 0; i<items.size(); i++) {
            System.out.println(i+1 + " "+items.get(i) +" -- "+ price.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please add a customer name");
        String userName = System.console().readLine();
        System.out.println();
        customers.add(userName);
        System.out.println("You have" + (customers.size() - 1) + "ahead of you");
    }
}