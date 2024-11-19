/**
 * Класс, представляющий двумерный вектор.
 */

class Vector {
    double x1=0;
    double y1=0;

    double x2=0;
    double y2=0;

    //конструктор с параметором
    /**
     * Конструктор с параметрами. Инициализирует вектор с заданными координатами.
     * @param x1 координата x начала вектора
     * @param y1 координата y начала вектора
     * @param x2 координата x конца вектора
     * @param y2 координата y конца вектора
     */
    public Vector(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    //конструктор без парарметров
    /**
     * Конструктор без параметров. Инициализирует вектор (0,0) - (0,0)
     */
    public Vector() {
        this(0,0,0,0); // Вызов конструктора с параметрами для удобства
    }

    //getters setters
    /**
     * Возвращает координату x начала вектора.
     * @return координата x начала вектора
     */
    public double getX1() {
        return x1;
    }

    /**
     * Устанавливает координату x начала вектора.
     * @param x1 координата x начала вектора
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }
    /**
     * Возвращает координату y начала вектора.
     * @return координата y начала вектора
     */
    public double getY1() {
        return y1;
    }

    /**
     * Устанавливает координату y начала вектора.
     * @param y1 координата y начала вектора
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }

    /**
     * Возвращает координату x конца вектора.
     * @return координата x конца вектора
     */
    public double getX2() {
        return x2;
    }

    /**
     * Устанавливает координату x конца вектора.
     * @param x2 координата x конца вектора
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }

    /**
     * Возвращает координату y конца вектора.
     * @return координата y конца вектора
     */
    public double getY2() {
        return y2;
    }

    /**
     * Устанавливает координату y конца вектора.
     * @param y2 координата y конца вектора
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }

    //метод для нахождения векторного произведения
    /**
     * Вычисляет векторное произведение текущего вектора и другого вектора.
     * @param other другой вектор
     * @return векторное произведение
     */
    public double vectorProduct(Vector other) {
        double dx1 = this.x2 - this.x1;
        double dy1 = this.y2 - this.y1;
        double dx2 = other.x2 - other.x1;
        double dy2 = other.y2 - other.y1;
        return dx1 * dy2 - dy1 * dx2;
    }

    //метод для нахождения скалярного произведения
    /**
     * Вычисляет скалярное произведение текущего вектора и другого вектора.
     * @param other другой вектор
     * @return скалярное произведение
     */
    public double scalarProduct(Vector other) {
        double dx1 = this.x2 - this.x1;
        double dy1 = this.y2 - this.y1;
        double dx2 = other.x2 - other.x1;
        double dy2 = other.y2 - other.y1;
        return dx1 * dx2 + dy1 * dy2;
    }

    //метод для нахождения длины векторов
    /**
     * Вычисляет длину текущего вектора.
     * @return длина вектора
     */
    public double length() {
        double dx = this.x2 - this.x1;
        double dy = this.y2 - this.y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    //метод для умножения векторов на число
    /**
     * Умножает текущий вектор на число.
     * @param scalar число, на которое нужно умножить вектор
     * @return новый вектор, являющийся результатом умножения
     */
    public Vector multiply(double scalar) {
        return new Vector(x1, y1, x1 + scalar * (x2 - x1), y1 + scalar * (y2 - y1));
    }

    //метод для нахождения суммы векторов
    /**
     * Находит сумму текущего вектора и другого вектора.
     * @param other другой вектор
     * @return новый вектор, являющийся суммой векторов
     */
    public Vector add(Vector other) {
        return new Vector(this.x1, this.y1, this.x1 + other.x2 - other.x1, this.y1 + other.y2 - other.y1);
    }

    //метод для нахождения разности векторов
    /**
     * Находит разность текущего вектора и другого вектора.
     * @param other другой вектор
     * @return новый вектор, являющийся разностью векторов
     */
    public Vector subtract(Vector other) {
        return new Vector(this.x1, this.y1, this.x1 - (other.x2 - other.x1), this.y1 - (other.y2 - other.y1));
    }

    public static void main(String[] args) {
        //создать объект класса, вызвав конструктор с параметрами
        Vector vector1 = new Vector(1, 2, 4, 6);
        //создать объект класса, вызвав конструктор без параметров
        Vector vector2 = new Vector();
        //вызвать каждый из методов
        System.out.println("Векторное произведение: " + vector1.vectorProduct(vector2));
        System.out.println("Скалярное произведение: " + vector1.scalarProduct(vector2));
        System.out.println("Длина vector1: " + vector1.length());
        System.out.println("Умножение vector1 на 2: " + vector1.multiply(2));
        System.out.println("Сумма vector1 и vector2: " + vector1.add(vector2));
        System.out.println("Разность vector1 и vector2: " + vector1.subtract(vector2));
    }
}