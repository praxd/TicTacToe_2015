package Muriel;

public class ArvorePossibilidades {
	No raiz;
	No tabuleiroAtual;
	
	public ArvorePossibilidades(String m[][])
	{	
		raiz = new No(m); 
		tabuleiroAtual = raiz;
		
		while(!estaCompleto(tabuleiroAtual))
		{
			//if(GameManager.getInstance().vezJogador == false)
			//{
				tabuleiroAtual.gerarFilhos();
				tabuleiroAtual = tabuleiroAtual.escolherFilho();
			//}
		
			if(tabuleiroAtual == null)
			{
				System.out.println("Cabo...");
				break;
			}
		}
	}
	
	boolean estaCompleto(No pTabuleiro)
	{
		//Diagonal
		if((pTabuleiro.matriz[0][0] == "X" && pTabuleiro.matriz[1][1] == "X" && pTabuleiro.matriz[2][2] == "X") || 
				(pTabuleiro.matriz[0][0] == "O" && pTabuleiro.matriz[1][1] == "O" && pTabuleiro.matriz[2][2] == "O"))
			return true;
		if((pTabuleiro.matriz[2][0] == "X" && pTabuleiro.matriz[1][1] == "X" && pTabuleiro.matriz[0][2] == "X") || 
				(pTabuleiro.matriz[2][0] == "O" && pTabuleiro.matriz[1][1] == "O" && pTabuleiro.matriz[0][2] == "O"))
			return true;
		//Linhas
		for(int i = 0; i < pTabuleiro.matriz.length; i++)
		{
			if((pTabuleiro.matriz[i][0] == "X" && pTabuleiro.matriz[i][1] == "X" && pTabuleiro.matriz[i][2] == "X") || 
					(pTabuleiro.matriz[i][0] == "O" && pTabuleiro.matriz[i][1] == "O" && pTabuleiro.matriz[i][2] == "O"))
				return true;

		}
		//Colunas
		for(int i = 0; i < pTabuleiro.matriz.length; i++)
		{
			if((pTabuleiro.matriz[0][i] == "X" && pTabuleiro.matriz[1][i] == "X" && pTabuleiro.matriz[2][i] == "X") || 
					(pTabuleiro.matriz[0][i] == "O" && pTabuleiro.matriz[1][i] == "O" && pTabuleiro.matriz[2][i] == "O"))
				return true;

		}
		return false;
	}
}
