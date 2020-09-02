public class Watermelon {
    public String watermelon(int n) {
        String waterMelonPattern = "";
        for(int i = 1; i <= n; i++) {
            if (i % 2 != 0)
                waterMelonPattern = waterMelonPattern + "수";
            else
                waterMelonPattern = waterMelonPattern + "박";
        }
        return waterMelonPattern;
    }

    public static void main(String[] args) {
        Watermelon wm = new Watermelon();
        System.out.println("when n is 3 : " + wm.watermelon(3));
    }
}