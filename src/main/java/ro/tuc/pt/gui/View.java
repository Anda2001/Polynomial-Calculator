package ro.tuc.pt.gui;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JPanel contentPane;
    private JTextField firstPolynomialTextField;
    private JTextField secondPolynomialTextField;
    private JComboBox operationsComboBox;
    private JLabel resultLabel;
    private JLabel resultPolynomialLabel;
  //  private JLabel resultIntegerLabel;

    Controller controller = new Controller(this);

    public View(String name) {
        super(name);
        this.prepareGui();
    }

    public void prepareGui(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(2, 2));
        this.preparePolynomialsPanel();
        this.prepareResultPanel();
        this.setContentPane(this.contentPane);
    }

    private void prepareResultPanel() {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1,1));
        this.resultLabel = new JLabel("Result", JLabel.CENTER);
        this.resultPolynomialLabel = new JLabel("", JLabel.CENTER);
        resultPanel.add(this.resultLabel);
        resultPanel.add(this.resultPolynomialLabel);
        this.contentPane.add(resultPanel);
    }

    private void preparePolynomialsPanel() {
        JPanel polynomialPanel = new JPanel();
        polynomialPanel.setLayout(new GridLayout(5, 2));
        JLabel firstPolynomialLabel = new JLabel("First polynomial", JLabel.CENTER);
        polynomialPanel.add(firstPolynomialLabel);
        this.firstPolynomialTextField = new JTextField();
        polynomialPanel.add(this.firstPolynomialTextField);
        JLabel secondPolynomialLabel = new JLabel("Second polynomial", JLabel.CENTER);
        polynomialPanel.add(secondPolynomialLabel);
        this.secondPolynomialTextField = new JTextField();
        polynomialPanel.add(secondPolynomialTextField);
        JLabel operationsLabel = new JLabel("Select operation", JLabel.CENTER);
        polynomialPanel.add(operationsLabel);
        String[] operations = new String[]{"Add", "Subtract", "Multiply"};
        this.operationsComboBox = new JComboBox(operations);
        polynomialPanel.add(operationsComboBox);
        JButton computeButton = new JButton("Compute");
        computeButton.setActionCommand("COMPUTE");
        computeButton.addActionListener(this.controller);
        polynomialPanel.add(computeButton);
        this.contentPane.add(polynomialPanel);
    }

    public JTextField getFirstPolynomialTextField() {
        return firstPolynomialTextField;
    }

    public JTextField getSecondPolynomialTextField() {
        return secondPolynomialTextField;
    }

    public JComboBox getOperationsComboBox() {
        return operationsComboBox;
    }

    public JLabel getResultPolynomialLabel() {
        return resultPolynomialLabel;
    }

    public String getResult() {
        return resultLabel.getText().toString();
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }


}
