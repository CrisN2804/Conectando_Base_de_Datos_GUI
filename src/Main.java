import Base.BaseDeDatos;
import Models.DatosUsuario;
import Ventanas.ChooseOptions;
import Ventanas.Formulario;
import Ventanas.Modificar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChooseOptions chooseOptions = new ChooseOptions();
        chooseOptions.setVisible(true);
    }
}

//region OBSERVER
        /*
        String nom, reg;
        x.addObserver(new Ventanas.TextObserver() {
            @Override
            public void updateText(String nombre, String registro) {
                //>>>>>>>>>>>desde aqui manipular los datos de nombre y registro<<<<<<
                System.out.println("——————Se presionó el boton——————");
                System.out.println("Nombre captado: " + nombre);
                System.out.println("Registro captado: " + registro);
                System.out.println("——————————————————————————————");
            }
        });
         */
//endregion

//region PrintAll
/*
BaseDeDatos BD = new BaseDeDatos();
List<DatosUsuario> respuesta = BD.LeerTodosLosDatos();
        for (DatosUsuario fila : respuesta) {
            Auxiliares.ImprimirColumnasDeFila(fila.getId(), fila.getNombre(), fila.getRegistro());
        }
*/
//endregion

//Use Material Design