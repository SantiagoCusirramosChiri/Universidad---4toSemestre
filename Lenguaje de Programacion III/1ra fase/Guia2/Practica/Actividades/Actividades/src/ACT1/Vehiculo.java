package ACT1;

class Vehiculo {
    public String color;
    private String modelo;
    private int velocidadMaxima;
    private int potenciaMotor;
    private boolean enMarcha;
    private String marca;
    public int añoFabricacion;
    public float precio;

    public Vehiculo(String modelo, int velocidadMaxima, int potenciaMotor, int añoFabricacion, float precio) {
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.potenciaMotor = potenciaMotor;
        this.enMarcha = false;
        this.añoFabricacion = añoFabricacion;
        this.precio = precio;
    }

    public Vehiculo() {
        this.modelo = "BMW";
        this.velocidadMaxima = 300;
        this.potenciaMotor = 120;
        this.enMarcha = false;
        this.añoFabricacion = 2012;
        this.precio = 50000;
    }

    public Vehiculo(String marca, String modelo, int añoFabricacion, float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = 300;
        this.precio = 12000;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean getEnMarcha() {
        return enMarcha;
    }

    public void setEnMarcha(boolean enMarcha) {
        this.enMarcha = enMarcha;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}