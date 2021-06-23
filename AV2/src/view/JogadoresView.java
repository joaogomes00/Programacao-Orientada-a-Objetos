package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bo.Jogadores;
import controller.JogadoresController;


public class JogadoresView implements ActionListener{
    private JFrame janela;
    private JPanel painel;

    private JLabel lblTitulo;
    
    private JLabel lblNome;
    private JLabel lblNumCamisa;
    private JLabel lblTime;
    private JLabel lblJogosD;
    private JLabel lblCartao;
    private JLabel lblGols;
    private JLabel lblID;
    

    private JLabel lblResultado;
    private JTextField txtNome;
    private JTextField txtNumCamisa;
    private JTextField txtTime;
    private JTextField txtJogosD;
    private JTextField txtCartao;
    private JTextField txtGols;
    private JTextField txtID;
    
    private JButton btnAdd;
    private JButton btnDeletar;
    private JButton btnUpdate;
    
    private String id;
    private String numCamisa;
    private String nome;
    private String time;
    private String jogosD;
    private String cartao;
    private String gols;

    public JogadoresView() {
    
        janela = new JFrame();

        painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        painel.setLayout(new GridLayout(0,1));

        //componentes da tela    
        lblTitulo = new JLabel("A-League");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
        painel.add(lblTitulo);
        
        
        //nome do jogador
        lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblNome);

        txtNome = new JTextField("");
        painel.add(txtNome);
        
        //num camisa
        lblNumCamisa = new JLabel("N° Camisa:");
        lblNumCamisa.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblNumCamisa);

        txtNumCamisa = new JTextField("");
        painel.add(txtNumCamisa);
        
        //time
        lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblTime);

        txtTime = new JTextField("");
        painel.add(txtTime);
        
        //cartão
        lblCartao = new JLabel("Cartão:");
        lblCartao.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblCartao);

        txtCartao = new JTextField("");
        painel.add(txtCartao);
        
        //jogos
        lblJogosD = new JLabel("N° jogos:");
        lblJogosD.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblJogosD);

        txtJogosD = new JTextField("");
        painel.add(txtJogosD);
        
        //gols
        lblGols = new JLabel("Gols:");
        lblGols.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblGols);

        txtGols = new JTextField("");
        painel.add(txtGols);
         
        //id 
        lblID = new JLabel("ID:");
        lblID.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblID);

        txtID = new JTextField("");
        painel.add(txtID);
        

        btnAdd = new JButton("CADASTRAR");
        btnAdd.addActionListener(this);
        painel.add(btnAdd);
        
        btnDeletar = new JButton("APAGAR");
        btnDeletar.addActionListener(this);
        painel.add(btnDeletar);
   
        btnUpdate = new JButton("ATUALIZAR");
        btnUpdate.addActionListener(this);
        painel.add(btnUpdate);

        lblResultado = new JLabel("PARA APAGAR, DIGITE A ID DO JOGADOR DESEJADO");
        lblResultado.setFont(new Font("Verdana", Font.BOLD, 18));
        lblResultado.setForeground(Color.RED);
        painel.add(lblResultado);
     

        janela.add(painel, BorderLayout.CENTER);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setTitle("Cadastro Jogador");
        janela.setSize(200, 200);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
	}
    
    public static void main(String[] args) {
    	new JogadoresView();	
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		id = txtID.getText();
		nome = txtNome.getText();
		time = txtTime.getText();
		numCamisa = txtNumCamisa.getText();
		jogosD = txtJogosD.getText();
		cartao = txtCartao.getText();
		gols = txtGols.getText();
		
		Jogadores jogador = new Jogadores();
		jogador.setId(id);
		jogador.setNome(nome);
		jogador.setTime(time);
		jogador.setNumCamisa(numCamisa);
		jogador.setJogosD(jogosD);
		jogador.setCartao(cartao);
		jogador.setGols(gols);

//		completo
		JogadoresController jogadorC = new JogadoresController();
		
		if(e.getActionCommand().equalsIgnoreCase("CADASTRAR")) {
			jogadorC.create(jogador);
		}

		else if (e.getActionCommand().equalsIgnoreCase("ATUALIZAR")) {
			jogadorC.update(jogador);
		}
		else if (e.getActionCommand().equalsIgnoreCase("APAGAR")) {
			jogadorC.delete(jogador);
		}
		
		
	}
    
    
    
    
    
    
}
