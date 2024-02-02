
    import java.util.ArrayList;

public class Vuelo implements IReservable {
    private int numeroDeVuelo;
    private String aereolinea;
    private String horaSalida;
    private String destino;
    private int capacidadMaxima;
    private int disponible;

    private int aereopuertoPartida;
    private int aereopuertoLlegada;
    private ArrayList<Pasajero> pasajeros;
    
    
    public String getAereolinea() {
        return aereolinea;
    }


    public String getHoraSalida() {
        return horaSalida;
    }





    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }


    public Vuelo(int numeroDeVuelo, String aereolinea, String horaSalida, String destino, int capacidadMaxima,
            int aereopuertoPartida, int aereopuertoLlegada) {
        this.numeroDeVuelo = numeroDeVuelo;
        this.aereolinea = aereolinea;
        this.horaSalida = horaSalida;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        this.aereopuertoPartida = aereopuertoPartida;
        this.aereopuertoLlegada = aereopuertoLlegada;
        this.pasajeros = new ArrayList <Pasajero>();
        this.disponible=capacidadMaxima;
    }


    public String getDestino() {
        return destino;
    }


    public int getNumeroDeVuelo() {
        return numeroDeVuelo;
    }


    public String toString() {
        return "[numeroDeVuelo=" + numeroDeVuelo + ", aereolinea=" + aereolinea + ", horaSalida=" + horaSalida
                + ", destino=" + destino + ", capacidadMaxima=" + capacidadMaxima + ", aereopuertoPartida="
                + aereopuertoPartida + ", aereopuertoLlegada=" + aereopuertoLlegada +"Disponible" +disponible+"]";
    }


    @Override
    public boolean reservarAsiento(int numeroAsiento) {
       
        if (pasajeros.size()<=disponible && numeroAsiento<=disponible) {
            disponible-=numeroAsiento;
            return true;
        }else{
            return false;
        }
       
    }

    public void agregarPasajero(Pasajero pasajero){
            pasajeros.add(pasajero);
            System.out.println("Pasajero asignado con exito.");
    }

    
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }


    public void mostrarPasajeros1(int numeroVuelo){
        for (Pasajero pasajero : pasajeros) {
            for (Vuelo vuelo : pasajero.getVuelosReservados()) {
                if (vuelo.getNumeroDeVuelo()==numeroVuelo) {
                    System.out.println(pasajero);
                    System.out.println("-"+vuelo);
                }
                
            }
         System.out.println();

        }
    }




    public int getDisponible() {
        return disponible;
    }

    
}


