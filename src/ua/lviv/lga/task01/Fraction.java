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
        return "\n Фракція   " + fractionName;
    }

    ArrayList<Deputy> deputat = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public void addDeputatToFraction() {
        int num = -1;
        Deputy d = new Deputy(0, 0);
        d.addDepyty();
        num = existDeputatInFraction(d.getSurname(), d.getName());
        System.out.println("додаємо " + d.getSurname() + d.getName());
        if (num < 0) {

            deputat.add(d);
            System.out.println("Депутат " + d + " успішно доданий до фракції");
        } else {
            System.out.println("Такий депутат " + d + " вже є у фракції. ");
            System.out.println("Спробуйте ввести іншого. ");

        }
    }


    /*Видалити депутата з фракції*/
    public void deleteDeputat() {
        System.out.println("Введіть прізвище депутата");
        String surname = sc.nextLine();
        System.out.println("Введіть im'я депутата");
        String name = sc.nextLine();
        int num = existDeputatInFraction(surname, name);

        if (num >= 0) {
            System.out.println(" \n Депутата  " + deputat.get(num).getSurname() + "\n успішно видалено із фракції. \n");
            deputat.remove(num);
        } else System.out.println("Такого депутата  немає");
        //  sc.close();

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

    /*Перевірка, чи є такий депутат у фракції*/
    public int existDeputatInFraction(String surname, String name) {
        int num = -1;
        for (int i = 0; i < deputat.size(); i++) {
            if (deputat.get(i).getSurname().equalsIgnoreCase(surname) && deputat.get(i).getName().equalsIgnoreCase(name)) {
                num = i;

            }
        }

        return num;
    }


}
