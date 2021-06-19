package com.zetcode;

//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
public class Snake extends JFrame
{
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    static boolean tmp = false;
    static JFrame temp = new JFrame();
    public static ArrayList<JPanel> panels=new ArrayList<JPanel>();
    MainMenu mainMenu;
    JPanel mainMenuPanel = new JPanel();
    GameRule gameRule = new GameRule();
    Board board;
    Data data = new Data();
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public Snake()
    {
        initUI();
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    private void initUI()
    {
        mainMenu = new MainMenu();
        gameRule = new GameRule();

        panels.add(mainMenu);
        panels.add(gameRule);

        mainMenu.btnGameStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("GameStart!");
                board = new Board();

                add(board);
                panels.add(board);

                board.setSize(data.getBoardWidth(),data.getBoardHeight());
                board.setVisible(true);

                board.setFocusable(true);
                mainMenu.setFocusable(false);
                mainMenu.setVisible(false);

            }
        });

        mainMenu.btnGameRule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("GameRule");
                add(gameRule, BorderLayout.NORTH);
                gameRule.setSize(700,700);
                gameRule.setVisible(true);
                gameRule.setFocusable(true);
                mainMenu.setFocusable(false);
                mainMenu.setVisible(false);
            }
        });

        mainMenu.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        add(mainMenu);

//        add(new inGame());
//        add(new GameRule());
        mainMenu.setVisible(true);

        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    /*
    private void initUI()
    {
        mainMenuPanel.setSize(700,700);
        mainMenuPanel.setBackground(Color.WHITE);
       // temp.setLayout(new FlowLayout());
        mainMenuPanel.setPreferredSize(new Dimension(data.getBoardWidth(), data.getBoardHeight()));
        mainMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,450));

        mainMenu = new MainMenu();

        mainMenuPanel.add(mainMenu.btnGameStart);
        mainMenuPanel.add(mainMenu.btnGameRule);

        Snake.panels.add(mainMenuPanel);
        Snake.panels.add(gameRule);

        mainMenu.btnGameStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("GameStart!");
                add(board = new Board(), BorderLayout.NORTH);
                Snake.panels.add(board);
                board.setSize(700,700);
                board.setVisible(true);
                board.setFocusable(true);
                mainMenuPanel.setFocusable(false);
                mainMenuPanel.setVisible(false);

            }
        });
        mainMenu.btnGameRule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("GameRule");
            }
        });
        add(mainMenuPanel);

//        add(new inGame());
//        add(new GameRule());
        mainMenuPanel.setVisible(true);

        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    */
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
//    private void initStartGame()
//    {
//        add(new Board());
//        setResizable(false);
//        pack();
//
//        setTitle("Snake");
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
    //--------------------------------------------------------------------------------------------//
    // StateGame 상태확인하고 눌렸을 때 Menu화면 Off Game화면 On.
    //--------------------------------------------------------------------------------------------//
//    private void StateGame()
//    {
//        if( data.isStateGame() == true )
//            tmp = data.isStateGame();
//    }
    public void removeBoard(){
        remove(board);
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            JFrame ex = new Snake();
            temp = ex;
            ex.setVisible(true);

//            StateGame();

//            if( tmp == true)

        });
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
}
//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
