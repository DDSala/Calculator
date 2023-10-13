/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author SALAD
 */
public class Calculator extends JFrame implements ActionListener{
    
    static JFrame frame;
    static JTextField display;
    
    String s0, s1, s2;

    Calculator() {
        s0 = s1 = s2 = "";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        frame = new JFrame("Sala's Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
            
        }
        
        
        Calculator c = new Calculator();
        
        
        display = new JTextField();
            display.setPreferredSize(new Dimension(275,50));
                display.setEditable(false);
        
      
        JPanel displayPanel = new JPanel(new FlowLayout());
            displayPanel.add(display);
        
       
        JButton[] numButtons = new JButton[10];
            for (int i = 0; i < 10; i++) {
            
                numButtons[i] = new JButton(String.valueOf(i));
                numButtons[i].addActionListener(c);
            
            }
        
            
            JButton[] operatorButtons = {
                
                new JButton("+"), 
                new JButton("-"), 
                new JButton("/"), 
                new JButton("*"), 
                new JButton("."), 
                new JButton("="), 
                new JButton("CE"), 
                new JButton("C"),
                new JButton("←")
                    
            };
        
            
            
        for (JButton button : operatorButtons) {
            
            button.addActionListener(c);
            
        }
        
        JButton leftArrowButton = new JButton("←");
        leftArrowButton.addActionListener(c);
        
        
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
        
            buttonPanel.add(leftArrowButton);
            buttonPanel.add(operatorButtons[6]); 
            buttonPanel.add(operatorButtons[7]);
            buttonPanel.add(operatorButtons[2]);
            buttonPanel.add(numButtons[7]);
            buttonPanel.add(numButtons[8]);
            buttonPanel.add(numButtons[9]);
            buttonPanel.add(operatorButtons[3]);
            buttonPanel.add(numButtons[4]);
            buttonPanel.add(numButtons[5]);
            buttonPanel.add(numButtons[6]);
            buttonPanel.add(operatorButtons[1]);
            buttonPanel.add(numButtons[1]);
            buttonPanel.add(numButtons[2]);
            buttonPanel.add(numButtons[3]);
            buttonPanel.add(operatorButtons[0]);
            buttonPanel.add(numButtons[0]);
            buttonPanel.add(operatorButtons[4]);
            buttonPanel.add(operatorButtons[5]);
        
        
        Container contentPane = frame.getContentPane();
            contentPane.setLayout(new BorderLayout());
                contentPane.add(displayPanel, BorderLayout.NORTH);
                    contentPane.add(buttonPanel, BorderLayout.CENTER);
        
                    
        frame.setSize(300, 300);
            frame.setVisible(true);
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

            if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
                if (!s1.isEmpty())
                    s2 += s;
                
                else
                    s0 += s;

                display.setText(s0 + s1 + s2);
        
        
            } else if (s.charAt(0) == 'C') {
        
                if (s.equals("CE")) {
                    if (!s2.isEmpty()) {
                        s2 = s2.substring(0, s2.length() - 1);
                        
                    } else if (!s1.isEmpty()) {
                        s1 = s1.substring(0, s1.length() - 1);
                        
                    } else if (!s0.isEmpty()) {
                        s0 = s0.substring(0, s0.length() - 1);
                        
                }
                    
                    
                } else {
            
                    s0 = s1 = s2 = "";
                }
                
                
                display.setText(s0 + s1 + s2);
        
        
            } else if (s.equals("←")) { 
        
                if (!display.getText().isEmpty()) {
                    
                    display.requestFocusInWindow();
                    
                        int pos = display.getCaretPosition();
                        
                            if (pos > 0) {
                                
                                display.setCaretPosition(pos - 1);
                                
                            }
                }
                
                
            } else if (s.charAt(0) == '=') {
    
                if (!s0.isEmpty() && !s1.isEmpty() && !s2.isEmpty()) {
                    
                    double num1 = Double.parseDouble(s0);
                    double num2 = Double.parseDouble(s2);
                    double result;
            
                switch (s1) {
                    
                    case "+":
                        result = num1 + num2;
                        break;
                        
                    case "-":
                        result = num1 - num2;
                        break;
                        
                    case "*":
                        result = num1 * num2;
                        break;
                        
                    case "/":
                        result = num1 / num2;
                        break;
                        
                    default:
                        result = 0.0;
                        
            }
                
                
            s0 = Double.toString(result);
            s1 = "";
            s2 = "";
            display.setText(s0);
            
            
        }
                
    } else {
                
        if (s1.isEmpty() || s2.isEmpty())
            s1 = s;
        
        else {
            
            double result;
            double num1 = Double.parseDouble(s0);
            double num2 = Double.parseDouble(s2);
            
            switch (s1) {
                case "+":
                    result = num1 + num2;
                    break;
                    
                case "-":
                    result = num1 - num2;
                    break;
                    
                case "*":
                    result = num1 * num2;
                    break;
                    
                case "/":
                    result = num1 / num2;
                    break;
                    
                default:
                    result = 0.0;
                    
            }
            
            
            s0 = Double.toString(result);
            s1 = s;
            s2 = "";
            
            
        }
        
        display.setText(s0 + s1 + s2);
        
    }
}
}
