import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Kohtunik {
    public int kasutaja;
    public int vastane;

    public int[] viimane_käik;
    public ArrayList<int[]> mängu_mälu = new ArrayList<>();

    public Kohtunik() {
    }

    public void setKohtunik(int kasutaja, int vastane) {
        this.kasutaja = kasutaja;
        this.vastane = vastane;
        this.viimane_käik = new int[]{kasutaja, vastane, võitja(kasutaja, vastane)};
        mängu_mälu.add(viimane_käik);
        /* for (int i = 0; i < 3; i++) {
            System.out.print(viimane_käik[i] + " ");
        }
        System.out.println(); */
    }

    public int võitja(int k, int v) { // Massiivis skoor kujul [kasutaja võidud, viigid, masina võidud]
        if (Objects.equals(k, v)) {
            return 1; // viik
        }
        else if (Objects.equals(k - v, -1) || Objects.equals(k - v, 2)) {
            return 2; // masina võit
        }
        else if (Objects.equals(k - v, 1) || Objects.equals(k - v, -2)) {
            return 0; // kasutaja võit
        }
        else {
            System.out.println("Viga võitja arvutamises. kasutaja: " + k + ", masin: " + v + "Tagastan väärtuse viik");
            return 1;
        }
    }
}
