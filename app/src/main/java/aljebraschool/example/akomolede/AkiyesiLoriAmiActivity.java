/* The activity implements the content covered under "akiyesi lori ami" */

package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class AkiyesiLoriAmiActivity extends AppCompatActivity {

    //created a mediaplayer class object to play music
    private MediaPlayer playmusic;

    //created a audiomanager class object to manage audio
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
            if(changeFocus == AudioManager.AUDIOFOCUS_LOSS)
            {
                releaseMediaPlayer(); //call releaseMediaPlayer method
            }

            //checks if audiofocus was completely gained
            else if(changeFocus == AudioManager.AUDIOFOCUS_GAIN)
            {
                playmusic.start();
            }

            //checks if audioFocus was either temporary lost due to incoming call or notifivication
            else if(changeFocus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || changeFocus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                playmusic.pause();      //pause the music
                playmusic.seekTo(0); //start afresh
            }


        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.akiyesi_ami);


        //store the audio files i want to use in an integer array
        int[] audioFiles = {R.raw.a_kii_fi_ami_re_sori_oro, R.raw.ori_faweli, R.raw.a_ki_fi_ami_konsonat_asesilebu};


        //find the layouts you wants to set events on
        LinearLayout layout = findViewById(R.id.layout_notice_one);
        LinearLayout layout2 = findViewById(R.id.layout_notice_two);
        LinearLayout layout3 = findViewById(R.id.layout_notice_three);



        //create an inner class object that will implement the onClick method
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the id(value) of the textView(s)
                int clickedLayoutId = view.getId();

                //use a switch case to find the textview that was clicked
                switch (clickedLayoutId){
                    case R.id.layout_notice_one:
                        playAudioFile(audioFiles[0]);
                        break;
                    case R.id.layout_notice_two:
                        playAudioFile(audioFiles[1]);
                        break;
                    case R.id.layout_notice_three:
                        playAudioFile(audioFiles[2]);
                        break;


                }

            }
        };


        //used to display action button that will take this activity back to the main screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //set the onClicklistener method on the textview
        layout.setOnClickListener(clickListener);
        layout2.setOnClickListener(clickListener);
        layout3.setOnClickListener(clickListener);


    }



    //method that is called when you want to play an audio file
    private void playAudioFile(int audioFile){

        //this will release the system memory before any audio object is being created
        releaseMediaPlayer();

        //created the audioManager context service to request for audio focus from android system
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //request for audio focus using requestAudioFocus method
        //by passing the following parameters
        //@param onAudioFocusChangeListener : onAudioFocusChangeListener object
        //@param AudioManger.STREAM_MUSIC : constant that signifies the type of audio we are requesting
        //@param AudioManager.AUDIOFOCUS_GAIN_TRANSIENT : constant that signifies the duration of request
        int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);


        //if granted
        if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
        {


            //use the position gotten above to set the resource file for each arrayList
            //by accessing a public method getAudiofile() in class Word
            playmusic = MediaPlayer.create(getApplicationContext(), audioFile);

            //Then start playing your sound with respect to the arraylist object position
            playmusic.start();

            //call the setOnCompletionListener (call back method) method and
            // pass the MediaPlayer.OnCompletionLister interface
            // object to it after it started playing sound
            playmusic.setOnCompletionListener(completionListener);

        }

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