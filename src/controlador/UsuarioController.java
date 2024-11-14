/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Jose Yesid Rodriguez
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioModel;
import vista.UsuarioView;

public class UsuarioController {

    private UsuarioModel model;
    private UsuarioView view;

    public UsuarioController(UsuarioModel model, UsuarioView view) {
        this.model = model;
        this.view = view;
        this.view.agregarListener(new AgregarListener());
        this.view.eliminarListener(new EliminarListener());
        this.view.actualizarListener(new ActualizarListener());
    }

    class AgregarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Usuario usuario = new Usuario(0, view.getNombre(), view.getEmail(), view.getPassword());
            model.agregarUsuario(usuario);
            view.mostrarMensaje("Usuario agregado con éxito.");
        }
    }

    class EliminarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID del usuario a eliminar:"));
                model.eliminarUsuario(id);
                view.mostrarMensaje("Usuario eliminado con éxito.");
            } catch (NumberFormatException ex) {
                view.mostrarMensaje("ID no válido.");
            }
        }
    }

    class ActualizarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID del usuario a actualizar:"));
                Usuario usuario = new Usuario(id, view.getNombre(), view.getEmail(), view.getPassword());
                model.actualizarUsuario(usuario);
                view.mostrarMensaje("Usuario actualizado con éxito.");
            } catch (NumberFormatException ex) {
                view.mostrarMensaje("ID no válido.");
            }
        }
    }
}
