package ro.tuc.pt.logic;

import ro.tuc.pt.model.Monomial;
import ro.tuc.pt.model.Polynomial;

//import java.util.Iterator;

public class Operations {

    public Polynomial add(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial polynomialSum ;//= new Polynomial();
        polynomialSum = firstPolynomial;

        for (Monomial currentMonomial : secondPolynomial.getPolynomial()) {
            int currentDegree = currentMonomial.getPower();
            int currentCoefficient = currentMonomial.getCoefficient();

            Monomial searchedMonomial = polynomialSum.findDegree(currentDegree);
            if (searchedMonomial == null) {
                polynomialSum.getPolynomial().add(currentMonomial);
            } else {
                int oldCoefficient = searchedMonomial.getCoefficient();
                searchedMonomial.setCoefficient(currentCoefficient + oldCoefficient);
            }
        }

        polynomialSum.sortByDegree();


        return polynomialSum;
       // return null; //firstPolynomial + secondPolynomial;
    }

    public Polynomial subtract(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial polynomialDiff;// = new Polynomial();
        polynomialDiff = firstPolynomial;

        for (Monomial currentMonomial : secondPolynomial.getPolynomial()) {
            int currentDegree = currentMonomial.getPower(); //monomial degree
            int currentCoefficient = currentMonomial.getCoefficient();

            Monomial searchedMonom = polynomialDiff.findDegree(currentDegree);
            if (searchedMonom == null) {
                currentCoefficient = -currentCoefficient;
                currentMonomial.setCoefficient(currentCoefficient);
                polynomialDiff.getPolynomial().add(currentMonomial);
            } else {
                int oldCoefficient = searchedMonom.getCoefficient();
                searchedMonom.setCoefficient(oldCoefficient - currentCoefficient);
            }
        }

        polynomialDiff.sortByDegree();

        return polynomialDiff;
       // return null; //firstNumber - secondNumber;
    }

  /*  public Polynomial multiply(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        return null;//firstNumber * secondNumber;
    }*/
}
