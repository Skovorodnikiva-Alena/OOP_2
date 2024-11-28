class Trousers extends Clothing implements MensClothing, WomensClothing {
    public Trousers(Size size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Мужчина одет в брюки: " + this);
    }
    @Override
    public void dressWoman() {
        System.out.println("Женщина одета в брюки: " + this);
    }

    @Override
    public void displayInfo() {
        System.out.println("Брюки: " + this);
    }
}