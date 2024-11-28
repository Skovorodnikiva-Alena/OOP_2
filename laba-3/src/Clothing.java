abstract class Clothing {
    Size size;
    double price;
    String color;

    public Clothing(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String getSizeDescription(){
        return size.getDescription();
    }

    public int getEuroSize(){
        return size.getEuroSize();
    }

    @Override
    public String toString() {
        return "Размер: " + size + " (" + size.getEuroSize() + "), Цена: " + price + " руб., Цвет: " + color;
    }

    public abstract void displayInfo();

}
