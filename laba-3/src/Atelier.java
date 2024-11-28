class Atelier {
    public void dressWoman(Clothing[] clothes) {
        System.out.println("\nЖенская одежда:");
        for (Clothing c : clothes) {
            if (c instanceof WomensClothing) {
                ((WomensClothing) c).dressWoman();
            }
        }
    }

    public void dressMan(Clothing[] clothes) {
        System.out.println("\nМужская одежда:");
        for (Clothing c : clothes) {
            if (c instanceof MensClothing) {
                ((MensClothing) c).dressMan();
            }
        }
    }
}
