package JogoDaVelha;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Jogo extends JFrame{
	
	JButton cor;
	JButton [] Botoes;
	JPanel painelDoJogo;
	int vezJogador = 0;
	String simbolo;
	
	boolean isPraying;
	String matriz[][] = new String[3][3];
	
	public Jogo()
	{
		super("Jogo da Velha");
		((JComponent)getContentPane()).setBorder(new EmptyBorder(5,5,5,5));
		
		painelDoJogo = new JPanel();
		painelDoJogo.setLayout(new GridLayout(3,3,10,10));
		cor = new JButton();
		
		Botoes = new JButton[9];
		
		for(int i = 0; i < 9; i++)
		{
			Botoes[i] = new JButton("");
		}
		
		//Interface
		
		Botoes[0].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(0);
				matriz[0][0] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[0]);
		
		Botoes[1].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(1);
				matriz[0][1] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[1]);
	
		Botoes[2].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(2);
				matriz[0][2] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[2]);
		
		Botoes[3].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(3);
				matriz[1][0] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[3]);
		
		Botoes[4].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(4);
				matriz[1][1] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[4]);
		
		Botoes[5].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(5);
				matriz[1][2] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[5]);
		
		Botoes[6].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(6);
				matriz[2][0] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[6]);
		
		Botoes[7].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(7);
				matriz[2][1] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[7]);
		
		Botoes[8].setFont(new Font("Calibri", Font.BOLD, 70));
		Botoes[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jogada(8);
				matriz[2][2] = simbolo;
				CondicaoDeVitoria(simbolo);
			}
		});
		painelDoJogo.add(Botoes[8]);
		
		add(painelDoJogo);
		setLocation(470,200);
		setSize(400,400);
		setVisible(true);
	}
	
	public void Jogada(int Simbol)
	{
		if(isPraying != false){
			if(vezJogador == 0)
			{
				simbolo = "X";
				vezJogador = 1;
			}else{
				simbolo = "O";
				vezJogador = 0;
			}
			Botoes[Simbol].setText(simbolo);
			Botoes[Simbol].setEnabled(false);
		}
	}
	
	void CondicaoDeVitoria(String simbol)
	{
		if(isPraying != false){
			// Imprime a matriz!
			for(int j = 0; j < matriz.length; j++)
			{
				System.out.print(matriz[0][j]+" ");
			}
			System.out.println("\n");
			for(int j = 0; j < matriz.length; j++)
			{
				System.out.print(matriz[1][j]+" ");
			}
			System.out.println("\n");
			for(int j = 0; j < matriz.length; j++)
			{
				System.out.print(matriz[2][j]+" ");
			}
			System.out.println("\n");
			// Fim 
		
		
			if((Botoes[0].getText() == "X" && Botoes[1].getText() == "X" && Botoes[2].getText() == "X") || 
			   (Botoes[0].getText() == "O" && Botoes[1].getText() == "O" && Botoes[2].getText() == "O"))
			{
				System.out.println("Jesus voltou! 0");
				isPraying = false;
				
			}else if((Botoes[0].getText() == "X" && Botoes[4].getText() == "X" && Botoes[8].getText() == "X") || 
			   (Botoes[0].getText() == "O" && Botoes[4].getText() == "O" && Botoes[8].getText() == "O"))
			{
				System.out.println("Jesus voltou! 1");
				isPraying = false;
				
			}else if((Botoes[0].getText() == "X" && Botoes[3].getText() == "X" && Botoes[6].getText() == "X") || 
			   (Botoes[0].getText() == "O" && Botoes[3].getText() == "O" && Botoes[6].getText() == "O"))
			{
				System.out.println("Jesus voltou! 2");
				isPraying = false;
				
			}else if((Botoes[1].getText() == "X" && Botoes[4].getText() == "X" && Botoes[7].getText() == "X") || 
					(Botoes[1].getText() == "O" && Botoes[4].getText() == "O" && Botoes[7].getText() == "O"))
			{
				System.out.println("Jesus voltou! 3");
				isPraying = false;
				
			}else if((Botoes[2].getText() == "X" && Botoes[5].getText() == "X" && Botoes[8].getText() == "X") || 
					(Botoes[2].getText() == "O" && Botoes[5].getText() == "O" && Botoes[8].getText() == "O"))
			{
				System.out.println("Jesus voltou! 4");
				isPraying = false;
				
			}else if((Botoes[2].getText() == "X" && Botoes[4].getText() == "X" && Botoes[6].getText() == "X") || 
					(Botoes[2].getText() == "O" && Botoes[4].getText() == "O" && Botoes[6].getText() == "O"))
			{
				System.out.println("Jesus voltou! 5");
				isPraying = false;
				
			}else if((Botoes[3].getText() == "X" && Botoes[4].getText() == "X" && Botoes[5].getText() == "X") || 
					(Botoes[3].getText() == "O" && Botoes[4].getText() == "O" && Botoes[5].getText() == "O"))
			{
				System.out.println("Jesus voltou! 6");
				isPraying = false;
				
			}else if((Botoes[6].getText() == "X" && Botoes[7].getText() == "X" && Botoes[8].getText() == "X") || 
					(Botoes[6].getText() == "O" && Botoes[7].getText() == "O" && Botoes[8].getText() == "O"))
			{
				System.out.println("Jesus voltou! 7");
				isPraying = false;
			}
		}
	}
}