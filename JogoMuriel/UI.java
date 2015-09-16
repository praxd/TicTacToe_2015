import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame
{
    JButton cor;
    JButton [][] Botoes;
    JPanel painelDoJogo;

    String[][] matrizAtual; 

    public UI()
    {       
        super("Jogo da Velha");
        ((JComponent)getContentPane()).setBorder(new EmptyBorder(5,5,5,5));

        painelDoJogo = new JPanel();
        painelDoJogo.setLayout(new GridLayout(3,3,10,10));
        cor = new JButton();
        

        Botoes = new JButton[3][3];

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                Botoes[i][j] = new JButton("");
            }
        }

        //Interface

        Botoes[0][0].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[0][0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(0,0);
                }
            });
        painelDoJogo.add(Botoes[0][0]);

        Botoes[0][1].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[0][1].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(0,1);
                }
            });
        painelDoJogo.add(Botoes[0][1]);

        Botoes[0][2].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[0][2].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(0,2);
                }
            });
        painelDoJogo.add(Botoes[0][2]);

        Botoes[1][0].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[1][0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(1,0);
                }
            });
        painelDoJogo.add(Botoes[1][0]);

        Botoes[1][1].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[1][1].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(1,1);
                }
            });
        painelDoJogo.add(Botoes[1][1]);

        Botoes[1][2].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[1][2].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(1,2);
                }
            });
        painelDoJogo.add(Botoes[1][2]);

        Botoes[2][0].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[2][0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(2,0);
                }
            });
        painelDoJogo.add(Botoes[2][0]);

        Botoes[2][1].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[2][1].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(2,1);
                }
            });
        painelDoJogo.add(Botoes[2][1]);

        Botoes[2][2].setFont(new Font("Calibri", Font.BOLD, 70));
        Botoes[2][2].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printar(2,2);
                }
            });
        painelDoJogo.add(Botoes[2][2]);   
        
        add(painelDoJogo);
        setLocation(470,200);
        setSize(400,500);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void printar(int i , int j)
    {
        if(matrizAtual[i][j] == "-")
        {
            No tabuleiroAtual = new No(matrizAtual);
            if(!GameManager.getInstance().estaCompleto(tabuleiroAtual)){
                matrizAtual[i][j] = "X";
                
                GameManager.getInstance().tabuleiroAtual = tabuleiroAtual;
                GameManager.getInstance().fimJogada();
                Botoes[i][j].setText("X");
                Botoes[i][j].setEnabled(false);
            }
        }
    }

    public void atualizar(String[][] pMatriz)
    {
        matrizAtual = pMatriz;

        for(int i = 0; i < matrizAtual.length; i++)
        {
            for(int j = 0; j < matrizAtual.length; j++)
            {
                Botoes[i][j].setText(matrizAtual[i][j]);
            }
        }
    }
}
