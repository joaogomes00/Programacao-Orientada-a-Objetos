package EX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




    public class Login implements ActionListener {

        private JFrame janela;
        private JPanel painel;

        private JLabel lblTitulo;
        private JLabel lblLogin;
        private JLabel lblSenha;

        private JButton btnLogar;

        private JTextField txtLogin;

        private JPasswordField senha;

        public Login(){

            janela = new JFrame();
            painel = new JPanel();


            painel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
            painel.setLayout(new GridLayout(0,1));

            lblTitulo = new JLabel("Login");
            lblTitulo.setFont(new Font("Verdana",Font.BOLD,15));
            painel.add(lblTitulo);


            lblLogin = new JLabel("Login");
            painel.add(lblLogin);

            txtLogin = new JTextField("");
            painel.add(txtLogin);

            lblSenha = new JLabel("Senha");
            painel.add(lblSenha);

            senha = new JPasswordField("");
            painel.add(senha);

            btnLogar = new JButton("Logar");
            painel.add(btnLogar);
            btnLogar.addActionListener(this);
            
            janela.add(painel,BorderLayout.CENTER);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setTitle("TELA DE LOGIN");
            janela.setSize(300,300);
            janela.pack();
            janela.setVisible(true);

        }

        public static void main(String[] args) {
            new Login();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            new Welcome();
            
        }





}
