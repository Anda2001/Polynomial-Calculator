package ro.tuc.tp;
import org.junit.jupiter.api.Test ;
import ro.tuc.pt.logic.Operations;
import ro.tuc.pt.model.Monomial;
import ro.tuc.pt.model.Polynomial;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {
   private final Operations operations = new Operations();


   @Test
   public void addTest(){

      Monomial m2 = new Monomial(2,2);
      Polynomial p1 = new Polynomial();
      p1.getPolynomial().add(m2);

      Monomial mm1 = new Monomial(1, 1);
      Monomial mm2 = new Monomial(0, 2);
      Polynomial p2 = new Polynomial();
      p2.getPolynomial().add(mm1);
      p2.getPolynomial().add(mm2);

      Polynomial sum;
      sum=operations.add(p1,p2);

      assertEquals(" 2x^2 + x + 2 ", sum.getIntPolynomialString(), "OK!");
   }

   @Test
   public void subTest(){

      Monomial m2 = new Monomial(2,2);
      Polynomial p1 = new Polynomial();
      p1.getPolynomial().add(m2);

      Monomial mm1 = new Monomial(1, 1);
      Monomial mm2 = new Monomial(0, 2);
      Polynomial p2 = new Polynomial();
      p2.getPolynomial().add(mm1);
      p2.getPolynomial().add(mm2);


      Polynomial diff;
      diff=operations.subtract(p1,p2);
      assertEquals(" 2x^2 -x -2 ", diff.getIntPolynomialString(), "OK!");
   }

   @Test
   public void mulTest(){

      Monomial m2 = new Monomial(2,2);
      Polynomial p1 = new Polynomial();
      p1.getPolynomial().add(m2);

      Monomial mm1 = new Monomial(1, 1);
      Monomial mm2 = new Monomial(0, 2);
      Polynomial p2 = new Polynomial();
      p2.getPolynomial().add(mm1);
      p2.getPolynomial().add(mm2);


      Polynomial mul;
      mul=operations.multiply(p1,p2);
      assertEquals(" 2x^3 + 4x^2 ", mul.getIntPolynomialString(), "OK!");
   }

   @Test
   public void divideTest(){

      Monomial m4 = new Monomial(3,1); //x^3-2x^2+6x-5 //x^2-1
      Monomial m3 = new Monomial(2,-2);
      Monomial m2 = new Monomial(1,6);
      Monomial m1 = new Monomial(0,-5);
      Polynomial p1 = new Polynomial();
      p1.getPolynomial().add(m4);
      p1.getPolynomial().add(m3);
      p1.getPolynomial().add(m2);
      p1.getPolynomial().add(m1);

      Monomial mm2 = new Monomial(2,1);
      Monomial mm1 = new Monomial(0,-1);
      Polynomial p2=new Polynomial();
      p2.getPolynomial().add(mm2);
      p2.getPolynomial().add(mm1);

      Polynomial divide;
      divide=operations.divide(p1,p2);
      assertEquals(" x -2.0 ", divide.getPolynomialString(), "OK!");
   }

   @Test
   public void derivTest(){

      Monomial m2 = new Monomial(2,2);
      Polynomial p1 = new Polynomial();
      p1.getPolynomial().add(m2);



      Polynomial deriv;
      deriv=operations.derivate(p1);
      assertEquals(" 4x ", deriv.getIntPolynomialString(), "OK!");
   }

   @Test
   public void integrateTest(){

      Monomial m2 = new Monomial(1,2);
      Polynomial p1 = new Polynomial();
      p1.getPolynomial().add(m2);



      Polynomial integrate;
      integrate=operations.integrate(p1);
      assertEquals(" x^2 ", integrate.getIntPolynomialString(), "OK!");
   }

}
