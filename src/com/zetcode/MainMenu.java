package com.zetcode;


import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel
{
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    Data data = new Data();

    JButton btnGameStart = new JButton(new ImageIcon("res/Image/btnGameStart.png"));
    JButton btnGameRule = new JButton(new ImageIcon("res/Image/btnGameRule.png"));
    JButton btnExit = new JButton(new ImageIcon("res/Image/btnExit.png"));


    ImageIcon imiBackGround = new ImageIcon("res/Image/MainBackGround.png");
    Image BackGround = imiBackGround.getImage();

    Font btnfont = new Font("맑은 고딕", Font.ITALIC,20);
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public MainMenu()
    {
        setPreferredSize(new Dimension(data.getBoardWidth(), data.getBoardHeight()));

        setLayout(null);
        //add(Box.createVerticalStrut(2));
        // 버튼 사이즈, 위치 조정
        btnGameStart.setLocation(400,280);
        btnGameStart.setSize(270,80);

        btnGameRule.setLocation(400,410);
        btnGameRule.setSize(270,80);

        btnExit.setLocation(400,540);
        btnExit.setSize(270,80);

        //버튼 틀제거
        btnGameStart.setBorderPainted(false);
        btnGameStart.setContentAreaFilled(false);
        btnGameStart.setFocusPainted(true);

        btnGameRule.setBorderPainted(false);
        btnGameRule.setContentAreaFilled(false);
        btnGameRule.setFocusPainted(true);

        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusPainted(true);


        add(btnGameStart);
        add(btnGameRule);
        add(btnExit);

        setFocusable(true);
        setVisible(true);
        //BtnMainMenu();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(BackGround,0,0,getWidth(),getHeight(),this);
    }


//    public void BtnMainMenu()
//        {
//            btnGameStart = new JButton("GameStart");
//            btnGameRule = new JButton("GameRule");
//            btnGameStart.setSize(300,300);
//            btnGameStart.setFont(btnfont);
//            btnGameRule.setSize(300,300);
//            btnGameRule.setFont(btnfont);
////        temp.addActionListener(listener -> asdf(Context));
//    }

//    protected void asdf(ActionEvent e)
//    {
//        temp = (JButton) e.getSource();
//
//        if(temp.getText().equals("GameStart"))
//        {
//            System.out.println("GameStart!");
//            setVisible(false);
//        }
//    }
}
