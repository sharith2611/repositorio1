import java.util.ArrayList;

public class Pasajero implements Ipagable {
    private String nombre;
    private String numeroDePasaporte;
    private int cantidadEquipaje;
    private ArrayList <Vuelo> vuelosReservados;
    
    
    public Pasajero(String nombre, String numeroDePasaporte,int cantidadEquipaje) {
        this.nombre = nombre;
        this.numeroDePasaporte = numeroDePasaporte;
        this.cantidadEquipaje = cantidadEquipaje;
        this.vuelosReservados = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }


    public String getNumeroDePasaporte() {
        return numeroDePasaporte;
    }


    public double getCantidadEquipaje() {
        return cantidadEquipaje;
    }


    public ArrayList<Vuelo> getVuelosReservados() {
        return vuelosReservados;
    }


    @Override
    public double calcularPrecioReserva() {
      return 100+(this.cantidadEquipaje*10);
    }

    public void añadirVueloReservado (Vuelo vuelo){
        vuelosReservados.add(vuelo);
    }
    
    @Override
    public String toString() {
        return "Pasajero [nombre=" + this.nombre + ",numeroDePasaporte=" + this.numeroDePasaporte + ", cantidadEquipaje="
                + this.cantidadEquipaje+"]";
    }

    
}
