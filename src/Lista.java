import javax.swing.*;

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
                return false;
            } else if (subs.length < 2 || subs[1] == null || subs[1].isEmpty()) {
                System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                return false;
            } else if (subs.length < 2 || subs[2] == null || subs[2].isEmpty()) {
                System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                return false;
            }

            caracter2 = subs[0].toCharArray();
            for (int i = 0; i < caracter2.length; i++) {
                if (String.valueOf(caracter2[i]) == null || String.valueOf(caracter2[i]).isBlank() || String.valueOf(caracter2[i]).isEmpty()) {
                    System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                    return false;
                } else {
                    System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                    return false;
                }
            }

            caracter3 = subs[1].toCharArray();
            for (int i = 0; i < caracter3.length; i++) {
                if (String.valueOf(caracter3[i]) == null || String.valueOf(caracter3[i]).isBlank() || String.valueOf(caracter3[i]).isEmpty()) {
                    System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                    return false;
                } else {
                    System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                    return false;
                }
            }

            caracter4 = subs[2].toCharArray();
            for (int i = 0; i < caracter4.length; i++) {
                if (String.valueOf(caracter4[i]) == null || String.valueOf(caracter4[i]).isBlank() || String.valueOf(caracter4[i]).isEmpty()) {
                    System.out.println("La informacion no cumple con los requisitos, por favor seguir la normativa de ingreso de datos");
                    return false;
                } else {
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


}
