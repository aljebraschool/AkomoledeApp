package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class OrikiOroAropoOrukoActivity extends AppCompatActivity {

    private MediaPlayer playmusic;
    private AudioManager audioManager;

    //declared an instance variable (completionListener) which store
    // the objects of the Mediaplayer's OnCompletionListener interface
    //to avoid creating new object everytime onCompletionListener method is called to release the memory
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    //we declared a class variable (onAudioFocusChangeListener) which will be used to store the object of OnDudioFocusChangeListener interface
    //interface which implements onAudioFocusChange callball method for AudioManager
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        //implementing callback method to handle change of states of audioFocus
        @Override
        public void onAudioFocusChange(int changeFocus) {

            //checks if audiofocus was completely lost
            if (changeFocus == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer(); //call releaseMediaPlayer method
            }

            //checks if audiofocus was completely gained
            else if (changeFocus == AudioManager.AUDIOFOCUS_GAIN) {
                playmusic.start();
            }

            //checks if audioFocus was either temporary lost due to incoming call or notifivication
            else if (changeFocus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || changeFocus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                playmusic.pause();      //pause the music
                playmusic.seekTo(0); //start afresh
            }


        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.oro_aropo_oruko_definition);


        RelativeLayout layout = findViewById(R.id.pronoun_definition);


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will release the system memory before any audio object is being created
                releaseMediaPlayer();

                //created the audioManager context servive to request for audio focus from android system
                audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

                //request for audio focus using requestAudioFocus method
                //by passing the following parameters
                //@param onAudioFocusChangeListener : onAudioFocusChangeListener object
                //@param AudioManger.STREAM_MUSIC : constant that signifies the type of audio we are requesting
                //@param AudioManager.AUDIOFOCUS_GAIN_TRANSIENT : constant that signifies the duration of request
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                //if granted
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //use the position gotten above to set the resource file for each arrayList
                    //by accessing a public method getAudiofile() in class Word
                    playmusic = MediaPlayer.create(getApplicationContext(), R.raw.oro_aropo_oruko_ni_a_nlo);

                    //Then start playing your sound with respect to the arraylist object position
                    playmusic.start();

                    //call the setOnCompletionListener (call back method) method and
                    // pass the MediaPlayer.OnCompletionLister interface
                    // object to it after it started playing sound
                    playmusic.setOnCompletionListener(completionListener);

                }


            }
        });

        //used to display action button that will take this activity back to the main screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    //method to clean up our phone memory by releasing the class variable playmusic
    //when it's not pointing to any object in memory
    private void releaseMediaPlayer() {
        //check if the class variable object is being used to play sound
        if (playmusic != null) {
            playmusic.release();    //call the release method on it after use

            //now reassign the class variable to null to be
            // reclaimed by the phone memory
            playmusic = null;

            //abandon audio focus when it's not pointing to any object
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }

    }

    //method onStop used to reclaim app memory when the user leaves the app at any point
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }

}
