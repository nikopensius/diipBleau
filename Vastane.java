import java.util.Arrays;
import java.util.Objects;

import static java.lang.Integer.*;

public class Vastane {
    private int[] viimane_käik = new int[2]; // massiiv viimane_käik täidetakse setVastasega,
    // kui mängus on varasemalt toimunud juba vähemalt üks käik,
    // viimase käigu 3kohaline massiiv moodustatakse kohtunik-arvepidaja klassis
/* valikud {kivi, paber, käärid} avalduvad programmis enamasti kujul {1, 2, 3},
massiivis vastase_mälu märgib valikut indeksinumber {0, 1, 2} (vastase mälu ehk mälu, mis talletab kasutaja varasemaid käike)
 */
    public int[][] käigu_mälu = new int[10][2]; // viimase 10 käigu tulemused kujul [[kasutaja valik, masina valik], ...]
    public int[] vastase_mälu = new int[3]; // kasutaja käikude statistika [kivi arv, paberi arv, kääride arv]






    /* masin otsustab, millist käiku teha kas:
    juhuslikult
    meenutades varasemaid käike (kas selline käik on juba olnud? mis pärast seda juhtus?)
    pidades arvet kasutaja käikude üle (mis on kasutaja üldine meeliskäik?)
     */
    public static int juhuslik() {
        return (int) (Math.random() * 3 + 1);
    }

    private int käigu_otsus(int hävitusele_kuuluv) { // atomaarne otsustamismeetod, f(x) = y, kus y hävitab x-i
        if (Objects.equals(hävitusele_kuuluv, 1)) { // kui arvame, et vastane käib järgmisena kivi
            return 2;                                   // siis käime paberi
        } else if (Objects.equals(hävitusele_kuuluv, 2)) { // jne
            return 3;
        } else if (Objects.equals(hävitusele_kuuluv, 3)) {
            return 1;
        } else return 0;
    }

    private int käigu_mälu_analüüs(int[] viimane, int[][] mälu) { // tagastan käigu, mille masin teeb järgmisena
        for (int i = 0; i < mälu.length - 1; i++) {
            if (Arrays.equals(mälu[i], viimane)) { // kui varasemalt on toimunud samasugune käik, nagu just praegu toimus
                int kasutaja_järgmine = mälu[i + 1][0]; // siis oletame, et vastase järgmine käik on ka sama nagu eelmisel korral
                return käigu_otsus(kasutaja_järgmine); // (f(x) = y)

            }
        }
        return 0; // kui ei leita ühtegi varasemat samasugust käiku ehk järgmist käiku ei saa analüütiliselt tuletada
    }

    private int vastase_mälu_analüüs(int[] sagedused) {
        int suurim = 0; // millist valikut esineb kõige sagedamini, talletame siia
        int kasutaja_järgmine = 0;

        for (int i = 0; i <= 2; i++) {
            if (sagedused[i] > suurim) {
                kasutaja_järgmine = i + 1;
                suurim = sagedused[i];
            }
        }
        if (kasutaja_järgmine > 0) {
            return käigu_otsus(kasutaja_järgmine); // (f(x) = y)
        } else return 0;
    }






    public int valik() {
        if (käigu_mälu_analüüs(viimane_käik, käigu_mälu) > 0) {
            // System.out.print("käigumälu   ");
            return käigu_mälu_analüüs(viimane_käik, käigu_mälu);
        }
        else if (vastase_mälu_analüüs(vastase_mälu) > 0) {
            // System.out.print("vastasemälu ");
            return vastase_mälu_analüüs(vastase_mälu);
        }
        else {
            // System.out.print("juhuslik ");
            return juhuslik();
        }
    }

    public Vastane() {
    }

    public void setVastane(int[] viimane_käik) {
        for (int i = 0; i < 2; i++) { // parameeter on 3kohaline massiiv, kus 3ndal kohal on võitja tähis - seda pole masinal vaja teada
            this.viimane_käik[i] = viimane_käik[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                this.käigu_mälu[i][j] = this.käigu_mälu[i + 1][j];
            }

        }
        this.käigu_mälu[9][0] = viimane_käik[0]; // kasutaja käigu talletamine
        this.käigu_mälu[9][1] = viimane_käik[1]; // masina käigu talletamine

        if (viimane_käik[0] > 0) {
        int kasutajaValik_indeksiks = viimane_käik[0] - 1; // f: {1, 2, 3} -> {0, 1, 2}
        this.vastase_mälu[kasutajaValik_indeksiks]++;} // kasutaja käigu talletamine statistikaks, vaata rida 5
        /* for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++){
            System.out.print(käigu_mälu[i][j]);}
            System.out.print(" ");
        }
        System.out.println();*/
    }
}
