

import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private double eps;
    private double a;
    private double b;

    public Double inputData() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String str = in.nextLine();
                double num = Double.parseDouble(str);
                return num;
            } catch (NumberFormatException wrongForm) {
                System.out.println("Неверный формат, попробуйте еще раз");

            }
        }
    }

    //    public static ArrayList<Point<Double>> inputPointsData(int steps) {
//        ArrayList<Point<Double>> pointValues = new ArrayList<>();
//        while (true) {
//            try {
//                for (int i = 0; i < steps; i++) {
//                    String str = inputSizeData();
//                    double xValue = Double.parseDouble(str.split(",")[0]);
//                    double yValue = Double.parseDouble(str.split(",")[1]);
//                    Point<Double> values = new Point<>(xValue, yValue);
//                    pointValues.add(values);
//                }
//                return pointValues;
//            } catch (NumberFormatException | ArrayIndexOutOfBoundsException n) {
//                System.out.println("Неверный формат, введите строку заново");
//
//            }
//        }
//    }
    public static Integer inputIntData() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String str = in.nextLine();
                int num = Integer.parseInt(str);
                return num;
            } catch (NumberFormatException wrongForm) {
                System.out.println("Неверный формат, попробуйте еще раз");

            }
        }
    }
//    public static String inputSizeData() {
//        Scanner in = new Scanner(System.in);
//        while (true) {
//            try {
//                String str = in.nextLine().trim();
//                double num1 = Double.parseDouble(str.split(",")[0]);
//                double num2 = Double.parseDouble(str.split(",")[1]);
//                return str;
//            } catch (NumberFormatException wrongForm) {
//                System.out.println("Неверный формат, попробуйте еще раз");
//
//            }
//        }
//    }


    public double getEps() {
        return eps;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
