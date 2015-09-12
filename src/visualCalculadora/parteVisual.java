/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualCalculadora;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class parteVisual extends JFrame implements ActionListener {

    private JMenuBar barraMenu;
    private JTextField txtEspacio;
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1;

    public parteVisual() {
        setLayout(null);
        mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Opciones");
        mb.add(menu1);
        mi1 = new JMenuItem("Creditos");
        mi1.addActionListener(this);
        menu1.add(mi1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Container f = this.getContentPane();
        if (ae.getSource() == mi1) {
            JOptionPane.showMessageDialog(null, "Calculadora elaborada por: \n Juan Pablo Montoya Restrepo \n Sebastian Moncada \n Miguel Mejia");
        }
    }
}
