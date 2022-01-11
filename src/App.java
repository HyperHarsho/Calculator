import java.util.Scanner;

public class App {
    public boolean works;
    public String input;
    public double ans;

    public void input() {
        Scanner sc = new Scanner(System.in);
        boolean rerun = true;
        while (rerun == true) {
            System.out.println("Enter the expression");
            input = sc.nextLine();
            String in = input;
            cal(in);
            if (works == false) {
                continue;
            }
            double an = ans;
            System.out.println("Answer = "+an);
        }
        sc.close();
    }

    private void cal(String iString) {
        String input = iString.trim();
        boolean numeric = false;
        double sum = 0;
        double val;
        String opp = "";
        try {
            Double.parseDouble(input);
            numeric = true;
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if (numeric == true) {
            ans = Double.parseDouble(input);
        } else {
            String[] aStrings = input.split("\\s+");
            try {
                Double.parseDouble(aStrings[0]);
                works = true;
            } catch (NumberFormatException e) {
                System.out.println("Input should only be numbers and opperators with space between them");
                works = false;
            }
            if (works == true) {
                for (int i = 0; i < aStrings.length; i++) {
                    if (i == 0) {
                        sum = Double.parseDouble(aStrings[0]);
                        continue;
                    }
                    if (i % 2 != 0) {
                        opp = aStrings[i];
                    }
                    if (i % 2 == 0) {
                        val = Double.parseDouble(aStrings[i]);
                        if (opp.equals("+")) {
                            sum = sum + val;
                        }
                        if (opp.equals("-")) {
                            sum = sum - val;
                        }
                        if (opp.equals("*")) {
                            sum = sum * val;
                        }
                        if (opp.equals("/")) {
                            sum = sum / val;
                        }
                    }
                }
                ans = sum;
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.input();
    }
}
