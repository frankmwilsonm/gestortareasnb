import java.util.List;
import java.util.Scanner;

import data.PersonData;
import entities.Person;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opt = 0;
        PersonData pData = new PersonData();
        do {
            System.out.println("***** Gestion de Usuarios *****");
            System.out.println("1 Listar ");
            System.out.println("2 Nuevo ");
            System.out.println("3 Eliminar");
            System.out.println("0 Salir ");
            System.out.println("Elige una opcion: ");
            opt = input.nextInt();
            System.out.println("Elegiste: " + opt);
            input.nextLine(); // Limpiar el buffer
            switch (opt) {
                case 1:
                    System.out.println("****** 1 Lista *****");
                    List<Person> lis = pData.list();
                    System.out.println("ID \tNombre \t Sexo");
                    for (Person d : lis) {
                        System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getSex());
                    }
                    break;
                case 2:
                    System.out.println("**** 2 Nuevo ****");
                    Person d = new Person();

                    System.out.print("Ingrese Nombre: ");
                    d.setName(input.nextLine());
                    System.out.print("Ingrese Sexo: ");
                    d.setSex(input.nextLine());

                    pData.create(d);
                    break;
                case 3:
                    System.out.println("**** 3 Eliminar ****");
                    System.out.print("Ingrese ID a eliminar: ");
                    pData.delete(input.nextInt());
                    input.nextLine();
                    break;

                case 9:
                    System.out.println("By Frank");
                    break;
                default:
                    System.out.println("Incorrecto");
                    break;
            }
        } while (opt != 0);

    }
}
