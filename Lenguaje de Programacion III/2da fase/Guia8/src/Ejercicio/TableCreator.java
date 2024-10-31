package Ejercicio;

import java.sql.*;

public class TableCreator {

    private String base = "jdbc:sqlite:Tienda.db";
    protected Contenidos contenidos = new Contenidos();

    public void createTables() {

        String Tabla_Clientes =
                "CREATE TABLE IF NOT EXISTS Clientes " +
                "(ID_Cliente INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Nombre TEXT NOT NULL, " +
                "Correo TEXT UNIQUE NOT NULL, " +
                "Telefono TEXT)";

        String Tabla_Productos =
                "CREATE TABLE IF NOT EXISTS Productos " +
                "(ID_Producto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Nombre TEXT NOT NULL, " +
                "Precio REAL NOT NULL, " +
                "ID_Proveedor INTEGER, " +
                "FOREIGN KEY (ID_Proveedor) REFERENCES Proveedores(ID_Proveedor) ON DELETE SET NULL)";

        String Tabla_Ordenes =
                "CREATE TABLE IF NOT EXISTS Ordenes " +
                "(ID_Orden INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ID_Cliente INTEGER, " +
                "Fecha_orden TEXT NOT NULL, " +
                "FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente) ON DELETE CASCADE)";

        String Tabla_Detalles =
                "CREATE TABLE IF NOT EXISTS DetallesOrden " +
                "(ID_Detalle INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ID_Orden INTEGER, " +
                "ID_Producto INTEGER, " +
                "Cantidad INTEGER NOT NULL, " +
                "FOREIGN KEY (ID_Orden) REFERENCES Ordenes(ID_Orden) ON DELETE CASCADE, " +
                "FOREIGN KEY (ID_Producto) REFERENCES Productos(ID_Producto) ON DELETE CASCADE)";

        String Tabla_Pagos =
                "CREATE TABLE IF NOT EXISTS Pagos " +
                "(ID_Pago INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ID_Orden INTEGER UNIQUE, " +
                "Monto REAL NOT NULL, " +
                "Fecha_pago TEXT NOT NULL, " +
                "FOREIGN KEY (ID_Orden) REFERENCES Ordenes(ID_Orden) ON DELETE CASCADE)";

        String Tabla_Proveedores =
                "CREATE TABLE IF NOT EXISTS Proveedores " +
                "(ID_Proveedor INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Nombre TEXT NOT NULL, " +
                "Contacto TEXT, " +
                "Telefono TEXT)";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            stmt.execute(Tabla_Clientes);
            stmt.execute(Tabla_Productos);
            stmt.execute(Tabla_Ordenes);
            stmt.execute(Tabla_Detalles);
            stmt.execute(Tabla_Pagos);
            stmt.execute(Tabla_Proveedores);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void addClientes() {
        String [] clientes = contenidos.clientes;
        String sql = "INSERT INTO Clientes(Nombre, Correo, Telefono) VALUES ";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            for (String cliente : clientes) {
                stmt.executeUpdate(sql + cliente);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void addProductos() {
        String[] productos = contenidos.productos;
        String sql = "INSERT INTO Productos(Nombre, Precio, ID_Proveedor) VALUES ";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            for (String producto : productos) {
                stmt.executeUpdate(sql + producto);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void addProveedores() {
        String[] proveedores = contenidos.proveedores;
        String sql = "INSERT INTO Proveedores(Nombre, Contacto, Telefono) VALUES ";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            for (String proveedor : proveedores) {
                stmt.executeUpdate(sql + proveedor);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void addOrdenes() {
        String[] ordenes = contenidos.ordenes;
        String sql = "INSERT INTO Ordenes(ID_Cliente, Fecha_orden) VALUES ";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            for (String orden : ordenes) {
                stmt.executeUpdate(sql + orden);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void addDetallesOrden() {
        String[] detalles = contenidos.detalles;
        String sql = "INSERT INTO DetallesOrden(ID_Orden, ID_Producto, Cantidad) VALUES ";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            for (String detalle : detalles) {
                stmt.executeUpdate(sql + detalle);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void addPagos() {
        String[] pagos = contenidos.pagos;
        String sql = "INSERT INTO Pagos(ID_Orden, Monto, Fecha_pago) VALUES ";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            for (String pago : pagos) {
                stmt.executeUpdate(sql + pago);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void vaciarTablas() {
        String[] tablas = {"Pagos", "Ordenes", "Clientes", "Productos", "Proveedores", "DetallesOrden"};

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            for (String tabla : tablas) {

                String sql = "DROP TABLE IF EXISTS " + tabla;
                stmt.executeUpdate(sql);
                System.out.println("Tabla " + tabla + " ha sido eliminada.");

            }

            createTables();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inicio(){
        createTables();
        vaciarTablas();
        addClientes();
        addProveedores();
        addProductos();
        addOrdenes();
        addDetallesOrden();
        addPagos();
    }



}
