package com.zetcode;

//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
public class EnemyX extends Enemy
{
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    Data data;
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public EnemyX(Data data)
    {
        super(data);
        this.data = data;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void createEnemy(int playerX, int playerY)
    {
        EventState.enemyExist = true;

        data.setEnemyHeadX(700);
        data.setEnemyHeadY(0);
        EventState.enemyDirection = EventState.LEFT;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void move()
    {
        for (data.setEnemyindex(data.getEnemyDots()); data.getEnemyindex() > 0; data.setEnemyindex(data.getEnemyindex()- 1))
        {
            data.setEnemyTmpIndex(data.getEnemyindex() - 1);
            data.setEnemyTmpX();
            data.setEnemyTmpY();
//            x[z] = x[(z - 1)];
//            y[z] = y[(z - 1)];
        }
        if (EventState.enemyDirection == EventState.LEFT) {
            data.setEnemyindex(0);
            data.setEnemyValue(data.getEnemyX() - data.getSizeDot());
            data.setEnemyX();
            data.setEnemyindex(data.getEnemyDots() -1 );
            if(data.getEnemyX() <= 0)
            {
                EventState.enemyExist = false;
            }
//            x[0] -= data.getDots();
        }
//        if (EventState.enemyDirection == EventState.RIGHT) {
//            data.setEnemyindex(0);
//            data.setEnemyValue(data.getEnemyX() + data.getSizeDot());
//            data.setEnemyX();
//            data.setEnemyindex(data.getEnemyDots() -1 );
//            if(data.getEnemyX() >= data.getBoardWidth())
//            {
//                EventState.enemyExist = false;
//            }
////            x[0] += DOT_SIZE;
//        }
//        if (EventState.enemyDirection == EventState.UP) {
//            data.setEnemyindex(0);
//            data.setEnemyValue(data.getEnemyY() - data.getSizeDot());
//            data.setEnemyY();
//            data.setEnemyindex(data.getEnemyDots() -1 );
//            if(data.getEnemyY() <= 0)
//            {
//                EventState.enemyExist = false;
//            }
////            y[0] -= DOT_SIZE;
//        }
        if (EventState.enemyDirection == EventState.DOWN) {
            data.setEnemyindex(0);
            data.setEnemyValue(data.getEnemyY() + data.getSizeDot());
            data.setEnemyY();
            data.setEnemyindex(data.getEnemyDots() -1 );
            if(data.getEnemyY() >= data.getBoardHeight())
            {
                EventState.enemyExist = false;
            }
//            y[0] += DOT_SIZE;
        }
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
}
//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//