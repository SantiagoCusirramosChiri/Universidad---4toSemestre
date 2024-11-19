package Guia9.Actividad;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFlowLayout {
    public static void main(String[] args) {
        LoginFrame loginP = new LoginFrame();
        loginP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginP.setSize(500, 200);
        loginP.setVisible(true);
    }
}

class LoginFrame extends JFrame {
    private JPanel contentPane = new JPanel();
    private JPanel inputPane = new JPanel(new GridLayout(2, 2, 5, 5));
    private JLabel eti_user = new JLabel("Ingresar tu correo: ");
    private JTextField txtUsuario = new JTextField(20);
    private JLabel eti_contrasenia = new JLabel("Ingresar tu contrasenia: ");
    private JPasswordField txtPassword = new JPasswordField(20);
    private JButton btnLogin = new JButton("Login");
    JLabel salida = new JLabel("", SwingConstants.CENTER);

    public LoginFrame() {
        super("Login");

        inputPane.add(eti_user);
        inputPane.add(txtUsuario);
        inputPane.add(eti_contrasenia);
        inputPane.add(txtPassword);

        contentPane.add(inputPane, BorderLayout.CENTER);
        contentPane.add(btnLogin, BorderLayout.SOUTH);
        contentPane.add(salida, BorderLayout.NORTH);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = txtUsuario.getText();
                String contrasenia = txtPassword.getText();

                if(user.trim().isEmpty() || contrasenia.trim().isEmpty()) {
                    salida.setText("Usuario o Contrasenia ingresado incorrectamente");
                }
                if(!user.trim().isEmpty() || !contrasenia.trim().isEmpty()) {
                    salida.setText("Ingreso");
                }
            }
        });
        setContentPane(contentPane);
    }
}