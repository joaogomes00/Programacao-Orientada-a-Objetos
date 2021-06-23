package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bo.Partidas;
import controller.PartidasController;


public class PartidasView implements ActionListener{
    private JFrame janela;
    private JPanel painel;

    private JLabel lblTitulo;
    
    private JLabel lblID;
    private JLabel lblData;
    private JLabel lblLocal;
    private JLabel lblTime1;
    private JLabel lblTime2;
    

    private JLabel lblResultado;
    private JTextField txtID;
    private JTextField txtData;
    private JTextField txtLocal;
    private JTextField txtTime1;
    private JTextField txtTime2;
    
    
    private JButton btnAdd;
    private JButton btnDeletar;
    private JButton btnUpdate;
    
    private String id;
    private String data;
    private String local;
    private String time1;
    private String time2;


    public PartidasView() {
    
        janela = new JFrame();

        painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        painel.setLayout(new GridLayout(0,1));

        //componentes da tela    
        lblTitulo = new JLabel("A-League");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
        painel.add(lblTitulo);
        
        
        //id do partida
        lblID = new JLabel("ID Partida:");
        lblID.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblID);

        txtID = new JTextField("");
        painel.add(txtID);
        
        //data
        lblData = new JLabel("Data: DD/MM");
        lblData.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblData);

        txtData = new JTextField("");
        painel.add(txtData);
        
        //local
        lblLocal = new JLabel("Local:");
        lblLocal.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblLocal);

        txtLocal = new JTextField("");
        painel.add(txtLocal);
        
        //time 1
        lblTime1 = new JLabel("Equipe mandante:");
        lblTime1.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblTime1);

        txtTime1 = new JTextField("");
        painel.add(txtTime1);
        
        //time 2
        lblTime2 = new JLabel("Equipe visitante:");
        lblTime2.setFont(new Font("Verdana", Font.CENTER_BASELINE,18));
        painel.add(lblTime2);

        txtTime2 = new JTextField("");
        painel.add(txtTime2);
                

        btnAdd = new JButton("CADASTRAR");
        btnAdd.addActionListener(this);
        painel.add(btnAdd);
        
        btnDeletar = new JButton("APAGAR");
        btnDeletar.addActionListener(this);
        painel.add(btnDeletar);
   
        btnUpdate = new JButton("ATUALIZAR");
        btnUpdate.addActionListener(this);
        painel.add(btnUpdate);

        lblResultado = new JLabel("PARA APAGAR, DIGITE A ID DA PARTIDA DESEJADA");
        lblResultado.setFont(new Font("Verdana", Font.BOLD, 18));
        lblResultado.setForeground(Color.RED);
        painel.add(lblResultado);
     

        janela.add(painel, BorderLayout.CENTER);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setTitle("Cadastro Partida");
        janela.setSize(200, 200);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
	}
    
    public static void main(String[] args) {
    	new PartidasView();	
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		id = txtID.getText();
		data = txtData.getText();
		local = txtLocal.getText();
		time1 = txtTime1.getText();
		time2 = txtTime2.getText();

		Partidas partida = new Partidas();
		partida.setId(id);
		partida.setData(data);
		partida.setLocal(local);
		partida.setTime1(time1);
		partida.setTime2(time2);
	
//		completo
		PartidasController partidasC = new PartidasController();
		
		if(e.getActionCommand().equalsIgnoreCase("CADASTRAR")) {
			partidasC.create(partida);
		}
		else if (e.getActionCommand().equalsIgnoreCase("ATUALIZAR")) {
			partidasC.update(partida);
		}
		else if (e.getActionCommand().equalsIgnoreCase("APAGAR")) {
			partidasC.delete(partida);
		}
		
		
	}
    

    
}
