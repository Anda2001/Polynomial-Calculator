package ro.tuc.pt.gui;

import ro.tuc.pt.logic.Operations;
import ro.tuc.pt.model.Monomial;
import ro.tuc.pt.model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Controller implements ActionListener {

    private final View view;
    private final Operations operations = new Operations();

    public Controller(View v){
        this.view = v;
    }

    public Polynomial createPolynomial(String textFieldString) {
        Polynomial currentPolynomial = new Polynomial();
        String polynomialString = textFieldString;
        try {
            polynomialString = polynomialString.replaceAll("\\s", ""); //whitespaces
            polynomialString = polynomialString.replaceAll("\\*", "");
            polynomialString = polynomialString.replaceAll("\\+-", "-");
            polynomialString = polynomialString.replaceAll("-", "+-");

            int coefficient=0;
            int power=0;

            if (polynomialString.length() == 1) {
                if (polynomialString.equals("x")) {
                    coefficient = 1;
                    power = 1;

                } else {
                    coefficient = Integer.parseInt(polynomialString);
                }
                Monomial newMonomial = new Monomial(power, coefficient);
                currentPolynomial.getPolynomial().add(newMonomial);
            }
            else {
                for (String subPolynomial : polynomialString.split("\\+")) {
                    coefficient=0;
                    power = 0;
                    if (subPolynomial.length() > 0) {
                        String[] temp = subPolynomial.split("x");
                        if (temp.length > 1) {
                            if (temp[1].indexOf('^') != -1) {
                                temp[1] = temp[1].replaceAll("\\^", "");
                            }
                            power = Integer.parseInt(temp[1]);

                            if (temp[0].length() == 0) {
                                coefficient = 1;
                            } else {
                                if(temp[0].equals("-")){
                                    coefficient=-1;
                                }else{
                                    coefficient = Integer.parseInt(temp[0]);
                                }

                            }
                        }
                        else if(subPolynomial.equals("x")){
                            coefficient=1;
                            power=1;
                        }
                       else if(temp[0].equals("-")){
                            coefficient=-1;
                        }
                       else{
                           coefficient=Integer.parseInt(temp[0]);
                        }
                        if (subPolynomial.endsWith("x")) {
                            power = 1;
                        }
                        if (subPolynomial.startsWith("x")) {
                            coefficient = 1;
                        }
                    }
                    if (coefficient != 0) {
                        Monomial newMonomial = new Monomial(power, coefficient);
                        currentPolynomial.getPolynomial().add(newMonomial);
                    }
                        }
            }
                 } catch(Exception e){
                  JOptionPane.showMessageDialog(null, "Bad input!");
                 }
                return currentPolynomial;
        }


    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Polynomial firstPolynomial = createPolynomial(view.getFirstPolynomialTextField().getText());
        Polynomial secondPolynomial = createPolynomial(view.getSecondPolynomialTextField().getText());
        if(Objects.equals(command,"Addition")){

            Polynomial result = null;
                    result = operations.add(firstPolynomial, secondPolynomial);
            assert result != null;
            view.getResultPolynomialLabel().setText(result.getIntPolynomialString());
        }
        if(Objects.equals(command,"Subtraction")){
            Polynomial result = null;

            result = operations.subtract(firstPolynomial, secondPolynomial);
            assert result != null;
            view.getResultPolynomialLabel().setText(result.getIntPolynomialString());
        }
        if(Objects.equals(command,"Multiplication")){
            Polynomial result = null;

            result = operations.multiply(firstPolynomial, secondPolynomial);
            assert result != null;
            view.getResultPolynomialLabel().setText(result.getIntPolynomialString());
        }
        if(Objects.equals(command,"Division")){
            Polynomial result = null;

            result = operations.divide(firstPolynomial, secondPolynomial);
            assert result != null;
            view.getResultPolynomialLabel().setText(result.getPolynomialString());
        }
        if(Objects.equals(command,"Derivation")){
            Polynomial result = null;

            result = operations.derivate(firstPolynomial);
            assert result != null;
            view.getResultPolynomialLabel().setText(result.getIntPolynomialString());
        }
        if(Objects.equals(command,"Integration")){
            Polynomial result = null;

            result = operations.integrate(firstPolynomial);
            assert result != null;
            view.getResultPolynomialLabel().setText(result.getPolynomialString());
        }
    }

}
