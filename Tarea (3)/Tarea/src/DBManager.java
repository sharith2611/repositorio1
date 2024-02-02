import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBManager implements AutoCloseable {

   
   private Connection connection;
    public DBManager() throws SQLException {
        connect();
    }
    

    private void connect() throws SQLException {
       
    String url="jdbc:mysql://localhost:3306/aereolinea?severTimezone=UTC";
    String user="root";
    String passoword="S3n42023*";
    connection= DriverManager.getConnection(url,user,passoword);
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
        connection = null;
        
    }

    public boolean agregarVuelo(String numeroDeVuelo,String Aereolinea,String horaSalida,String destino,String capacidadMaxima, String disponible,String aereopuertoPartida,String aereopuertoLlegada){
       try {
        int idAereopuertoPartida=Integer.parseInt(aereopuertoPartida);
        int idAereopuertoLlegada=Integer.parseInt(aereopuertoLlegada);
        int Disponible=Integer.parseInt(disponible);
        int CapacidadMaxima=Integer.parseInt(capacidadMaxima);
        int numeroDeVuelo1=Integer.parseInt(numeroDeVuelo);
        String sql="INSERT INTO Vuelos ( numeroVuelo,aereolinea,horaDeSalida,destino,capacidadMaxima,disponible,aereopuertoLlegada,aereopuertoPartida) VALUES(?,?,?,?,?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, numeroDeVuelo1);
            statement.setString(2, Aereolinea);
            statement.setString(3, horaSalida);
            statement.setString(4, destino);
            statement.setInt(5, CapacidadMaxima);
            statement.setInt(6, Disponible);
            statement.setInt(7, idAereopuertoPartida);
            statement.setInt(8, idAereopuertoLlegada);
            statement.executeUpdate();

        }
        
       } catch (SQLException ex) {
        System.out.println(ex.getCause());
        System.out.println(ex.toString());
        System.out.println(ex.getMessage());
        System.out.println(ex.getSQLState());
         return false;
       }
        return true;
    }

    public boolean agregarAereopuerto(String idAerepuerto,String nombre,String ubicacion){
         int idAereopuerto1= Integer.parseInt(idAerepuerto);
        try {
        String sql="INSERT INTO aereopuertos ( idAereopuertos,nombreAereopuerto,ubicacion) VALUES(?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, idAereopuerto1);
            statement.setString(2, nombre);
            statement.setString(3, ubicacion);
            statement.executeUpdate();
            return true;
           

        }
        
       } catch (SQLException ex) {
        System.out.println(ex.getCause());
        System.out.println(ex.toString());
        System.out.println(ex.getMessage());
        System.out.println(ex.getSQLState());
         return false;
       }
        
    }

    public ArrayList<ArrayList<String>> listarAereopuertos(){
        String sql = "SELECT * FROM aereopuertos";
        ArrayList<ArrayList<String>>datos=new ArrayList<>();

            try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

    

                while (resultSet.next()) {
                    ArrayList <String> dato=new ArrayList<>();
                    int id = resultSet.getInt("idAereopuertos");
                    String Nombre = resultSet.getString("nombreAereopuerto");
                    String ubicacion= resultSet.getString("ubicacion");

                    dato.add(String.valueOf(id));
                    dato.add(Nombre);
                    dato.add(ubicacion);

                    datos.add(dato);
                     
                
                }

                return datos;
             

            }
             catch (Exception e) {
                return datos;
            }
    

    }


    public ArrayList <String> buscarProducto(String idAereopuerto){
        StringBuilder mensaje=null;
       
        ArrayList <String> datos=new ArrayList<>();
        
        try {
            String sql= "SELECT* FROM aereopuertos WHERE idAereopuertos=?";
            try (PreparedStatement statement=connection.prepareStatement(sql)){
             int idAereopuerto1=Integer.parseInt(idAereopuerto);
            statement.setInt(1,idAereopuerto1);
            ResultSet rs=statement.executeQuery();

           
            while (rs.next()) {
               
                String idProducto=String.valueOf(rs.getInt("idAereopuertos"));
                datos.add(idProducto);
              
               
                String Nombre= rs.getString("nombreAereopuerto");
                datos.add(Nombre);
                System.out.println(datos);

                String ubicacion=rs.getString("ubicacion");
                datos.add(ubicacion);
              
            }
            System.out.println(datos);
            
            }  
        } catch (Exception ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.toString());
            System.out.println(ex.getMessage());
            
        }
        return datos;
    }

    public boolean actualizarAereopuerto(String idAereopuerto,String nombre, String ubicacion){
        try {
            String sql="UPDATE aereopuertos SET nombreAereopuerto=?, ubicacion=? WHERE idAereopuertos=?";
            int id=Integer.parseInt(idAereopuerto);
            try(PreparedStatement statement= connection.prepareStatement(sql)){
                statement.setString(1, nombre);
                statement.setString(2, ubicacion);
                statement.setInt(3, id);
                statement.executeUpdate();

            }
           

        } catch (SQLException ex) {
           System.out.println(ex.getCause());
           System.out.println(ex.toString());
           System.out.println(ex.getMessage());
           System.out.println(ex.getSQLState());
            return false;
        }
        return true;
        
    }

    public boolean eliminarAereopuerto(String id){
    int idAereopuerto=Integer.parseInt(id);
    try {
        String sql="DELETE  FROM aereopuertos WHERE idAereopuertos=?";
        try(PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setInt(1, idAereopuerto);
            statement.executeUpdate();
            return true;

        }

        
    } catch (Exception ex) {
        System.out.println(ex.getCause());
        System.out.println(ex.toString());
        System.out.println(ex.getMessage());
        return false;
    }
}

    public ArrayList <ArrayList<String>> buscarVuelo(String idVuelo){
 
   
    ArrayList <ArrayList<String>> datos=new ArrayList<>();
    
    try {
        String sql= "SELECT* FROM vuelos WHERE numeroVuelo=?";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
         int idVuelo1=Integer.parseInt(idVuelo);
        statement.setInt(1,idVuelo1);
        ResultSet rs=statement.executeQuery();

       
        while (rs.next()) {
            ArrayList <String> conjunto=new ArrayList<>();
            String idProducto=String.valueOf(rs.getInt("numeroVuelo"));
            conjunto.add(idProducto);
    
            String aereolinea= rs.getString("aereolinea");
            conjunto.add(aereolinea);

            String horaSalida= rs.getString("horaDeSalida");
            conjunto.add(horaSalida);
     
            String destino=rs.getString("destino");
            conjunto.add(destino);
        
            String capacidadMaxima= rs.getString("capacidadMaxima");
            conjunto.add(capacidadMaxima);

            String AereopuertoSalida= rs.getString("aereopuertoPartida");
            conjunto.add(AereopuertoSalida);
            
            String AereopuertoLlegada= rs.getString("aereopuertoLlegada");
            conjunto.add(AereopuertoLlegada);
           

            String disponible=rs.getString("disponible");
            conjunto.add(disponible);
            datos.add(conjunto);
            
           

        }
        System.out.println(datos);
        return datos;
       
        
        }  
    } catch (Exception ex) {
        System.out.println(ex.getCause());
        System.out.println(ex.toString());
        System.out.println(ex.getMessage());
        return datos;
        
    }
    
    
}

    public boolean actualizarVuelo(String numeroDeVuelo,String Aereolinea,String horaSalida,String destino,String capacidadMaxima, String disponible,String aereopuertoPartida,String aereopuertoLlegada){
        try {
            String sql="UPDATE vuelos SET aereolinea=?,horaDeSalida=?,destino=?,capacidadMaxima=?,aereopuertoPartida=?,aereopuertoLLegada=? WHERE numeroVuelo=?";
            int id=Integer.parseInt(numeroDeVuelo);
            try(PreparedStatement statement= connection.prepareStatement(sql)){
                statement.setString(1, Aereolinea);
                statement.setString(2, horaSalida);
                statement.setString(3, destino);
                statement.setString(4,capacidadMaxima);
                statement.setString(5,disponible);
                statement.setString(6,aereopuertoPartida);
                statement.setString(7,aereopuertoLlegada);
                statement.setInt(7, id);
                statement.executeUpdate();

            }
           

        } catch (SQLException ex) {
           System.out.println(ex.getCause());
           System.out.println(ex.toString());
           System.out.println(ex.getMessage());
           System.out.println(ex.getSQLState());
            return false;
        }
        return true;
        
    }
    
    public ArrayList<ArrayList<String>> listarVuelos(){
        String sql = "SELECT * FROM vuelos";
        ArrayList<ArrayList<String>>datos=new ArrayList<>();

            try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

    

                while (resultSet.next()) {
                    ArrayList <String> dato=new ArrayList<>();
                    int id = resultSet.getInt("numeroVuelo");
                    String aereolinea=resultSet.getString("aereolinea");
                    String horaSalida = resultSet.getString("horaDeSalida");
                    String destino= resultSet.getString("destino");
                    String capacidadMaxima=resultSet.getString("capacidadMaxima");
                    String aereopuertoPartida=resultSet.getString("aereopuertoPartida");
                    String aereopuertoLlegada=resultSet.getString("aereopuertoLLegada");
                    String disponible=resultSet.getString("disponible");



                    dato.add(String.valueOf(id));
                    dato.add(aereolinea);
                    dato.add(horaSalida);
                    dato.add(destino);
                    dato.add(capacidadMaxima);
                    dato.add(aereopuertoPartida);
                    dato.add(aereopuertoLlegada);
                    dato.add(disponible);


                    datos.add(dato);
                     
                
                }
                System.out.println(datos);

                return datos;
               
            }
             catch (Exception ex) {
                System.out.println(ex.getCause());
                System.out.println(ex.toString());
                System.out.println(ex.getMessage());

                return datos;
            }
    

    }

    public boolean eliminarVuelo(String id){
        try {
            String sql="DELETE FROM vuelos WHERE numeroVuelo=?";
            int numero=Integer.parseInt(id);
            try(PreparedStatement statement= connection.prepareStatement(sql)){
                statement.setInt(1, numero);
                statement.executeUpdate();
                
    
            }
           
    
        } catch (SQLException ex) {
           System.out.println(ex.getCause());
           System.out.println(ex.toString());
           System.out.println(ex.getMessage());
           System.out.println(ex.getSQLState());
            return false;
        }
        return true;
    }

    public boolean agregarPasajero(String pasaporte,String nombre, String equipaje){
        try {
            String sql="INSERT INTO pasajeros (nombre,numeroDePasaporte,cantidadDeEquipaje)VALUES(?,?,?)";
            int equipaje1=Integer.parseInt(equipaje);
            try(PreparedStatement statement= connection.prepareStatement(sql)){
                statement.setString(1, nombre);
                statement.setString(2, pasaporte);
                statement.setInt(3, equipaje1);
                statement.executeUpdate();
                
    
            }
           
    
        } catch (SQLException ex) {
           System.out.println(ex.getCause());
           System.out.println(ex.toString());
           System.out.println(ex.getMessage());
           System.out.println(ex.getSQLState());
            return false;
        }
        return true;
    }

    public ArrayList<String> buscarPasajero(String id){
        ArrayList <String> datos=new ArrayList<>();
        
        try {
            String sql= "SELECT* FROM pasajeros WHERE numeroDePasaporte=?";
            try (PreparedStatement statement=connection.prepareStatement(sql)){
            
            statement.setString(1, id);
            ResultSet rs=statement.executeQuery();

           
            while (rs.next()) {
               
                String idPasajero=String.valueOf(rs.getInt("idPasajeros"));
                datos.add(idPasajero);
              
               
                String Nombre= rs.getString("nombre");
                datos.add(Nombre);
            

                String pasaporte=rs.getString("numeroDePasaporte");
                datos.add(pasaporte);

                String equipaje=rs.getString("cantidadDeEquipaje");
                datos.add(equipaje);

            
            }
            
            
            }  
        } catch (Exception ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.toString());
            System.out.println(ex.getMessage());
            
        }
        
        return datos;
    }

    public boolean eliminarPasajero(String id){
        try {
            String sql="DELETE FROM pasajeros WHERE numeroDePasaporte=?";
            try(PreparedStatement statement= connection.prepareStatement(sql)){
                statement.setString(1, id);
                statement.executeUpdate();
        
            }
           
    
        } catch (SQLException ex) {
           System.out.println(ex.getCause());
           System.out.println(ex.toString());
           System.out.println(ex.getMessage());
           System.out.println(ex.getSQLState());
            return false;
        }
        return true;
    }

    public ArrayList <ArrayList<String>> listarPasajeros(){
        String sql = "SELECT * FROM pasajeros";
        ArrayList<ArrayList<String>>datos=new ArrayList<>();

            try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

    

                while (resultSet.next()) {
                    ArrayList <String> dato=new ArrayList<>();
                    int id = resultSet.getInt("idPasajeros");
                    String pasaporte= resultSet.getString("numeroDePasaporte");
                    String nombre=resultSet.getString("nombre");
                    String equipaje= resultSet.getString("cantidadDeEquipaje");
                   



                    dato.add(String.valueOf(id));
                    dato.add(pasaporte);
                    dato.add(nombre);
                    dato.add(equipaje);
                

                    datos.add(dato);
                     
                
                }
                System.out.println(datos);

                return datos;
               
            }
             catch (Exception ex) {
                System.out.println(ex.getCause());
                System.out.println(ex.toString());
                System.out.println(ex.getMessage());

                return datos;
            }

    }
    
    public ArrayList<Vuelo>listarVueloCombox(){
      
            String sql = "SELECT * FROM vuelos";
            ArrayList<Vuelo>datos=new ArrayList<>();
    
                try (PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
    
        
    
                    while (resultSet.next()) {
                        
                        int id = resultSet.getInt("numeroVuelo");
                        String aereolinea=resultSet.getString("aereolinea");
                        String horaSalida = resultSet.getString("horaDeSalida");
                        String destino= resultSet.getString("destino");
                        String capacidadMaxima=resultSet.getString("capacidadMaxima");
                        int aereopuertoPartida=Integer.parseInt(resultSet.getString("aereopuertoPartida"));
                        int aereopuertoLlegada=Integer.parseInt(resultSet.getString("aereopuertoLLegada"));
                        String disponible=(resultSet.getString("disponible"));
                        
    
                        
                        datos.add(new Vuelo(id, aereolinea, horaSalida, destino, Integer.parseInt(disponible), aereopuertoPartida, aereopuertoPartida));
                    
                    }
                    System.out.println(datos);
    
                    return datos;
                   
                }
                 catch (Exception ex) {
                    System.out.println(ex.getCause());
                    System.out.println(ex.toString());
                    System.out.println(ex.getMessage());
    
                    return datos;
                }
        
    
        }
    
    public ArrayList<Pasajero> listarPasajeroCombox(){
        String sql = "SELECT * FROM pasajeros";
        ArrayList<Pasajero>datos=new ArrayList<>();

            try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

    

                while (resultSet.next()) {
                    
                    String nombre=resultSet.getString("nombre");
                    String pasaporte = resultSet.getString("numeroDePasaporte");
                    int equipaje= Integer.parseInt(resultSet.getString("cantidadDeEquipaje"));
                    

                    datos.add(new Pasajero(nombre, pasaporte, equipaje));
                
                }
                System.out.println(datos);

                return datos;
               
            }
             catch (Exception ex) {
                System.out.println(ex.getCause());
                System.out.println(ex.toString());
                System.out.println(ex.getMessage());

                return datos;
            }
    

    }
    
    public boolean reservarVuelos(Vuelo vuelo,Pasajero pasajero,String equipaje,double valorReserva){
        try {
            String sql="INSERT INTO reservas (Equipaje,Pasajeros_idPasajeros,valorReserva,Vuelos_numeroViuelo) VALUES (?,?,?,?)";
            String id=pasajero.getNumeroDePasaporte();
            ArrayList<String> pasajero1= buscarPasajero(id);
            try(PreparedStatement statement= connection.prepareStatement(sql)){
                statement.setInt(1, Integer.parseInt(equipaje));
                statement.setInt(2, Integer.parseInt(pasajero1.get(0)));
                statement.setDouble(3, valorReserva);
                statement.setInt(4, vuelo.getNumeroDeVuelo());
                statement.executeUpdate();
                descontarAsiento(vuelo);
                
    
            }
           
    
        } catch (SQLException ex) {
           System.out.println(ex.getCause());
           System.out.println(ex.toString());
           System.out.println(ex.getMessage());
           System.out.println(ex.getSQLState());
            return false;
        }
        return true;
    }

    public void descontarAsiento(Vuelo vuelo){
        try {
            String sql="UPDATE vuelos SET disponible=? WHERE numeroVuelo=?";
            try(PreparedStatement statement= connection.prepareStatement(sql)){
                statement.setInt(1, vuelo.getDisponible()-1);
                statement.setInt(2, vuelo.getNumeroDeVuelo());
                statement.executeUpdate();
                
    
            }
           
    
        } catch (SQLException ex) {
           System.out.println(ex.getCause());
           System.out.println(ex.toString());
           System.out.println(ex.getMessage());
           System.out.println(ex.getSQLState());
         
        }
    
    }

    public void mostrarReservas() {
        String sql = "SELECT * FROM reservas ";
        ArrayList<Vuelo>datos=new ArrayList<>();
        try{
            try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

                    DefaultTableModel tableModel = new DefaultTableModel();
                    JTable table = new JTable(tableModel);
    
                    tableModel.addColumn("Número de Vuelo");
                    tableModel.addColumn("Pasajero");
                    tableModel.addColumn("codigo Reserva");
                    tableModel.addColumn("Equipaje");
                    tableModel.addColumn("Valor Reserva");
                    while (resultSet.next()) {
                        int numeroVuelo = resultSet.getInt("Vuelos_numeroViuelo");
                        int numeroAsiento = resultSet.getInt("Pasajeros_idPasajeros");
                        int pasaporte = resultSet.getInt("codigoReserva");
                        int equipaje=resultSet.getInt("equipaje");
                        double precio=resultSet.getDouble("ValorReserva");

    
                        tableModel.addRow(new Object[]{numeroVuelo, numeroAsiento, pasaporte,equipaje, precio});
                    }
    
                    JFrame frame = new JFrame("Reservas");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    frame.add(new JScrollPane(table), BorderLayout.CENTER);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
      
    }
}





    
    

