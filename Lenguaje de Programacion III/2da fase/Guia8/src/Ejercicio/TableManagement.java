package Ejercicio;

import java.sql.*;

public class TableManagement {
    protected String base = "jdbc:sqlite:Tienda.db";


    public void insertarPago(int idOrden, double monto) {

        String sql = "INSERT INTO Pagos(id_orden, monto) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idOrden);
            pstmt.setDouble(2, monto);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void actualizarPago(int idOrden, double nuevoMonto) {

        String sql = "UPDATE Pagos SET monto = ? WHERE id_orden = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, nuevoMonto);
            pstmt.setInt(2, idOrden);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void borrarPago(int idOrden) {

        String sql = "DELETE FROM Pagos WHERE id_orden = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idOrden);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarPagos() {

        String sql = "SELECT * FROM Pagos";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID-> " + rs.getInt("ID_Orden") + ", Monto-> " + rs.getDouble("Monto"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void insertarCliente(String nombre, String correo, String telefono) {

        String sql = "INSERT INTO Clientes(Nombre, Correo, Telefono) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, correo);
            pstmt.setString(3, telefono);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void actualizarCliente(int idCliente, String nombre, String correo, String telefono) {

        String sql = "UPDATE Clientes SET Nombre = ?, Correo = ?, Telefono = ? WHERE ID_Cliente = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, correo);
            pstmt.setString(3, telefono);
            pstmt.setInt(4, idCliente);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void borrarCliente(int idCliente) {

        String sql = "DELETE FROM Clientes WHERE ID_Cliente = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarClientes() {

        String sql = "SELECT * FROM Clientes";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        "ID Cliente: " + rs.getInt("ID_Cliente") +
                        ", Nombre: " + rs.getString("Nombre") +
                        ", Correo: " + rs.getString("Correo") +
                        ", Telefono: " + rs.getString("Telefono"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void insertarProducto(String nombre, double precio) {

        String sql = "INSERT INTO Productos(Nombre, Precio) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void actualizarProducto(int idProducto, String nombre, double precio) {

        String sql = "UPDATE Productos SET Nombre = ?, Precio = ? WHERE ID_Producto = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.setInt(3, idProducto);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void borrarProducto(int idProducto) {

        String sql = "DELETE FROM Productos WHERE ID_Producto = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idProducto);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarProductos() {

        String sql = "SELECT * FROM Productos";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                System.out.println("ID Producto: " + rs.getInt("ID_Producto") +
                        ", Nombre: " + rs.getString("Nombre") +
                        ", Precio: " + rs.getDouble("Precio"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void insertarProveedor(String nombre, String contacto) {

        String sql = "INSERT INTO Proveedores(Nombre, Contacto) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, contacto);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void actualizarProveedor(int idProveedor, String nombre, String contacto) {

        String sql = "UPDATE Proveedores SET Nombre = ?, Contacto = ? WHERE ID_Proveedor = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, contacto);
            pstmt.setInt(3, idProveedor);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void borrarProveedor(int idProveedor) {

        String sql = "DELETE FROM Proveedores WHERE ID_Proveedor = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idProveedor);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarProveedores() {

        String sql = "SELECT * FROM Proveedores";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                System.out.println("ID Proveedor: " + rs.getInt("ID_Proveedor") +
                        ", Nombre: " + rs.getString("Nombre") +
                        ", Contacto: " + rs.getString("Contacto"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void insertarOrden(int idCliente, String fecha) {

        String sql = "INSERT INTO Ordenes(ID_Cliente, Fecha) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            pstmt.setString(2, fecha);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void actualizarOrden(int idOrden, int idCliente, String fecha) {

        String sql = "UPDATE Ordenes SET ID_Cliente = ?, Fecha = ? WHERE ID_Orden = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            pstmt.setString(2, fecha);
            pstmt.setInt(3, idOrden);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void borrarOrden(int idOrden) {

        String sql = "DELETE FROM Ordenes WHERE ID_Orden = ?";

        try (Connection conn = DriverManager.getConnection(base); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idOrden);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarOrdenes() {

        String sql = "SELECT * FROM Ordenes";

        try (Connection conn = DriverManager.getConnection(base); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                System.out.println("ID Orden: " + rs.getInt("ID_Orden") +
                        ", ID Cliente: " + rs.getInt("ID_Cliente") +
                        ", Fecha: " + rs.getString("Fecha"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
