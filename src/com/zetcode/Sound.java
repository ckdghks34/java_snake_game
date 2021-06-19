package com.zetcode;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Sound
{

    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    private String audioFile;
    private Clip clip;
    private AudioInputStream audio;

    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public Sound(String file)      //
    {
        audioFile = file;
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void PlaySound(boolean loop)
    {
        try
        {
            audio = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(audioFile)));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            if(loop)
                clip.loop(-1);
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------------------------------------------//
    //
    //--------------------------------------------------------------------------------------------//
    public void stopSound()
    {
        clip.stop();
    }
    
}
