package mascotas;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class ModeloDatos {
    HashMap<Integer, Mascota> mapMascotas = new HashMap<Integer, Mascota>();
    Mascota mascotas = null;

    public void iniciar(ModeloDatos datos) {
        String menu = "Informacion del sistema Daniela\n";
        menu += "1. Ingresar mascota\n";
        menu += "2. Imprimir HashMap\n";
        menu += "3. Consultar mascota individual\n";
        menu += "4. Salir\n";
        menu += "Ingrese una opción:\n";
        int opc = 0;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            validarDatos(opc);
        } while (opc != 4);
    }

    public void validarDatos(int opc) {
        switch (opc) {
            case 1:
                guardarDatos();
                break;

            case 2:
                if (!mapMascotas.isEmpty()) {
                    imprimirHashMap();
                } else {
                    System.out.println("No existe esta mascota registrada");
                }
                break;
            case 3:
                if (!mapMascotas.isEmpty()) {
                    consultarMascota();
                } else {
                    System.out.println("No hay mascotas registradas");
                }
                break;
            case 4:
                System.out.println("¡Salio!");
                break;
            default:
                break;
        }
    }

    public void guardarDatos() {
        String resp = "";
        do {
            mascotas = new Mascota();
            mascotas.ingresar();
            mascotas.hacerSonido();
            mascotas.jugar();
            mapMascotas.put(mascotas.codigo, mascotas);
            mascotas.mostrarInformacion();
            resp = JOptionPane.showInputDialog("Diga SI, si quiere continuar");
        } while (resp.equalsIgnoreCase("si"));
    }


    public void imprimirHashMap() {
        System.out.println("HashMap : ");
        for (Mascota mascota : mapMascotas.values()) {
            mascota.mostrarInformacion();
        }
    }

    public void consultarMascota() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese código de la mascota a buscar"));
        Mascota mascota = mapMascotas.get(codigo);
        if (mascota != null) {
            System.out.println("El codigo de la mascota " + codigo + ":");
            mascota.mostrarInformacion();
        } else {
            System.out.println("No se encontró una mascota con el código."+ codigo);
        }
    }

    public HashMap<Integer, Mascota> getSizeMap(){
        return mapMascotas;
    }
}
