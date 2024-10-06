package ACT1;

class Coche extends Vehiculo {

    Coche(String modelo, int velocidadMaxima, int potenciaMotor, int añoFabricacion, int precio) {
        super(modelo, velocidadMaxima, potenciaMotor, añoFabricacion, precio);
    }

    public void acelerar() {
        if (getEnMarcha()) {
            System.out.println("El coche " + getEnMarcha() + " esta acelerando.");
        } else {
            System.out.println("Primero enciende el coche.");
        }
    }

    public void frenar() {
        if (getEnMarcha()) {
            System.out.println("El coche " + getEnMarcha() + " esta frenando.");
        } else {
            System.out.println("El coche esta apagado, no se puede frenar.");
        }
    }

    public void encender() {
        setEnMarcha(true);
        System.out.println("El coche " + getEnMarcha() + " se ha encendido.");
    }

    public void apagar() {
        setEnMarcha(false);
        System.out.println("El coche " + getModelo() + " se ha apagado.");
    }

    public void descuento() {
        if (getAñoFabricacion() > 2010) {
            System.out.println("El coche " + getModelo() + " esta con descuento.");
            float precioDescuento = (float) (getPrecio() * 0.90);
            setPrecio(precioDescuento);
        }
    }
}
