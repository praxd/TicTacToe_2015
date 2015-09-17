 public class GameManager {
    private static GameManager Instance;
    
    public boolean vezJogador = false;
    public boolean isGameOver = false;
    public No tabuleiroAtual;
    
    private Player player;
    private IA ia;
    private UI ui;
    
    public static GameManager getInstance()
    {
        if(Instance == null)
        {
            Instance = new GameManager();
        }
        return Instance;
    }
    
    public static void setInstanceNull(){
        Instance = null;      
    }
    
    public GameManager()
    {
        String[][] inicial = new String[3][3];

        for(int i = 0; i < inicial.length; i++)
        {
            for(int j = 0; j < inicial.length; j++)
            {
                inicial[i][j] = "-";
                //System.out.print(inicial[i][j]);
            }

            //System.out.println("\n");
        }
         
        
        tabuleiroAtual = new No(inicial, null);
        
        ia = new IA();
        player = new Player();
        
        ui = new UI();
    }
    
    public void realizarJogada()
    {        
        
        imprimeVitoria();
        if(!estaCompleto(tabuleiroAtual)){
            if(!vezJogador)            
                ia.jogar();
            
            ui.atualizar(tabuleiroAtual.matriz);            
        }
    }
    
    public void fimJogada()
    {
        vezJogador = !vezJogador;
        realizarJogada();
    }
    
    boolean estaCompleto(No pTabuleiro)
    {
        //Diagonal
        if((pTabuleiro.matriz[0][0] == "X" && pTabuleiro.matriz[1][1] == "X" && pTabuleiro.matriz[2][2] == "X") || 
                (pTabuleiro.matriz[0][0] == "O" && pTabuleiro.matriz[1][1] == "O" && pTabuleiro.matriz[2][2] == "O")){
            isGameOver = true;
            return true;
        }

            
        if((pTabuleiro.matriz[2][0] == "X" && pTabuleiro.matriz[1][1] == "X" && pTabuleiro.matriz[0][2] == "X") || 
                (pTabuleiro.matriz[2][0] == "O" && pTabuleiro.matriz[1][1] == "O" && pTabuleiro.matriz[0][2] == "O")){
            isGameOver = true;
            return true;
        }
        //Linhas
        for(int i = 0; i < pTabuleiro.matriz.length; i++)
        {
            if((pTabuleiro.matriz[i][0] == "X" && pTabuleiro.matriz[i][1] == "X" && pTabuleiro.matriz[i][2] == "X") || 
                    (pTabuleiro.matriz[i][0] == "O" && pTabuleiro.matriz[i][1] == "O" && pTabuleiro.matriz[i][2] == "O")){
                isGameOver = true;
                return true;
            }
        }
        //Colunas
        for(int i = 0; i < pTabuleiro.matriz.length; i++)
        {
            if((pTabuleiro.matriz[0][i] == "X" && pTabuleiro.matriz[1][i] == "X" && pTabuleiro.matriz[2][i] == "X") || 
                    (pTabuleiro.matriz[0][i] == "O" && pTabuleiro.matriz[1][i] == "O" && pTabuleiro.matriz[2][i] == "O")){
                isGameOver = true;
                return true;
            }
        }
        isGameOver = false;
        return false;
    }
    
    public void imprimeVitoria(){
        if(estaCompleto(tabuleiroAtual)){
            mostrarHistorico(tabuleiroAtual);
            if(vezJogador){
                System.out.println("O PC ganhou!");
            }else{
                System.out.println("O jogador ganhou!");
            }
        }else if(!tabuleiroAtual.temEspacoDisponivel(tabuleiroAtual.matriz)){
            mostrarHistorico(tabuleiroAtual);
            System.out.println("Deu velha !");
        }
    }
    
    public void mostrarHistorico(No pTabuleiro){
        pTabuleiro.mostrarMatriz();
        if(pTabuleiro.pai != null){
            mostrarHistorico(pTabuleiro.pai);
        }        
        
    }
    
//    public boolean isGameOver(){
//        if(estaCompleto(tabuleiroAtual) || !tabuleiroAtual.temEspacoDisponivel(tabuleiroAtual.matriz)){
//            isGameOver = true;
//            return isGameOver;
//        }else{
//            isGameOver = false;
//            return false;
//        }
//    }
}