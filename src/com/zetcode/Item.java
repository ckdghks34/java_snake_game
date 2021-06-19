package com.zetcode;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Item {
    Data data = new Data();
    public Item(Data data){
        this.data = data;
        Runnable runnableItem = new Runnable(){
            @Override
            public void run() {
                if(data.itemState == false){
                    data.itemState = true;
                }
                else {
                    locateItem();
                    data.itemState = false;
                }
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnableItem, 0, 30000,TimeUnit.MILLISECONDS);

    }
    public void checkItem()
    {
        data.setIndex(0);
        if ((data.getX() == data.getItem_x()) && (data.getY() == data.getItem_y())&&data.itemState == true)
        {


//            data.secTime = true;
            data.setEatItem(true);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    data.setEatItem(false);
//                    if(data.secTime == false){
//                        data.setEatItem(false);
//                    }
//                  else{
//                      data.secTime = false;
//                   }
                }
            };
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            service.scheduleAtFixedRate(runnable, 5000, 10000,TimeUnit.MILLISECONDS);

            data.itemState = false;
            locateItem();
        }
    }
    public void locateItem()
    {
        int r = (int) (Math.random() * data.getRandPos());
        data.setItem_x(r * data.getSizeDot());

        r = (int) (Math.random() * data.getRandPos());
        data.setItem_y(r * data.getSizeDot());
    }
}
