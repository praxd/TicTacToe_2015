 public class GameManager {
    private static GameManager Instance;
    
    public boolean vezJogador = false;
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
         
        
        tabuleiroAtual = new No(inicial);
        
        ia = new IA();
        player = new Player();
        
        ui = new UI();
    }
    
    public void realizarJogada()
        {
            imprimeVitoria();
        if(!estaCompleto(tabuleiroAtual)){
            if(vezJogador == true)
            {
               //System.out.println("Jogador jogando...");
               // player.jogar();
                
            }
            else
            {
                //System.out.println("IA jogando...");
                ia.jogar();
            }
            ui.atualizar(tabuleiroAtual.matriz);
        }
    }
    
    public void fimJogada()
    {
        if(vezJogador == true)
        {
            //System.out.println("Fim jogador jogando...");
            
        }
        else
        {
            //System.out.println("Fim IA jogando...");
            
        }
        
        vezJogador = !vezJogador;
        realizarJogada();
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
    
    public void imprimeVitoria(){
        if(estaCompleto(tabuleiroAtual)){
            if(vezJogador){
                System.out.println("O PC ganhou!");
            }else{
                System.out.println("O jogador ganhou!");
            }
        }
    }
}