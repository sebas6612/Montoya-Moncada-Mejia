/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualCalculadora;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

/**
 *
 * @author Usuario
 */
public class validacion extends JTextArea{
    
     public validacion(){
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();

                if (!isNumber(ch) && ch != '\b') {
                    e.consume();
                }
            }
        });

    }

    private boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }

    
}
