/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jose Yesid Rodriguez
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {

    private Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sys"; // Ajusta a tu base de datos
            String user = "root";
            String password = "1234"; // Cambia a tu contraseña
            Connection conexion = DriverManager.getConnection(url, user, password);

            // Crear tabla si no existe
            String crearTabla = "CREATE TABLE IF NOT EXISTS usuario ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(50) NOT NULL, "
                    + "email VARCHAR(100) UNIQUE NOT NULL, "
                    + "password VARCHAR(100) NOT NULL)";
            Statement statement = conexion.createStatement();
            statement.execute(crearTabla);
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, email, password) VALUES (?, ?, ?)";
        try ( Connection conexion = conectar();  PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try ( Connection conexion = conectar();  PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre = ?, email = ?, password = ? WHERE id = ?";
        try ( Connection conexion = conectar();  PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPassword());
            pstmt.setInt(4, usuario.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try ( Connection conexion = conectar();  Statement stmt = conexion.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("password"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
