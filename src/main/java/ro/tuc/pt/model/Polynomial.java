package ro.tuc.pt.model;

import java.util.ArrayList;


public class Polynomial {
   // public Polynomial getPolynomial() {
    //    return this;
   // }
    private final ArrayList<Monomial> polynomial= new ArrayList<>();

    public Polynomial() {}

    public ArrayList<Monomial> getPolynomial() {
        return this.polynomial;
    }

    public Monomial findDegree(int currentDegree) {
        Monomial resultMonom = null;

        for (Monomial currentMonom : this.getPolynomial()) {
            if (currentMonom.getPower() == currentDegree)
                resultMonom = currentMonom;
        }

        return resultMonom;
    }

    public String getPolinomString() {
         StringBuilder stringBuilder = new StringBuilder();

        for (Monomial currentMonom : this.getPolynomial()) {
            stringBuilder.append(currentMonom.getMonomialString());
        }
        return stringBuilder.toString();
    }


    public void displayPolinom() {
        for (Monomial currentMonom : this.getPolynomial()) {
            currentMonom.displayMonomial();
        }
        System.out.println(" ");
    }

    public void sortByDegree() {
        polynomial.sort((o1, o2) -> Integer.compare(o2.getPower(), o1.getPower()));
    }



}
