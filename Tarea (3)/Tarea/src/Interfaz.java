
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class Interfaz extends JFrame  implements ActionListener {
    private JPanel contenidoImagen,ventana,panelAggAereopuerto,panelIngresar, panelActualizarAereopuerto,panelEliminarAereopuerto,panelActualizarVuelo,panelEliminarVuelo,panelAgregarPasajero,panelEliminarPasajero;
    private JTextField  codigoReservaField,valorReserField,numeroPasaporteField,nombrePasajeroField,numeroDeEquipajeField,idpasajeroField,disponibleField, nombreAereolineaField, ubicacionField, 
    idAereopuertoField, nombreAereopuertoField, numeroVueloField,horaDeSalidaField,destinoField,capacidadMaximaField,llegadaField,partidaField;
    private JLabel Imagen,labelcodigoReserva,labelValorReserva,labelNumeroPasaporte,labelnombrePasajero,labelnumeroEquipaje,labelidPasajero, labeldisponible,labelNombreAereolinea,labelUbicacion, nombreAereopuerto,idAereopuerto, labelNumeroDeVuelo,labelHoraDeSalida,labelDestino,labelCapacidadMaxima,labelLlegada,labelPartida;
    private JMenuBar barra;
    private JMenu menuAereopuerto,menuPasajero,menuVuelo,menuAtencion;
    private JMenuItem item2Atencion,item1Atencion,item1aereopuerto, item2aereopuerto,item3aereopuerto,item4aereopuerto,item1Pasajero,item2Pasajero,item1Vuelo,item2Vuelo,item3Vuelo,item4Vuelo,item3Pasajero;
    private JButton actualizarButton , agregar,consultarButton,eliminarButton,reservarButton;
    private JFrame framereservar;
    
    ImageIcon icono;
    

    public Interfaz() {

        setTitle("Interfaz Vuelos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120,600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        //this.getContentPane().setBackground(Color.pink);

        contenidoImagen=new JPanel();
        contenidoImagen.setLayout(null);
        contenidoImagen.setVisible(false);
        ImageIcon icono=new ImageIcon("C:\\Users\\ADSI\\Downloads\\Tarea (3)\\Tarea\\descarga (2).png");
        Imagen=new JLabel(icono);
        contenidoImagen.add(Imagen);
        contenidoImagen.setBounds(-10,50,205,500);
        Imagen.setBounds(-100,0,400,700);
        add(contenidoImagen);

        ventana=new JPanel();
            add(ventana); 
            ventana.setLayout(null);
            ventana.setBounds(0,50,1100,500);
            ventana.setVisible(true);
        
            JLabel bienvenida=new JLabel("Aereolinea");
            bienvenida.setFont(new Font("Tahoma", Font. BOLD, 20));
            bienvenida.setBounds(500,0,500,520);
            ventana.add(bienvenida);
            
            //ventana.setBackground(Color.pink);
            ImageIcon icono1=new ImageIcon("C:\\Users\\ADSI\\Downloads\\Tarea (3)\\Tarea\\Sin_título1.jpg");
            JLabel Imagen1=new JLabel(icono1);
            Imagen1.setBounds(0,0,1200,500);
            ventana.add(Imagen1);
            
           

        barra= new JMenuBar();
        menuAereopuerto=new JMenu("Aereopuerto");
        item1aereopuerto=new JMenuItem("Agregar aereopuerto");
        item1aereopuerto.addActionListener(this);
        menuAereopuerto.add(item1aereopuerto);

        item2aereopuerto=new JMenuItem("Actualizar aereopuerto");
        item2aereopuerto.addActionListener(this);
        menuAereopuerto.add(item2aereopuerto);

        item3aereopuerto=new JMenuItem("Listar aereopuertos");
        menuAereopuerto.add(item3aereopuerto);
        item3aereopuerto.addActionListener(this);

        item4aereopuerto=new JMenuItem("Eliminar aereopuertos");
        menuAereopuerto.addActionListener(this);
        item4aereopuerto.addActionListener(this);
        menuAereopuerto.add(item4aereopuerto);


        menuVuelo= new JMenu("Vuelo");
         item1Vuelo=new JMenuItem("Agregar vuelo");
         item1Vuelo.addActionListener(this);
         menuVuelo.add(item1Vuelo);

         item2Vuelo=new JMenuItem("Actualizar vuelo");
         item2Vuelo.addActionListener(this);
         menuVuelo.add(item2Vuelo);

         item3Vuelo=new JMenuItem("Listar vuelo");
         item3Vuelo.addActionListener(this);
         menuVuelo.add( item3Vuelo);

         item4Vuelo=new JMenuItem("Eliminar vuelo");
         item4Vuelo.addActionListener(this);
         menuVuelo.add(item4Vuelo);
        

        menuPasajero=new JMenu("Pasajero");
          item1Pasajero=new JMenuItem("Agregar pasajero");
          item1Pasajero.addActionListener(this);
          menuPasajero.add(item1Pasajero);

         item2Pasajero=new JMenuItem("Listar pasajero");
         item2Pasajero.addActionListener(this);
         menuPasajero.add(item2Pasajero);

         item3Pasajero=new JMenuItem("Eliminar Pasajero");
         item3Pasajero.addActionListener(this);
         menuPasajero.add(item3Pasajero);
        
        menuAtencion=new JMenu("Atencion");
         item1Atencion=new JMenuItem("Reservar Vuelo");
         item1Atencion.addActionListener(this);
         menuAtencion.add(item1Atencion);

         item2Atencion=new JMenuItem("listar Reservas");
         item2Atencion.addActionListener(this);
         menuAtencion.add(item2Atencion);

        
        barra.add(menuAereopuerto);
        barra.add(menuVuelo);
        barra.add(menuPasajero);
        barra.add(menuAtencion);
        barra.setBounds(1, 0, 1500, 50);      
        add(barra);

        panelIngresar=new JPanel();
            panelIngresar.setLayout(null);
            panelIngresar.setBounds(200,150,1200,500);
            labelNumeroDeVuelo=new JLabel("Numero de vuelo");
            labelNumeroDeVuelo.setBounds(25,5,100,30);
            panelIngresar.add(labelNumeroDeVuelo);
            panelIngresar.setVisible(false);   
            add(panelIngresar);    
             
           

        
        panelAggAereopuerto=new JPanel();
            panelAggAereopuerto.setLayout(null);
            panelAggAereopuerto.setBounds(150,150,1200,500);
            panelAggAereopuerto.setVisible(false);
            add(panelAggAereopuerto);
            
            
        panelActualizarAereopuerto=new JPanel();
            panelActualizarAereopuerto.setLayout(null);
            panelActualizarAereopuerto.setBounds(150,150,1200,500);
            panelActualizarAereopuerto.setVisible(false);
            
        
          
            add(panelActualizarAereopuerto);

        panelEliminarAereopuerto=new JPanel();
            panelEliminarAereopuerto.setLayout(null);
            panelEliminarAereopuerto.setBounds(150,150,1200,500);
            panelEliminarAereopuerto.setVisible(false);
            add( panelEliminarAereopuerto);


        panelActualizarVuelo=new JPanel();
            panelActualizarVuelo.setLayout(null);
            panelActualizarVuelo.setBounds(200,150,1200,500);
            panelActualizarVuelo.setVisible(false);
            add(panelActualizarVuelo);
        
        panelEliminarVuelo=new JPanel();
            panelEliminarVuelo.setLayout(null);
            panelEliminarVuelo.setBounds(200,150,1200,500);
            panelEliminarVuelo.setVisible(false);
            add(panelEliminarVuelo); 
            
        panelAgregarPasajero=new JPanel();
            panelAgregarPasajero.setLayout(null);
            panelAgregarPasajero.setBounds(200,150,1200,500);
            panelAgregarPasajero.setVisible(false);
            add(panelAgregarPasajero); 

        panelEliminarPasajero=new JPanel();
            panelEliminarPasajero.setLayout(null);
            panelEliminarPasajero.setBounds(370,150,1200,500);
            panelEliminarPasajero.setVisible(false);
            add(panelEliminarPasajero); 




           

            




        }
            
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==item1aereopuerto) {
            panelAgregarAereopuerto();
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            
            panelActualizarAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            contenidoImagen.setVisible(true);
           
        
        }   
        if (e.getSource()==item2aereopuerto) {
            panelActualizarAereopuerto();
        
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            contenidoImagen.setVisible(true);
         
           
            
           
        }

        if (e.getSource()==item3aereopuerto) {
            panelListarAereopuertos();
            
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            ventana.setVisible(false);
            contenidoImagen.setVisible(true);
            
        }
       if (e.getSource()==item4aereopuerto) {
           panelEliminarAereopuerto();
         
           panelAggAereopuerto.setVisible(false);
           panelIngresar.setVisible(false);
           panelActualizarAereopuerto.setVisible(false);
           panelActualizarVuelo.setVisible(false);
           panelEliminarVuelo.setVisible(false);
           panelAgregarPasajero.setVisible(false);
           panelEliminarPasajero.setVisible(false);
           ventana.setVisible(false);
           contenidoImagen.setVisible(true);
           panelActualizarAereopuerto.setVisible(false);
           
        } 

        if (e.getSource()==item1Vuelo) {
            panelCrearVuelo();
            
            panelAggAereopuerto.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            contenidoImagen.setVisible(true);
            panelActualizarAereopuerto.setVisible(false);
          
        }
        if (e.getSource()==item2Vuelo) {
            PanelactualizaarVuelo();
           
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            contenidoImagen.setVisible(true);
            panelActualizarAereopuerto.setVisible(false);
        }
        if (e.getSource()==item3Vuelo) {
            listarVuelo();
         
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            contenidoImagen.setVisible(true);
        

        }
        if (e.getSource()==item4Vuelo) {
            panelEliminarVuelo();
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            ventana.setVisible(false);
            contenidoImagen.setVisible(true);
           

        }
        if (e.getSource()==item1Pasajero) {
            panelAgregarPasajero();
            
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            contenidoImagen.setVisible(true);
        }
        if (e.getSource()==item2Pasajero) {
            listarPasajeros();
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            contenidoImagen.setVisible(true);
        }
        if (e.getSource()==item3Pasajero) {
            panelEliminarPasajero();
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            ventana.setVisible(false);
            contenidoImagen.setVisible(true);
        }
        if (e.getSource()==item1Atencion) {
            ReservarVuelo();
          
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            contenidoImagen.setVisible(true);
        }
        if (e.getSource()==item2Atencion) {
            listarReservas();
            panelAggAereopuerto.setVisible(false);
            panelIngresar.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            panelEliminarAereopuerto.setVisible(false);
            panelActualizarVuelo.setVisible(false);
            panelEliminarVuelo.setVisible(false);
            panelAgregarPasajero.setVisible(false);
            panelEliminarPasajero.setVisible(false);
            ventana.setVisible(false);
            panelActualizarAereopuerto.setVisible(false);
            contenidoImagen.setVisible(true);
        }
    }





public void ingresar(){
  try (var manager=new DBManager()){
    boolean validacion=manager.agregarVuelo(numeroVueloField.getText(), nombreAereolineaField.getText(), 
   horaDeSalidaField.getText(), destinoField.getText(), capacidadMaximaField.getText(), disponibleField.getText(),partidaField.getText(),llegadaField.getText()); 
        if (validacion) {
            JOptionPane.showMessageDialog(this,"Vuelo agregado correctamente","Control",JOptionPane.ERROR_MESSAGE);
        }else{
             JOptionPane.showMessageDialog(this,"Vuelo no agergado","Error",JOptionPane.ERROR_MESSAGE);
        }
    
  } catch (Exception ex) {
    System.out.println("Excepción SQL: " + ex.getMessage());
  }


}

public void agregarAereopuerto(String id,String nombre, String ubucacion){
   try (var manager=new DBManager()){
       boolean validacion= manager.agregarAereopuerto(id,nombre,ubucacion);
        if (validacion) {
            JOptionPane.showMessageDialog(this,"Aereopuerto agregado correctamente","Control",JOptionPane.INFORMATION_MESSAGE);
        }else{
             JOptionPane.showMessageDialog(this,"Aereopuerto no agergado","Error",JOptionPane.ERROR_MESSAGE);
        }
    
  } catch (Exception ex) {
         ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
           
  }
}



 public void listarReservas(){
    try(var manager =new DBManager()) {
        manager.mostrarReservas();

        } catch (Exception e) {
            // TODO: handle exception
        }
    
}


 public void panelAgregarAereopuerto(){

            JLabel bienvenida=new JLabel("Crear Aereopuerto");
            bienvenida.setFont(new Font("Tahoma", Font. BOLD, 20));
            bienvenida.setBounds(350,0,300,30);
            panelAggAereopuerto.add(bienvenida);

            idAereopuerto=new JLabel("id");
            idAereopuerto.setBounds(260,50,100,30);
            panelAggAereopuerto.add(idAereopuerto);

            
            nombreAereopuerto=new JLabel("Nombre");
            nombreAereopuerto.setBounds(400,50,100,30);
            panelAggAereopuerto.add(nombreAereopuerto);        
            
            labelUbicacion=new JLabel("Ubicacion");
            labelUbicacion.setBounds(545,50,100,30);
            panelAggAereopuerto.add(labelUbicacion);

            
           JTextField idAereopuertoField1=new JTextField();
           idAereopuertoField1.setBounds(230,80,80,20);
            panelAggAereopuerto.add(idAereopuertoField1); 

            nombreAereopuertoField=new JTextField();
            nombreAereopuertoField.setBounds(345,80,150,20);
            panelAggAereopuerto.add(nombreAereopuertoField);

            ubicacionField=new JTextField();
            ubicacionField.setBounds(515,80,150,20);
            panelAggAereopuerto.add(ubicacionField);

            JButton buttonAgregarAereopuerto=new JButton("Agregar");
            buttonAgregarAereopuerto.setBounds(380,150,100,20);
            panelAggAereopuerto.add(buttonAgregarAereopuerto);
            buttonAgregarAereopuerto.addActionListener(e-> agregarAereopuerto(idAereopuertoField1.getText(),nombreAereopuertoField.getText(),ubicacionField.getText()));
            add(panelAggAereopuerto);
            panelAggAereopuerto.setVisible(true);

 } 


 public void panelCrearVuelo(){

    JLabel bienvenida=new JLabel("Crear Vuelo");
    bienvenida.setFont(new Font("Tahoma", Font. BOLD, 20));
    bienvenida.setBounds(350,0,200,30);
    panelIngresar.add(bienvenida);

    numeroVueloField=new JTextField(20);
    numeroVueloField.setBounds(20,50,100,20);
    panelIngresar.add(numeroVueloField);
    labelNumeroDeVuelo.setBounds(25,30,100,20);
    
    labelDestino= new JLabel("Destino");
    labelDestino.setBounds(190,30,80,20);
    panelIngresar.add(labelDestino);

    destinoField=new JTextField();
    destinoField.setBounds(140,50,150,20);
    panelIngresar.add(destinoField);

    labelHoraDeSalida= new JLabel("Hora de Salida");
    labelHoraDeSalida.setBounds(350,30,100,20);
    panelIngresar.add(labelHoraDeSalida);

    horaDeSalidaField=new JTextField();
    horaDeSalidaField.setBounds(320,50,150,20);
    panelIngresar.add(horaDeSalidaField);


    labelCapacidadMaxima=new JLabel("Capacidad maxima");
    labelCapacidadMaxima.setBounds(510,30,150,20);
    panelIngresar.add(labelCapacidadMaxima);
    
    capacidadMaximaField=new JTextField();
    capacidadMaximaField.setBounds(505,50,130,20);
    panelIngresar.add(capacidadMaximaField);


    labelLlegada=new JLabel("Aereopuerto llegada");
    labelLlegada.setBounds(180,80,120,20);
    panelIngresar.add(labelLlegada);
    llegadaField=new JTextField();
    llegadaField.setBounds(175,100,120,20); 
    panelIngresar.add(llegadaField);

    labelPartida=new JLabel("Aereopuerto partida");
    labelPartida.setBounds(680,30,120,20);
    panelIngresar.add(labelPartida);
    partidaField=new JTextField();
    partidaField.setBounds(675,50,120,20);
    panelIngresar.add(partidaField);


    labelNombreAereolinea=new JLabel("Aereolinea");
    labelNombreAereolinea.setBounds(365,80,160,20);
    panelIngresar.add(labelNombreAereolinea);

    nombreAereolineaField=new JTextField();
    nombreAereolineaField.setBounds(345,100,120,20);
    panelIngresar.add(nombreAereolineaField);


    labeldisponible=new JLabel("Disponibles");
    labeldisponible.setBounds(515,80,120,20);
    panelIngresar.add(labeldisponible);


    disponibleField= new JTextField();
    disponibleField.setBounds(500,100,120,20);
    panelIngresar.add(disponibleField);




    agregar=new JButton("Agregar vuelo");
    agregar.setBounds(300,140,200,30);
    agregar.addActionListener(e->ingresar());
    panelIngresar.add(agregar);
    add(panelIngresar);
    panelIngresar.setVisible(true);
 }

 public void panelActualizarAereopuerto(){

     JLabel bienvenida=new JLabel("Actualizar Aereopuerto");
            bienvenida.setFont(new Font("Tahoma", Font. BOLD, 20));
            bienvenida.setBounds(290,0,300,30);
            panelActualizarAereopuerto.add(bienvenida);

    idAereopuerto=new JLabel("id");
    idAereopuerto.setBounds(390,50,50,50);
    
    JTextField idAereopuertoField1=new JTextField();
    idAereopuertoField1.setBounds(320,90,160,20);

    panelActualizarAereopuerto.add(idAereopuerto);
    panelActualizarAereopuerto.add(idAereopuertoField1);
   
    consultarButton=new JButton("buscar");
    consultarButton.addActionListener(e->cconsultarAereopuerto(idAereopuertoField1.getText(),"actualizar"));
    consultarButton.setBounds(320,280,160,20);
    panelActualizarAereopuerto.add(consultarButton);
    
   
    panelActualizarAereopuerto.setVisible(true);
    add(panelActualizarAereopuerto);

 }


public void cconsultarAereopuerto(String idAereopuertoField,String tipo){
         System.out.println(idAereopuertoField+"Holaa");
        try (var manager =new DBManager()){
            ArrayList <String> datos;
            
            
            datos=manager.buscarProducto(idAereopuertoField);
            System.out.println(datos);
            
            if (datos.size()!=0) {
                    nombreAereopuerto=new JLabel("Nombre");
                    nombreAereopuerto.setBounds(375, 120, 100, 20);
                   
            
                    labelUbicacion=new JLabel("Ubicacion");
                    labelUbicacion.setBounds(375, 200, 80, 20);
                    

                   nombreAereopuertoField=new JTextField(datos.get(1));
                   nombreAereopuertoField.setBounds(320,150, 160, 20);
                   nombreAereopuertoField.addActionListener(this);
   
                   
                   ubicacionField=new JTextField(datos.get(2));
                   ubicacionField.setBounds(320, 220, 160, 20);
                   ubicacionField.addActionListener(this);
                  
                 

                   if (tipo.equalsIgnoreCase("actualizar")) {
                    panelActualizarAereopuerto.add(nombreAereopuerto);
                    panelActualizarAereopuerto.add(labelUbicacion);
                    panelActualizarAereopuerto.add( nombreAereopuertoField); 
                    panelActualizarAereopuerto.add(ubicacionField);  

                
                   actualizarButton=new JButton("actualizar");
                   actualizarButton.addActionListener(e->actualizarAereopuerto(idAereopuertoField, nombreAereopuertoField.getText(),ubicacionField.getText()));
                   actualizarButton.setBounds(340,320,120,20);
                   panelActualizarAereopuerto.add(actualizarButton);
                   }else{

                    panelEliminarAereopuerto.add(nombreAereopuerto);
                    panelEliminarAereopuerto.add(labelUbicacion);
                    panelEliminarAereopuerto.add( nombreAereopuertoField); 
                    panelEliminarAereopuerto.add(ubicacionField);  
                    
                    eliminarButton=new JButton("Eliminar");
                    String id= idAereopuertoField;
                    eliminarButton.addActionListener(e-> eliminarAereopuerto(id));
                    eliminarButton.setBounds (360,320,120,20);
                    panelEliminarAereopuerto.add(eliminarButton);
                    
                   }

                  
                
    
            }else{
                JOptionPane.showMessageDialog(null,
                    "Aereopuerto no encontrado","Error",JOptionPane.ERROR_MESSAGE);



            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Excepción SQL: " + e.getMessage());

        }

    }

public void actualizarAereopuerto(String idAereopuerto,String nombreAereopuerto,String ubicacion){
        try {
            try (var manager=new DBManager()){
                boolean confirmacion=manager.actualizarAereopuerto(idAereopuerto,nombreAereopuerto,ubicacion);
                if (confirmacion) {
                    JOptionPane.showMessageDialog(null, "aereopuerto actualizado");
                   

                }else{
                    JOptionPane.showMessageDialog(null,
                    "aereopuerto no actualizado","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Excepción SQL: " + e.getMessage());
        }

    }

public void panelListarAereopuertos(){
    try(var manager =new DBManager()) {
        ArrayList <ArrayList<String>>datos= manager.listarAereopuertos();

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("IdAereopuertos");
        tableModel.addColumn("nombreAereopuerto");
        tableModel.addColumn("Ubicacion");
        for (ArrayList<String> arrayList : datos) {
            tableModel.addRow(new Object[]{arrayList.get(0), arrayList.get(1), arrayList.get(2)});
        }
       

        JFrame frame = new JFrame("Aereopuertos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    
    
}

public void panelEliminarAereopuerto(){
    idAereopuerto=new JLabel("id");
    idAereopuerto.setBounds(400,50,50,50);
    idAereopuertoField=new JTextField();
    idAereopuertoField.setBounds(340,80,160,20);
    panelEliminarAereopuerto.add(idAereopuerto);
    panelEliminarAereopuerto.add(idAereopuertoField);

    consultarButton=new JButton("buscar");
    consultarButton.addActionListener(e->cconsultarAereopuerto(idAereopuertoField.getText(),"Eliminar"));
    consultarButton.setBounds(360,180,160,20);
    panelEliminarAereopuerto.add(consultarButton);


    panelEliminarAereopuerto.setVisible(true);
    add(panelEliminarAereopuerto);

    
}


public void eliminarAereopuerto(String id){
    try (var manager = new DBManager()) {
       boolean validacion= manager.eliminarAereopuerto(id);
        if (validacion) {
            JOptionPane.showMessageDialog(null,
            "Aereopuerto Eliminado","control",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,
                    "Aereopuerto no eliminado","Error",JOptionPane.ERROR_MESSAGE);

        }
        
    } catch (Exception e) {
          e.printStackTrace();
         System.out.println("Excepción SQL: " + e.getMessage());
    }
}

public void buscarVuelo(String id,String tipo){

    try (var manager =new DBManager()){
        ArrayList <ArrayList<String>> datos=manager.buscarVuelo(id);
        ArrayList<String> dato=datos.get(0);
        
        datos=manager.buscarVuelo(id);
        System.out.println(datos);
        
     if (datos.size()!=0) {
            labelDestino= new JLabel("Destino");
            labelDestino.setBounds(25,150,80,20);
    
            destinoField=new JTextField(dato.get(3));
            destinoField.setBounds(0,170,150,20);
            
            

            labelHoraDeSalida= new JLabel("Hora de Salida");
            labelHoraDeSalida.setBounds(200,150,100,20);
            
            horaDeSalidaField=new JTextField(dato.get(2));
            horaDeSalidaField.setBounds(180,170,150,20);
           


            labelCapacidadMaxima=new JLabel("Capacidad maxima");
            labelCapacidadMaxima.setBounds(370,150,150,20);
            
            
            capacidadMaximaField=new JTextField(dato.get(4));
            capacidadMaximaField.setBounds(355,170,130,20);
    


            labelLlegada=new JLabel("Aereopuerto llegada");
            labelLlegada.setBounds(520,148,120,20);
            

            llegadaField=new JTextField(dato.get(6));
            llegadaField.setBounds(519,170,120,20); 
           

            labelPartida=new JLabel("Aereopuerto partida");
            
            labelPartida.setBounds(670,150,120,20);
            panelActualizarVuelo.add(labelPartida);
            partidaField=new JTextField(dato.get(5));
            partidaField.setBounds(665,170,120,20);
           

            labelNombreAereolinea=new JLabel("Aereolinea");
            labelNombreAereolinea.setBounds(255,200,120,20);
            

            nombreAereolineaField=new JTextField(dato.get(1));
            nombreAereolineaField.setBounds(245,230,120,20);
            


            labeldisponible=new JLabel("Disponibles");
            labeldisponible.setBounds(405,200,120,20);
           

            disponibleField= new JTextField(dato.get(7));
            disponibleField.setBounds(395,230,120,20);
           
            if (tipo.equalsIgnoreCase("actualizar")) {
                panelActualizarVuelo.add(disponibleField);
                panelActualizarVuelo.add(labeldisponible);
                panelActualizarVuelo.add(nombreAereolineaField);
                panelActualizarVuelo.add(partidaField);
                panelActualizarVuelo.add(llegadaField);
                panelActualizarVuelo.add(labelCapacidadMaxima);
                panelActualizarVuelo.add(horaDeSalidaField);
                panelActualizarVuelo.add(destinoField);
                panelActualizarVuelo.add(labelDestino);
                panelActualizarVuelo.add(labelNombreAereolinea);
                panelActualizarVuelo.add(capacidadMaximaField);
                panelActualizarVuelo.add(labelHoraDeSalida);
                panelActualizarVuelo.add(labelLlegada);
                actualizarButton=new JButton("actualizar");
                actualizarButton.addActionListener(e->actualizarVuelo());
                actualizarButton.setBounds(370,320,120,20);
                panelActualizarVuelo.add(actualizarButton);
             

            }if(tipo.equalsIgnoreCase("eliminar")){
                panelEliminarVuelo.add(disponibleField);
                panelEliminarVuelo.add(labeldisponible);
                panelEliminarVuelo.add(nombreAereolineaField);
                panelEliminarVuelo.add(partidaField);
                panelEliminarVuelo.add(llegadaField);
                panelEliminarVuelo.add(labelCapacidadMaxima);
                panelEliminarVuelo.add(horaDeSalidaField);
                panelEliminarVuelo.add(destinoField);
                panelEliminarVuelo.add(labelDestino);
                panelEliminarVuelo.add(labelNombreAereolinea);
                panelEliminarVuelo.add(capacidadMaximaField);
                panelEliminarVuelo.add(labelHoraDeSalida);
                panelEliminarVuelo.add(labelLlegada);
                eliminarButton=new JButton("Eliminar");
                eliminarButton.addActionListener(e->eliminarVuelo());
                eliminarButton.setBounds(370,320,120,20);
                panelEliminarVuelo.add( eliminarButton);
            }

           
            }

     } catch (Exception e) {
        // TODO: handle exception
     }


       
}
public void PanelactualizaarVuelo(){
    JLabel bienvenida=new JLabel("Actualizar Vuelo");
    bienvenida.setFont(new Font("Tahoma", Font. BOLD, 20));
    bienvenida.setBounds(350,0,200,30);
    panelActualizarVuelo.add(bienvenida);

    labelNumeroDeVuelo=new JLabel("Numero de vuelo");
    labelNumeroDeVuelo.setBounds(380,50,100,30);
    
    panelActualizarVuelo.add(labelNumeroDeVuelo);
   

    numeroVueloField=new JTextField(20);
    numeroVueloField.setBounds(375,80,100,20);


    panelActualizarVuelo.add(numeroVueloField);


    consultarButton=new JButton("consultar");
    consultarButton.setBounds(375,120, 100, 20);
    consultarButton.addActionListener(e->buscarVuelo(numeroVueloField.getText(),"Actualizar"));
    panelActualizarVuelo.add(consultarButton);
    panelActualizarVuelo.setVisible(true);
}

public void actualizarVuelo(){
    try(var manager = new DBManager()) {
       boolean validacion= manager.actualizarVuelo(numeroVueloField.getText(), nombreAereolineaField.getText(), 
        horaDeSalidaField.getText(), destinoField.getText(), capacidadMaximaField.getText(),partidaField.getText(),llegadaField.getText(),disponibleField.getText());
        if (validacion) {
            JOptionPane.showMessageDialog(null,
            "Vuelo actualizado","control",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,
                    "Vuelo no actualizado","Error",JOptionPane.ERROR_MESSAGE);

        }
    } catch (Exception e) {
        // TODO: handle exception
    }
}

public void listarVuelo(){
    try(var manager =new DBManager()) {
        ArrayList <ArrayList<String>>datos= manager.listarVuelos();

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table1 = new JTable(tableModel);
        tableModel.addColumn("numeroVuelo");
        tableModel.addColumn("aereolinea");
        tableModel.addColumn("horaDeSalida");
        tableModel.addColumn("destino");
        tableModel.addColumn("capacidad Maxima");
        tableModel.addColumn("Aereopuerto Partida");
        tableModel.addColumn("Llegada");
        tableModel.addColumn("Disponibilidad");

        for (ArrayList<String> arrayList : datos) {
            tableModel.addRow(new Object[]{arrayList.get(0), arrayList.get(1), arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7)});
        }
       

        JFrame frame1 = new JFrame("Vuelos");
        frame1.setSize(1,1);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
      
        frame1.add(new JScrollPane(table1), BorderLayout.CENTER);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    
}

public void panelEliminarVuelo(){

    JLabel bienvenida=new JLabel("Eliminar Vuelo");
    bienvenida.setFont(new Font("Tahoma", Font. BOLD, 20));
    bienvenida.setBounds(350,0,200,30);
    panelEliminarVuelo.add(bienvenida);

    labelNumeroDeVuelo=new JLabel("Numero de vuelo");
    labelNumeroDeVuelo.setBounds(380,50,100,30);
    panelEliminarVuelo.add(labelNumeroDeVuelo);
   
    numeroVueloField=new JTextField(20);
    numeroVueloField.setBounds(375,80,100,20);
    panelEliminarVuelo.add(numeroVueloField);

    consultarButton=new JButton("consultar");
    consultarButton.setBounds(375,120, 100, 20);
    consultarButton.addActionListener(e->buscarVuelo(numeroVueloField.getText(),"eliminar"));
    panelEliminarVuelo.add(consultarButton);
    panelEliminarVuelo.setVisible(true);
    
}
public void eliminarVuelo(){
    try (var manager=new DBManager()){
       boolean validacion= manager.eliminarVuelo(numeroVueloField.getText());
       if (validacion) {
        JOptionPane.showMessageDialog(null,
        "Vuelo eliminado","control",JOptionPane.ERROR_MESSAGE);
    }else{
        JOptionPane.showMessageDialog(null,
                "Vuelo no eliminado","Error",JOptionPane.ERROR_MESSAGE);

    }
    } catch (Exception e) {
        // TODO: handle exception
    }

}

public void panelAgregarPasajero(){
    
    labelNumeroPasaporte=new JLabel("No. Pasaporte");
    labelNumeroPasaporte.setBounds(200,50,100,20);
    panelAgregarPasajero.add(labelNumeroPasaporte);

    numeroPasaporteField=new JTextField();
    numeroPasaporteField.setBounds(190,80,110,20);
    panelAgregarPasajero.add(numeroPasaporteField);


    labelnombrePasajero=new JLabel("Nombre");
    labelnombrePasajero.setBounds(220,120,100,20);
    panelAgregarPasajero.add(labelnombrePasajero);

    nombrePasajeroField=new JTextField();
    nombrePasajeroField.setBounds(190,160,110,20);
    panelAgregarPasajero.add(nombrePasajeroField);
   
    labelnumeroEquipaje=new JLabel("Cantidad de equipaje");
    labelnumeroEquipaje.setBounds(190,190,120,20);
    panelAgregarPasajero.add(labelnumeroEquipaje);


    numeroDeEquipajeField=new JTextField();
    numeroDeEquipajeField.setBounds(190,230,110,20);
    panelAgregarPasajero.add(numeroDeEquipajeField);

    agregar=new JButton("Agregar");
    agregar.setBounds(195,330,100,20);
    agregar.addActionListener(e->agregarPasajero(numeroPasaporteField.getText(),nombrePasajeroField.getText(),numeroDeEquipajeField.getText()));
    panelAgregarPasajero.add(agregar);

    panelAgregarPasajero.setVisible(true);
}

public void agregarPasajero(String pasaporte,String nombre, String equipaje){
    try (var manager= new DBManager()){
        boolean validacion=manager.agregarPasajero(pasaporte,nombre,equipaje);
        if (validacion) {
            JOptionPane.showMessageDialog(null,
            "pasajero agregado","control",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,
                    "pasagero no agregado","Error",JOptionPane.ERROR_MESSAGE);
    
        }
    } catch (Exception e) {
        // TODO: handle exception
    }
}

public void panelEliminarPasajero(){
    labelNumeroPasaporte=new JLabel("No. Pasaporte");
    labelNumeroPasaporte.setBounds(200,50,100,20);
    panelEliminarPasajero.add(labelNumeroPasaporte);

    numeroPasaporteField=new JTextField();
    numeroPasaporteField.setBounds(190,80,110,20);
    panelEliminarPasajero.add(numeroPasaporteField);

    consultarButton=new JButton("Consultar");
    consultarButton.setBounds(200,120,100,20);
    consultarButton.addActionListener(e-> consultarPasajero(numeroPasaporteField.getText()));
    panelEliminarPasajero.add(consultarButton);
    panelEliminarPasajero.setVisible(true);

}

public void consultarPasajero(String id){
    try (var manager =new DBManager()){
        ArrayList <String> datos=manager.buscarPasajero(id);
      
        
    
        System.out.println(datos);
        
     if (datos.size()!=0) {
           
                labelnombrePasajero=new JLabel("Nombre");
                labelnombrePasajero.setBounds(220,150,100,20);
                panelEliminarPasajero.add(labelnombrePasajero);

                nombrePasajeroField=new JTextField(datos.get(1));
                nombrePasajeroField.setBounds(190,170,110,20);
                panelEliminarPasajero.add(nombrePasajeroField);
            
                labelnumeroEquipaje=new JLabel("Cantidad de equipaje");
                labelnumeroEquipaje.setBounds(190,200,120,20);
                panelEliminarPasajero.add(labelnumeroEquipaje);


                numeroDeEquipajeField=new JTextField(datos.get(3));
                numeroDeEquipajeField.setBounds(190,230,110,20);
                panelEliminarPasajero.add(numeroDeEquipajeField);


                eliminarButton=new JButton("Eliminar");
                eliminarButton.addActionListener(e->eliminarPasajero(id));
                eliminarButton.setBounds(195,330,100,20);
                panelEliminarPasajero.add( eliminarButton);

           
            }

     } catch (Exception e) {
        // TODO: handle exception
     }

    
}

public void eliminarPasajero(String id){
    try (var manager=new DBManager() ){
        boolean validacion =manager.eliminarPasajero(id);
        if (validacion) {
            JOptionPane.showMessageDialog(null,
            "pasajero eliminado","control",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,
                    "pasagero no eliminado","Error",JOptionPane.ERROR_MESSAGE);
    
        }
    } catch (Exception e) {
        
    }
}

public void listarPasajeros(){
    try(var manager =new DBManager()) {
        ArrayList <ArrayList<String>>datos= manager.listarPasajeros();

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table1 = new JTable(tableModel);
        tableModel.addColumn("idPasajeros");
        tableModel.addColumn("nombre");
        tableModel.addColumn("numeroDePasaporte");
        tableModel.addColumn("cantidadDeEquipaje");
      

        for (ArrayList<String> arrayList : datos) {
            tableModel.addRow(new Object[]{arrayList.get(0), arrayList.get(1), arrayList.get(2),arrayList.get(3)});
        }
       

        JFrame frame1 = new JFrame("Pasajeros");
        frame1.setSize(1,1);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
      
        frame1.add(new JScrollPane(table1), BorderLayout.CENTER);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
}

public void ReservarVuelo(){
    framereservar=new JFrame("Reservar");
    framereservar.setSize(600,700);
    framereservar.setLayout(null);
    framereservar.setLocationRelativeTo(null);
    framereservar.setVisible(true);
    
   
    try (var manager=new DBManager()){

        ArrayList<Vuelo>vuelos=manager.listarVueloCombox();
        ArrayList<Pasajero>pasajeros=manager.listarPasajeroCombox();
        JComboBox <Pasajero> comboPasajero=new JComboBox<>(pasajeros.toArray(new Pasajero[0]));
        JComboBox <Vuelo> comboVuelo=new JComboBox<>(vuelos.toArray(new Vuelo[0]));
        comboVuelo.setBounds(10,100,550,20);
        
        comboPasajero.setBounds(10,200,550,20);
        ventana=new JPanel();
        ventana.setSize(600,600);
        ventana.setVisible(true);
        ventana.setLayout(null);
        framereservar.add(ventana);



        ventana.add(comboVuelo);
        ventana.add(comboPasajero);
   

        labelNumeroDeVuelo=new JLabel("Vuelo: ");
        labelNumeroDeVuelo.setBounds(280,80,200,20);
        ventana.add(labelNumeroDeVuelo);

        labelidPasajero=new JLabel("Pasajero: ");
        labelidPasajero.setBounds(280,180,200,20);
        ventana.add(labelidPasajero);

        
        labelnumeroEquipaje=new JLabel("Equipaje");
        labelnumeroEquipaje.setBounds(280,250,100,20);
        ventana.add(labelnumeroEquipaje);

        numeroDeEquipajeField=new JTextField();
        numeroDeEquipajeField.setBounds(260,300,100,20);
        ventana.add(numeroDeEquipajeField);

        Vuelo vuelo=(Vuelo)comboVuelo.getSelectedItem();
        Pasajero pasajero=(Pasajero) comboPasajero.getSelectedItem();

        consultarButton=new JButton("Consultar");
        consultarButton.setBounds(260,350,100,20);
        consultarButton.addActionListener(e->calcularPrecio(numeroDeEquipajeField.getText(),vuelo,pasajero));
        ventana.add(consultarButton);

    } catch (Exception e) {
        // TODO: handle exception
    }
   
}

public void calcularPrecio(String equipaje,Vuelo vuelo,Pasajero pasajero){
        int equipaje1=Integer.parseInt(equipaje);
        double total=100+(equipaje1*10);

        TextArea valortotalText=new TextArea("El valor de la reserva es de "+total);
        valortotalText.setBounds(150,400,300,100);
        ventana.add(valortotalText);

        reservarButton=new JButton("Reservar");
        reservarButton.setBounds(260,500,120,20);
        reservarButton.addActionListener(e->ReservarVuelos(vuelo,pasajero,total));
        ventana.add(reservarButton);

}

public void ReservarVuelos(Vuelo vuelo,Pasajero pasajero,Double valorReserva){
    try (var manager=new DBManager()){
        boolean validacion=manager.reservarVuelos(vuelo,pasajero,numeroDeEquipajeField.getText(),valorReserva);
        if (validacion) {
            JOptionPane.showMessageDialog(null,
            "Vuelo Reservado","control",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,
                    "Vuelo no Reservdo","Error",JOptionPane.ERROR_MESSAGE);
    
        }
    } catch (Exception e) {
        // TODO: handle exception
    }



}



}

