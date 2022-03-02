package ro.tuc.pt.gui;

import ro.tuc.pt.logic.Operations;
import ro.tuc.pt.model.Monomial;
import ro.tuc.pt.model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private View view;
    private Polynomial polynomialOne;
    private Polynomial polynomialTwo;

    private Operations operations = new Operations();

    public Controller(View v){
        this.view = v;
    }

    public Polynomial createPolynomial(String textFieldString) {
        Polynomial currentPolynomial = new Polynomial();
        String myPolinomialString = textFieldString;
        try {
            myPolinomialString = myPolinomialString.replaceAll("\\s", "");
            if (myPolinomialString.charAt(0) == '+')
                myPolinomialString = myPolinomialString.substring(1);

            for (String val : myPolinomialString.split("\\+")) {
                double coeff = 0;
                int power = 0;
                int xPosition = val.indexOf("x");
                int powPosition = val.indexOf("^");
                try {

                    coeff = Integer.parseInt(val.substring(0, xPosition));
                    power = Integer.parseInt(val.substring(powPosition + 1));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Bad input! Please respect the format");
                    return null;
                }

                if (coeff != 0) {
                    Monomial myMonomial = new Monomial(power, coeff);
                    currentPolynomial.getPolynomial().add(myMonomial);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bad input!");
        }
        return currentPolynomial;
    }

    public Polynomial getPolinomOne() {
        return polynomialOne;
    }

    public Polynomial getPolinomTwo() {

        return polynomialTwo;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command == "COMPUTE"){
            Polynomial firstPolynomial = createPolynomial(view.getFirstPolynomialTextField().getText());
            Polynomial secondPolynomial = createPolynomial(view.getSecondPolynomialTextField().getText());
            String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());
            Polynomial result = null;
            switch(operation){
                case "Add": result = operations.add(firstPolynomial, secondPolynomial);
                    break;
                case "Subtract": result = operations.subtract(firstPolynomial, secondPolynomial);
                    break;
                case "Multiply": result = operations.multiply(firstPolynomial, secondPolynomial);
                    break;
            }
            view.getResultPolynomialLabel().setText(String.valueOf(result));
        }
    }

}
