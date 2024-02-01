package ua.lviv.lga.task01;

public class Human {
    private int weighat;
    private int height;

    public Human(int weighat, int height) {
        this.weighat = weighat;
        this.height = height;
    }

    public int getWeighat() {
        return weighat;
    }

    public int getHeight() {
        return height;
    }

    public void setWeighat(int weighat) {
        this.weighat = weighat;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Human{" +
                "weighat=" + weighat +
                ", height=" + height +
                '}';
    }
}
