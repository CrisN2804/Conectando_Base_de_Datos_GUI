package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Base.BaseDeDatos;
import Materials.*;

public class Formulario extends JFrame {
    JLabel lblBienvenida;
    CLabels lblNombre, lblRegistro;
    CTextField txtNombre, txtRegistro;
    CButton btnEnviar;
    private TextObserver observer;
public Formulario(){
    super("Ventanas.Formulario");
    crearFormulario();
}

public void crearFormulario(){
    //region Frame_SETUP
    lblBienvenida= new JLabel("Bienvenido, introduce tus datos", SwingConstants.CENTER);
    lblNombre=new CLabels("Nombre:");
    lblRegistro=new CLabels("Registro:");
    txtNombre=new CTextField(40);
    txtRegistro=new CTextField(8);
    btnEnviar=new CButton("Enviar datos");

    lblBienvenida.setFont(new Font("Serif", Font.PLAIN, 37));

    GroupLayout gl =new GroupLayout(getContentPane());
    gl.setAutoCreateGaps(true);
    gl.setAutoCreateContainerGaps(true);

    gl.setHorizontalGroup(
            gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(lblBienvenida, 150, 455, 500)
                    .addGroup(
                            gl.createSequentialGroup()
                                    .addComponent(lblNombre, 50, 155, 166)
                                    .addComponent(txtNombre, 100, 300, 324)
                    )
                    .addGroup(
                            gl.createSequentialGroup()
                                    .addComponent(lblRegistro, 50, 155, 166)
                                    .addComponent(txtRegistro, 100, 300, 324)
                    )
                    .addGroup(
                            gl.createSequentialGroup()
                                    .addGap(50)
                                    .addComponent(btnEnviar,50, 355, 400)
                                    .addGap(50)
                    )
    );
    gl.setVerticalGroup(
            gl.createSequentialGroup()
                    .addComponent(lblBienvenida, 50, 144, 150)
                    .addGroup(
                            gl.createParallelGroup()
                                    .addComponent(lblNombre,50, 96, 100)
                                    .addComponent(txtNombre, 50, 96, 100)
                    )
                    .addGroup(
                            gl.createParallelGroup()
                                    .addComponent(lblRegistro, 50, 96, 100)
                                    .addComponent(txtRegistro, 50, 96, 100)
                    )
                    .addGap(100)
                    .addGroup(
                            gl.createSequentialGroup()
                                    .addComponent(btnEnviar, 50, 100, 150)
                    )
                    .addGap(35)
    );
    setLayout(gl);

    btnEnviar.setBackground(Color.decode("#1a7d45"));
    btnEnviar.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            btnEnviar.setBackground(Color.decode("#2de07a"));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnEnviar.setBackground(Color.decode("#1a7d45"));
        }
    });

    setSize(500, 600);
    setLocationRelativeTo(null);

    //endregion
    //si se presiona el boton
    btnEnviar.addActionListener(e -> accionBoton());
    //region Press_Enter
    btnEnviar.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                accionBoton();
            }
        }
    });
    //endregion
}

public void accionBoton(){
    if(observer!=null){
        observer.updateText(txtNombre.getText(), txtRegistro.getText());
    }
    BaseDeDatos bd = new BaseDeDatos();
    bd.AgregarDatos(txtNombre.getText(), txtRegistro.getText());
    txtNombre.setText("");
    txtRegistro.setText("");

}

public void addObserver(TextObserver observer){
    this.observer=observer;
}
}
