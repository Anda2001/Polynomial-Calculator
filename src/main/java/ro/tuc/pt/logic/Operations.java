package ro.tuc.pt.logic;

import ro.tuc.pt.model.Monomial;
import ro.tuc.pt.model.Polynomial;


public class Operations {

    public Polynomial add(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial polynomialSum ;
        polynomialSum = firstPolynomial;

        secondPolynomial.getPolynomial().forEach(myMonomial -> {
            int degree = myMonomial.getPower();
            double coefficient1 = myMonomial.getCoefficient();
            Monomial searchedMonomial = polynomialSum.findMonomialOfDegree(degree);
            if (searchedMonomial == null) {
                polynomialSum.getPolynomial().add(myMonomial);
            } else {
                double coefficient2 = searchedMonomial.getCoefficient();
                searchedMonomial.setCoefficient(coefficient1 + coefficient2);
            }
        });
        polynomialSum.orderByDegree();
        return polynomialSum;
    }

    public Polynomial subtract(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial polynomialDiff;
        polynomialDiff = firstPolynomial;

        for (Monomial myMonomial : secondPolynomial.getPolynomial()) {
            int degree = myMonomial.getPower(); //monomial degree
            double coefficient1 = myMonomial.getCoefficient();

            Monomial searchedMonomial = polynomialDiff.findMonomialOfDegree(degree);
            if (searchedMonomial == null) {
                coefficient1 = -coefficient1;
                myMonomial.setCoefficient(coefficient1);
                polynomialDiff.getPolynomial().add(myMonomial);
            } else {
                double coefficient2 = searchedMonomial.getCoefficient();
                searchedMonomial.setCoefficient(coefficient2 - coefficient1);
            }
        }
        polynomialDiff.orderByDegree();
        return polynomialDiff;
    }

  public Polynomial multiply(Polynomial firstPolynomial, Polynomial secondPolynomial) {
      Polynomial polynomialMul = new Polynomial();

      firstPolynomial.getPolynomial().forEach(myMonomial1 -> {
          int powerp1 = myMonomial1.getPower();
          double coeffp1 = myMonomial1.getCoefficient();
          secondPolynomial.getPolynomial().forEach(myMonomial2 -> {
              int powerp2 = myMonomial2.getPower();
              int finalPower = powerp1 + powerp2;
              double coeffp2 = myMonomial2.getCoefficient();
              double finalCoeff = coeffp1 * coeffp2;
              Monomial searchedMonomial = polynomialMul.findMonomialOfDegree(finalPower);
              if (searchedMonomial == null) {
                  Monomial newMonom = new Monomial(finalPower, finalCoeff);
                  polynomialMul.getPolynomial().add(newMonom);
              } else {
                  double oldCoeff = searchedMonomial.getCoefficient();
                  searchedMonomial.setCoefficient(oldCoeff + finalCoeff);
              }
          });
      });
      polynomialMul.orderByDegree();
      return polynomialMul;
    }

    public Polynomial divide(Polynomial firstPolynomial, Polynomial secondPolynomial){
        firstPolynomial.orderByDegree();
        secondPolynomial.orderByDegree();
        Polynomial result=new Polynomial();
        int deg1, deg2;
        deg1=firstPolynomial.getFirstMonomial(firstPolynomial).getPower();
        deg2=secondPolynomial.getFirstMonomial(secondPolynomial).getPower();
        Polynomial p1; //deimpartit
        Polynomial p2; //impartitor

        if(deg1>=deg2){
            p1=firstPolynomial;
            p2=secondPolynomial;
        }
        else{
            p1=secondPolynomial;
            p2=firstPolynomial;
        }
        int powerp1=p1.getFirstMonomial(p1).getPower();
        double coeffp1=p1.getFirstMonomial(p1).getCoefficient();
        int powerp2=p2.getFirstMonomial(p2).getPower();
        double coeffp2=p2.getFirstMonomial(p2).getCoefficient();

        while(!(powerp1<powerp2)){
            int power= powerp1-powerp2;
            double coefficient = coeffp1/coeffp2;

            Monomial myMonomial=new Monomial(power,coefficient);
            result.getPolynomial().add(myMonomial);
            Polynomial helper = new Polynomial();
            helper.getPolynomial().add(myMonomial);
            p1=subtract(p1, (multiply(helper,p2)));

            Monomial reminderMonom = p1.getFirstMonomial(p1);
            powerp1=reminderMonom.getPower();
            coeffp1=reminderMonom.getCoefficient();
            if(coeffp1==0){

                p1.getPolynomial().remove(myMonomial);
                break;
            }
        }
        return result;
    }

    public Polynomial derivate(Polynomial p) {
        Polynomial derivatedPolinom = new Polynomial();

        p.getPolynomial().forEach(myMonomial -> {
            int power = myMonomial.getPower();
            double coefficient = myMonomial.getCoefficient();
            myMonomial.setCoefficient(power * coefficient);
            myMonomial.setPower(power - 1);
            derivatedPolinom.getPolynomial().add(myMonomial);
        });
        derivatedPolinom.orderByDegree();

        return derivatedPolinom;
    }


    public Polynomial integrate(Polynomial p) {
        Polynomial result = new Polynomial();

        p.getPolynomial().forEach(myMonomial -> {
            int power = myMonomial.getPower();
            double coefficient = myMonomial.getCoefficient();
            myMonomial.setPower(power + 1);
            if (power == -1) {
                myMonomial.setCoefficient(coefficient);
            } else
                myMonomial.setCoefficient(coefficient / (power + 1));
            result.getPolynomial().add(myMonomial);
        });
        result.orderByDegree();
        return result;
    }

}
