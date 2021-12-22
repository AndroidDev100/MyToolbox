package com.app.mytoolbox.utils;

import android.os.AsyncTask;
import android.util.Log;

import com.app.mytoolbox.player.ui.DTPlayer;

public class DoubleTabAsyncTask extends AsyncTask<Void, Void, Void> {
    public int minGapOfTaps;
    public DTPlayer dtPlayer;

    public DoubleTabAsyncTask(DTPlayer dtPlayer, int miniGapOfTaps) {
        this.minGapOfTaps = miniGapOfTaps;
        this.dtPlayer=dtPlayer;
    }

    @Override
    protected void onPostExecute(Void unused) {
        this.dtPlayer.isTapped=false;
        this.dtPlayer.tapThread=null;
        if(!dtPlayer.isDoubleTap){

            Log.i("TOUCH_EVENTS", "rl_UP");
            this.dtPlayer.isTouchCaptured = false;
            if (this.dtPlayer.isSeekBarInteraction) {
                this.dtPlayer.showPlayerAllControls();
                this.dtPlayer.showSeekBar();
                this.dtPlayer.isSeekBarInteraction = false;
            }
            else if (this.dtPlayer.isDragGesture) {
                this.dtPlayer.hideVolumeDialog();
                this.dtPlayer.hideBrightnessDialog();
                    this.dtPlayer.showPlayerAllControls();
               this.dtPlayer.isDragGesture=false;
            }
            else{
                this.dtPlayer.showPlayerAllControls();
                this.dtPlayer.showPlayerMediaControls();
                this.dtPlayer.showSeekBar();
            }
        }
        else{
            this.dtPlayer.isDoubleTap = true;
            this.dtPlayer.playPauseControl();
            if (!this.dtPlayer.adRunning) {
                this.dtPlayer.showCurrentTime();
                this.dtPlayer.showSlash();
                this.dtPlayer.showTotalDuration();
            }
        }
        this.dtPlayer.isDoubleTap=false;
        super.onPostExecute(unused);

    }


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            this.dtPlayer.tapThread=Thread.currentThread();
            Thread.sleep(this.minGapOfTaps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        this.dtPlayer.isTapped=true;

        super.onPreExecute();
    }
}
