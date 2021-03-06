package com.zetcode;

//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
import java.util.Arrays;

//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
public class Data
{
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    private final int boardWidth        = 1000;
    private final int boardHeight       = 1000;
    private final int sizeDot           = 50;                // 10pix. -> 사과의 크기와 뱀의 점.
    private final int allDot            = 400;               // 전체 Dots 수.                             => width * height / sizedot^2
    private final int randPos           = 20;                // 랜덤 좌표.(사과에 대한 임의의 위치를 계산) => width / sizedot && heighth / sizedot
    protected int delay                 = 140 ;              // 게임 속도 조절.


    protected int score;
    protected int tmpScore;
    private boolean inGame;

    protected int enemytimer;

    protected boolean leftDirection = false;

    protected boolean rightDirection = true;
    protected boolean upDirection = false;
    protected boolean downDirection = false;

    protected int itemtimer;
    protected int clearballNum;

    private int EnemyValue;
    private int EnemyX2;
    private int EnemyY2;

    private int dots;
    private int apple_x;
    private int apple_y;
    private int item_x;
    private int item_y;

    private int index;
    private int tmpIndex;
    private int value;

    public boolean itemState = true;
    protected boolean eatItem = false;
    public boolean secTime = false;

    private String startGame;

    private int nowState = 1;
    private int tmpStage = 1;

    private boolean stateGame = true;


    private final int x[] = new int[allDot];      // 뱀의 x축 관절 저장.
    private final int y[] = new int[allDot];      // 뱀의 y축 관절 저장.

    protected int enemyDelay            = 70;                   // 적 속도 조절.

    private int enemyDots               = 15;
    private int enemyindex;
    private int enemyTmpIndex;
    private int enemyValue;


    private int enemyHeadX;
    private int enemyHeadY;

    private final int enemyX[] = new int[allDot]; // 적 뱀의 x축 관절 저장.
    private final int enemyY[] = new int[allDot]; // 적 뱀의 y축 관절 저장.


    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//

    public void setEnemyY2(int enemyY2)
    {
        EnemyY2 = enemyY2;
    }

    public int getTmpStage()
    {
        return tmpStage;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setTmpStage(int tmpStage)
    {
        this.tmpStage = tmpStage;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getTmpScore()
    {
        return tmpScore;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setTmpScore(int tmpScore)
    {
        this.tmpScore = tmpScore;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isSecTime()
    {
        return secTime;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setSecTime(boolean secTime)
    {
        this.secTime = secTime;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getNowState()
    {
        return nowState;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setNowState(int nowState)
    {
        this.nowState = nowState;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getDots()
    {
        return dots;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyDots(){
        return enemyDots;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setDots(int dots)
    {
        this.dots = dots;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyDots(int enemyDots) {
        this.enemyDots = enemyDots;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getApple_x()
    {
        return apple_x;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setApple_x(int apple_x)
    {
        this.apple_x = apple_x;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getApple_y()
    {
        return apple_y;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setApple_y(int apple_y)
    {
        this.apple_y = apple_y;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getX()
    {
        return x[index];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setX()
    {
        x[index] = value;
        this.x[index] = x[index];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getY()
    {
        return y[index];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setY()
    {
        y[index] = value;
        this.y[index] = y[index];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getTmpIndex()
    {
        return tmpIndex;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setTmpIndex(int tmpIndex)
    {
        this.tmpIndex = tmpIndex;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getTmpX()
    {
        return x[tmpIndex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setTmpX()
    {
        x[index] = x[tmpIndex];
        this.x[index] = x[index];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public  int getTmpY()
    {
        return y[tmpIndex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setTmpY()
    {
        y[index] = y[tmpIndex];
        this.y[index] = y[index];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getIndex()
    {
        return index;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setIndex(int index)
    {
        this.index = index;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getValue()
    {
        return value;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setValue(int value)
    {
        this.value = value;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getBoardWidth()
    {
        return boardWidth;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getBoardHeight()
    {
        return boardHeight;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getSizeDot()
    {
        return sizeDot;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getAllDot()
    {
        return allDot;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getRandPos()
    {
        return randPos;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getDelay()
    {
        return delay;
    }

    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isStateGame()
    {
        return stateGame;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setStateGame(boolean stateGame)
    {
        this.stateGame = stateGame;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public String getStartGame()
    {
        return startGame;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setStartGame(String startGame)
    {
        this.startGame = startGame;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setDelay(int delay) {
        this.delay = delay;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemytimer() {
        return enemytimer;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemytimer(int enemytimer) {
        this.enemytimer = enemytimer;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getItemtimer() {
        return itemtimer;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setItemtimer(int itemtimer) {
        this.itemtimer = itemtimer;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getClearballNum()
    {
        return clearballNum;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setClearballNum(int clearballNum)
    {
        this.clearballNum = clearballNum;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isInGame()
    {
        return inGame;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setInGame(boolean inGame)
    {
        this.inGame = inGame;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isEatItem()
    {
        return eatItem;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEatItem(boolean eatItem)
    {
        this.eatItem = eatItem;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getItem_x()
    {
        return item_x;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getItem_y()
    {
        return item_y;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setItem_x(int item_x)
    {
        this.item_x = item_x;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setItem_y(int item_y)
    {
        this.item_y = item_y;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isItemState()
    {
        return itemState;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setItemState(boolean itemState)
    {
        this.itemState = itemState;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isLeftDirection()
    {
        return leftDirection;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setLeftDirection(boolean leftDirection)
    {
        this.leftDirection = leftDirection;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isRightDirection()
    {
        return rightDirection;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setRightDirection(boolean rightDirection)
    {
        this.rightDirection = rightDirection;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isUpDirection()
    {
        return upDirection;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setUpDirection(boolean upDirection)
    {
        this.upDirection = upDirection;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public boolean isDownDirection()
    {
        return downDirection;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setDownDirection(boolean downDirection)
    {
        this.downDirection = downDirection;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getScore()
    {
        return score;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setScore(int score)
    {
        this.score = score;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyHeadX()
    {
        return enemyHeadX;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyHeadX(int enemyHeadX)
    {
        this.enemyHeadX = enemyHeadX;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyHeadY()
    {
        return enemyHeadY;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyHeadY(int enemyHeadY)
    {
        this.enemyHeadY = enemyHeadY;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyX()
    {
        return enemyX[enemyindex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyX()
    {
        enemyX[enemyindex] = enemyValue;
        this.enemyX[enemyindex] = enemyX[enemyindex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyY()
    {
        return enemyY[enemyindex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyY()
    {
        enemyY[enemyindex] = enemyValue;
        this.enemyY[enemyindex] = enemyY[enemyindex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyTmpIndex()
    {
        return enemyTmpIndex;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyTmpIndex(int enemyTmpIndex)
    {
        this.enemyTmpIndex = enemyTmpIndex;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyTmpX()
    {
        return enemyX[enemyTmpIndex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyTmpX()
    {
        enemyX[enemyindex] = enemyX[enemyTmpIndex];
        this.enemyX[enemyindex] = enemyX[enemyindex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyTmpY()
    {
        return enemyY[enemyTmpIndex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyTmpY()
    {
        enemyY[enemyindex] = enemyY[enemyTmpIndex];
        this.enemyY[enemyindex] = enemyY[enemyindex];
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyindex()
    {
        return enemyindex;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyindex(int enemyindex)
    {
        this.enemyindex = enemyindex;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyValue()
    {
        return enemyValue;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyValue(int enemyValue)
    {
        this.enemyValue = enemyValue;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public int getEnemyDelay()
    {
        return enemyDelay;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void setEnemyDelay(int enemyDelay)
    {
        this.enemyDelay = enemyDelay;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//

    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    @Override
    public String toString()
    {
        return "Data{" + "boardWidth=" + boardWidth + ", boardHeight=" + boardHeight + ", sizeDot=" + sizeDot + ", allDot=" + allDot + ", randPos=" + randPos + ", delay=" + delay + ", dots=" + dots + ", apple_x=" + apple_x + ", apple_y=" + apple_y + ", index=" + index + ", tmpIndex=" + tmpIndex + ", value=" + value + ", stateGame=" + stateGame + ", startGame='" + startGame + '\'' + ", x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y) + '}';
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
}
//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//