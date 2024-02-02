import java.util.ArrayList;
public class Aereopuerto {

    private String nombre;
    private String ubicacion;
    private ArrayList <Vuelo> partida;
    private ArrayList <Vuelo> llegada;


    
    public Aereopuerto(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.partida = new ArrayList<Vuelo>();
        this.llegada = new ArrayList<Vuelo>();
    }



    public String getNombre() {
        return nombre;
    }



    public void registrarVueloPartida(Vuelo vuelo){
        partida.add(vuelo);
        System.out.println("Vuelo agregado con exito");

    }

    public void registrarVueloLlegada(Vuelo vuelo){
        llegada.add(vuelo);
        System.out.println("Vuelo agregado con exito");

    }

    public void obtenerPasajerosVueloLlegada(int numeroVuelo){
        if (llegada.size()!=0) {
           for (Vuelo vuelo : llegada) {
            if (numeroVuelo==vuelo.getNumeroDeVuelo()) {
                vuelo.mostrarPasajeros1(numeroVuelo);
            } 
        } 
        }else{
            System.out.println("Este aereopuerto no registra vuelos");
        }
    
    }

    public void obtenerPasajerosvueloPartida(int numeroVuelo){
        Vuelo vuelo1=null;
    if (partida.size()!=0) {        
        for (Vuelo vuelo : partida) {
            if (numeroVuelo==vuelo.getNumeroDeVuelo()) {
                vuelo1=vuelo;
            }else
                vuelo1=null;
        } if (vuelo1!=null) {
            vuelo1.mostrarPasajeros1(numeroVuelo);}
         else{
            System.out.println("Este aereopuerto no tiene vuelos registrados con este numero");}
    }else{
            System.out.println("Este aereopuerto no registra vuelos");
        }
    
    }

    public void listarVuelosPartida(String destino){      
        for (Vuelo vuelo : partida) {
            if (destino.equalsIgnoreCase(vuelo.getDestino())) {
                System.out.println("Vuelo [numeroDeVuelo=" + vuelo.getNumeroDeVuelo() + ", aereolinea=" + vuelo.getAereolinea() + ", horaSalida=" + vuelo.getHoraSalida()
                + ", destino=" + vuelo.getDestino() + ", capacidad Disponible=" + vuelo.getDisponible() + ", aereopuertoPartida="
                + vuelo + ", aereopuertoLlegada=" + vuelo + "]");
            }
        }
    }


    public Vuelo obtenerVuelo(int numeroDeVuelo){
        Vuelo encontrado=null;
        for (Vuelo vuelo : partida) {
            if (numeroDeVuelo==vuelo.getNumeroDeVuelo()) {
                encontrado=vuelo;
                break;
            } else{
                encontrado=null;
                continue;
            }
        }
        return encontrado;
    }
    @Override
    public String toString() {
        return "Aereopuerto [nombre=" + nombre + ", ubicacion=" + ubicacion + ", partida=" + partida + ", llegada="
                + llegada + "]";
    }
    
}