package ACT5;

import java.util.Scanner;
import java.util.List;

public class Eje5 {
    public static void main(String[] args) {
        Cuenta[] cuentas = new Cuenta[10];
        int cuentaIndex = 0;

        Scanner in = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            List<String> opciones = List.of("Crear cuenta de ahorros", "Crear cuenta corriente", "Depositar", "Retirar", "Consultar", "Salir");
            String titulo = "Menú Principal";
            mostrarMenu(opciones, titulo);
            System.out.println("Seleccione una opción: ");
            int op = in.nextInt();

            switch (op) {
                case 1:
                    if (cuentaIndex < cuentas.length) {
                        System.out.print("Ingrese número de cuenta: ");
                        int numero = in.nextInt();
                        System.out.print("Ingrese saldo inicial: ");
                        double saldo = in.nextDouble();
                        System.out.print("Ingrese tasa de interés: ");
                        double interes = in.nextDouble();
                        cuentas[cuentaIndex] = new CuentaAhorro(numero, saldo, interes);
                        cuentaIndex++;
                        System.out.println("Cuenta de ahorros creada exitosamente.");
                    } else {
                        System.out.println("No se pueden crear más cuentas.");
                    }
                    break;
                case 2:
                    if (cuentaIndex < cuentas.length) {
                        System.out.print("Ingrese número de cuenta: ");
                        int numero = in.nextInt();
                        System.out.print("Ingrese saldo inicial: ");
                        double saldo = in.nextDouble();
                        cuentas[cuentaIndex] = new CuentaCorriente(numero, saldo);
                        cuentaIndex++;
                        System.out.println("Cuenta corriente creada exitosamente.");
                    } else {
                        System.out.println("No se pueden crear más cuentas.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese número de cuenta: ");
                    int numeroDepositar = in.nextInt();
                    System.out.print("Ingrese monto a depositar: ");
                    double montoDepositar = in.nextDouble();
                    Cuenta cuentaDeposito = buscarCuenta(cuentas, numeroDepositar);
                    if (cuentaDeposito != null) {
                        cuentaDeposito.depositar(montoDepositar);
                        System.out.println("Depósito realizado con éxito.");
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese número de cuenta: ");
                    int numeroRetirar = in.nextInt();
                    System.out.print("Ingrese monto a retirar: ");
                    double montoRetirar = in.nextDouble();
                    Cuenta cuentaRetiro = buscarCuenta(cuentas, numeroRetirar);
                    if (cuentaRetiro != null) {
                        cuentaRetiro.retirar(montoRetirar);
                        System.out.println("Retiro realizado con éxito.");
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese número de cuenta: ");
                    int numeroConsultar = in.nextInt();
                    Cuenta cuentaConsulta = buscarCuenta(cuentas, numeroConsultar);
                    if (cuentaConsulta != null) {
                        cuentaConsulta.consultar();
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 6:
                    done = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static Cuenta buscarCuenta(Cuenta[] cuentas, int numero) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta != null && cuenta.getNumero() == numero) {
                return cuenta;
            }
        }
        return null;
    }
    public static void mostrarMenu(List<String> opciones, String titulo) {
        String separador = "+";
        for (int i = 0; i < titulo.length(); i++) {
            separador += "-";
        }
        separador += "+";

        System.out.println(separador);
        System.out.println("| " + titulo + " |");
        System.out.println(separador);

        for (int i = 0; i < opciones.size(); i++) {
            System.out.println("| " + (i + 1) + ". " + opciones.get(i));
        }

        System.out.println(separador);
    }
}

abstract class Cuenta {
    private int numero;
    private double saldo;

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depositado: S/ " + monto);
        } else {
            System.out.println("Monto inválido.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.println("Retirado: S/ " + monto);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    public abstract void consultar();
}

class CuentaAhorro extends Cuenta {
    private double tazaInteres;
    private double minSaldo;

    public CuentaAhorro(int numero, double saldo, double tazaInteres) {
        super(numero, saldo);
        this.tazaInteres = tazaInteres;
        this.minSaldo = saldo;
    }

    public void setTazaIntereses(double intereses) {
        this.tazaInteres = intereses;
    }

    @Override
    public void retirar(double amount) {
        super.retirar(amount);
        double saldo = getSaldo();
        if (saldo < minSaldo) {
            minSaldo = saldo;
        }
    }

    @Override
    public void consultar() {
        double interes = minSaldo * tazaInteres / 100;
        depositar(interes);
        minSaldo = getSaldo();
        System.out.println("Intereses aplicados. Nuevo saldo: S/ " + getSaldo());
    }
}

class CuentaCorriente extends Cuenta {
    private int retiros = 0;
    private final int LIBRE_RETIROS = 3;
    private final double TARIFA_TRANSACCION = 3.5;

    public CuentaCorriente(int numero, double saldo) {
        super(numero, saldo);
    }

    @Override
    public void retirar(double amount) {
        super.retirar(amount);
        retiros++;
        if (retiros > LIBRE_RETIROS) {
            super.retirar(TARIFA_TRANSACCION);
            System.out.println("Se ha aplicado una tarifa de S/ " + TARIFA_TRANSACCION + " por retiro adicional.");
        }
    }

    @Override
    public void consultar() {
        retiros = 0;
        System.out.println("Consultado.");
    }
}

