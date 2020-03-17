import java.util.Arrays;

public class Mälukas {


        private static int käigu_mälu_analüüs(int[] viimane, int[][] mälu) { // tagastan käigu, mille masin teeb järgmisena
            for (int i = 0; i < mälu.length - 1; i++) {

                if (Arrays.equals(mälu[i], viimane)) { // kui varasemalt on toimunud samasugune käik, nagu just praegu toimus
                    int kasutaja_järgmine = mälu[i + 1][0]; // siis oletame, et vastase järgmine käik on ka sama nagu eelmisel korral
                    System.out.println(kasutaja_järgmine);
                    return kasutaja_järgmine;
                }
            }
            System.out.println("ei leidnud");
            return 0; // kui ei leita ühtegi varasemat samasugust käiku ehk järgmist käiku ei saa analüütiliselt tuletada
        }

    public static void main(String[] args) {
        int[] viimane = {1, 2};
        int[][] mälu = {{1, 2}, {3, 4}};
        käigu_mälu_analüüs(viimane, mälu);
    }
}
