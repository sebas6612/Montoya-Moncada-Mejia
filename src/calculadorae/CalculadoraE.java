/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorae;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import visualCalculadora.parteVisual;

/**
 *
 * @author sebastian
 */
public class CalculadoraE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      parteVisual marcoEtiqueta = new parteVisual(); // crea objeto parteVisual
      marcoEtiqueta.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      marcoEtiqueta.setSize( 500, 380 ); // establece el tamaño del marco
      marcoEtiqueta.setLocationRelativeTo(null); // hace que el panel aparezca centrado
      marcoEtiqueta.setVisible( true ); // muestra el marco
      marcoEtiqueta.setTitle("Calculadora Basica"); // establece un título    
    }
}
