/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualCalculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import pilas.ArrayStack;

/**
 *
 * @author Usuario
 */
public class parteVisual extends JFrame implements ActionListener {

    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private JButton btnSuma, btnResta, btnProducto, btnDivision, btnBackSpace, btnIgual;
    private JButton btnBorrar, btnParIzquierdo, btnParDerecho, btnPunto;
    private JTextArea txtConsola;
    private ArrayStack<String> pila;
    private ArrayList<String> expresion = new ArrayList<>();
    private ArrayList<String> expresion2 = new ArrayList<>();
    private String consola;
    private String cadenaPunto;
    private int ParDer, ParIzq, texto;

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
        Font font = new Font("Arial", Font.BOLD, 18);
        txtConsola.setFont(font);
        txtConsola.setEditable(true);
        txtConsola.setText("");
        inner.add(this.txtConsola);
        return inner;

    }

    protected JComponent panelBotones() {
        JPanel inner = new JPanel();
        inner.setLayout(new GridLayout(4, 5, 5, 5));
        inner.setSize(5, 5);
        inner.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        btn1 = new JButton("1");
        inner.add(btn1);
        btn1.addActionListener(this);
        btn1.setBackground(Color.darkGray);
        btn1.setForeground(Color.WHITE);
        btn2 = new JButton("2");
        btn2.setBackground(Color.darkGray);
        btn2.setForeground(Color.WHITE);
        inner.add(btn2);
        btn2.addActionListener(this);
        btn3 = new JButton("3");
        btn3.setBackground(Color.darkGray);
        btn3.setForeground(Color.WHITE);
        inner.add(btn3);
        btn3.addActionListener(this);
        btnSuma = new JButton("+");
        btnSuma.setBackground(Color.darkGray);
        btnSuma.setForeground(Color.WHITE);
        inner.add(btnSuma);
        btnSuma.addActionListener(this);
        btnParIzquierdo = new JButton("(");
        btnParIzquierdo.setBackground(Color.darkGray);
        btnParIzquierdo.setForeground(Color.WHITE);
        inner.add(btnParIzquierdo);
        btn4 = new JButton("4");
        btn4.setBackground(Color.darkGray);
        btn4.setForeground(Color.WHITE);
        inner.add(btn4);
        btn4.addActionListener(this);
        btn5 = new JButton("5");
        btn5.setBackground(Color.darkGray);
        btn5.setForeground(Color.WHITE);
        inner.add(btn5);
        btn5.addActionListener(this);
        btn6 = new JButton("6");
        btn6.setBackground(Color.darkGray);
        btn6.setForeground(Color.WHITE);
        inner.add(btn6);
        btn6.addActionListener(this);
        btnResta = new JButton("-");
        btnResta.setBackground(Color.darkGray);
        btnResta.setForeground(Color.WHITE);
        inner.add(btnResta);
        btnResta.addActionListener(this);
        btnParDerecho = new JButton(")");
        btnParDerecho.setBackground(Color.darkGray);
        btnParDerecho.setForeground(Color.WHITE);
        inner.add(btnParDerecho);
        btn7 = new JButton("7");
        btn7.setBackground(Color.darkGray);
        btn7.setForeground(Color.WHITE);
        inner.add(btn7);
        btn7.addActionListener(this);
        btn8 = new JButton("8");
        btn8.setBackground(Color.darkGray);
        btn8.setForeground(Color.WHITE);
        inner.add(btn8);
        btn8.addActionListener(this);
        btn9 = new JButton("9");
        btn9.setBackground(Color.darkGray);
        btn9.setForeground(Color.WHITE);
        inner.add(btn9);
        btn9.addActionListener(this);
        btnProducto = new JButton("*");
        btnProducto.setBackground(Color.darkGray);
        btnProducto.setForeground(Color.WHITE);
        inner.add(btnProducto);
        btnProducto.addActionListener(this);
        btnBackSpace = new JButton("<-");
        btnBackSpace.setBackground(Color.darkGray);
        btnBackSpace.setForeground(Color.WHITE);
        inner.add(btnBackSpace);
        btnPunto = new JButton(".");
        btnPunto.setBackground(Color.darkGray);
        btnPunto.setForeground(Color.WHITE);
        inner.add(btnPunto);
        btnPunto.addActionListener(this);
        btnBackSpace.addActionListener(this);
        btn0 = new JButton("0");
        btn0.setBackground(Color.darkGray);
        btn0.setForeground(Color.WHITE);
        inner.add(btn0);
        btn0.addActionListener(this);
        btnIgual = new JButton("=");
        btnIgual.setBackground(Color.darkGray);
        btnIgual.setForeground(Color.WHITE);
        inner.add(btnIgual);
        btnIgual.addActionListener(this);
        btnDivision = new JButton("/");
        btnDivision.setBackground(Color.darkGray);
        btnDivision.setForeground(Color.WHITE);
        inner.add(btnDivision);
        btnDivision.addActionListener(this);
        btnBorrar = new JButton("C");
        btnBorrar.setBackground(Color.darkGray);
        btnBorrar.setForeground(Color.WHITE);
        inner.add(btnBorrar);
        btnBorrar.addActionListener(this);

        return inner;
    }

    private void JtxtConsolaKeyTyped(KeyEvent evt) {
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
            JOptionPane.showMessageDialog(parteVisual.this, "Texto Ingresado no valido");
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        Container f = this.getContentPane();
        if (evento.getSource() == mi1) {
            JOptionPane.showMessageDialog(null, "Calculadora elaborada por: \n \n Juan Pablo Montoya Restrepo \n Sebastian Moncada Duque \n Miguel Mejia");
        }

        JButton boton = (JButton) evento.getSource();
        String texto = boton.getText();
        if (pila.peek().equals("")) {
            txtConsola.setText("");
        }
        if (!((pila.peek().equals("+") || pila.peek().equals("-") || pila.peek().equals("*") || pila.peek().equals("/")) && (texto.equals("+") || texto.equals("-") || texto.equals("*") || texto.equals("/")))) {
            if (!(texto.equals("<-") || texto.equals("=") || texto.equals(".") || texto.equals("C"))) {
                cadenaPunto = cadenaPunto + texto;
                pila.push(texto);
                txtConsola.setText(txtConsola.getText() + texto);
                if (texto.equals("*") || texto.equals("/") || texto.equals("+") || texto.equals("-")) {
                    cadenaPunto = "";
                }
                if (texto.equals("(")) {
                    ParIzq++;
                }
                if (texto.equals(")")) {
                    ParDer++;
                }

            }
            if (texto.equals("<-") && !pila.peek().equals("")) {
                pila.pop();
                consola = txtConsola.getText();
                consola = consola.substring(0, consola.length() - 1);
                cadenaPunto = cadenaPunto.substring(0, cadenaPunto.length() - 1);
                txtConsola.setText(consola);
            }
            if (texto.equals("C") && !pila.peek().equals("")) {
                while (!pila.isEmpty()) {
                    pila.pop();
                }
                pila.push("");
                txtConsola.setText("");
                cadenaPunto = "";
            }
            if (texto.equals(".") && !(pila.peek().equals("+") || pila.peek().equals("-") || pila.peek().equals("*") || pila.peek().equals("/")) && !pila.peek().equals("")) {
                if (!cadenaPunto.contains(".")) {
                    pila.push(texto);
                    txtConsola.setText(txtConsola.getText() + texto);
                    cadenaPunto = cadenaPunto + texto;
                } else {
                    JOptionPane.showMessageDialog(parteVisual.this, "Entrada invalida");
                }
            }
            if (texto.equals("=") && !pila.peek().equals("")) {
                if (ParDer == ParIzq) {
                    expresion.clear();
                    resultado();
                } else {
                    JOptionPane.showMessageDialog(parteVisual.this, "Numero erroneo de parentesis");
                }
            }
        }

    }

    public void resultado() {
        try {
            String n = "";
            while (!pila.isEmpty()) {
                if (!(pila.peek().equals("+") || pila.peek().equals("-") || pila.peek().equals("*") || pila.peek().equals("/") || pila.peek().equals("(") || pila.peek().equals(")"))) {
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
            expresion.removeAll(Collections.singleton(""));
            System.out.println(expresion);
            while (!(expresion.size() == 1)) {
                while (expresion.contains("*")) {
                    for (int i = 0; i < expresion.size(); i++) {
                        if ("*".equals(expresion.get(i))) {
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
                        if ("/".equals(expresion.get(i))) {
                            double num1 = Double.parseDouble(expresion.get(i - 1));
                            double num2 = Double.parseDouble(expresion.get(i + 1));
                            if (num2 == 0) {
                                JOptionPane.showMessageDialog(parteVisual.this, "La division por cero no esta definida");
                            }
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
                        if ("+".equals(expresion.get(i))) {

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
                        if ("-".equals(expresion.get(i))) {
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
            txtConsola.setText(txtConsola.getText() + "\n\n" + " = " + expresion.get(0));
            pila.push("");
        }
        catch (IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(parteVisual.this, "Falta un operando");
        }
    }
    
}
