package controller;

import model.ScoutDAO;

import java.util.ArrayList;
import java.util.List;


import bo.Scout;


public class ScoutController {

	

	public List<Scout> read()
	{
		List<Scout> listaJogadores = new ArrayList<Scout>();
		
		try
		{
			ScoutDAO model = new ScoutDAO();
			listaJogadores = model.read();
		}
		catch (Exception e) {
			System.out.println("Erro no controller read");
		}
		
		return listaJogadores;
	}

}