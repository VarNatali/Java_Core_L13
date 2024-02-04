package ua.lviv.lga.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VerkhovnaRada {
    public static final VerkhovnaRada VERKHOVNARADA = new VerkhovnaRada();

    private VerkhovnaRada() {
    }

    List<Fraction> fractia = new ArrayList<Fraction>();

    public void addFraction() {
        String name = getString();
        Fraction fr = new Fraction();

        int num = getNum(name);
        if (num == -1) {
            fr.setFractionName(name);
            fractia.add(fr);
            System.out.println("Фракцію додано. ");
        } else System.out.println("Така фракція вже є, введіть іншу назву. ");

    }

    public void deleteFraction() {

        String name = getString();
        int num = getNum(name);

        if (num != -1) {
            System.out.println("Фракцію успішно видалено.");
            fractia.remove(num);

        }
    }

    /*перевірка на наявність фракції і  повертає її номер*/
    private int getNum(String name) {
        int num = -1;
        for (int i = 0; i < fractia.size(); i++) {
            if (fractia.get(i).getFractionName().equalsIgnoreCase(name)) {
                num = i;
            }
        }
        if (num == -1) {
            System.out.println("Такої фракції ще немає.");
        }
        return num;
    }

    /*input fraction*/
    private static String getString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть назву фракції");
        String name = sc.nextLine();
        return name;
    }


    public void schowAllFraction() {
        if (fractia.size() != 0) System.out.println(VerkhovnaRada.VERKHOVNARADA.fractia);

        else System.out.println("Ця Верховна рада не має жодної фракції");

    }

    public void clearСoncreteFraction() {
        String name = getString();
        int num = getNum(name);

        if (num != -1) {
            int count = fractia.get(num).deputat.size();
            if (count == 0) System.out.println("Ця фракція не має депутатів ");
            else fractia.get(num).clearAllDeputat();
        }
    }

    public void schowСoncreteFraction() {
        String name = getString();
        int num = getNum(name);
        if (num != -1) {
            int count = fractia.get(num).deputat.size();
            if (count == 0) System.out.println("Ця фракція не має жодного депутата ");
            else {
                fractia.get(num).schowAllDeputat();
            }
        }
    }

    public void addDeputatToFraction() {
        String name = getString();
        int num = getNum(name);
        if (num != -1) {
            fractia.get(num).addDeputat();
        }

    }

    public void deleteDeputatFromFraction() {
        String name = getString();
        int num = getNum(name);
        if (num != -1) {
            fractia.get(num).deleteDeputat();
        }

    }

    public void schowAllGrafterOfFraction() {
        String name = getString();
        int num = getNum(name);
        System.out.println("Хабарники фракції: " + fractia.get(num).getFractionName());
        fractia.get(num).schowGrafter();

    }

    public void schowBiggestGrafterOfFraction() {
        String name = getString();
        int num = getNum(name);

        if (num != -1) {
            fractia.get(num).theGrateGrafter();
        }

    }

}


