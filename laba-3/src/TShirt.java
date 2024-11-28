class TShirt extends Clothing implements MensClothing, WomensClothing {
    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Мужчина одет в футболку: " + this);
    }
    @Override
    public void dressWoman() {
        System.out.println("Женщина одета в футболку: " + this);
    }

    @Override
    public void displayInfo() {
        System.out.println("Футболка: " + this);
    }
}
