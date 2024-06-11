package DSA_Java;

public class Main {
    public static void main(String[] args) {


        var text = new Tries();

        text.insert("MAN");
        text.insert("MAT");
        text.insert("MAP");
        text.insert("MALL");
        text.insert("MOON");
        System.out.println(text.findWords("MAL"));

    }
} 
