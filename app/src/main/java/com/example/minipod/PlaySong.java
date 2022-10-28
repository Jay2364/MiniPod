package com.example.minipod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class PlaySong extends AppCompatActivity {

    String[] nameArray;
    int[] songArray;
    int[] imageArray;

    SeekBar seekBar;

    ImageView imageView;
    TextView textView;
    ImageView play;
    ImageView next;
    ImageView prev;
    ImageView like;
    ImageView share;
    boolean flag = true;

    public int currPosition;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    AudioAttributes playbackAttributes;

    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mediaPlayer.release();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        seekBar = findViewById(R.id.seekBar);

        /* ------------------------------------ Intent Catching ----------------------------------*/
        Intent intent = getIntent();
        nameArray = intent.getStringArrayExtra("nameArray");
        imageArray = intent.getIntArrayExtra("imageArray");
        songArray = intent.getIntArrayExtra("songArray");
        currPosition = intent.getIntExtra("position",1);
        /* ------------------------------------ Intent Catching ----------------------------------*/


        /* --------------------------------- Buttons and listeners -------------------------------*/
        play = findViewById(R.id.imageView3);
        next = findViewById(R.id.imageView6);
        prev = findViewById(R.id.imageView4);
        like = findViewById(R.id.imageView7);
        share = findViewById(R.id.imageView8);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == true) {
                    paused();
                    play.setImageResource(R.drawable.play);
                    flag = false;
                } else {
                    play();
                    play.setImageResource(R.drawable.circledpause);
                    flag = true;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prev();
            }
        });
        /* --------------------------------- Buttons and listener --------------------------------*/


        /* ------------------------------------- AudioFocus ------------------------------------- */
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // initiate the audio playback attributes
        playbackAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        // set the playback attributes for the focus requester
        AudioFocusRequest focusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                .setAudioAttributes(playbackAttributes)
                .setAcceptsDelayedFocusGain(true)
                .setOnAudioFocusChangeListener(audioFocusChangeListener)
                .build();

        // request the audio focus and
        // store it in the int variable
        final int audioFocusRequest = audioManager.requestAudioFocus(focusRequest);
        /* ------------------------------------- AudioFocus ------------------------------------- */


        /* ------------------------------------ MediaPlayer ------------------------------------- */
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        playSong();
        /* ------------------------------------ MediaPlayer ------------------------------------- */


        /* -------------------------------------- Seekbar --------------------------------------- */
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /* -------------------------------------- Seekbar --------------------------------------- */


        /* ------------------------------------ Completion ------------------------------------- */
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                next();
            }
        });
        /* ------------------------------------ Completion ------------------------------------- */

    }

    public void play() {
        mediaPlayer.start();
    }

    public void paused() {
        mediaPlayer.pause();
    }

    public void playSong(){
        mediaPlayer = MediaPlayer.create(getApplicationContext(),songArray[currPosition]);

        textView.setText(nameArray[currPosition]);
        imageView.setImageResource(imageArray[currPosition]);
        mediaPlayer.start();
        seekBar.setProgress(0);
        seekB(0);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                next();
            }
        });
    }

    public void next() {
        currPosition = (currPosition + 1) % songArray.length;
        mediaPlayer.release();
        playSong();
    }

    public void seekB(int position){
        seekBar.setMax(mediaPlayer.getDuration());
        mediaPlayer.seekTo(position);
        seekBar.setProgress(0);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void prev() {
        currPosition = (currPosition-1 + songArray.length) % songArray.length;
        mediaPlayer.release();
        playSong();
    }
}