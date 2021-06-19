package com.zetcode;

//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//
public class StageThree extends Stage
{
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    Data data;
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public StageThree(Data data)
    {
        super(data);
        this.data = data;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    protected void stageInfo(Data data)
    {
        data.setScore(data.getTmpScore());
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
}
//------------------------------------------------------------------------------------------------//
//
//------------------------------------------------------------------------------------------------//