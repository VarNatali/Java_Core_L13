package ua.lviv.lga.task01;

import java.util.Scanner;

public class Deputy extends Human implements Comparable<Deputy> {
    private String surname;
    private String name;
    private int age;
    private boolean isGrafter;
    private int sum;

    public Deputy(int weighat, int height, String surname, String name, int age, boolean isGrafter) {
        super(weighat, height);
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.isGrafter = isGrafter;
    }

    Scanner sc = new Scanner(System.in);

    public void addDepyty() {
        String st;
        int num = 0;

        System.out.println("Введіть прізвище");
        st = sc.nextLine();
        this.setSurname(st);
        System.out.println("Введіть iм'я");
        this.setName(sc.nextLine());
        System.out.println("Введіть вік");
        num = sc.nextInt();
        while (num < 21) {
            System.out.println("Це занадто юний депутат");
            System.out.println("Введіть вік");
            num = sc.nextInt();
        }
        if (num > 21) {
            this.setAge(num);
            System.out.println("Введіть ріст");
            num = sc.nextInt();
            while (num < 100 || num > 200) {
                System.out.println("Це нереальний зріст");
                System.out.println("Введіть ріст");
                num = sc.nextInt();
            }
            this.setHeight(num);
            System.out.println("Чи бере депутат хабарі (y/n)");
            st = sc.next().toLowerCase();
            if (st.equals("y")) {
                this.setGrafter(true);
                giveGraft();
            } else this.setGrafter(false);


        }

        // sc.close();
    }

    public Deputy(int weighat, int height) {
        super(weighat, height);
    }

    public void giveGraft() {

        int sum = 0;
        if (!this.isGrafter) System.out.println("Цей дерпутат не бере хабаря");
        else {
            System.out.println("Введіть суму хабаря");
            sum = sc.nextInt();
            while (sum >= 5000) {
                System.out.println("Хабар завеликий. Поліція ув'язнить депутата");
                System.out.println("Введіть суму хабаря");
                sum = sc.nextInt();
            }
            if (sum < 5000) setSum(sum);
        }


    }


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isGrafter() {
        return isGrafter;
    }

    public int getSum() {
        return sum;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrafter(boolean grafter) {
        isGrafter = grafter;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "  " + surname + " " + name + ", " + age + "років ";
    }


    @Override
    public int compareTo(Deputy o) {
        return ((this.sum > o.getSum()) ? 1 : -1);
    }
}
