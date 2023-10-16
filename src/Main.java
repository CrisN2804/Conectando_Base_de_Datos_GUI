public class Main {
    public static void main(String[] args) {
        Formulario x = new Formulario();
        x.setVisible(true);
        x.addObserver(new TextObserver() {
            @Override
            public void updateText(String nombre, String registro) {
                //>>>>>>>>>>>desde aqui manipular los datos de nombre y registro<<<<<<
                System.out.println("——————Se presionó el boton——————");
                System.out.println("Nombre captado: " + nombre);
                System.out.println("Registro captado: " + registro);
                System.out.println("——————————————————————————————");
            }
        });
    }
}