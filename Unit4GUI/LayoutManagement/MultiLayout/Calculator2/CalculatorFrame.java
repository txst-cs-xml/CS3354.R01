import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
   This frame contains a panel that displays buttons
   for a calculator and a panel with a text field to
   specify the result of calculation.
*/
public class CalculatorFrame extends JFrame
{  
   private JTextField display;

   private double lastValue;
   private String lastOperator;
   private boolean startNewValue;   

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 300;

   public CalculatorFrame()
   {
      createButtonPanel();

      display = new JTextField("0");
      //set display size bigger
      display.setFont(display.getFont().deriveFont(24.0f));
      display.setEditable(false);     
      add(display, BorderLayout.NORTH);

      lastValue = 0;
      lastOperator = "=";
      startNewValue = true;

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }
      
   /**
      Creates the control panel with the text field 
      and buttons on the frame.
   */
   private void createButtonPanel()
   {      
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(4, 4));

      buttonPanel.add(makeDigitButton("7"));
      buttonPanel.add(makeDigitButton("8"));
      buttonPanel.add(makeDigitButton("9"));
      buttonPanel.add(makeOperatorButton("/"));
      buttonPanel.add(makeDigitButton("4"));
      buttonPanel.add(makeDigitButton("5"));
      buttonPanel.add(makeDigitButton("6"));
      buttonPanel.add(makeOperatorButton("*"));
      buttonPanel.add(makeDigitButton("1"));
      buttonPanel.add(makeDigitButton("2"));
      buttonPanel.add(makeDigitButton("3"));
      buttonPanel.add(makeOperatorButton("-"));
      buttonPanel.add(makeDigitButton("0"));
      buttonPanel.add(makeDigitButton("."));
      buttonPanel.add(makeOperatorButton("="));
      buttonPanel.add(makeOperatorButton("+"));

      add(buttonPanel, BorderLayout.CENTER);
   }


   /**
      Combines two values with an operator.
      @param value1 the first value
      @param value2 the second value
      @param op an operator (+, -, *, /, or =)
   */
   public double calculate(double value1, double value2, String op)
   {  
      if (op.equals("+")) 
      {
         return value1 + value2;
      }
      else if (op.equals("-")) 
      {
         return value1 - value2;
      }
      else if (op.equals("*")) 
      {
         return value1 * value2;
      }
      else if (op.equals("/")) 
      {
         return value1 / value2;
      }
      else // "="
      {
         return value2;
      }
   }
   
   class DigitButtonListener implements ActionListener
   {
      private String digit;
      
      /**
         Constructs a listener whose actionPerformed method adds a digit
         to the display.
         @param aDigit the digit to add
      */
      public DigitButtonListener(String aDigit)
      {
         digit = aDigit;
      }
      
      public void actionPerformed(ActionEvent event)
      {  
         if (startNewValue) 
         {
            display.setText("");
            startNewValue = false;
         }
         display.setText(display.getText() + digit);
      }        
   }

   /**
      Makes a button representing a digit of a calculator.
      @param digit the digit of the calculator
      @return the button of the calculator
   */
   public JButton makeDigitButton(String digit)
   {
      JButton button = new JButton(digit);      
      ActionListener listener = new DigitButtonListener(digit);
      button.addActionListener(listener);  
      return button;    
   } 

   class OperatorButtonListener implements ActionListener
   {
      private String operator;

      /**
         Constructs a listener whose actionPerformed method
         schedules an operator for execution.
      */      
      public OperatorButtonListener(String anOperator)
      {
         operator = anOperator;
      }

      public void actionPerformed(ActionEvent event)
      {  
         if (!startNewValue)
         {  
            double value = Double.parseDouble(display.getText());
            lastValue = calculate(lastValue, value, lastOperator);
            display.setText("" + lastValue);
            startNewValue = true;
         }
            
         lastOperator = operator;
      }       
   }

   /**
      Makes a button representing an operator of a calculator.
      @param op the operator of the calculator
      @return button the button of the calcalator
   */
   public JButton makeOperatorButton(String op)
   {
      JButton button = new JButton(op);      
      ActionListener listener = new OperatorButtonListener(op);
      button.addActionListener(listener);  
      return button;    
   }     
}
