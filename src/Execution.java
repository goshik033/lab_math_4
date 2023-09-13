import java.util.*;

public class Execution {
    Scanner in= new Scanner(System.in);

    public void execute1(IFunction f, int n) {
        ArrayList<Point<Double>> pointValues = new ArrayList<>();
        double step = Math.PI  / (n - 1);
        for (int i = 0; i < n; i++) {
            double xValue = i * step;
            double yValue = f.solve(xValue);
            Point<Double> values = new Point<>(xValue, yValue);
            pointValues.add(values);
        }
        System.out.println("Готовые данные: ");
        for (Point<Double> pointValue : pointValues) {
            System.out.println("( " + pointValue.getX() + ", " + pointValue.getY() + " )");
        }
        solve(pointValues, f);
    }

    public void execute2(IFunction f) {
        ArrayList<Point<Double>> pointValues = new ArrayList<>();
        System.out.println("Введите количество точек:");
        Integer steps = Data.inputIntData();
        while(steps<1){
            System.out.println("Неверный количество точек, введите еще раз");
            steps = Data.inputIntData();
        }
        System.out.println("Вводите данные через запятую");
        System.out.println("Пример:\n1,2\n2,3\n4,5");
        for (int i = 0; i < steps; i++) {
            String str = in.nextLine().trim();
            double xValue = Double.parseDouble(str.split(",")[0]);
            double yValue = Double.parseDouble(str.split(",")[1]);
            Point<Double> values = new Point<>(xValue, yValue);
            pointValues.add(values);
        }
        System.out.println("Полученные данные:");
        for (Point point : pointValues) {
            System.out.println("(" + point.getX() + "," + point.getY() + ")");
        }
        solve(pointValues, f);
    }

    public void execute3(IFunction f) {
        ArrayList<Point<Double>> pointValues = new ArrayList<>();
        double left, right;
        System.out.println("Введите границы через запятую");
        System.out.println("Пример для промежутка от -2 до 2:\n-2,2");
        System.out.println("Введите данные:");
        String str= in.nextLine().trim();
        left = Double.parseDouble(str.split(",")[0]);
        right = Double.parseDouble(str.split(",")[1]);
        if (right < left) {
            Double t = right;
            right = left;
            left = t;
        }
        Double sep = right - left;
        System.out.println("Введите количество точек:");
        Integer steps = Data.inputIntData();
        for (double i = left; i < right; i += sep / steps) {
            pointValues.add(new Point(i, f.solve(i)));
        }
        System.out.println("Полученные данные:");
        for (Point point : pointValues) {
            System.out.println("(" + point.getX() + "," + point.getY() + ")");
        }
        solve(pointValues, f);

    }

    public void solve(ArrayList<Point<Double>> pointValues, IFunction func) {
        Data data = new Data();
        System.out.println("Введите точку, в которой нужно вычислить значение функции");
        double x = data.inputData();
        NewtonInterpolation Newtoninterpolation = new NewtonInterpolation(pointValues);
        double y = Newtoninterpolation.interpolate(x);
        System.out.println("f(" + x + ") = " + func.solve(x));
        System.out.println("Interpolated value: " + y);

        Map<String, ArrayList<IFunction>> map_func = new HashMap<>();
        Map<String, ArrayList<Point<Double>>> point_func = new HashMap<>();
        ArrayList<IFunction> funcs = new ArrayList<>();
        funcs.add(func);
        map_func.put("График функции", funcs);


        point_func.put("Точки исходных данных", pointValues);


        ArrayList<Point<Double>> point = new ArrayList<>();
        point.add(new Point<>(x, y));
        point_func.put("Точка Интерполяции", point);

        ArrayList<Point<Double>> iinterpolation = Newtoninterpolation.interpolation(pointValues, 2);
        point_func.put("Точки Интерполяции внутри", iinterpolation);

        ArrayList<Point<Double>> extrapolation = Newtoninterpolation.extrapolation(pointValues);
        point_func.put("Точки вне исходных данных", extrapolation);

        new GraphModule(map_func, point_func);


    }
}
