/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Jose Yesid Rodriguez
 */
import javax.swing.*;
import java.awt.event.ActionListener;

public class UsuarioView extends JFrame {
    private JTextField txtNombre = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JTextField txtPassword = new JTextField(20);
    private JButton btnAgregar = new JButton("Agregar");
    private JButton btnEliminar = new JButton("Eliminar");
    private JButton btnActualizar = new JButton("Actualizar");

    public UsuarioView() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPassword);
        panel.add(btnAgregar);
        panel.add(btnEliminar);
        panel.add(btnActualizar);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.add(panel);
    }

    public String getNombre() { return txtNombre.getText(); }
    public String getEmail() { return txtEmail.getText(); }
    public String getPassword() { return txtPassword.getText(); }

    public void agregarListener(ActionListener listener) { btnAgregar.addActionListener(listener); }
    public void eliminarListener(ActionListener listener) { btnEliminar.addActionListener(listener); }
    public void actualizarListener(ActionListener listener) { btnActualizar.addActionListener(listener); }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}

