class Tie extends Clothing implements MensClothing {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина одет в галстук: " + this);
    }

    @Override
    public void displayInfo() {
        System.out.println("Галстук: " + this);
    }
}
