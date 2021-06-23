package controller;

import model.JogadoresDAO;

import java.util.ArrayList;
import java.util.List;

import bo.Jogadores;

public class JogadoresController {

	
	public void create(Jogadores jogador) {
		
		//System.out.println("Incluir jogador");
		
		JogadoresDAO model = new JogadoresDAO();
		model.create(jogador);
	}
	
	
	public void update(Jogadores jogador) {
		
		//System.out.println("atualizar jogador");
		
		JogadoresDAO model = new JogadoresDAO();
		model.update(jogador);
	}
	
	public void delete(Jogadores jogador) {
		
		//System.out.println("deletar jogador");
		
		JogadoresDAO model = new JogadoresDAO();
		model.delete(jogador);
	}
	
	public List<Jogadores> read()
	{
		List<Jogadores> listaJogadores = new ArrayList<Jogadores>();
		
		try
		{
			JogadoresDAO model = new JogadoresDAO();
			listaJogadores = model.read();
		}
		catch (Exception e) {
			System.out.println("Erro no controller read");
		}
		
		return listaJogadores;
	}





}