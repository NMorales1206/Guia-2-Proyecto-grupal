import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // write your code here

        do {
            System.out.println("Por favor ingrese el numero: ");
            boolean intChecker = input.hasNextLong();
            if (intChecker) {
                long number = input.nextLong();
                numberToWords(number);
                input.nextLine();
                System.out.println("Desea volver a ingresar un numero? Y/N");
                String oneMoreTime = input.nextLine().toLowerCase();
                if(oneMoreTime.equals("y")) {
                    continue;
                } else if(oneMoreTime.equals("n")) {
                    System.out.println("Gracias por jugar.");
                    break;
                } else {
                    System.out.println("Opcion invalida. Cerrando Apliacion");
                    break;
                }
            } else {
                System.out.println("Por favor solo ingresar numeros.");
            }
            input.nextLine();
        } while(true);
    }

    public static void numberToWords(long a) {
        if(a < 0) {
            System.out.println("Ingresar solo valores mayores a cero");
        } else if(a == 0) {
            System.out.println("0 - Cero - Zero");
        } else {
            int counter = 0;
            long length = getDigitCount(a);
            a = reverse(a);
            if (a >= 1) {
                do {
                    long lastNumber = a % 10;
                    a /= 10;
                    switch ((int)lastNumber) {
                        case (1):
                            System.out.println("1 - Uno - One");
                            counter++;
                            break;
                        case (2):
                            System.out.println("2 - Dos - Two");
                            counter++;
                            break;
                        case (3):
                            System.out.println("3 - Tres - Three");
                            counter++;
                            break;
                        case (4):
                            System.out.println("4 - Cuatro - Four");
                            counter++;
                            break;
                        case (5):
                            System.out.println("5 - Cinco - Five");
                            counter++;
                            break;
                        case (6):
                            System.out.println("6 - Seis - Six");
                            counter++;
                            break;
                        case (7):
                            System.out.println("7 - Siete - Seven");
                            counter++;
                            break;
                        case (8):
                            System.out.println("8 - Ocho - Eight");
                            counter++;
                            break;
                        case (9):
                            System.out.println("9 - Nueve - Nine");
                            counter++;
                            break;
                        case (0):
                            System.out.println("0 - Cero - Zero");
                            counter++;
                            break;
                        default:
                            System.out.println("Hmmm");
                    }
                } while (a > 0);
                while (counter < length) {
                    System.out.println("0 - Cero - Zero");
                    counter++;
                }
            }
        }
    }

    public static long reverse(long number) {
        boolean isNegative = number < 0;
        number = number < 0 ? number * (-1) : number;
        long newNumber = 0, counter = 1;
        do {
            long lastNumber = number - ((number / 10) * 10);
            number /= 10;
            newNumber = (newNumber * counter)+ lastNumber;
            counter = 10;
        } while(number > 0);
        if(isNegative) {
            return (newNumber * -1);
        } else {
            return newNumber;
        }
    }

    public static long getDigitCount(long a) {
        if(a < 0) {
            return -1;
        } else {
            int counter = 0;
            do {
                a /= 10;
                counter++;
            } while (a > 0);
            return counter;
        }
    }
}