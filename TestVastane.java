public class TestVastane {

    public static void main(String[] args) {
        Vastane vastane = new Vastane();
        int[] jou = new int[3];

        for(int i = 0; i <= 20; i++) {
            jou[0] = (int) (Math.random() * 3 + 1);
            jou[1] = vastane.valik();
            vastane.setVastane(jou);
        }

    }
}
