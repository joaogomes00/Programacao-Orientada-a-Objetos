package controller;

import model.PartidasDAO;

import java.util.ArrayList;
import java.util.List;

import bo.Partidas;

public class PartidasController {

	
	public void create(Partidas partida) {
		
		//System.out.println("Incluir jogador");
		
		PartidasDAO model = new PartidasDAO();
		model.create(partida);
	}
	
	
	public void update(Partidas partida) {
		
		//System.out.println("atualizar jogador");
		
		PartidasDAO model = new PartidasDAO();
		model.update(partida);
	}
	
	public void delete(Partidas partida) {
		
		//System.out.println("deletar jogador");
		
		PartidasDAO model = new PartidasDAO();
		model.delete(partida);
	}


public List<Partidas> read()
{
	List<Partidas> listaPartidas = new ArrayList<Partidas>();
	
	try
	{
		PartidasDAO model = new PartidasDAO();
		listaPartidas = model.read();
	}
	catch (Exception e) {
		System.out.println("Erro no controller read");
	}
	
	return listaPartidas;
}

}