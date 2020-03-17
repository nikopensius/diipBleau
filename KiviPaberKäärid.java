import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.*;

public class KiviPaberKäärid {
    static int[] skoor = new int[3];

    public static String s(int x) { // tõlgib numbrid 'kiviks', 'kääriks' või 'paberiks'
        if (Objects.equals(x, 1)) {
            return "kivi";
        }
        else if (Objects.equals(x, 2)) {
            return "paberi";
        }
        else if (Objects.equals(x, 3)) {
            return "käärid";
        }
        else {
            String tagastis = String.format("vigane sisend %s", x);
            return tagastis;
        }
    }

    public static String ss(int x) { // tõlgib numbri stringiks "kasutaja", "masin", "sport" võitis
        if (Objects.equals(x, 0)) {
            return "Kasutaja";
        }
        else if (Objects.equals(x, 1)) {
            return "Sport";
        }
        else if (Objects.equals(x, 2)) {
            return "Masin";
        }
        else {
            String tagastis = String.format("vigane sisend %s", x);
            return tagastis;
        }
    }

    public static void main(String[] args) {

        Vastane masin = new Vastane();
        Kohtunik kohtunik = new Kohtunik();
        Scanner in = new Scanner(System.in);

        System.out.println("Kui soovid vaadata hetkeseisu kujul 'kasutaja võidud, viigid, masina võidud', trüki väiketähtedega 'skoor'. \nEsmalt aga palun, mitu mängu soovid mängida? Palun vastata numbriga: ");
        int mängude_arv = parseInt(in.nextLine());
        System.out.println("Uue käigu alustamiseks trüki oma valik numbrina - 1 ehk kivi, 2 ehk paber, 3 ehk käärid - ja vajuta ENTER");

        for (int i = 0; i < mängude_arv; i++) {

            String k_valikStr = in.nextLine();
            if (Objects.equals(k_valikStr, "skoor")) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(skoor[j] + " ");
                }
                System.out.println();
                i--;
            }
            else {
                int k_valik = parseInt(k_valikStr);
                int v_valik = masin.valik();
                kohtunik.setKohtunik(k_valik, v_valik); // kohtunik täiendab oma mälu ja selgitab võitja

                System.out.println("Kasutaja käis " + s(k_valik) + ", masin käis " + s(v_valik) + ". " + ss(kohtunik.viimane_käik[2]) + " võitis.");
                masin.setVastane(kohtunik.viimane_käik);

                skoor[kohtunik.viimane_käik[2]]++; //viimane_käik[2] tähistab kes võitis - 0 ehk kasutaja, 1 ehk viik, 2 ehk masin
                                                    //massiivis skoor kasvab vastava indeksiga elemendi väärtus ühe võrra
            }

        }
        StringBuilder lõpuseis = new StringBuilder("Lõpuseisuga on ");
        lõpuseis.append("kasutajal võite ").append(skoor[0]);
        lõpuseis.append(", masinal võite ").append(skoor[2]);
        lõpuseis.append(", viike ").append(skoor[1]);
        System.out.println(lõpuseis);
    }
}
