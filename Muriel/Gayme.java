package Muriel;

public class Gayme {
	
	public static void main (String[] args)
	{
		String[][] inicial = new String[3][3];
		
		for(int i = 0; i < inicial.length; i++)
		{
			for(int j = 0; j < inicial.length; j++)
			{
				inicial[i][j] = "-";
				System.out.print(inicial[i][j]);
			}
			
			System.out.println("\n");
		}
		
		ArvorePossibilidades a = new ArvorePossibilidades(inicial);	
		
	}
}