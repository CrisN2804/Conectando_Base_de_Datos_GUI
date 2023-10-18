package Ventanas;

import Materials.CButton;
import Materials.CLabels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseOptions extends JFrame {
    CButton btnAgregar, btnModificar;
    CLabels lblMensaje;
    Formulario wdwAgregar = new Formulario();
    Modificar wdwModificar = new Modificar();
    public ChooseOptions(){
        super("Task Selector");
        metodo();
    }
    void metodo(){
        btnAgregar = new CButton("Agregar");
        btnModificar = new CButton("Modificar");
        lblMensaje = new CLabels("Elige qué quieres hacer");

        GroupLayout gl = new GroupLayout(getContentPane());
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblMensaje)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(btnAgregar)
                                        .addComponent(btnModificar)
                        )
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addComponent(lblMensaje)
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnAgregar)
                                        .addComponent(btnModificar)
                        )
        );
        setLayout(gl);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wdwAgregar.setVisible(true);
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wdwModificar.setVisible(true);
            }
        });
    }
}
