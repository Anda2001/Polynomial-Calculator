package ro.tuc.pt.gui;
import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class View extends JFrame {

    private JPanel contentPane;
    private JTextField firstPolynomialTextField;
    private JTextField secondPolynomialTextField;
    private JLabel resultPolynomialLabel;

    Controller controller = new Controller(this);

    Font myFont = new Font("Times New Roman", Font.PLAIN, 22);

    public View(String name) {
        super(name);
        this.setLayout(null);
        this.prepareGui();

    }

    public void prepareGui(){
        this.setSize(900, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel();
        this.contentPane.setLayout(null);
        this.contentPane.setBackground(MAGENTA);
        this.preparePolynomialsPanel();
        this.setContentPane(this.contentPane);
        this.setVisible(true);
    }

    private void preparePolynomialsPanel() {
        JPanel polynomialPanel = new JPanel();

        polynomialPanel.setLayout(null);
       polynomialPanel.setBounds(10,10,860,445);

        //first polynomial label + text
        JLabel firstPolynomialLabel = new JLabel("First polynomial: ");
        firstPolynomialLabel.setBounds(20, 50, 210, 30);
        firstPolynomialLabel.setFont(myFont);
        polynomialPanel.setBackground(PINK);
        polynomialPanel.add(firstPolynomialLabel);

        this.firstPolynomialTextField = new JTextField();
        this.firstPolynomialTextField.setBounds(230, 50, 300, 30);
        this.firstPolynomialTextField.setBackground(LIGHT_GRAY);
        polynomialPanel.add(this.firstPolynomialTextField);


        //second polynomial label + text
        JLabel secondPolynomialLabel = new JLabel("Second polynomial :");
        secondPolynomialLabel.setFont(myFont);
        polynomialPanel.add(secondPolynomialLabel);
        secondPolynomialLabel.setBounds(20, 100, 210, 30);

        this.secondPolynomialTextField = new JTextField();
        this.secondPolynomialTextField.setBackground(LIGHT_GRAY);
        this.secondPolynomialTextField.setBounds(230,100 , 300, 30);
        polynomialPanel.add(this.secondPolynomialTextField);

        //operations
        JLabel operationsLabel = new JLabel("Select operation:");
        operationsLabel.setFont(myFont);
        polynomialPanel.add(operationsLabel);
        operationsLabel.setBounds(650, 10, 200, 30);

        //addition button
        JButton additionButton = new JButton("Addition");
        additionButton.setFont(myFont);
        additionButton.setBounds(630,60 , 180, 40);
        additionButton.setActionCommand("Addition");
        additionButton.addActionListener(this.controller);
        polynomialPanel.add(additionButton);

        // substraction button
        JButton substractionButton = new JButton("Subtraction");
        substractionButton.setFont(myFont);
        substractionButton.setBounds(630, 110, 180, 40);
        substractionButton.setActionCommand("Subtraction");
        substractionButton.addActionListener(this.controller);
        polynomialPanel.add(substractionButton);

        // multiplication button
        JButton multiplicationButton = new JButton("Multiplication");
        multiplicationButton.setFont(myFont);
        multiplicationButton.setBounds(630, 160, 180, 40);
        multiplicationButton.setActionCommand("Multiplication");
        multiplicationButton.addActionListener(this.controller);
        polynomialPanel.add(multiplicationButton);

        // division button
        JButton divisionButton = new JButton("Division");
        divisionButton.setFont(myFont);
        divisionButton.setBounds(630, 210, 180, 40);
        divisionButton.setActionCommand("Division");
        divisionButton.addActionListener(this.controller);
        polynomialPanel.add(divisionButton);

        // derivation button
        JButton derivationButton = new JButton("Derivation");
        derivationButton.setFont(myFont);
        derivationButton.setBounds(630, 260, 180, 40);
        derivationButton.setActionCommand("Derivation");
        derivationButton.addActionListener(this.controller);
        polynomialPanel.add(derivationButton);

        // integration button
        JButton integrationButton = new JButton("Integration");
        integrationButton.setFont(myFont);
        integrationButton.setBounds(630, 310, 180, 40);
        integrationButton.setActionCommand("Integration");
        integrationButton.addActionListener(this.controller);
        polynomialPanel.add(integrationButton);

        //result label+ text
        JLabel resultLabel = new JLabel("Result:");
        this.resultPolynomialLabel = new JLabel("");
        resultLabel.setFont(myFont);
        this.resultPolynomialLabel.setFont(myFont);
        resultLabel.setBounds(60, 250, 120, 30);
        this.resultPolynomialLabel.setBounds(140, 250, 550, 30);
        polynomialPanel.add(resultLabel);
        polynomialPanel.add(this.resultPolynomialLabel);

        JLabel noteLabel = new JLabel("NOTE: For derivation and integration the first polynomial will be used!");
        Font anotherFont=new Font("Times New Roman", Font.ITALIC, 20);
        noteLabel.setFont(anotherFont);
        noteLabel.setBounds(20,350,850,100);
        polynomialPanel.add(noteLabel);

        this.contentPane.add(polynomialPanel); //add everything to content pane
    }

    public JTextField getFirstPolynomialTextField() {
        return firstPolynomialTextField;
    }

    public JTextField getSecondPolynomialTextField() {
        return secondPolynomialTextField;
    }


    public JLabel getResultPolynomialLabel() {
        return resultPolynomialLabel;
    }

}
