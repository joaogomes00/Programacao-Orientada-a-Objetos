package EX;

import java.awt.*;
import javax.swing.*;


public class Welcome{
    
    private JPanel painel;
    private JFrame janela;

    private JLabel lblWelcome;

    public Welcome(){
        
    janela = new JFrame();
    painel = new JPanel();

    painel.setBorder(BorderFactory.createEmptyBorder(70, 70, 70, 70));
    painel.setLayout(new GridLayout(0,1));

    
    lblWelcome = new JLabel("Bem Vindo");
    lblWelcome.setFont(new Font("Verdana", Font.BOLD, 15));
    lblWelcome.setForeground(Color.blue);
    painel.add(lblWelcome);

    janela.add(painel,BorderLayout.CENTER);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setTitle("TELA DE LOGIN");
    janela.setSize(300,300);
    janela.pack();
    janela.setVisible(true);


    }


}
