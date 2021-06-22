package controller;

import model.AlunoDAO;

import java.util.ArrayList;
import java.util.List;

import bo.Aluno;

public class AlunoController {

	
	public void create(Aluno aluno) {
		
		//System.out.println("Incluir aluno");
		
		AlunoDAO model = new AlunoDAO();
		model.create(aluno);
	}
	
	
	public void update(Aluno aluno) {
		
		//System.out.println("atualizar aluno");
		
		AlunoDAO model = new AlunoDAO();
		model.update(aluno);
	}
	
	public void delete(Aluno aluno) {
		
		//System.out.println("deletar aluno");
		
		AlunoDAO model = new AlunoDAO();
		model.delete(aluno);
	}


public List<Aluno> read()
{
	List<Aluno> listaAlunos = new ArrayList<Aluno>();
	
	try
	{
		AlunoDAO model = new AlunoDAO();
		listaAlunos = model.read();
	}
	catch (Exception e) {
		System.out.println("Erro no controller read");
	}
	
	return listaAlunos;
}

}