package JogoDaVelha;
import javax.swing.JFrame;
public class JogoDaVelha extends JFrame{
	
	public static void main(String[] args)
	{
			Jogo Tela = new Jogo();
			Tela.setDefaultCloseOperation(EXIT_ON_CLOSE);
			Tela.setResizable(false);
			Tela.isPraying = true;
	}
}