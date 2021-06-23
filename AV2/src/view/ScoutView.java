package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import bo.Scout;
import controller.ScoutController;


public class ScoutView implements ActionListener{
    private JFrame janela;
    private JPanel painel;

    private JLabel lblTitulo;
    private JLabel lblResultado;
    
    private JButton btnListar;
    
    
    
    public ScoutView() {
    
        janela = new JFrame();

        painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        painel.setLayout(new GridLayout(0,1));

        //componentes da tela    
        lblTitulo = new JLabel("A-League");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
        painel.add(lblTitulo);
        
        lblResultado = new JLabel("Listagem:\n\n\n");
        lblResultado.setFont(new Font("Verdana", Font.BOLD, 18));
        lblResultado.setForeground(Color.BLACK);
        painel.add(lblResultado);
     
        btnListar = new JButton("BUSCAR");
        btnListar.addActionListener(this);
        painel.add(btnListar);
        
        janela.add(painel, BorderLayout.CENTER);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setTitle("Scouts Jogadores");
        janela.setSize(200, 200);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
	}
    
    public static void main(String[] args) {
    	new ScoutView();	
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		lblResultado.setText("Listagem no Console!");
			
		 if (e.getActionCommand().equalsIgnoreCase("BUSCAR")) {
			
			ScoutController controller = new ScoutController();
			System.out.println("Listagem de jogadores");
			System.out.println("******************");
			
			for(Scout sc:controller.read())
			{
				System.out.println("Nome:" + sc.getNome());
				System.out.println("Time:" + sc.getTime());
				System.out.println("Gols:" + sc.getGols());
				System.out.println("Cartões:" + sc.getCartao());
				System.out.println("Ano:" + sc.getAno());
				System.out.println("ID_camp:" + sc.getIdcamp());

				
				
				System.out.println("-----------------------------------");
			
		}
	
		}
	}

}
