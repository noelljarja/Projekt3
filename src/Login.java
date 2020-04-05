import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

/*
 Projekt 3
 Grupi 4
 Java
 Viti II
 05.04.2020
 Programi ka nje nderfaqe ku perdoruesi mund te logohet.  Ne te vendoset username dhe password dhe nese ato jane te sakta
 do hapet nje nderfaqe tjeter ku personi eshte loguar.  Nese te dhenat nuk jane te sakta, perdoruesi mund ta provoje 5 here
 te tjera pastaj programi mbyllet.  Username i sakte eshte Test dhe passwordi abc
 */
public class Login extends JFrame{
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton bLogin;
    private JLabel jLValidation;
    private JPanel main;

    public Login() {
        super("Paneli Administratorit");
        setContentPane(main);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        bLogin.addActionListener(new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                count ++;
                String username = tfUsername.getText();
                char [] password = tfPassword.getPassword();
                String pass = String.valueOf(password);
                if((username.length()>0) && (pass.length()>0)) {
                    if (username.equals("Test") && pass.equals("abc")) {
                        //jLValidation.setForeground(Color.green);
                        //jLValidation.setText("Hyrja u krye me sukses");
                        setContentPane(new Admin().getAdmin());
                        setVisible(true);
                    }
                    else if(count==5){
                       dispose();
                    }
                    else{
                        jLValidation.setForeground(Color.red);
                        jLValidation.setText("Të dhënat ishin të pasakta.  Mundesi të mbetura: " + (5-count));
                    }
                }else{
                    jLValidation.setForeground(Color.red);
                    jLValidation.setText("Të dhënat nuk janë të plota. Mundesi të mbetura: " + (5-count));
                }
            }
        });
    }
    public static void main(String [] args){
        Login loginFrame = new Login();
        loginFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        loginFrame.setVisible(true);
    }
}
