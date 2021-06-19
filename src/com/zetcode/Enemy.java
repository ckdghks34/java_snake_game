package com.zetcode;

public abstract class Enemy
{
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    Data data;

    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    Enemy(Data data)
    {
        this.data = data;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public abstract void createEnemy(int playerX, int playerY);
//    {
//        EventState.enemyExist = true;
//
//        if(data.isRightDirection())
//        {
//            if(playerY < data.getBoardHeight()/ 2)
//            {
//                data.setEnemyHeadX(playerX + 150);
//                data.setEnemyHeadY(0);
//                EventState.enemyDirection = EventState.DOWN;
//            }
//
//            if(playerY > data.getBoardHeight() / 2)
//            {
//                data.setEnemyHeadX(playerX + 150);
//                data.setEnemyHeadY(data.getBoardHeight());
//                EventState.enemyDirection = EventState.UP;
//            }
//        }
//
//        if(data.isLeftDirection())
//        {
//            if(playerY < data.getBoardHeight() / 2)
//            {
//                data.setEnemyHeadX(playerX - 150);
//                data.setEnemyHeadY(0);
//                EventState.enemyDirection = EventState.DOWN;
//            }
//
//            if(playerY > data.getBoardHeight() / 2)
//            {
//                data.setEnemyHeadX(playerX - 150);
//                data.setEnemyHeadY(data.getBoardHeight());
//                EventState.enemyDirection = EventState.UP;
//            }
//        }
//
//        if(data.isUpDirection())
//        {
//            if(playerX > data.getBoardWidth() / 2)
//            {
//                data.setEnemyHeadY(playerY - 150);
//                data.setEnemyHeadX(data.getBoardWidth());
//                EventState.enemyDirection = EventState.LEFT;
//            }
//
//            if(playerX < data.getBoardWidth() / 2)
//            {
//                data.setEnemyHeadY(playerY - 150);
//                data.setEnemyHeadX(0);
//                EventState.enemyDirection = EventState.RIGHT;
//            }
//        }
//
//        if(data.isDownDirection())
//        {
//            if(playerX < data.getBoardWidth() / 2)
//            {
//                data.setEnemyHeadY(playerY + 150);
//                data.setEnemyHeadX(data.getBoardWidth());
//                EventState.enemyDirection = EventState.LEFT;
//            }
//
//            if(playerX > data.getBoardWidth() / 2)
//            {
//                data.setEnemyHeadY(playerY + 150);
//                data.setEnemyHeadX(0);
//                EventState.enemyDirection = EventState.RIGHT;
//            }
//        }
//    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected abstract void move();
//    {
//        for (data.setEnemyindex(data.getEnemyDots()); data.getEnemyindex() > 0; data.setEnemyindex(data.getEnemyindex()- 1))
//        {
//            data.setEnemyTmpIndex(data.getEnemyindex() - 1);
//            data.setEnemyTmpX();
//            data.setEnemyTmpY();
////            x[z] = x[(z - 1)];
////            y[z] = y[(z - 1)];
//        }
//        if (EventState.enemyDirection == EventState.LEFT) {
//            data.setEnemyindex(0);
//            data.setEnemyValue(data.getEnemyX() - data.getSizeDot());
//            data.setEnemyX();
//            data.setEnemyindex(data.getEnemyDots() -1 );
//            if(data.getEnemyX() <= 0)
//            {
//                EventState.enemyExist = false;
//            }
////            x[0] -= data.getDots();
//        }
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
//        if (EventState.enemyDirection == EventState.DOWN) {
//            data.setEnemyindex(0);
//            data.setEnemyValue(data.getEnemyY() + data.getSizeDot());
//            data.setEnemyY();
//            data.setEnemyindex(data.getEnemyDots() -1 );
//            if(data.getEnemyY() >= data.getBoardHeight())
//            {
//                EventState.enemyExist = false;
//            }
////            y[0] += DOT_SIZE;
//        }
//    }
}
