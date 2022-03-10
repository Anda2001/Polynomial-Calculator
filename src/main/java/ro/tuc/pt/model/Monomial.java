package ro.tuc.pt.model;

public class Monomial {

    private int power;
    private double coefficient;

    public Monomial() {
        this.power = 0;
        this.coefficient = 0;
    }

    public Monomial(int power, double coefficient) {
        this.power = power;
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String getMonomialString() {
        StringBuilder monomialString = new StringBuilder();

        if (coefficient != 0) {
            if (power == 0) {
                if (coefficient < 0) {
                    return monomialString.append(coefficient).append(" ").toString();
                } else {
                    return monomialString.append("+ ").append(coefficient).append(" ").toString();
                }
            } else if (power == 1) {
                if (coefficient < 0) {
                    if(coefficient==-1){
                        return  monomialString.append("-").append("x").append(" ").toString();
                    }
                    return monomialString.append(coefficient).append("x").append(" ").toString();
                } else if (coefficient == 1) {
                    return monomialString.append("+ ").append("x").append(" ").toString();
                } else {
                    return monomialString.append("+ ").append(coefficient).append("x").append(" ").toString();
                }
            } else { //power>1
                if (coefficient < 0) {
                    if(coefficient==-1){
                        return  monomialString.append("-").append("x^").append(power).append(" ").toString();
                    }
                    return monomialString.append(coefficient).append("x^").append(power).append(" ").toString();
                } else if (coefficient == 1) {
                    return monomialString.append("+ ").append("x^").append(power).append(" ").toString();
                } else {
                    return monomialString.append("+ ").append(coefficient).append("x^").append(power).append(" ").toString();
                }
            }
        } else {
            return "";
        }
    }

    public String getIntMonomialString() {
        StringBuilder monomialString = new StringBuilder();

        if (coefficient != 0) {
            if (power == 0) {
                if (coefficient < 0) {
                    return monomialString.append((int) coefficient).append(" ").toString();
                } else {
                    return monomialString.append("+ ").append((int) coefficient).append(" ").toString();
                }
            } else if (power == 1) {
                if (coefficient < 0) {
                    if(coefficient==-1){
                        return  monomialString.append("-").append("x").append(" ").toString();
                    }
                    return monomialString.append((int) coefficient).append("x").append(" ").toString();
                } else if (coefficient == 1) {
                    return monomialString.append("+ ").append("x").append(" ").toString();
                } else {
                    return monomialString.append("+ ").append((int) coefficient).append("x").append(" ").toString();
                }
            } else { //power>1
                if (coefficient < 0) {
                    if(coefficient==-1){
                        return  monomialString.append("-").append("x^").append(power).append(" ").toString();
                    }
                    return monomialString.append((int) coefficient).append("x^").append(power).append(" ").toString();
                } else if (coefficient == 1) {
                    return monomialString.append("+ ").append("x^").append(power).append(" ").toString();
                } else {
                    return monomialString.append("+ ").append((int) coefficient).append("x^").append(power).append(" ").toString();
                }
            }
        } else {
            return "";
        }
    }
}
