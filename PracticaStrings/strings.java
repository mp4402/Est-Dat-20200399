import java.util.*;

public class strings{

    static Scanner teclado = new Scanner(System.in);
    public static void main(String[]args){
        int control = 0;
        int resultadoPalindromos = 0;
        int opcion = 0;
        while(control == 0){
            System.out.print("Bienvenido\n1.Contador de letras\n2.Verificador de Palindromos\n3.Salir\nSeleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                case 1:
                    contar();
                    break;
                case 2:
                    resultadoPalindromos = palindromos();
                    if (resultadoPalindromos == 0){
                        System.out.println("El texto ingresado no es palindromo");
                    }
                    else if(resultadoPalindromos == 1){
                        System.out.println("El texto ingresado es palindromo");
                    }
                    break;
                case 3:
                    System.out.println("Gracias por utilizar este programa ;)");
                    control = 1;
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida");
                    break;
            }
        }
    }

    public static void contar(){
        int cantidadParrafos = 0;
        int[] contador = new int[26];
        char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String cadena = "";
        System.out.print("Ingrese el numero de parrafos a ingresar: ");
        cantidadParrafos = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el texto para contar sus letras: ");
        for (int z = 0; z < (cantidadParrafos); z++){
            cadena = teclado.nextLine();
            teclado.nextLine();
            cadena = cadena.toLowerCase();
            for (int x = 0; x <= (cadena.length()-1); x++){
                for (int y = 0; y < 26; y++){
                    if (cadena.charAt(x) == letras[y]){
                        contador[y] += 1;
                    }
                }
            }
        }
        for (int i = 1; i < contador.length; ++i) { 
            int keyContador = contador[i]; 
            char keyLetra = letras[i];
            int j = i - 1; 
                while (j >= 0 && contador[j] < keyContador) { 
                    contador[j + 1] = contador[j]; 
                    letras[j+ 1 ] = letras[j];
                    j = j - 1; 
                } 
            contador[j + 1] = keyContador;
            letras[j + 1] = keyLetra; 
        } 
        for (int i = 0; i <= 9; i++){
            System.out.print((i+1) + "." + letras[i] + " " + contador[i] + " ");
            imprimirAsteriscos(contador[i]);
        }
    }

    public static int palindromos(){
        String nuevaCadena = "";
        String cadenaInvertida = "";
        String cadena = "";
        System.out.println("Ingrese el texto que quiere comprobar si es palindromo: ");
        cadena = teclado.nextLine();
        cadena = cadena.toLowerCase();
        for (int x = 0; x <= (cadena.length()-1); x++){
            if (cadena.charAt(x) != ' '){
                nuevaCadena += cadena.charAt(x);
            }
        }
        for (int x = (cadena.length()-1); x >= 0; x--){
            if (cadena.charAt(x) != ' '){
                cadenaInvertida += cadena.charAt(x);
            }
        }
        if (nuevaCadena.equals(cadenaInvertida)){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void imprimirAsteriscos(int cantidad){
        for (int x = 1; x <= cantidad; x++){
            System.out.print("*");
        }
        System.out.print("\n");
    }
}