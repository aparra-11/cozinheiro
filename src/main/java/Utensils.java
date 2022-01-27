public class Utensils {
    private static String knife;
    private static String pan;

    public Utensils (String knife, String pan) {
        this.knife = knife;
        this.pan = pan;
    }

    public static String getKnife() {
        return knife;
    }

    public static String getPan() {
        return pan;
    }
}
