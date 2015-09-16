public class IA{
    No raiz;
    No tabuleiroAtual;
    
    public IA()
    {
    }
    
    public void jogar()
    {
        tabuleiroAtual = GameManager.getInstance().tabuleiroAtual;
        
        tabuleiroAtual.gerarFilhos();
        tabuleiroAtual.mostrarFilhos();
        tabuleiroAtual = tabuleiroAtual.escolherFilho();
        GameManager.getInstance().tabuleiroAtual = tabuleiroAtual;
 
        GameManager.getInstance().fimJogada();
    }
}