// The Controller: Handles user actions
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        // Add AC button functionality
        view.getAcButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.reset();
                view.getDisplay().setText("0");
            }
        });

        // Add digit buttons
        for (String digit : "7894561230.".split("")) {
            JButton button = new JButton(digit);
            button.addActionListener(new DigitButtonListener(digit));
            view.getButtonPanel().add(button);
        }

        // Add operator buttons
        for (String operator : "+-*/=".split("")) {
            JButton button = new JButton(operator);
            button.addActionListener(new OperatorButtonListener(operator));
            view.getButtonPanel().add(button);
        }
    }

    // Listener for digit buttons
    private class DigitButtonListener implements ActionListener {
        private String digit;

        public DigitButtonListener(String digit) {
            this.digit = digit;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (model.isStartNewValue()) {
                view.getDisplay().setText("");
                model.setStartNewValue(false);
            }
            view.getDisplay().setText(view.getDisplay().getText() + digit);
        }
    }

    // Listener for operator buttons
    private class OperatorButtonListener implements ActionListener {
        private String operator;

        public OperatorButtonListener(String operator) {
            this.operator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!model.isStartNewValue()) {
                double currentValue = Double.parseDouble(view.getDisplay().getText());
                double result = model.calculate(model.getLastValue(), currentValue, model.getLastOperator());
                view.getDisplay().setText("" + result);
                model.setLastValue(result);
                model.setStartNewValue(true);
            }
            model.setLastOperator(operator);
        }
    }
}
