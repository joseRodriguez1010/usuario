/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocun;

import controlador.UsuarioController;
import modelo.UsuarioModel;
import vista.UsuarioView;

/**
 *
 * @author Jose Yesid Rodriguez
 */
public class ProyectoCun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UsuarioModel model = new UsuarioModel();
        UsuarioView view = new UsuarioView();
        UsuarioController controller = new UsuarioController(model,view);

        view.setVisible(true);

    }
}
