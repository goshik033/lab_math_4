import java.util.ArrayList;
import java.util.Scanner;

public class Printer {
    public void go() {
        IFunction f1 = new FirstFunction();
        IFunction f2 = new SecondFunction();
        Scanner in = new Scanner(System.in);
        Menu.printMenu();
        String userInput = in.nextLine().trim();
        Execution execute = new Execution();
        while (!userInput.equals("0")) {

            if (userInput.equals("1")) {
                Menu.printFirstMenu();
                String userSecInput = in.nextLine().trim();

                if (userSecInput.equals("1")) {
                    execute.execute1(f1, 5);
                }
                if (userSecInput.equals("2")) {
                    execute.execute2(f1);
                }
                if (userSecInput.equals("3")) {
                    execute.execute3(f1);
                }
                if (userSecInput.equals("4")) {
                    ArrayList<Point<Double>> pointValues;
                    System.out.println("Данные для sin(x):");
                    pointValues = new ArrayList<>();
                    pointValues.add(new Point<>(0.0, 0.05));
                    pointValues.add(new Point<>(0.5, 0.37));
                    pointValues.add(new Point<>(1.0, 0.94));
                    pointValues.add(new Point<>(1.5, 1.0));
                    pointValues.add(new Point<>(2.0, 0.85));
                    pointValues.add(new Point<>(2.5, 0.5));
                    pointValues.add(new Point<>(4.0, -0.75));
                    for (Point<Double> point : pointValues) {
                        System.out.println("(" + point.getX() + "," + point.getY() + ")");
                    }
                    execute.solve(pointValues, f1);
                }
            }
            if (userInput.equals("2")) {
                Menu.printSecMenu();
                String userSecInput = in.nextLine().trim();

                if (userSecInput.equals("1")) {
                    execute.execute1(f2, 5);
                }

                if (userSecInput.equals("2")) {
                    execute.execute2(f2);
                }
                if (userSecInput.equals("3")) {
                    execute.execute3(f2);
                }
                if (userSecInput.equals("4")) {
                    ArrayList<Point<Double>> pointValues;
                    System.out.println("Данные для 34:");
                    pointValues = new ArrayList<>();
                    pointValues.add(new Point<>(1.0, 4.0));
                    pointValues.add(new Point<>(2.0, 6.0));
                    pointValues.add(new Point<>(0.0, 0.0));
                    pointValues.add(new Point<>(-1.0, -3.0));
                    pointValues.add(new Point<>(3.0, 10.0));
                    pointValues.add(new Point<>(-2.0, -5.0));
                    pointValues.add(new Point<>(-3.0, -9.0));
                    for (Point<Double> point : pointValues) {
                        System.out.println("(" + point.getX() + "," + point.getY() + ")");
                    }
                    execute.solve(pointValues, f2);
                }
            }
            Menu.printMenu();
            userInput = in.nextLine().trim();
        }

    }

}
