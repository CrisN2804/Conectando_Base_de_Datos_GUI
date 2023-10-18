package Base;

import Models.DatosUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
        Connection con;
        public BaseDeDatos(){
                try{
                        /*
                                cj es para la version mas nueva. a veces puede estar como mysql.com
                        */
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection(
                                "jdbc:mysql://localhost/formulariojava" ,
                                "root" ,
                                "");

                }catch(ClassNotFoundException e) {

                }catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        public void AgregarDatos(String nombre, String registro){
                PreparedStatement sql;
                try {
                        sql = con.prepareStatement("insert into datosusuario(Nombre, Registro) " +
                                "values(?,?)");
                        sql.setString(1, nombre);
                        sql.setString(2, registro);
                        sql.executeUpdate();
                        sql.close();
                }catch(SQLException e){
                        System.out.println(e.getMessage());
                }
        }

        public List<DatosUsuario> LeerTodosLosDatos(){
                PreparedStatement sql;
                ResultSet rs;
                List<DatosUsuario> respuesta = new ArrayList<>();
                try{
                        sql = con.prepareStatement("select * from datosusuario");
                        rs = sql.executeQuery();
                        while(rs.next()){
                                int id = rs.getInt("ID_Usuario");
                                String nombre = rs.getString("Nombre");
                                String registro = rs.getString("Registro");
                                respuesta.add(new DatosUsuario(id, nombre, registro));
                        }
                        sql.close();
                }catch(SQLException e){
                        System.out.println(e.getMessage());
                }
                return respuesta;
        }

        public DatosUsuario LeerDato(int id){
                PreparedStatement sql;
                ResultSet rs;
                DatosUsuario respuesta = null;
                try{
                        sql = con.prepareStatement("select * from datosusuario where ID_Usuario=?");
                        sql.setInt(1, id);
                        rs = sql.executeQuery();
                        while(rs.next()){
                                String nombre = rs.getString("Nombre");
                                String registro = rs.getString("Registro");
                                respuesta =new DatosUsuario(id, nombre, registro);
                        }
                        sql.close();
                }catch(SQLException e){
                        System.out.println(e.getMessage());
                }
                return respuesta;
        }

        public boolean actualizarDatos(int id, String nombre, String registro){
                PreparedStatement sql;
                int rs=0;
                try{
                        sql = con.prepareStatement("update datosusuario " +
                                "set Nombre=?, Registro=? where ID_Usuario=?");
                        sql.setString(1, nombre);
                        sql.setString(2, registro);
                        sql.setInt(3, id);
                        rs = sql.executeUpdate();
                        sql.close();
                        System.out.println("Se actualizó con los datos...");
                        System.out.println("ID: " + id);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Registro: " + registro);
                }catch(SQLException e){
                        System.out.println(e.getMessage());
                }
                return rs==1;
        }
}
