import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
public class Main {
    public static void main(String[] args) {
        // Установка кодировки консоли в UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Clothing[] clothes = {
                new TShirt(Size.M, 1000, "синий"),
                new Trousers(Size.L, 2000, "черный"),
                new Skirt(Size.S, 1500, "красный"),
                new Tie(Size.M, 500, "бордовый")
        };

        Atelier atelier = new Atelier();
        atelier.dressWoman(clothes);
        atelier.dressMan(clothes);
    }
}