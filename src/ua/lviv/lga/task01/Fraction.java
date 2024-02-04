package ua.lviv.lga.task01;

import java.util.*;

public class Fraction {
    private String fractionName;

    public Fraction() {

    }

    public String getFractionName() {
        return fractionName;
    }

    public void setFractionName(String fractionName) {
        this.fractionName = fractionName;
    }

    @Override
    public String toString() {
        return "\n Fraction:  " + fractionName;
    }

    ArrayList<Deputy> deputat = new ArrayList();

    public void addDeputat() {
        String st;
        int num = 0;
        Scanner sc = new Scanner(System.in);
        Deputy d = new Deputy(0, 0);
        System.out.println("Введіть прізвище");
        st = sc.nextLine();
        d.setSurname(st);
        System.out.println("Введіть iм'я");
        d.setName(sc.nextLine());
        System.out.println("Введіть вік");
        num = sc.nextInt();
        if (num < 21) System.out.println("Це занадто юний депутат");
        else {
            d.setAge(num);
            System.out.println("Введіть ріст");
            num = sc.nextInt();
            if (num < 100 || num > 200) {
                System.out.println("Це нереальний зріст");
            } else {
                d.setHeight(num);
                System.out.println("Чи бере депутат хабарі (y/no)");
                st = sc.next().toLowerCase();
                if (st.equals("y")) {
                    d.setGrafter(true);
                    d.giveGraft();
                } else d.setGrafter(false);

                deputat.add(d);
                System.out.println("Депутата " + d + " успішно зараховано до фракції");
            }
        }
        sc.close();
    }


    /*Видалити депутата з фракції*/
    public void deleteDeputat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть прізвище ");
        String surname = sc.nextLine();
        int num = existDeputat(surname);

        if (num >= 0) {
            System.out.println(" \n" + deputat.get(num).getSurname() + "\n успішно видалено. \n");
            deputat.remove(num);
        }
        sc.close();

    }

    /*Показати всіх хабарників*/
    public void schowGrafter() {

        for (int i = 0; i < deputat.size(); i++) {
            if (deputat.get(i).isGrafter()) System.out.println(deputat.get(i));
        }

    }


    /*Вивести всіх депутатів фракції*/
    public void schowAllDeputat() {
        for (int i = 0; i < deputat.size(); i++) {
            System.out.println(deputat.get(i));
        }
    }

    /*Видалити всіх депутатів фракції*/
    public void clearAllDeputat() {

        deputat.removeAll(deputat);

        if (deputat.size() == 0) System.out.println("У цій фракції більше немає депутатів");

    }

    /*Відсортувати за розміром хабаря і вивести найбільшого хапугу*/
    public void theGrateGrafter() {
        Collections.sort(deputat);

        System.out.println("Найбільший хабарник у фракції " + deputat.getLast().getSurname() + "  Він бере не менше " + deputat.getLast().getSum() + "$  за голос");

    }

    /*Перевірка, чи є депутат у фракції*/
    public int existDeputat(String surname) {
        int num = -1;
        for (int i = 0; i < deputat.size(); i++) {
            if (deputat.get(i).getSurname().equalsIgnoreCase(surname)) {
                num = i;
            }
        }
        if (num < 0) System.out.println("Депутата з таким прізвищем не знайдено");
        return num;
    }


}
