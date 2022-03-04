package ro.tuc.pt.model;

public class Monomial {

    private int power;
    private int coefficient;

    public Monomial(int power, int coefficient) {
        this.power = power;
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void displayMonomial() {
        if (coefficient > 0)
            System.out.print("+" + coefficient + "x^" + power + " ");
        else if (coefficient < 0)
            System.out.print(coefficient + "x^" + power + " ");
        else
            System.out.print("+" + 0 + " ");
    }

    public String getMonomialString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (coefficient != 0)
            return stringBuilder.append("+ ").append(coefficient).append("x^").append(power).append(" ").toString();
        else
            return "";
    }

    public String getIntMonomString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (coefficient != 0)
            return stringBuilder.append("+ ").append((int)coefficient).append("x^").append(power).append(" ").toString();
        else
            return "";
    }
}
