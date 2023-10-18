package Ventanas;

import Base.BaseDeDatos;
import Materials.CButton;
import Materials.CLabels;
import Materials.CTextField;
import Models.DatosUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Modificar extends JFrame {
    JLabel lblBienvenida;
    CLabels lblId, lblNombre, lblRegistro;
    CTextField txtNombre, txtRegistro;
    CButton btnIzquierda, btnDerecha, btnGuardar;
    JButton btnEliminar;
    BaseDeDatos BD = new BaseDeDatos();
    List<DatosUsuario> datos;
    DatosUsuario datoMostrar;
    int navegador=0;
    public Modificar(){
        super("Ventanita para Modificar");
        metodo();
    }
    void metodo(){
        datos = BD.LeerTodosLosDatos();
        lblBienvenida = new JLabel("Bienvenido, editaremos tus datos", SwingConstants.CENTER);
        lblId = new CLabels();
        lblNombre=new CLabels("Nombre:");
        lblRegistro = new CLabels("Registro:");
        txtNombre = new CTextField(40);
        txtRegistro = new CTextField(8);
        btnIzquierda= new CButton("<");
        btnDerecha=new CButton(">");
        btnGuardar = new CButton("Guardar");
        btnEliminar = new JButton("DEL");
        btnEliminar.setBackground(Color.red);
        btnEliminar.setForeground(Color.WHITE);

        lblBienvenida.setFont(new Font("Serif", Font.PLAIN, 37));

        if(datos.isEmpty()){
            lblId.setText("NO HAY NADA");
        }else{
            datoMostrar = datos.get(navegador);
            lblId.setText("ID: " + datoMostrar.getId());
            txtNombre.setText(datoMostrar.getNombre());
            txtRegistro.setText(datoMostrar.getRegistro());
        }

        GroupLayout gl = new GroupLayout(getContentPane());
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addComponent(lblId)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblRegistro)
                                        .addComponent(txtRegistro)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(btnIzquierda)
                                        .addComponent(btnGuardar)
                                        .addComponent(btnDerecha)
                        )
                        .addGap(40)
                        .addComponent(btnEliminar)
                        .addGap(40)
        );

        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addComponent(lblId)
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblRegistro)
                                        .addComponent(txtRegistro)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnIzquierda)
                                        .addComponent(btnGuardar)
                                        .addComponent(btnDerecha)
                        )
                        .addComponent(btnEliminar)
        );
        setLayout(gl);
        setSize(600, 300);
        setLocationRelativeTo(null);

        btnIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datos = BD.LeerTodosLosDatos();
                if(!datos.isEmpty()){
                    if(navegador != 0){
                        navegador--;
                    }else{
                        navegador= datos.size() -1;
                    }
                    datoMostrar = datos.get(navegador);
                    updateTextField();
                }
            }
        });
        btnDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datos = BD.LeerTodosLosDatos();
                if(!datos.isEmpty()){
                    if(navegador != (datos.size()-1)){
                        navegador++;
                    }else{
                        navegador=0;
                    }
                    datoMostrar = datos.get(navegador);
                    updateTextField();
                }
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!datos.isEmpty()){
                    boolean res = BD.actualizarDatos(datoMostrar.getId(), txtNombre.getText(), txtRegistro.getText());
                    if(res){
                        System.out.println("Se ejecutó la actualizacion");
                    }else{
                        System.out.println("No se ejecutó la actualización");
                    }
                    datos = BD.LeerTodosLosDatos();
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!datos.isEmpty()){
                    BD.borrarDato(datoMostrar.getId());
                    datos = BD.LeerTodosLosDatos();
                    if(datos.isEmpty()){

                    }else{
                        datoMostrar = datos.get(navegador);
                        updateTextField();
                    }
                }
            }
        });
    }

    void updateTextField(){
        lblId.setText("ID: " + datoMostrar.getId());
        txtNombre.setText(datoMostrar.getNombre());
        txtRegistro.setText(datoMostrar.getRegistro());
    }
}
