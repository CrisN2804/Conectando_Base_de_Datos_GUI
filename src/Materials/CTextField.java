package Materials;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class CTextField extends JTextField {
    public CTextField() {
        metodo();
    }
    public CTextField(int size){
        metodo();
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= size) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() - length <= size) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    public void metodo(){
        this.setFont(new Font("Serif", Font.PLAIN, 18));
        this.setHorizontalAlignment(JTextField.CENTER);
    }
}
