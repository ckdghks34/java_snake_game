package com.zetcode;

//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
public class Board extends JPanel
                    implements ActionListener
{
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    Data data = new Data();
    Player player;
    Enemy enemy;
    Enemy enemyX;
    StageOne stageOne;
    StageTwo stageTwo;
    StageThree stageThree;

    Item item = new Item(data);
    Save save = new Save(data);

    private boolean inGame = true;

    private Timer timer;

    public int highNum;

    private Image ball;
    private Image apple;
    private Image head;
    private Image gameItem;

    private Image enemyHead;
    private Image enemyBall;
    protected Image GameBackGround;

    protected int tempStage;

    JPanel high = new JPanel();

    JButton btnGotoMain = new JButton(new ImageIcon("res/Image/GameOverBack.png"));
    JButton btnContinue = new JButton(new ImageIcon("res/Image/btnContinue.png"));
//    protected Timer timer;
    //int tmp;


    int x[] = new int[data.getDots()];
    protected Sound backGroundMusic = new Sound("res/Sound/BGM.wav");
    protected Sound eatAappleMusic = new Sound("res/Sound/EatCoin.wav");
    protected Sound gameOverMusic = new Sound("res/Sound/Death.wav");

    public int scoreNum = 0;


    int enemyLocation[] = new int[data.getEnemyDots()];
    // --------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public Board()
    {
        initBoard();
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    private void initBoard()
    {
        player = new Player(data);
        enemy = new EnemyY(data);
        enemyX = new EnemyX(data);
        tempStage = data.getNowState();

        high.setBackground(Color.BLACK);
        high.setSize(350,60);
        high.setLocation(20,20);
        high.setLayout(new FlowLayout(FlowLayout.LEFT));
        high.setVisible(false);

        btnGotoMain.setBorderPainted(false);
        btnGotoMain.setContentAreaFilled(false);
        btnGotoMain.setFocusPainted(true);

        btnContinue.setBorderPainted(false);
        btnContinue.setContentAreaFilled(false);
        btnContinue.setFocusPainted(true);

        high.add(btnGotoMain).setVisible(false);
        high.add(btnContinue).setVisible(false);
        add(high);


        addKeyListener(new TAdapter());

        setBackground(Color.black);
//            setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(null);
        setPreferredSize(new Dimension(data.getBoardWidth(), data.getBoardHeight()));

        setFocusable(true);
        setImages();
        backGroundMusic.PlaySound(true);
        System.out.println("key");
        data.setInGame(true);
        data.setTmpScore(data.getScore());
        data.setTmpStage(data.getNowState());
        data.setScore(0);
        data.setNowState(1);

        if( data.getNowState() == 1 )
        {

        }
        else if( data.getNowState() == 2)
            stageTwo.stageInfo(data);
        else if( data.getNowState() == 3)
            stageThree.stageInfo(data);

        initGame();
        setVisible(true);
        setEnabled(true);
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void initGame()
    {
        data.setDots(3);
        data.setEnemyDots(data.getEnemyDots());
        System.out.println("initgame");
        for (data.setIndex(0); data.getIndex() < data.getDots(); data.setIndex(data.getIndex() + 1)) {
            data.setValue(100 - data.getIndex() * 10);
            data.setX();
            data.setValue(100);
            data.setY();
        }

        newEnemyDown();
        newEnemyLeft();

        locateApple();
        item.locateItem();

        setTimer();
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void newEnemyLeft()
    {
        // Enemy 생성
        for (data.setEnemyindex(0); data.getEnemyindex() < data.getEnemyDots(); data.setEnemyindex(data.getEnemyindex()+1))
        {
            data.setEnemyValue(0);
            data.setEnemyX();

            data.setEnemyValue(300);
            data.setEnemyY();
        }

        if(!EventState.enemyExist)
        {
            data.setIndex(0);
            enemy.createEnemy(data.getX(), data.getY());
        }
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void newEnemyDown()
    {
        // Enemy 생성
        for (data.setEnemyindex(0); data.getEnemyindex() < data.getEnemyDots(); data.setEnemyindex(data.getEnemyindex()+1))
        {
            data.setEnemyValue(700);
            data.setEnemyX();
            data.setEnemyValue(0);
            data.setEnemyY();
        }

        if(!EventState.enemyExist)
        {
            data.setIndex(0);
            enemy.createEnemy(data.getX(), data.getY());
        }
    }

    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setTimer(){
        timer = new Timer(data.getDelay(), this);
        timer.start();
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void setImages()
    {
        ImageIcon imiBall = new ImageIcon("res/Image/PlayerBody2.png");
        ball = imiBall.getImage();

        ImageIcon imiApple = new ImageIcon("res/Image/Item2.png");
        apple = imiApple.getImage();

        ImageIcon imiHead = new ImageIcon("res/Image/PlayerHead2.png");
        head = imiHead.getImage();

        ImageIcon imiEnemyHead = new ImageIcon("res/Image/EnemyHead.png");
        enemyHead = imiEnemyHead.getImage();

        ImageIcon imiEnemyBall = new ImageIcon("res/Image/EnemyBall.png");
        enemyBall = imiEnemyBall.getImage();

        ImageIcon imiGameBackGround = new ImageIcon("res/Image/GameBackGround.jpg");
        GameBackGround = imiGameBackGround.getImage();

        ImageIcon imiItem = new ImageIcon("res/Image/Item.png");
        gameItem = imiItem.getImage();
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(GameBackGround,0,0,getWidth(),getHeight(),this);
        if(data.itemState == true) {
            g.drawImage(gameItem, data.getItem_x(), data.getItem_y(), this);
        }
        doDrawing(g);
        doEnemyDrawing(g);

        File inFile = new File("res/txt", "HighScore.txt");
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new FileReader(inFile));
            String line;
            while ((line = br.readLine()) != null)
            {
                highNum = Integer.parseInt(line);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(br != null) try {br.close(); } catch (IOException e) {}
        }

        g.setColor(Color.RED);
        Font font = new Font("Verdana", Font.BOLD,17);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        String score = ("Stage :"+ tempStage +"    Score : "+ data.getScore() +"      "+"HighScore : "+highNum);
        g.drawString(score,600,50);
    }
    //--------------------------------------------------------------------------------------------//
    // 사과 먹었을 때, 꼬리 추가.(그림으로 추가.)
    //--------------------------------------------------------------------------------------------//
    private void doDrawing(Graphics g)
    {
        if(data.isInGame())
        {
            g.drawImage(apple, data.getApple_x(), data.getApple_y(), this);

            for (data.setIndex(0); data.getIndex() < data.getDots(); data.setIndex(data.getIndex()+1))
            {
                if (data.getIndex() == 0)
                    g.drawImage(head, data.getX(), data.getY(), this);
                else
                    g.drawImage(ball, data.getX(), data.getY(), this);
            }

            Toolkit.getDefaultToolkit().sync();
        }
        else {
            gameOver(g);
        }
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    private void doEnemyDrawing(Graphics g)
    {
        if(inGame)
        {
            for(data.setEnemyindex(0); data.getEnemyindex() < data.getEnemyDots(); data.setEnemyindex(data.getEnemyindex() +1))
            {
                if(data.getEnemyindex() == 0)
                    g.drawImage(enemyHead, data.getEnemyX(), data.getEnemyY(), this);
                else
                    g.drawImage(enemyBall, data.getEnemyX(), data.getEnemyY(), this);
            }

            Toolkit.getDefaultToolkit().sync();

        }
        else
            gameOver(g);
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    private void checkEnemyCollison()
    {
        int i =0;
        int enemyX[] = new int[data.getEnemyDots()];
        int enemyY[] = new int[data.getEnemyDots()];

        for(data.setEnemyindex(0);data.getEnemyindex()<data.getEnemyDots();data.setEnemyindex(data.getEnemyindex()+1))
        {
            enemyX[i] = data.getEnemyX();
            enemyY[i] = data.getEnemyY();
            i++;
        }

        data.setIndex(0);
        for(i = 0; i<data.getEnemyDots();i++)
        {
            if(data.getX() == enemyX[i] && data.getY() == enemyY[i])
            {
                this.inGame = false;
                break;
            }



        }
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void gameOver(Graphics g)
    {
            backGroundMusic.stopSound();
            gameOverMusic.PlaySound(false);
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (data.getBoardWidth() - metr.stringWidth(msg)) / 2, data.getBoardHeight() / 2);

            File outFile = new File("res/txt", "HighScore.txt");
            String stScore = Integer.toString(data.getScore());

            BufferedWriter bw = null;
            if (data.getScore() > highNum)
            {
                try
                {
                    bw = new BufferedWriter(new FileWriter(outFile));
                    bw.write(stScore);
                    bw.flush();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (bw != null) try
                    {
                        bw.close();
                    }
                    catch (IOException e)
                    {
                    }
                }
            }
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    private void createEnd()
    {
        if (!data.isInGame())
        {
            high.setVisible(true);
            btnGotoMain.setVisible(true);
            btnGotoMain.setFocusable(true);
            btnContinue.setVisible(true);
            btnContinue.setFocusable(true);

            btnGotoMain.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    gameOverMusic.stopSound();
                    setVisible(false);
                    setFocusable(false);
                    Snake.panels.remove(2);
                    Snake.panels.get(0).setVisible(true);
                    Snake.panels.get(0).setFocusable(true);
                }
            });

            btnContinue.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    Board newBoard = new Board();
                    newBoard.setSize(700,700);
                    Snake.temp.add(newBoard);

                    Snake.panels.add(newBoard);
                    Snake.panels.get(3).setVisible(true);
                    Snake.panels.get(3).setFocusable(true);
                    data.setNowState(data.getTmpStage());

                    gameOverMusic.stopSound();
                    setVisible(false);
                    setFocusable(false);

                    Snake.panels.remove(2);
                }
            });
        }
        else
            return;
    }

    //--------------------------------------------------------------------------------------------//
    // 사과 먹었는지 확인 후, 생성.
    //--------------------------------------------------------------------------------------------//
    private void checkApple()
    {
        data.setIndex(0);
        if ((data.getX() == data.getApple_x()) && (data.getY() == data.getApple_y()))
        {
            eatAappleMusic.PlaySound(false);
            data.setDots(data.getDots()+1);
            data.setScore(data.getScore()+10);
            locateApple();
        }
    }
    //--------------------------------------------------------------------------------------------//
    // 벽 닿았을 때, 이벤트 처리.
    //--------------------------------------------------------------------------------------------//
    private void checkCollision()
    {
        data.setTmpIndex(0);
        for (data.setIndex(data.getDots()); data.getIndex() > 0; data.setIndex(data.getIndex() - 1))
        {
            if ((data.getIndex() > 1) && (data.getTmpX() == data.getX()) && (data.getTmpY() == data.getY()))
                data.setInGame(false);
        }

        data.setIndex(0);
        if (data.getY() >= data.getBoardHeight())
        {
            data.setInGame(false);
        }
        if (data.getY() < 0)
        {
            data.setInGame(false);
        }
        if (data.getX() >= data.getBoardWidth())
        {
            data.setInGame(false);
        }
        if (data.getX() < 0)
        {
            data.setInGame(false);
        }
        if (!data.isInGame())
            timer.stop();
    }
    //--------------------------------------------------------------------------------------------//
    // 사과 랜덤 생성.
    //--------------------------------------------------------------------------------------------//
    private void locateApple()
    {
        int r = (int) (Math.random() * data.getRandPos());
        data.setApple_x(r * data.getSizeDot());

        r = (int) (Math.random() * data.getRandPos());
        data.setApple_y(r * data.getSizeDot());
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (data.isInGame())
        {
            if(data.isEatItem()==true)
                timer.setDelay(300);
            else if(data.secTime==false)
                timer.setDelay(100);

            // esc 눌렸을 때.
//            if( data.isStateGame() != true)
//                timer.setDelay(5000);
//            else
//                timer.restart();

            checkApple();

            // 스테이지 넘어가는 부분.
            if( data.getDots() > 10 )
            {
                if( data.getNowState() == 1 )
                {
                    data.setNowState(2);
                    tempStage = data.getNowState();
//                    Board newBoard = new Board();
//                    newBoard.setSize(1000,1000);
//                    Snake.temp.add(newBoard);
//
//
//                    Snake.panels.add(newBoard);
//                    Snake.panels.get(4).setVisible(true);
//                    Snake.panels.get(4).setFocusable(true);
//
//                    gameOverMusic.stopSound();
//                    setVisible(false);
//                    setFocusable(false);
//
//                    Snake.panels.remove(2);

                }
                else if( data.getNowState() == 2 && data.getDots() == 20)
                {
                    data.setNowState(3);
                    data.setTmpStage(data.getNowState());
                    tempStage = data.getNowState();
//                    Board newBoard = new Board();
//                    newBoard.setSize(700,700);
//                    Snake.temp.add(newBoard);
//
//                    Snake.panels.add(newBoard);
//                    Snake.panels.get(3).setVisible(true);
//                    Snake.panels.get(3).setFocusable(true);
//
//                    gameOverMusic.stopSound();
//                    setVisible(false);
//                    setFocusable(false);
//
//                    Snake.panels.remove(2);
                }
            }

            checkCollision();
            player.move();
            enemy.move();
            checkEnemyCollison();
            item.checkItem();
            createEnd();
        }
        repaint();
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT) && (!data.rightDirection))
            {
               data.leftDirection = true;
                data.upDirection = false;
                data.downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!data.leftDirection))
            {
                data.rightDirection = true;
                data.upDirection = false;
                data.downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!data.downDirection))
            {
                data.upDirection = true;
                data.rightDirection = false;
                data.leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!data.upDirection))
            {
                data.downDirection = true;
                data.rightDirection = false;
                data.leftDirection = false;
            }

            if((key == KeyEvent.VK_G)){
                System.out.println("Input G");
                save.saveEnemyLocation();
                save.savePlayerLocation();
                save.saveItemLocation();
                save.saveAssignmentLocation();
                save.saveScore();
                save.saveStage();
            }

        }
    }
}
//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//