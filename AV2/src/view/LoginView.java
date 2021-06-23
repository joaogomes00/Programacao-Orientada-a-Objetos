package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class LoginView implements ActionListener{
	
    private JFrame janela;
    private JPanel painel;

    private JLabel lblTitulo;
    
    private JLabel lblResultado;
    
    private JButton btnJoga;
    private JButton btnJogo;
    private JButton btnScout;

    public LoginView() {
    
        janela = new JFrame();

        painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        painel.setLayout(new GridLayout(0,1));

        //componentes da tela    
        lblTitulo = new JLabel("A-League");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
        painel.add(lblTitulo);
        
        lblResultado = new JLabel("SELECIONE UMA OPÇÃO");
        lblResultado.setFont(new Font("Verdana", Font.BOLD, 18));
        lblResultado.setForeground(Color.RED);
        painel.add(lblResultado);
        

        btnJoga = new JButton("CADASTRAR JOGADORES");
        btnJoga.addActionListener(this);
        painel.add(btnJoga);
        
        btnJogo = new JButton("CADASTRAR JOGO");
        btnJogo.addActionListener(this);
        painel.add(btnJogo);
   
        btnScout = new JButton("SCOUTS");
        btnScout.addActionListener(this);
        painel.add(btnScout);


        janela.add(painel, BorderLayout.CENTER);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setTitle("Login");
        janela.setSize(200, 200);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
	}
    
    public static void main(String[] args) {
    	new LoginView();	
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnJoga) {
			new JogadoresView();
		}
		else if (e.getSource() == btnJogo) {
			new PartidasView();
		}
		else if (e.getSource() == btnScout) {
			new ScoutView();;
		}
		
		
	}
    
    
    
    
    
    
}
