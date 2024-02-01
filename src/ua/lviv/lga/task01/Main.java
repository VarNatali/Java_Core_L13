package ua.lviv.lga.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println();
        System.out.println(" Введіть 0 : завершити");
        System.out.println("Введіть 1 :  додати фракцію");
        System.out.println("Введіть 2 :  видалити конкретну фракцію");
        System.out.println("Введіть 3 :  вивести усі  фракції");
        System.out.println("Введіть 4 :  очистити конкретну фракцію");
        System.out.println("Введіть 5 :  вивести конкретну фракцію");
        System.out.println("Введіть 6 :  додати депутата в фракцію");
        System.out.println("Введіть 7 :  видалити депутата з фракції");
        System.out.println("Введіть 8 :  вивести список хабарників");
        System.out.println("Введіть 9 :  вивести найбільшого хабарника");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isWork = true;

        while (isWork) {

            menu();

            switch (sc.next()) {
                case "0":
                    isWork = false;
                    break;

                case "1":
                    VerkhovnaRada.VERKHOVNARADA.addFraction();

                    break;

                case "2":
                    VerkhovnaRada.VERKHOVNARADA.deleteFraction();

                    break;

                case "3":
                    VerkhovnaRada.VERKHOVNARADA.schowAllFraction();
                    break;

                case "4":
                    VerkhovnaRada.VERKHOVNARADA.clearСoncreteFraction();
                    break;
                case "5":
                    VerkhovnaRada.VERKHOVNARADA.schowСoncreteFraction();
                    break;

                case "6":
                    VerkhovnaRada.VERKHOVNARADA.addDeputatToFraction();
                    break;
                case "7":
                    VerkhovnaRada.VERKHOVNARADA.deleteDeputatFromFraction();
                    break;

                case "8":
                    VerkhovnaRada.VERKHOVNARADA.schowAllGrafterOfFraction();
                    break;
                case "9":
                    VerkhovnaRada.VERKHOVNARADA.schowBiggestGrafterOfFraction();
                    break;

            }

        }
    }
}
