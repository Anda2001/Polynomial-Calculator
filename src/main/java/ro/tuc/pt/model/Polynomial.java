package ro.tuc.pt.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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

    public String getIntegerPolinomString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Monomial currentMonom : this.getPolynomial()) {
            stringBuilder.append(currentMonom.getIntMonomString());
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
        polynomial.sort(new Comparator<Monomial>() {

            @Override
            public int compare(Monomial o1, Monomial o2) {
                return Integer.compare(o2.getPower(), o1.getPower());
            }
        });
    }



}
