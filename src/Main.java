import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista l = new Lista();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        String dato = "";

        do {
            System.out.println("-------------------------------------------");
            System.out.println("--------------BIENVENIDO :D----------------");
            System.out.println("1. Ingresar estudiantes");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Promedio de notas");
            System.out.println("4. Nota maxima");
            System.out.println("5. Nota minima");
            System.out.println("6. Desviacion estandar de notas");
            System.out.println("7. Consultar lista de estudiantes");
            System.out.println("8. Consultar estudiante especifico");
            System.out.println("9. Consultar estudiantes aprobados");
            System.out.println("10. Consultar estudiantes reprobados");
            System.out.println("11. Respaldar lista");
            System.out.println("12. Consultar ultimo respaldo de notas");
            System.out.println("13. Salir del programa");
            System.out.print("Selecciona una opcion: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    sc.nextLine();
                    System.out.print("Ingresa un estudiante: ");
                    dato = sc.nextLine();
                    l.insertar(dato);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Ingresa un estudiante a eliminar: ");
                    dato = sc.nextLine();
                    l.eliminar(dato);
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:
                    l.mostrar();
                    break;

                case 8:
                    sc.nextLine();
                    System.out.print("Ingresa un estudiante a consultar: ");
                    dato = sc.nextLine();
                    l.consultar(dato);
                    break;

                case 9:
                    l.consultarAprobados();
                    break;

                case 10:
                    l.consultarReprobados();
                    break;

                case 11:

                    break;

                case 12:

                    break;

                case 13:
                    System.out.println("Muchas gracias por usar este programa ;D");
                    break;

                default:
                    System.out.println("Ingresa una opcion del menu");
                    break;
            }
        } while (opc != 12);



    }
}