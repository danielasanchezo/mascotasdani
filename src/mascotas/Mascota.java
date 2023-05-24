package mascotas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Mascota {
	ModeloDatos datos =new ModeloDatos();
	int codigo;
    String nombre;
    String especie;
    int edad;
  
    public Mascota() {
    	
    }
	public void ingresar() {
    	codigo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la mascota"));
    	nombre = JOptionPane.showInputDialog("Ingrese nombre de la mascota");
        especie = JOptionPane.showInputDialog("Ingrese especie de la mascota");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota"));

    }
    public Mascota(String nombre, String especie, int edad) {
    	this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void mostrarInformacion() {
    	System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }

    public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("¡Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("¡Miau miau!");
        }else {
            System.out.println("La mascota no hace sonidos conocidos.");
        }
    }
    public void comer() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("El perro come!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("El gato come!");
        }else {
            System.out.println("La mascota no ha comido conocidos.");
        }
    }
	public void jugar() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("¡El perro juega!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("¡El gato juega!");
        }else {
            System.out.println("La mascota no juega conocidos.");
        }
		
	}
    public void imprimirDatos(ModeloDatos datos) {
   	 HashMap<Integer, Mascota> mascota = datos.getSizeMap();
   	Iterator iterator = mascota.keySet().iterator();
   	Mascota mascotas; Integer llave;
		while(iterator.hasNext()) {
           llave = (Integer) iterator.next();
           mascotas = datos.getSizeMap().get(llave);
           System.out.println("ID: " + llave + ", Nombre: " + mascotas.nombre + ", edad: " + mascotas.edad 
               		+ " y especie " + mascotas.especie);
		}
		System.out.println("-----");
   }

}