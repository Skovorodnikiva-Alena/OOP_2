class Skirt extends Clothing implements WomensClothing {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женщина одета в юбку: " + this);
    }

    @Override
    public void displayInfo() {
        System.out.println("Юбка: " + this);
    }
}
