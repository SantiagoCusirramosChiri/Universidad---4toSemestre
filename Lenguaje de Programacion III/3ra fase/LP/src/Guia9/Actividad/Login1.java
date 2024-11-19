package Guia9.Actividad;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.FlowLayout;

public class Login1 {
    public static void main(String[] args) {
        LoginFrameOrigin loginP = new LoginFrameOrigin();
        loginP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginP.setSize(400, 200);
        loginP.setVisible(true);
    }
}

class LoginFrameOrigin extends JFrame {
    private JPanel contentPane = new JPanel();
    private JLabel eti_user = new JLabel("Ingresar tu correo: ");
    private JTextField txtUsuario = new JTextField(20);
    private JLabel eti_contrasenia = new JLabel("Ingresar tu contrasenia: ");
    private JPasswordField txtPassword = new JPasswordField(20);
    private JButton btnLogin = new JButton("Login");
    JLabel salida = new JLabel("");

    public LoginFrameOrigin() {
        super("Login");
        contentPane.setLayout(new FlowLayout());
        contentPane.setBackground(Color.LIGHT_GRAY);

        contentPane.add(eti_user);
        contentPane.add(txtUsuario);
        contentPane.add(eti_contrasenia);
        contentPane.add(txtPassword);
        contentPane.add(btnLogin);
        contentPane.add(salida);

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

