package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class GameRule extends JPanel{

    Data data = new Data();
    JButton btnBack = new JButton(new ImageIcon("res/Image/BackImage.png"));

    ImageIcon imiRule = new ImageIcon("res/Image/GameRule.png");
    Image gameRule = imiRule.getImage();

    GameRule(){
        setPreferredSize(new Dimension(data.getBoardWidth(), data.getBoardHeight()));

        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(true);

        add(btnBack);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setFocusable(true);
        setVisible(true);
//        add(panel);
//       setSize(700,700);
//        setVisible(true);
//        JLabel LbRule = new JLabel(imiRule);
//        add(LbRule);
//        LbRule.setVisible(true);
//        add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                setFocusable(false);
                Snake.panels.remove(this);
                Snake.panels.get(0).setVisible(true);
                Snake.panels.get(0).setFocusable(true);
                repaint();
            }
        });
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(gameRule,0,0,getWidth(),getHeight(),this);
    }
}

