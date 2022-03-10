package ro.tuc.pt.model;
import java.util.ArrayList;

public class Polynomial {

    private final ArrayList<Monomial> polynomial= new ArrayList<>();
    public Polynomial() {}

    public ArrayList<Monomial> getPolynomial() {
        return this.polynomial;
    }

    public Monomial findMonomialOfDegree(int degree) {
        Monomial resultMonomial = null;

        for (Monomial myMonomial : this.getPolynomial()) {
            if (myMonomial.getPower() == degree)
                resultMonomial = myMonomial;
        }
        return resultMonomial;
    }

    public String getPolynomialString() {
         StringBuilder polynomialString = new StringBuilder();

        for (Monomial myMonomial : this.getPolynomial()) {
            polynomialString.append(myMonomial.getMonomialString());
        }
        String temp=polynomialString.toString();
        if(temp.startsWith("-")){
            return polynomialString.toString();
        }
        if(polynomialString.isEmpty()){
            return "0";
        }
        return polynomialString.substring(1);
    }

    public void orderByDegree() {
        polynomial.sort((o1, o2) -> Integer.compare(o2.getPower(), o1.getPower()));
    }

    public Monomial getFirstMonomial(Polynomial p) {
        Monomial firstMonomial = new Monomial();

        for (Monomial myMonomial : p.getPolynomial()) {
            if (myMonomial.getCoefficient() != 0) {
                firstMonomial = myMonomial;
                break;
            }
        }
        return firstMonomial;
    }

    public String getIntPolynomialString() {
        StringBuilder polynomialString = new StringBuilder();
        for (Monomial currentMonom : this.getPolynomial()) {
            polynomialString.append(currentMonom.getIntMonomialString());
        }
        String temp=polynomialString.toString();
        if(temp.startsWith("-")){
            return polynomialString.toString();
        }
        if(polynomialString.isEmpty()){
            return "0";
        }
        return polynomialString.substring(1);
    }
}
