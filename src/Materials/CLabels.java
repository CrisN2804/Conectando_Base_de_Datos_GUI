package Materials;

import javax.swing.*;
import java.awt.*;

public class CLabels extends JLabel {
    public CLabels(){
        super();
        this.setFont(new Font("Serif", Font.PLAIN, 20));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public CLabels(String text){
        this.setFont(new Font("Serif", Font.PLAIN, 20));
        this.setText(text);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
