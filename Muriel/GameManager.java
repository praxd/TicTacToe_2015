package Muriel;

public class GameManager {
	private static GameManager Instance;
	
	public boolean vezJogador = false;
	
	public static GameManager getInstance()
	{
		if(Instance == null)
		{
			Instance = new GameManager();
		}
		return Instance;
	}
}