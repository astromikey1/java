import javax.swing.*; //package that represents a window in a GUI
import java.awt.*;
import java.awt.event.*;

//basic calculator application using API to build basic GUI components
public class Calculator implements ActionListener{

        JFrame frame; //this will include everything
        JTextField textfield; //where you will see the calculations
        JButton[] numberButtons = new JButton[10]; //0-9
        JButton[] functionButtons = new JButton[9];
        JButton addButton, subButton, mulButton, divButton; //variables to represent fun buttons
        JButton decButton, equButton, delButton, clrButton, negButton;
        JPanel panel; //this will hold the buttons

        Font myFont = new Font("Ink Free",Font.BOLD, 30);

        double num1 = 0, num2 = 0, result = 0;
        char operator;


        Calculator() { //initialization of calculator
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
            //creation of the buttons
            addButton = new JButton("+");
            subButton = new JButton("-");
            mulButton = new JButton("*");
            divButton = new JButton("/");
            decButton = new JButton(".");
            equButton = new JButton("=");
            delButton = new JButton("Delete");
            clrButton = new JButton("Clear");
            negButton = new JButton("(-)");

            functionButtons[0] = addButton;
            functionButtons[1] = subButton;
            functionButtons[2] = mulButton;
            functionButtons[3] = divButton;
            functionButtons[4] = decButton;
            functionButtons[5] = equButton;
            functionButtons[6] = delButton;
            functionButtons[7] = clrButton;
            functionButtons[8] = negButton;

            for(int i = 0; i < 9; i++) {
                functionButtons[i].addActionListener(this);
                functionButtons[i].setFont(myFont);
                functionButtons[i].setFocusable(false);
            }

            for(int i = 0; i < 10; i++) {
                numberButtons[i] = new JButton(String.valueOf(i)); //instantiating the numbered buttons
                numberButtons[i].addActionListener(this);
                numberButtons[i].setFont(myFont);
                numberButtons[i].setFocusable(false);
            }
            negButton.setBounds(50,430,100,50);
            delButton.setBounds(150,430,100, 50);
            clrButton.setBounds(250,430,100,50);

            panel = new JPanel(); //this will hold the buttons
            panel.setBounds(50,100,300,300);
            panel.setLayout(new GridLayout(4,4,10,10)); //sets the layout
           panel.add(numberButtons[1]);
            panel.add(numberButtons[2]);
            panel.add(numberButtons[3]);
            panel.add(addButton);
            panel.add(numberButtons[4]);
            panel.add(numberButtons[5]);
            panel.add(numberButtons[6]);
            panel.add(subButton);
            panel.add(numberButtons[7]);
            panel.add(numberButtons[8]);
            panel.add(numberButtons[9]);
            panel.add(mulButton);
            panel.add(decButton);
            panel.add(numberButtons[0]);
            panel.add(equButton);
            panel.add(divButton);


            frame.add(panel);
            frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
        }

    public static void main(String[] args) {
    Calculator calc = new Calculator();
    }

    //defines actions when buttons are clicked
    public void actionPerformed(ActionEvent e) {
       for (int i = 0; i < 10; i++) {
           if(e.getSource() == numberButtons[i]) textfield.setText(textfield.getText().concat(String.valueOf(i)));

       }
       if(e.getSource() ==decButton) { //adds a decimal when clicked
           textfield.setText(textfield.getText().concat("."));
       }

       if(e.getSource() == addButton) {
           num1 = Double.parseDouble(textfield.getText());
           operator = '+';
           textfield.setText("");
       }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource() == negButton) { //action when negative is clicked
            double temp = Double.parseDouble(textfield.getText()); //take value
            temp*=-1; //change to negative
            textfield.setText(String.valueOf(temp));
        }
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/': //add a check if num2 = 0
                     result = num1 / num2;
                    break;
            }

            textfield.setText(String.valueOf(result));
            num1 = result;

        }

        if(e.getSource() == clrButton) {
            textfield.setText("");
        }
        if(e.getSource() == delButton) {
           String string = textfield.getText(); //hold the value of the text
           textfield.setText("");
           for(int i = 0; i < string.length()-1; i++) {
               textfield.setText(textfield.getText()+ string.charAt(i));
           }

        }

    }


}
