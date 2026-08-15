package Exercicio01;

import java.util.ArrayList;

public class MinhaAgendaDeAniversarios implements AgendaDeAniversarios {

	private ArrayList<Aniversariante> aniversariantes = new ArrayList<Aniversariante>();

	public void adicionarAniversariante(String nome, int dia, int mes){
		aniversariantes.add(new Aniversariante(nome, dia, mes));
	}

	public ArrayList<String> obterAniversariantesDoDia(int dia, int mes){
		ArrayList<String> nomes = new ArrayList<String>();
		for (Aniversariante a : aniversariantes){
			if (a.getDataAniversario().equals(new DataAniversario(dia, mes))){
				nomes.add(a.getNome());
			}
		}
		return nomes;
	}

	public void removerAniversariante(String nomeAniversariante){
		for (int i = aniversariantes.size()-1; i >= 0; i--){
			if (aniversariantes.get(i).getNome().equals(nomeAniversariante)){
				aniversariantes.remove(i);
			}
		}
	}
}