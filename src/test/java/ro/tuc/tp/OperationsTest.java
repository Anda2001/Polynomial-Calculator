package ro.tuc.tp;
import org.junit.jupiter.api.Test ;
import ro.tuc.pt.logic.Operations;
import ro.tuc.pt.model.Monomial;
import ro.tuc.pt.model.Polynomial;

import java.util.Objects;

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


      Monomial mr2 = new Monomial(2,2);
      Monomial mr3 = new Monomial(1,1);
      Monomial mr4 = new Monomial(0,2);
      Polynomial result = new Polynomial();
      result.getPolynomial().add(mr2);
      result.getPolynomial().add(mr3);
      result.getPolynomial().add(mr4);

     assertTrue(result.getPolinomString().equals("2x^2 + 1x^1 + 2x^0 "),
             "OK!");


   }
}
