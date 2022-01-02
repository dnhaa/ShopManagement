package data;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MyToys {

    public static Scanner sc = new Scanner(System.in);

    public static int getAPositiveInt(String msg) {
        int n;
        do {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    return n;
                } else {
                    System.out.println("Wrong format. Input a positive integer.");
                }

            } catch (Exception e) {
                System.out.println("Wrong format. Input a positive integer.");
            }
        } while (true);
    }

    public static long getAPositiveLong(String msg) {
        String s;

        do {
            try {
                s = getAString(msg);
                Pattern tenDigit = Pattern.compile("^\\d{10}$");
                if (tenDigit.matcher(s).matches()) 
                    return Long.parseLong(s); 
                else
                    System.out.println("Wrong format. Input a 10-digit positive number.");

            } catch (Exception e) {
                System.out.println("Wrong format. Input a 10-digit positive number.");
            }
        } while (true);
    }

    public static double getAPositiveDouble(String msg) {
        double n;
        do {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (n > 0) {
                    return n;
                } else {
                    System.out.println("Wrong format. Input a positive double.");
                }

            } catch (Exception e) {
                System.out.println("Wrong format. Input a positive double.");
            }
        } while (true);
    }

    public static String getAString(String msg) {
        String n;
        do {
            try {
                System.out.print(msg);
                n = sc.nextLine().trim().toUpperCase();
                if (n.isEmpty()) {
                    System.out.println("Input cannot be empty.");
                } else {
                    return n;
                }
            } catch (Exception e) {
            }
        } while (true);
    }

    public static double getAPositiveDoubleUpdate(String msg, double previousDouble) {
        double n;
        String s;
        do {
            try {
                System.out.print(msg);
                if ((s = sc.nextLine().trim()).isEmpty()) {
                    return previousDouble;
                }
                n = Double.parseDouble(s);
                if (n > 0) {
                    return n;
                } else {
                    System.out.println("Wrong format. Input a positive double.");
                }

            } catch (Exception e) {
                System.out.println("Wrong format. Input a positive double.");
            }
        } while (true);
    }

    public static String getAStringUpdate(String msg, String previousString) {
        String n;
        do {
            try {
                System.out.print(msg);
                n = sc.nextLine().trim().toUpperCase();
                if (n.isEmpty()) {
                    return previousString;
                } else {
                    return n;
                }
            } catch (Exception e) {
            }
        } while (true);
    }

    public static int chooseOneOrZero(String msg) {
        int n;
        do {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n == 1 || n == 0) {
                    return n;
                } else {
                    System.out.println("Choose only either 0 or 1.");
                }
            } catch (Exception e) {
                System.out.println("Choose only either 0 or 1.");
            }
        } while (true);
    }
}
