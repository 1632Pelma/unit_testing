package validate_sa_id;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
  
        JFrame frame = new JFrame("South African ID Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());


        JTextField idField = new JTextField(13);
        JButton validateButton = new JButton("Validate");
        JLabel resultLabel = new JLabel("Enter ID and click Validate");

     
        validateButton.addActionListener(e -> {
            String idNumber = idField.getText().trim();
            boolean isValid = ValidateSaId.isIdNumberValid(idNumber);
            resultLabel.setText("ID " + idNumber + " is " + (isValid ? "valid" : "invalid"));
        });


        frame.add(idField);
        frame.add(validateButton);
        frame.add(resultLabel);

        
        frame.setVisible(true);
    }
}