package shapes;

import colors.Color;

public abstract class Shape {

    private Color color = Color.TRANSPARENT;
    private double x;
    private double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    protected Shape() {
    }

    // Добавляем сеттеры для x и y
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getArea() {
        return 0.0;
    }

    public double getPerimeter() {
        return 0.0;
    }

    public void move(double moveX, double moveY) {
        // Реализация перемещения фигуры
        this.x += moveX;
        this.y += moveY;
    }

    public void draw() {
        System.out.println("Фигура: " + this.getClass().getSimpleName());
        System.out.println("Цвет: " + color);
        // Вывести координаты точек фигуры
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
    }
}

// Класс Точка
class Point extends Shape {

    private double x;
    private double y;

    // Конструктор без параметров
    public Point(double v, double v1) {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Конструктор со всеми параметрами
    public Point(double x, double y, Color color) {
        super(x, y);
        this.setColor(color);
    }

    // Getter для x
    public double getX() {
        return x;
    }

    // Setter для x
    public void setX(double x) {
        this.x = x;
    }

    // Getter для y
    public double getY() {
        return y;
    }

    // Setter для y
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getArea() {
        return 0.0; // Точка не имеет площади
    }

    @Override
    public double getPerimeter() {
        return 0.0; // Точка не имеет периметра
    }

    @Override
    public void draw() {
        System.out.println("Фигура: Точка");
        System.out.println("Цвет: " + getColor());
        System.out.println("Координаты: (" + x + ", " + y + ")");
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
    }
}

// Класс Прямоугольник
class Rectangle extends Shape {

    private Point point1;
    private Point point2;

    // Конструктор без параметров
    public Rectangle() {
        this.point1 = new Point(0.0, 0.0);
        this.point2 = new Point(0.0, 0.0);
    }

    // Конструктор со всеми параметрами
    public Rectangle(Point point1, Point point2, Color color) {
        super(point1.getX(), point1.getY()); // Инициализация координат в Shape
        this.point1 = point1;
        this.point2 = point2;
        this.setColor(color);
        validate();
    }

    // Getter для point1
    public Point getPoint1() {
        return point1;
    }

    // Setter для point1
    public void setPoint1(Point point1) {
        this.point1 = point1;
        super.setX(point1.getX());
        super.setY(point1.getY()); // Обновление координат в Shape
    }

    // Getter для point2
    public Point getPoint2() {
        return point2;
    }

    // Setter для point2
    public void setPoint2(Point point2) {
        this.point2 = point2;
        validate();
    }

    // Метод валидации точек
    private void validate() {
        if (point1.getX() == point2.getX() || point1.getY() == point2.getY()) {
            throw new IllegalArgumentException("Не удалось создать фигуру, т.к. точки х или y лежат на одной прямой");
        }
    }

    @Override
    public double getArea() {
        return Math.abs(point1.getX() - point2.getX()) * Math.abs(point1.getY() - point2.getY());
    }

    @Override
    public double getPerimeter() {
        return 2 * (Math.abs(point1.getX() - point2.getX()) + Math.abs(point1.getY() - point2.getY()));
    }

    @Override
    public void draw() {
        System.out.println("Фигура: Прямоугольник");
        System.out.println("Цвет: " + getColor());
        System.out.println("Точка 1: (" + point1.getX() + ", " + point1.getY() + ")");
        System.out.println("Точка 2: (" + point2.getX() + ", " + point2.getY() + ")");
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
    }

    @Override
    public void move(double moveX, double moveY) {
        super.move(moveX, moveY); // Перемещение точки 1
        point1.setX(point1.getX() + moveX);
        point1.setY(point1.getY() + moveY);
        point2.setX(point2.getX() + moveX);
        point2.setY(point2.getY() + moveY); // Перемещение точки 2
    }
}

// Класс Треугольник
class Triangle extends Shape {

    private Point point1;
    private Point point2;
    private Point point3;

    // Конструктор без параметров
    public Triangle() {
        this.point1 = new Point(0.0, 0.0);
        this.point2 = new Point(0.0, 0.0);
        this.point3 = new Point(0.0, 0.0);
    }

    // Конструктор со всеми параметрами
    public Triangle(Point point1, Point point2, Point point3, Color color) {
        super(point1.getX(), point1.getY()); // Инициализация координат в Shape
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.setColor(color);
        validate();
    }

    // Getter для point1
    public Point getPoint1() {
        return point1;
    }

    // Setter для point1
    public void setPoint1(Point point1) {
        this.point1 = point1;
        super.setX(point1.getX());
        super.setY(point1.getY()); // Обновление координат в Shape
    }

    // Getter для point2
    public Point getPoint2() {
        return point2;
    }

    // Setter для point2
    public void setPoint2(Point point2) {
        this.point2 = point2;
        validate();
    }

    // Getter для point3
    public Point getPoint3() {
        return point3;
    }

    // Setter для point3
    public void setPoint3(Point point3) {
        this.point3 = point3;
        validate();
    }

    // Метод валидации точек (проверка, что они не лежат на одной прямой)
    private void validate() {
        double slope12 = (point2.getY() - point1.getY()) / (point2.getX() - point1.getX());
        double slope13 = (point3.getY() - point1.getY()) / (point3.getX() - point1.getX());

        if (slope12 == slope13) {
            throw new IllegalArgumentException("Не удалось создать фигуру, т.к. все три точки лежат на одной прямой");
        }
    }

    @Override
    public double getArea() {
        // Формула Герона
        double a = getSideLength(point1, point2);
        double b = getSideLength(point2, point3);
        double c = getSideLength(point3, point1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(point1, point2) + getSideLength(point2, point3) + getSideLength(point3, point1);
    }

    @Override
    public void draw() {
        System.out.println("Фигура: Треугольник");
        System.out.println("Цвет: " + getColor());
        System.out.println("Точка 1: (" + point1.getX() + ", " + point1.getY() + ")");
        System.out.println("Точка 2: (" + point2.getX() + ", " + point2.getY() + ")");
        System.out.println("Точка 3: (" + point3.getX() + ", " + point3.getY() + ")");
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
    }

    @Override
    public void move(double moveX, double moveY) {
        super.move(moveX, moveY); // Перемещение точки 1
        point1.setX(point1.getX() + moveX);
        point1.setY(point1.getY() + moveY);
        point2.setX(point2.getX() + moveX);
        point2.setY(point2.getY() + moveY); // Перемещение точки 2
        point3.setX(point3.getX() + moveX);
        point3.setY(point3.getY() + moveY); // Перемещение точки 3
    }

    // Вспомогательный метод для расчета длины стороны
    private double getSideLength(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}

// Класс Круг
class Circle extends Shape {

    private Point center;
    private double radius;

    // Конструктор без параметров
    public Circle() {
        this.center = new Point(0.0, 0.0);
        this.radius = 0.0;
    }

    // Конструктор со всеми параметрами
    public Circle(Point center, double radius, Color color) {
        super(center.getX(), center.getY()); // Инициализация координат из точки
        this.center = center;
        this.radius = radius;
        this.setColor(color);
        validate();
    }

    // Getter для центра
    public Point getCenter() {
        return center;
    }

    // Setter для центра
    public void setCenter(Point center) {
        this.center = center;
        super.setX(center.getX());
        super.setY(center.getY()); // Обновление координат в Shape
    }

    // Getter для радиуса
    public double getRadius() {
        return radius;
    }

    // Setter для радиуса
    public void setRadius(double radius) {
        this.radius = radius;
        validate();
    }

    // Метод валидации радиуса
    private void validate() {
        if (radius <= 0) {
            throw new IllegalArgumentException("Не удалось создать фигуру, т.к. радиус не может быть меньше нуля");
        }
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Фигура: Круг");
        System.out.println("Цвет: " + getColor());
        System.out.println("Центр: (" + center.getX() + ", " + center.getY() + ")");
        System.out.println("Радиус: " + radius);
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
    }

    @Override
    public void move(double moveX, double moveY) {
        super.move(moveX, moveY); // Перемещение центра круга
        center.setX(center.getX() + moveX);
        center.setY(center.getY() + moveY); // Перемещение точки
    }
}