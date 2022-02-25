package ro.tuc.pt.gui;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JPanel contentPane;
    private JPanel polynomialPanel;
    private JLabel firstPolynomialLabel;
    private JTextField firstPolynomialTextField;
    private JLabel secondPolynomialLabel;
    private JTextField secondPolynomialTextField;
    private JLabel operationsLabel;
    private JComboBox operationsComboBox;
    private JButton computeButton;
    private JPanel resultPanel;
    private JLabel resultLabel;
    private JLabel resultPolynomialLabel;

    Controller controller = new Controller(this);

    public View(String name) {
        super(name);
        this.prepareGui();
    }

    public void prepareGui(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(2, 2));
        this.prepareNumbersPanel();
        this.prepareResultPanel();
        this.setContentPane(this.contentPane);
    }

    private void prepareResultPanel() {
        this.resultPanel = new JPanel();
        this.resultPanel.setLayout(new GridLayout(1,1));
        this.resultLabel = new JLabel("Result", JLabel.CENTER);
        this.resultPolynomialLabel = new JLabel("", JLabel.CENTER);
        this.resultPanel.add(this.resultLabel);
        this.resultPanel.add(this.resultPolynomialLabel);
        this.contentPane.add(this.resultPanel);
    }

    private void prepareNumbersPanel() {
        this.polynomialPanel = new JPanel();
        this.polynomialPanel.setLayout(new GridLayout(5, 2));
        this.firstPolynomialLabel = new JLabel("First polynomial", JLabel.CENTER);
        this.polynomialPanel.add(this.firstPolynomialLabel);
        this.firstPolynomialTextField = new JTextField();
        this.polynomialPanel.add(this.firstPolynomialTextField);
        this.secondPolynomialLabel = new JLabel("Second polynomial", JLabel.CENTER);
        this.polynomialPanel.add(secondPolynomialLabel);
        this.secondPolynomialTextField = new JTextField();
        this.polynomialPanel.add(secondPolynomialTextField);
        this.operationsLabel = new JLabel("Select operation", JLabel.CENTER);
        this.polynomialPanel.add(this.operationsLabel);
        String[] operations = new String[]{"Add", "Subtract", "Multiply"};
        this.operationsComboBox = new JComboBox(operations);
        this.polynomialPanel.add(operationsComboBox);
        this.computeButton = new JButton("Compute");
        this.computeButton.setActionCommand("COMPUTE");
        this.computeButton.addActionListener(this.controller);
        this.polynomialPanel.add(this.computeButton);
        this.contentPane.add(this.polynomialPanel);
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
}
