package Muriel;
import java.util.ArrayList;
import java.util.Random;

public class No {
	String matriz[][] = new String[3][3];
	ArrayList<No> nosFilhosDoSenhor;
	
	public No(String m[][])
	{
		nosFilhosDoSenhor = new ArrayList<No>();
		matriz = m.clone();
	}
	
	public void gerarFilhos()
	{
		for(int i = 0; i < matriz.length; i++)
		{
			for(int j = 0; j < matriz.length; j++)
			{
				if(matriz[i][j] == "-")
				{
					System.out.println("Criando filho...");
					String m1[][] = new String[3][3];
					
					for(int k = 0; k < matriz.length; k++)
					{
						for(int l = 0; l < matriz.length; l++)
						{
							m1[k][l] = matriz[k][l];
						}
					}
					
					if(GameManager.getInstance().vezJogador)
						m1[i][j] = "X";
					else
						m1[i][j] = "O";

					nosFilhosDoSenhor.add(new No(m1));
				}
			}
		}
		
		
	}
	
	public void mostrarFilhos()
	{
		for(int i = 0; i < nosFilhosDoSenhor.size(); i++)
		{
			for(int cedilha = 0; cedilha < matriz.length; cedilha++)
			{
				for(int j = 0; j < matriz.length; j++)
				{
					System.out.print(nosFilhosDoSenhor.get(i).matriz[cedilha][j]);
				} 
				System.out.println("");	
			}
			System.out.println("");
		}
	}
	
	public void mostrarFilho(No no)
	{
		
		String[][] m2 = no.matriz;
		for(int i = 0; i < m2.length; i++)
		{
			for(int j = 0; j < m2.length; j++)
			{
				System.out.print(m2[i][j]);
			}
			System.out.println("");
		}
	}
	
	public No escolherFilho()
	{
		System.out.println(nosFilhosDoSenhor.size());
		int escolha = 0;
		
		if(nosFilhosDoSenhor.size() > 0)
		{
			Random random = new Random();
			
			//TODO Implementar critério de melhor tabuleiro
			
			escolha = random.nextInt(nosFilhosDoSenhor.size());
			
			mostrarFilho(nosFilhosDoSenhor.get(escolha));
			
			GameManager.getInstance().vezJogador = !GameManager.getInstance().vezJogador;
			return nosFilhosDoSenhor.get(escolha);
		}
		
		return null;
	}
	
	public boolean temEspacoDisponivel(String m[][])
	{
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m.length; j++)
			{
				if(m[i][j] == "-")
					return true;
			}
		}
		return false;
	}
}
