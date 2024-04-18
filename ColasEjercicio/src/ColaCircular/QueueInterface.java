package ColaCircular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import colalista.ColaLista;
import colalineal.ColaLineal;
import java.util.Stack;


public class QueueInterface extends JFrame {
    
    private JButton btnInsertarColaLista, btnQuitarColaLista, btnInvertirColaLista;
    private JButton btnInsertarColaLineal, btnQuitarColaLineal;
    private JButton btnInsertarColaCircular, btnQuitarColaCircular;
    private JTextField txtInput;
    private JTextArea txtEstadoColaLista, txtEstadoColaLineal, txtEstadoColaCircular;
    private JLabel lblEstadoColaLista, lblEstadoColaLineal, lblEstadoColaCircular;

   
    private final ColaLista colaLista;
    private final ColaLineal colaLineal;
    private final ColaCircular colaCircular;

    public QueueInterface() {
        colaLista = new ColaLista();
        colaLineal = new ColaLineal();
        colaCircular = new ColaCircular();
        initializeUI();
    }

    private void initializeUI() {
    setTitle("Queue Manager");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new FlowLayout());

    txtInput = new JTextField(10);
    inputPanel.add(new JLabel("Elemento:"));
    inputPanel.add(txtInput);

  
    btnInsertarColaLista = new JButton("Insertar en Cola Lista");
    btnQuitarColaLista = new JButton("Quitar de Cola Lista");
    btnInvertirColaLista = new JButton("Invertir Cola Lista");
   
    inputPanel.add(btnInsertarColaLista);
    inputPanel.add(btnQuitarColaLista);
    inputPanel.add(btnInvertirColaLista);

   
    btnInsertarColaLineal = new JButton("Insertar en Cola Lineal");
    btnQuitarColaLineal = new JButton("Quitar de Cola Lineal");
  
    inputPanel.add(btnInsertarColaLineal);
    inputPanel.add(btnQuitarColaLineal);

   
    btnInsertarColaCircular = new JButton("Insertar en Cola Circular");
    btnQuitarColaCircular = new JButton("Quitar de Cola Circular");
    // Agregar los botones al panel de entrada
    inputPanel.add(btnInsertarColaCircular);
    inputPanel.add(btnQuitarColaCircular);

   
    txtEstadoColaLista = new JTextArea(5, 30);
    txtEstadoColaLista.setEditable(false);

    txtEstadoColaLineal = new JTextArea(5, 30);
    txtEstadoColaLineal.setEditable(false);

    txtEstadoColaCircular = new JTextArea(5, 30);
    txtEstadoColaCircular.setEditable(false);

   
    JPanel estadoPanel = new JPanel();
    estadoPanel.setLayout(new GridLayout(3, 1));
    estadoPanel.add(new JScrollPane(txtEstadoColaLista));
    estadoPanel.add(new JScrollPane(txtEstadoColaLineal));
    estadoPanel.add(new JScrollPane(txtEstadoColaCircular));

    
    add(inputPanel, BorderLayout.NORTH);
    add(estadoPanel, BorderLayout.CENTER);

   
btnInsertarColaLista.addActionListener(e -> {
    try {
        colaLista.insertar(txtInput.getText());
        txtInput.setText("");
        actualizarEstado();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});

btnQuitarColaLista.addActionListener(e -> {
    try {
        colaLista.quitar();
        actualizarEstado();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});

btnInvertirColaLista.addActionListener(e -> {
    invertirColaLista();
    actualizarEstado();
});


btnInsertarColaLineal.addActionListener(e -> {
    try {
        colaLineal.insertar(txtInput.getText());
        txtInput.setText("");
        actualizarEstado();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});

btnQuitarColaLineal.addActionListener(e -> {
    try {
        colaLineal.quitar();
        actualizarEstado();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});


btnInsertarColaCircular.addActionListener(e -> {
    try {
        colaCircular.insertar(txtInput.getText());
        txtInput.setText("");
        actualizarEstado();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});

btnQuitarColaCircular.addActionListener(e -> {
    try {
        colaCircular.quitar();
        actualizarEstado();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});

  
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
}




private void actualizarEstado() {
    txtEstadoColaLista.setText(colaLista.visualizar());
    txtEstadoColaLineal.setText(colaLineal.visualizar());
    txtEstadoColaCircular.setText(colaCircular.visualizar());
}

public void invertirColaLista() {
    Stack<Object> stack = new Stack<>();
    try {
        while (!colaLista.colaVacia()) {
            stack.push(colaLista.quitar());
        }
        while (!stack.isEmpty()) {
            colaLista.insertar(stack.pop());
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}


    public void display() {
        setVisible(true);
    }
}
