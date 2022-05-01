package com.example.newyear;

import android.content.Context;
import android.content.ContextWrapper;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.util.Log;

class AudioPlayer extends ContextWrapper {
    private final static String TAG = "AudioPlayer";
    private MediaPlayer mPlayer;

    public AudioPlayer(Context base) {
        super(base);
    }

    public void play(){
        mPlayer = MediaPlayer.create(this,R.raw.track);
        mPlayer.start();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stop();
                Log.d(TAG,"Clicked!" );
            }
        });
    }
    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }
}