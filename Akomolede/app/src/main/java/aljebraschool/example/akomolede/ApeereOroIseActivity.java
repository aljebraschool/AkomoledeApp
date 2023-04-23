/* The activity implements the content covered under "examples of verbs in yoruba" */
package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;



public class ApeereOroIseActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apeere_oro_ise);

        //store the audio files i want to use in an integer array
        int[] audioFiles = {R.raw.sare, R.raw.tunde_sare_wa, R.raw.mo_fe_sare_jade,
                R.raw.duro, R.raw.duro_de_mi,
                R.raw.mo_fe_jokoo, R.raw.folake_duro, R.raw.jokoo,
                R.raw.baba_ti_joko_tipe, R.raw.sun, R.raw.mo_fe_sun,
                R.raw.bola_n_sun, R.raw.wa, R.raw.jowo_wa,
                R.raw.mo_wa_mi_o_bayin, R.raw.lo, R.raw.mo_fe_jeun,
                R.raw.mama_lo_si_oja, R.raw.fo, R.raw.fo_soke,
                R.raw.fo_sile_lati_oke, R.raw.ra, R.raw.mo_ra_bata_tuntun,
                R.raw.mo_fe_ra_oko_ayokele, R.raw.ta, R.raw.mo_n_ta_aso,
                R.raw.mo_ti_ta_oko_mi};


        //find the layouts you wants to set events on
        LinearLayout layout = findViewById(R.id.layout_apeere_one);
        LinearLayout layout2 = findViewById(R.id.layout_apeere_two);
        LinearLayout layout3 = findViewById(R.id.layout_apeere_three);
        LinearLayout layout4 = findViewById(R.id.layout_apeere_four);
        LinearLayout layout5 = findViewById(R.id.layout_apeere_five);
        LinearLayout layout6 = findViewById(R.id.layout_apeere_six);
        LinearLayout layout7 = findViewById(R.id.layout_apeere_seven);
        LinearLayout layout8 = findViewById(R.id.layout_apeere_eight);
        LinearLayout layout9 = findViewById(R.id.layout_apeere_9);
        LinearLayout layout10 = findViewById(R.id.layout_apeere_10);
        LinearLayout layout11 = findViewById(R.id.layout_apeere_11);
        LinearLayout layout12 = findViewById(R.id.layout_apeere_12);
        LinearLayout layout13 = findViewById(R.id.layout_apeere_13);
        LinearLayout layout14 = findViewById(R.id.layout_apeere_14);
        LinearLayout layout15 = findViewById(R.id.layout_apeere_15);
        LinearLayout layout16 = findViewById(R.id.layout_apeere_16);
        LinearLayout layout17 = findViewById(R.id.layout_apeere_17);
        LinearLayout layout18 = findViewById(R.id.layout_apeere_18);
        LinearLayout layout19 = findViewById(R.id.layout_apeere_19);
        LinearLayout layout20 = findViewById(R.id.layout_apeere_20);
        LinearLayout layout21 = findViewById(R.id.layout_apeere_21);
        LinearLayout layout22 = findViewById(R.id.layout_apeere_22);
        LinearLayout layout23 = findViewById(R.id.layout_apeere_23);
        LinearLayout layout24 = findViewById(R.id.layout_apeere_24);
        LinearLayout layout25 = findViewById(R.id.layout_apeere_25);
        LinearLayout layout26 = findViewById(R.id.layout_apeere_26);
        LinearLayout layout27 = findViewById(R.id.layout_apeere_27);


        //create an inner class object that will implement the onClick method
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the id(value) of the textView(s)
                int clickedLayoutId = view.getId();

                //use a switch case to find the textview that was clicked
                switch (clickedLayoutId) {
                    case R.id.layout_apeere_one:
                        playAudioFile(audioFiles[0]);
                        break;
                    case R.id.layout_apeere_two:
                        playAudioFile(audioFiles[1]);
                        break;
                    case R.id.layout_apeere_three:
                        playAudioFile(audioFiles[2]);
                        break;

                    case R.id.layout_apeere_four:
                        playAudioFile(audioFiles[3]);
                        break;

                    case R.id.layout_apeere_five:
                        playAudioFile(audioFiles[4]);
                        break;

                    case R.id.layout_apeere_six:
                        playAudioFile(audioFiles[5]);
                        break;

                    case R.id.layout_apeere_seven:
                        playAudioFile(audioFiles[6]);
                        break;

                    case R.id.layout_apeere_eight:
                        playAudioFile(audioFiles[7]);
                        break;

                    case R.id.layout_apeere_9:
                        playAudioFile(audioFiles[8]);
                        break;

                    case R.id.layout_apeere_10:
                        playAudioFile(audioFiles[9]);
                        break;

                    case R.id.layout_apeere_11:
                        playAudioFile(audioFiles[10]);
                        break;

                    case R.id.layout_apeere_12:
                        playAudioFile(audioFiles[11]);
                        break;

                    case R.id.layout_apeere_13:
                        playAudioFile(audioFiles[12]);
                        break;

                    case R.id.layout_apeere_14:
                        playAudioFile(audioFiles[13]);
                        break;

                    case R.id.layout_apeere_15:
                        playAudioFile(audioFiles[14]);
                        break;

                    case R.id.layout_apeere_16:
                        playAudioFile(audioFiles[15]);
                        break;

                    case R.id.layout_apeere_17:
                        playAudioFile(audioFiles[16]);
                        break;

                    case R.id.layout_apeere_18:
                        playAudioFile(audioFiles[17]);
                        break;


                    case R.id.layout_apeere_19:
                        playAudioFile(audioFiles[18]);
                        break;

                    case R.id.layout_apeere_20:
                        playAudioFile(audioFiles[19]);
                        break;


                    case R.id.layout_apeere_21:
                        playAudioFile(audioFiles[20]);
                        break;

                    case R.id.layout_apeere_22:
                        playAudioFile(audioFiles[21]);
                        break;

                    case R.id.layout_apeere_23:
                        playAudioFile(audioFiles[22]);
                        break;

                    case R.id.layout_apeere_24:
                        playAudioFile(audioFiles[23]);
                        break;

                    case R.id.layout_apeere_25:
                        playAudioFile(audioFiles[24]);
                        break;

                    case R.id.layout_apeere_26:
                        playAudioFile(audioFiles[25]);
                        break;


                    case R.id.layout_apeere_27:
                        playAudioFile(audioFiles[26]);
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
        layout4.setOnClickListener(clickListener);
        layout5.setOnClickListener(clickListener);
        layout6.setOnClickListener(clickListener);
        layout7.setOnClickListener(clickListener);
        layout8.setOnClickListener(clickListener);
        layout9.setOnClickListener(clickListener);
        layout10.setOnClickListener(clickListener);
        layout11.setOnClickListener(clickListener);
        layout12.setOnClickListener(clickListener);
        layout13.setOnClickListener(clickListener);
        layout14.setOnClickListener(clickListener);
        layout15.setOnClickListener(clickListener);
        layout16.setOnClickListener(clickListener);
        layout17.setOnClickListener(clickListener);
        layout18.setOnClickListener(clickListener);
        layout19.setOnClickListener(clickListener);
        layout20.setOnClickListener(clickListener);
        layout21.setOnClickListener(clickListener);
        layout22.setOnClickListener(clickListener);
        layout23.setOnClickListener(clickListener);
        layout24.setOnClickListener(clickListener);
        layout25.setOnClickListener(clickListener);
        layout26.setOnClickListener(clickListener);
        layout27.setOnClickListener(clickListener);


    }


    //method that is called when you want to play an audio file
    private void playAudioFile(int audioFile) {

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
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


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