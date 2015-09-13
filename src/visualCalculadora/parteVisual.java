/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualCalculadora;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import pilas.ArrayStack;

/**
 *
 * @author Usuario
 */
public class parteVisual extends JFrame implements ActionListener {

    private JMenuBar barraMenu;
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1, mi2;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private JButton btnSuma, btnResta, btnProducto, btnDivision, btnBackSpace, btnIgual;
    private JTextArea txtConsola;
    private ArrayStack<String> pila;
    private ArrayList<String> expresion = new ArrayList<>();
    private ArrayList<String> expresion2 = new ArrayList<>();
    private String consola;

    public parteVisual() {

        super("Calculadora");
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(panelResultado(), BorderLayout.NORTH);
        pane.add(panelBotones(), BorderLayout.CENTER);
        pila = new ArrayStack<>();
        pila.push("");
        mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Opciones");
        mb.add(menu1);
        mi1 = new JMenuItem("Créditos");
        mi1.addActionListener(this);
        menu1.add(mi1);
        menu1 = new JMenu("Opciones");
        mb.add(menu1);
        mi2 = new JMenuItem("Borrar");
        mi2.addActionListener(this);
        menu1.add(mi2);

        try {
            Image img = ImageIO.read(new File("calculator.png"));
            this.setIconImage(img);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected JComponent panelResultado() {
        JPanel inner = new JPanel();
        inner.setLayout(new GridLayout(1, 1, 5, 5));
        txtConsola = new JTextArea(3, 50);
        Font font = new Font("Verdana", Font.BOLD, 18);
        txtConsola.setFont(font);
        txtConsola.setEditable(false);
        txtConsola.setText("");
        inner.add(this.txtConsola);
        return inner;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Container f = this.getContentPane();
        if (ae.getSource() == mi1) {
            JOptionPane.showMessageDialog(null, "Calculadora elaborada por: \n \n Juan Pablo Montoya Restrepo \n Sebastian Moncada Duque \n Miguel Mejia");
        }
        if (ae.getSource() == mi2) {
            JOptionPane.showMessageDialog(null, "Se han borrado los datos");
            while (!pila.isEmpty()) {  
                pila.push("");
                pila.pop();
                txtConsola.setText("");
            }
        }
        
        JButton boton = (JButton) ae.getSource();
        String texto = boton.getText();
        if (pila.peek().equals("")) {
            txtConsola.setText("");
        }
        if (!((pila.peek().equals("+") || pila.peek().equals("-") || pila.peek().equals("*") || pila.peek().equals("/")) && (texto.equals("+") || texto.equals("-") || texto.equals("*") || texto.equals("/")))) {
            if (!(texto.equals("bks") || texto.equals("="))) {
                pila.push(texto);
                txtConsola.setText(txtConsola.getText() + texto);
            }
            if (texto.equals("bks") && !pila.peek().equals("")) {
                pila.pop();
                consola = txtConsola.getText();
                consola = consola.substring(0, consola.length() - 1);
                txtConsola.setText(consola);
            }
            if (texto.equals("=") && !pila.peek().equals("")) {
                resultado();
            }
        }
    }

    protected JComponent panelBotones() {
        JPanel inner = new JPanel();
        inner.setLayout(new GridLayout(4, 4, 5, 5));
        inner.setSize(5, 5);
        inner.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        btn1 = new JButton("1");
        inner.add(btn1);
        btn1.addActionListener(this);
        btn2 = new JButton("2");
        inner.add(btn2);
        btn2.addActionListener(this);
        btn3 = new JButton("3");
        inner.add(btn3);
        btn3.addActionListener(this);
        btnSuma = new JButton("+");
        inner.add(btnSuma);
        btnSuma.addActionListener(this);
        btn4 = new JButton("4");
        inner.add(btn4);
        btn4.addActionListener(this);
        btn5 = new JButton("5");
        inner.add(btn5);
        btn5.addActionListener(this);
        btn6 = new JButton("6");
        inner.add(btn6);
        btn6.addActionListener(this);
        btnResta = new JButton("-");
        inner.add(btnResta);
        btnResta.addActionListener(this);
        btn7 = new JButton("7");
        inner.add(btn7);
        btn7.addActionListener(this);
        btn8 = new JButton("8");
        inner.add(btn8);
        btn8.addActionListener(this);
        btn9 = new JButton("9");
        inner.add(btn9);
        btn9.addActionListener(this);
        btnProducto = new JButton("*");
        inner.add(btnProducto);
        btnProducto.addActionListener(this);
        btnBackSpace = new JButton("<--");
        inner.add(btnBackSpace);
        btnBackSpace.addActionListener(this);
        btn0 = new JButton("0");
        inner.add(btn0);
        btn0.addActionListener(this);
        btnIgual = new JButton("=");
        inner.add(btnIgual);
        btnIgual.addActionListener(this);
        btnDivision = new JButton("/");
        inner.add(btnDivision);
        btnDivision.addActionListener(this);
        return inner;
    }

    public void resultado() {
       String n = "";
        while (!pila.isEmpty()) {
            if (!(pila.peek().equals("+") || pila.peek().equals("-") || pila.peek().equals("*") || pila.peek().equals("/"))) {
                n = pila.pop() + n;
                if (pila.isEmpty()) {
                    expresion.add(n);
                    n = "";
                }
            } else {
                expresion.add(n);
                expresion.add(pila.pop());
                n = "";
            }
        }
        Collections.reverse(expresion);
        System.out.println(expresion);
        while (!(expresion.size() == 1)) {
            while (expresion.contains("*")) {
                for (int i = 0; i < expresion.size(); i++) {
                    if (expresion.get(i) == "*") {
                        double num1 = Double.parseDouble(expresion.get(i - 1));
                        double num2 = Double.parseDouble(expresion.get(i + 1));
                        String res = num1 * num2 + "";
                        expresion.set(i, res);
                        expresion.set(i - 1, "");
                        expresion.set(i + 1, "");
                        expresion.removeAll(Collections.singleton(""));
                    }
                }
            }
            while (expresion.contains("/")) {
                for (int i = 0; i < expresion.size(); i++) {
                    if (expresion.get(i) == "/") {
                        double num1 = Double.parseDouble(expresion.get(i - 1));
                        double num2 = Double.parseDouble(expresion.get(i + 1));
                        String res = num1 / num2 + "";
                        expresion.set(i, res);
                        expresion.set(i - 1, "");
                        expresion.set(i + 1, "");
                        expresion.removeAll(Collections.singleton(""));
                    }
                }
            }
            while (expresion.contains("+")) {
                for (int i = 0; i < expresion.size(); i++) {
                    if (expresion.get(i) == "+") {
                        double num1 = Double.parseDouble(expresion.get(i - 1));
                        double num2 = Double.parseDouble(expresion.get(i + 1));
                        String res = num1 + num2 + "";
                        expresion.set(i, res);
                        expresion.set(i - 1, "");
                        expresion.set(i + 1, "");
                        expresion.removeAll(Collections.singleton(""));
                    }
                }
            }
            while (expresion.contains("-")) {
                for (int i = 0; i < expresion.size(); i++) {
                    if (expresion.get(i) == "-") {
                        double num1 = Double.parseDouble(expresion.get(i - 1));
                        double num2 = Double.parseDouble(expresion.get(i + 1));
                        String res = num1 - num2 + "";
                        expresion.set(i, res);
                        expresion.set(i - 1, "");
                        expresion.set(i + 1, "");
                        expresion.removeAll(Collections.singleton(""));
                    }
                }
            }
            
            
        }
        txtConsola.setText(expresion.get(0));
        pila.push("");
    }
}
