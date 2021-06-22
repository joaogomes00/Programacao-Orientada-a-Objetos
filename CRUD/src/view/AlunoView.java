package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bo.Aluno;
import controller.AlunoController;

public class AlunoView implements ActionListener{
	/*
	public void create() {
		
		Scanner in = new Scanner(System.in);
		
		Aluno aluno = new Aluno();
		
		System.out.println("Entre com a matricula");
		aluno.setMatricula(in.next());
		
		System.out.println("Entre com a nome");
		aluno.setNome(in.next());
		
		System.out.println("Entre com a cidade");
		aluno.setCidade(in.next());
		
		AlunoController controller = new AlunoController();
		controller.create(aluno);
		
		
	}
	
	public void read() {
		
		AlunoController controller = new AlunoController();
		
		System.out.println("Listagem de alunos");
		System.out.println("******************");
		
		for(Aluno aluno:controller.read())
		{
			System.out.println("Aluno matr:" + aluno.getMatricula());
			System.out.println("Aluno nome:" + aluno.getNome());
			System.out.println("Aluno cidade:" + aluno.getCidade());
			System.out.println("-----------------------------------");
			
		}
		
		
	}
	
	public void update()
	{
		Scanner in = new Scanner(System.in);
		Aluno aluno = new Aluno();
		
		System.out.println("Entre com a matricula");
		aluno.setMatricula(in.next());
		
		System.out.println("Entre com a nome");
		aluno.setNome(in.next());
		
		System.out.println("Entre com a cidade");
		aluno.setCidade(in.next());
		
		
		AlunoController controller = new AlunoController();
		controller.update(aluno);
		
	}
	
	public void delete()
	{
		Scanner in = new Scanner(System.in);
		Aluno aluno = new Aluno();
		
		System.out.println("Entre com a matricula");
		aluno.setMatricula(in.next());
		
		AlunoController controller = new AlunoController();
		controller.delete(aluno);
	}
	
	public static void main(String[] args) {
		
		AlunoView crud = new AlunoView();
		
		System.out.println("Qual ação do CRUD?");
		System.out.println("c-------------create");
		System.out.println("r-------------read");
		System.out.println("d-------------delete");
		System.out.println("u-------------update");
		Scanner in = new Scanner(System.in);
		
		String resposta = in.next();
		
		if (resposta.equalsIgnoreCase("c"))
			crud.create();
		else if(resposta.equalsIgnoreCase("r"))
			crud.read();
		else if (resposta.equalsIgnoreCase("d"))
			crud.delete();
		else
			crud.update();

	}*/
	
    private JFrame janela;
    private JPanel painel;

    private JLabel lblTitulo;
    private JLabel lblMat;
    private JLabel lblNome;
    private JLabel lblCidade;
   // private JLabel lblResultado;

    private JTextField txtMat;
    private JTextField txtNome;
    private JTextField txtCidade;

    private JButton btnAdd;
    private JButton btnDeletar;
    private JButton btnUpdate;
    private JButton btnList;
    
    private String mat;
    private String nome;
    private String cidade;

    public AlunoView() {
    
        janela = new JFrame();

        painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        painel.setLayout(new GridLayout(0,1));

        //componentes da tela    
        lblTitulo = new JLabel("CRUD");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
        painel.add(lblTitulo);

        lblMat = new JLabel("Matricula:");
        painel.add(lblMat);

        txtMat = new JTextField("");
        painel.add(txtMat);

        lblNome = new JLabel("Nome:");
        painel.add(lblNome);

        txtNome = new JTextField("");
        painel.add(txtNome);
        
        lblCidade = new JLabel("Cidade:");
        painel.add(lblCidade);

        txtCidade = new JTextField("");
        painel.add(txtCidade);
         

        btnAdd = new JButton("ADICIONAR");
        btnAdd.addActionListener(this);
        painel.add(btnAdd);
        
        btnDeletar = new JButton("DELETAR");
        btnDeletar.addActionListener(this);
        painel.add(btnDeletar);
   
        btnUpdate = new JButton("ATUALIZAR");
        btnUpdate.addActionListener(this);
        painel.add(btnUpdate);
        
        btnList = new JButton("LISTAGEM");
        btnList.addActionListener(this);
        painel.add(btnList);

        /* lblResultado = new JLabel("Resultado = ");
        lblResultado.setFont(new Font("Verdana", Font.BOLD, 18));
        lblResultado.setForeground(Color.RED);
        painel.add(lblResultado); */


        janela.add(painel, BorderLayout.CENTER);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setTitle("Tela1 - Aluno");
        janela.setSize(200,700);
        janela.pack();
        janela.setVisible(true);
	}
    
    public static void main(String[] args) {
    	new AlunoView();	
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		mat = txtMat.getText();
		nome = txtNome.getText();
		cidade = txtCidade.getText();
		
		
		Aluno aluno = new Aluno();
		aluno.setMatricula(mat);
		aluno.setNome(nome);
		aluno.setCidade(cidade);
		
		AlunoController alunoC = new AlunoController();
		
		if(e.getActionCommand().equalsIgnoreCase("adicionar")) {
			alunoC.create(aluno);
		}
		else if (e.getActionCommand().equalsIgnoreCase("listagem")) {
			
			AlunoController controller = new AlunoController();
			
			System.out.println("Listagem de alunos");
			System.out.println("******************");
			
			for(Aluno A:controller.read())
			{
				System.out.println("Aluno matr:" + A.getMatricula());
				System.out.println("Aluno nome:" + A.getNome());
				System.out.println("Aluno cidade:" + A.getCidade());
				System.out.println("-----------------------------------");
				
			}
	
		}
		else if (e.getActionCommand().equalsIgnoreCase("ATUALIZAR")) {
			alunoC.update(aluno);
		}
		else if (e.getActionCommand().equalsIgnoreCase("deletar")) {
			alunoC.delete(aluno);
		}
		
		
	}
    
    
    
    
    
    
}
