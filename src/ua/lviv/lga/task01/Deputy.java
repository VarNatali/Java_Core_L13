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

    public Deputy(int weighat, int height) {
        super(weighat, height);
    }

    public void giveGraft() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        if (!this.isGrafter) System.out.println("Цей дерпутат не бере хабаря");
        else {
            System.out.println("Введіть суму хабаря");
            sc = new Scanner(System.in);
            sum = sc.nextInt();
            if (sum > 5000) System.out.println("Хабар завеликий. Поліція ув'язнить депутата");
            else setSum(sum);
        }
        sc.close();

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
        return " surname " + surname + ", name  " + name + ", age  " + age + ", sum =" + sum;
    }


    @Override
    public int compareTo(Deputy o) {
        return ((this.sum > o.getSum()) ? 1 : -1);
    }
}
