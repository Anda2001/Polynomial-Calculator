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
   // private Polynomial polynomialOne;
   // private Polynomial polynomialTwo;

    private final Operations operations = new Operations();

    public Controller(View v){
        this.view = v;
    }

    public Polynomial createPolynomial(String textFieldString) {
        Polynomial currentPolynomial = new Polynomial();
        String polynomialString = textFieldString;
        try {
            polynomialString = polynomialString.replaceAll("\\s", ""); //whitespaces

            for (String subPolynomial : polynomialString.split("\\+")) {
                int coefficient;
                int power;
                int xPosition = subPolynomial.indexOf("x");
                int powerPosition = subPolynomial.indexOf("^");
                try {

                    coefficient = Integer.parseInt(subPolynomial.substring(0, xPosition));
                    power = Integer.parseInt(subPolynomial.substring(powerPosition + 1));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Bad input format!");
                    return null;
                }

                if (coefficient != 0) {
                    Monomial newMonomial = new Monomial(power, coefficient);
                    currentPolynomial.getPolynomial().add(newMonomial);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bad input!");
        }
        return currentPolynomial;
    }

   /* public Polynomial getPolinomOne() {
        return polynomialOne;
    }*/

   /* public Polynomial getPolinomTwo() {

        return polynomialTwo;
    }*/

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(Objects.equals(command, "COMPUTE")){
            Polynomial firstPolynomial = createPolynomial(view.getFirstPolynomialTextField().getText());
            Polynomial secondPolynomial = createPolynomial(view.getSecondPolynomialTextField().getText());
            String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());
            Polynomial result = null;
            switch (operation) {
                case "Add" -> {
                    result = operations.add(firstPolynomial, secondPolynomial);
                    //result = result.add(firstPolynomial, secondPolynomial);
                    view.setResult(result.getPolinomString());
                    //view.setIntResult(result.getIntegerPolinomString());
                   // result.displayPolinom();
                }
                case "Subtract" -> {
                    result = operations.subtract(firstPolynomial, secondPolynomial);
                    view.setResult(result.getPolinomString());
                    //view.setIntResult(result.getIntegerPolinomString());
                   // result.displayPolinom();
                }
               // case "Multiply" -> result = operations.multiply(firstPolynomial, secondPolynomial);
            }
            view.getResultPolynomialLabel().setText(String.valueOf(result));
        }
    }

}
