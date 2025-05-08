import javax.swing.*;
import java.util.Arrays;

public class Lista {
    private Nodo inicio;
    private Nodo fin;

    public Lista() {
        inicio = null;
        fin = null;
    }

    //Metodo para verificar sila lista se encuentra vacia o no.
    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo para insertar un dato y que revise si es apto para ser insertado / guardado.
    public boolean insertar(String dato) {
        int cont = 0; //variable para contabilizar que hayan las comas suficientes
        char[] caracter1;
        char[] caracter2;
        char[] caracter3;
        char[] caracter4;
        caracter1 = dato.toCharArray();

        for (int i = 0; i < caracter1.length; i++) {
            if (String.valueOf(caracter1[i]).equals(",")) {
                cont++; //cuento las comas
            }
        }

        if (cont == 2) {
            String[] subs = dato.split(",", -1);

            if (subs.length < 2 || subs[0] == null || subs[0].isEmpty()) {
                System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                System.out.println("01");
                return false;
            } else if (subs.length < 2 || subs[1] == null || subs[1].isEmpty()) {
                System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                System.out.println("02");
                return false;
            } else if (subs.length < 2 || subs[2] == null || subs[2].isEmpty()) {
                System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                System.out.println("03");
                return false;
            }

            caracter2 = subs[0].toCharArray();
            for (int i = 0; i < caracter2.length; i++) {
                if (!Character.isLetter(caracter2[i])) {
                    System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                    return false;
                }
            }

            caracter3 = subs[1].toCharArray();
            for (int i = 0; i < caracter3.length; i++) {
                if (!Character.isLetter(caracter3[i])) {
                    System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                    return false;
                }
            }

            caracter4 = subs[2].toCharArray();
            for (int i = 0; i < caracter4.length; i++) {
                if (!Character.isDigit(caracter4[i])) {
                    System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                    return false;
                }
            }

            Nodo actual = new Nodo(dato);
            actual.dato = dato;
            if (estaVacia()) {
                inicio = actual;
                inicio.siguiente = null;
                fin = inicio;
            } else {
                fin.siguiente = actual;
                actual.siguiente = null;
                fin = actual;
            }
            System.out.println("Se ha ingresado correctamente el estudiante en la lista");
            return true;

        } else {
            System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
            return false;
        }
    }

    //Metodo para eliminar un dato
    public void eliminar(String dato) {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            if (inicio == fin && dato.equals(inicio.dato)) { //Eliminar primer y único valor en la lista
                inicio = fin = null;
                System.out.println("Se ha eliminado correctamente al estudiante de la lista");
            } else if (dato.equals(inicio.dato)) { //Eliminar primer pero NO unico valor en la lista
                inicio = inicio.siguiente;
                System.out.println("Se ha eliminado correctamente al estudiante de la lista");
            } else { //Proceso para eliminar a estudiantes en medio de la lista o al final
                Nodo temporal, anterior;
                anterior = inicio;
                temporal = inicio.siguiente;
                while (temporal != null && !temporal.dato.equals(dato)) {
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;
                }
                if (temporal != null) {
                    anterior.siguiente = temporal.siguiente; //Eliminar valor en medio de la lista
                    System.out.println("Se ha eliminado correctamente al estudiante de la lista");
                    if (temporal == fin) { //Eliminar al ultimo valor de la lista
                        fin = anterior;
                    }
                }
            }
        }
    }

    //Metodo para consultar toda la lista
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo temporal;
            temporal = inicio;
            while (temporal != null) {
                String[] subs = temporal.dato.split(",");
                System.out.println("-Estudiante-");
                System.out.println("Nombre: " + subs[0]);
                System.out.println("Apellido: " + subs[1]);
                System.out.println("Nota: " + subs[2]);
                System.out.println("\n");
                temporal = temporal.siguiente;
            }
        }
    }

    //Metodo para consultar a un estudiante especifico
    public void consultar (String dato) {
        boolean hayEstudiante = false;
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo temporal;
            temporal = inicio;
            while (temporal != null) {
                String[] subs = temporal.dato.split(",");
                if (temporal.dato.equals(dato)) {
                    hayEstudiante = true;
                    System.out.println("-Estudiante-");
                    System.out.println("Nombre: " + subs[0]);
                    System.out.println("Apellido: " + subs[1]);
                    System.out.println("Nota: " + subs[2]);
                    System.out.println("\n");
                }
                temporal = temporal.siguiente;
            }
            if (!hayEstudiante) {
                System.out.println("Lo sentimos, no hemos encontrado al estudiante: " + dato);
            }
        }
    }

    //Metood para consultar estudiantes con notas superiores o iguales a 70 (aprobados)
    public void consultarAprobados () {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo temporal;
            temporal = inicio;
            while (temporal != null) {
                String[] subs = temporal.dato.split(",");
                if (Integer.parseInt(subs[2]) >= 70) {
                    System.out.println("-Estudiante aprobado-");
                    System.out.println("Nombre: " + subs[0]);
                    System.out.println("Apellido: " + subs[1]);
                    System.out.println("Nota: " + subs[2]);
                    System.out.println("\n");
                }
                temporal = temporal.siguiente;
            }
        }
    }

    //Metodo para consultar estudiantes con notas inferiores a 70 (reprobados)
    public void consultarReprobados () {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo temporal;
            temporal = inicio;
            while (temporal != null) {
                String[] subs = temporal.dato.split(",");
                if (Integer.parseInt(subs[2]) < 70) {
                    System.out.println("-Estudiante reprobado-");
                    System.out.println("Nombre: " + subs[0]);
                    System.out.println("Apellido: " + subs[1]);
                    System.out.println("Nota: " + subs[2]);
                    System.out.println("\n");
                }
                temporal = temporal.siguiente;
            }
        }
    }

}
