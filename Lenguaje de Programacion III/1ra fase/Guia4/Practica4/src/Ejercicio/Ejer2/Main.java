package Ejercicio.Ejer2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        double num1, num2;
        char operacion;

        while (true) {
            System.out.println("\n--- Calculadora Básica ---");
            System.out.println("Introduce el primer número");
            System.out.println("\nIntroduce 'exit' para terminar el programa: ");


            try {
                if (scanner.hasNextDouble()) {
                    num1 = scanner.nextDouble();
                } else {
                    String input = scanner.next();
                    if (input.equalsIgnoreCase("exit")) {
                        throw new ExcepcionSalida();
                    } else {
                        throw new InputMismatchException("Entrada inválida.");
                    }
                }

                System.out.print("Introduce el segundo número: ");
                num2 = scanner.nextDouble();

                System.out.print("Introduce la operación (+, -, *, /): ");
                operacion = scanner.next().charAt(0);

                double resultado = 0;

                switch (operacion) {
                    case '+':
                        resultado = calculadora.sumar(num1, num2);
                        break;
                    case '-':
                        resultado = calculadora.restar(num1, num2);
                        break;
                    case '*':
                        resultado = calculadora.multiplicar(num1, num2);
                        break;
                    case '/':
                        resultado = calculadora.dividir(num1, num2);
                        break;
                    default:
                        throw new IllegalArgumentException("Operación no válida. Elige +, -, * o /.");
                }

                System.out.println("El resultado de la operación es: " + resultado);

            } catch (DivisionPorCeroException e) {
                System.out.println(e.getMessage());

            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage());
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (ArithmeticException e) {
                System.out.println("Error aritmético: " + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Error de entrada: " + e.getMessage());
                scanner.nextLine();
            }

        }
        scanner.close();
    }
}
