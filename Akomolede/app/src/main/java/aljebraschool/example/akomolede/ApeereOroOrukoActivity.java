package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class ApeereOroOrukoActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apeere_oro_oruko);

        //store the audio files i want to use in an integer array
        int[] audioFiles = {R.raw.oruko_eniyan, R.raw.taye, R.raw.bode, R.raw.michelle,
                R.raw.florence, R.raw.adesanya, R.raw.titilayo, R.raw.oruko_eranko,
                R.raw.aja, R.raw.ewure, R.raw.aguntan, R.raw.adiye,
                R.raw.ejo, R.raw.oruko_ibugbe, R.raw.ibadan, R.raw.sokoto, R.raw.abia,
                R.raw.ghana, R.raw.london, R.raw.oruko_nnkan, R.raw.sibi, R.raw.abo,
                R.raw.igi, R.raw.aga, R.raw.oro_afoye_han, R.raw.iku, R.raw.arun,
                R.raw.ife, R.raw.apeere_lilo_oro_oruko_ninu_gbolohun, R.raw.ade_ni_ife_sade, R.raw.igi_wo_lule,
                R.raw.ilu_pa_aja_ode, R.raw.mo_lo_si_ghana,};


        //find the layouts you wants to set events on
        TextView layoutType1 = findViewById(R.id.layout_apeere_oro_oruko_iran_kini);
        LinearLayout layout1 = findViewById(R.id.layout_apeere_oro_oruko_one);
        LinearLayout layout2 = findViewById(R.id.layout_apeere_oro_oruko_two);
        LinearLayout layout3 = findViewById(R.id.layout_apeere_oro_oruko_three);
        LinearLayout layout4 = findViewById(R.id.layout_apeere_oro_oruko_four);
        LinearLayout layout5 = findViewById(R.id.layout_apeere_oro_oruko_five);
        LinearLayout layout6 = findViewById(R.id.layout_apeere_oro_oruko_6);

        TextView layoutType2 = findViewById(R.id.layout_apeere_oro_oruko_iran_keji);
        LinearLayout layout7 = findViewById(R.id.layout_apeere_oro_oruko_7);
        LinearLayout layout8 = findViewById(R.id.layout_apeere_oro_oruko_8);
        LinearLayout layout9 = findViewById(R.id.layout_apeere_oro_oruko_9);
        LinearLayout layout10 = findViewById(R.id.layout_apeere_oro_oruko_10);
        LinearLayout layout11 = findViewById(R.id.layout_apeere_oro_oruko_11);


        TextView layoutType3 = findViewById(R.id.layout_apeere_oro_oruko_iran_keta);
        LinearLayout layout12 = findViewById(R.id.layout_apeere_oro_oruko_12);
        LinearLayout layout13 = findViewById(R.id.layout_apeere_oro_oruko_13);
        LinearLayout layout14 = findViewById(R.id.layout_apeere_oro_oruko_14);
        LinearLayout layout15 = findViewById(R.id.layout_apeere_oro_oruko_15);
        LinearLayout layout16 = findViewById(R.id.layout_apeere_oro_oruko_16);

        TextView layoutType4 = findViewById(R.id.layout_apeere_oro_oruko_iran_kerin);
        LinearLayout layout17 = findViewById(R.id.layout_apeere_oro_oruko_17);
        LinearLayout layout18 = findViewById(R.id.layout_apeere_oro_oruko_18);
        LinearLayout layout19 = findViewById(R.id.layout_apeere_oro_oruko_19);
        LinearLayout layout20 = findViewById(R.id.layout_apeere_oro_oruko_20);

        TextView layoutType5 = findViewById(R.id.layout_apeere_oro_oruko_iran_kerun);
        LinearLayout layout21 = findViewById(R.id.layout_apeere_oro_oruko_21);
        LinearLayout layout22 = findViewById(R.id.layout_apeere_oro_oruko_22);
        LinearLayout layout23 = findViewById(R.id.layout_apeere_oro_oruko_23);

        TextView layoutType6 = findViewById(R.id.layout_apeere_oro_oruko_iran_kefa);
        LinearLayout layout24 = findViewById(R.id.layout_apeere_oro_oruko_24);
        LinearLayout layout25 = findViewById(R.id.layout_apeere_oro_oruko_25);
        LinearLayout layout26 = findViewById(R.id.layout_apeere_oro_oruko_26);
        LinearLayout layout27 = findViewById(R.id.layout_apeere_oro_oruko_27);


        //create an inner class object that will implement the onClick method
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the id(value) of the textView(s)
                int clickedLayoutId = view.getId();

                //use a switch case to find the textview that was clicked
                switch (clickedLayoutId) {
                    case R.id.layout_apeere_oro_oruko_iran_kini:
                        playAudioFile(audioFiles[0]);
                        break;
                    case R.id.layout_apeere_oro_oruko_one:
                        playAudioFile(audioFiles[1]);
                        break;
                    case R.id.layout_apeere_oro_oruko_two:
                        playAudioFile(audioFiles[2]);
                        break;

                    case R.id.layout_apeere_oro_oruko_three:
                        playAudioFile(audioFiles[3]);
                        break;

                    case R.id.layout_apeere_oro_oruko_four:
                        playAudioFile(audioFiles[4]);
                        break;

                    case R.id.layout_apeere_oro_oruko_five:
                        playAudioFile(audioFiles[5]);
                        break;

                    case R.id.layout_apeere_oro_oruko_6:
                        playAudioFile(audioFiles[6]);
                        break;

                    case R.id.layout_apeere_oro_oruko_iran_keji:
                        playAudioFile(audioFiles[7]);
                        break;
                    case R.id.layout_apeere_oro_oruko_7:
                        playAudioFile(audioFiles[8]);
                        break;
                    case R.id.layout_apeere_oro_oruko_8:
                        playAudioFile(audioFiles[9]);
                        break;

                    case R.id.layout_apeere_oro_oruko_9:
                        playAudioFile(audioFiles[10]);
                        break;

                    case R.id.layout_apeere_oro_oruko_10:
                        playAudioFile(audioFiles[11]);
                        break;

                    case R.id.layout_apeere_oro_oruko_11:
                        playAudioFile(audioFiles[12]);
                        break;

                    case R.id.layout_apeere_oro_oruko_iran_keta:
                        playAudioFile(audioFiles[13]);
                        break;
                    case R.id.layout_apeere_oro_oruko_12:
                        playAudioFile(audioFiles[14]);
                        break;
                    case R.id.layout_apeere_oro_oruko_13:
                        playAudioFile(audioFiles[15]);
                        break;

                    case R.id.layout_apeere_oro_oruko_14:
                        playAudioFile(audioFiles[16]);
                        break;

                    case R.id.layout_apeere_oro_oruko_15:
                        playAudioFile(audioFiles[17]);
                        break;

                    case R.id.layout_apeere_oro_oruko_16:
                        playAudioFile(audioFiles[18]);
                        break;

                    case R.id.layout_apeere_oro_oruko_iran_kerin:
                        playAudioFile(audioFiles[19]);
                        break;
                    case R.id.layout_apeere_oro_oruko_17:
                        playAudioFile(audioFiles[20]);
                        break;
                    case R.id.layout_apeere_oro_oruko_18:
                        playAudioFile(audioFiles[21]);
                        break;

                    case R.id.layout_apeere_oro_oruko_19:
                        playAudioFile(audioFiles[22]);
                        break;

                    case R.id.layout_apeere_oro_oruko_20:
                        playAudioFile(audioFiles[23]);
                        break;

                    case R.id.layout_apeere_oro_oruko_iran_kerun:
                        playAudioFile(audioFiles[24]);
                        break;
                    case R.id.layout_apeere_oro_oruko_21:
                        playAudioFile(audioFiles[25]);
                        break;
                    case R.id.layout_apeere_oro_oruko_22:
                        playAudioFile(audioFiles[26]);
                        break;

                    case R.id.layout_apeere_oro_oruko_23:
                        playAudioFile(audioFiles[27]);
                        break;

                    case R.id.layout_apeere_oro_oruko_iran_kefa:
                        playAudioFile(audioFiles[28]);
                        break;
                    case R.id.layout_apeere_oro_oruko_24:
                        playAudioFile(audioFiles[29]);
                        break;
                    case R.id.layout_apeere_oro_oruko_25:
                        playAudioFile(audioFiles[30]);
                        break;

                    case R.id.layout_apeere_oro_oruko_26:
                        playAudioFile(audioFiles[31]);
                        break;

                    case R.id.layout_apeere_oro_oruko_27:
                        playAudioFile(audioFiles[32]);
                        break;


                }

            }
        };


        //used to display action button that will take this activity back to the main screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //set the onClicklistener method on the textview
        layoutType1.setOnClickListener(clickListener);
        layout1.setOnClickListener(clickListener);
        layout2.setOnClickListener(clickListener);
        layout3.setOnClickListener(clickListener);
        layout4.setOnClickListener(clickListener);
        layout5.setOnClickListener(clickListener);
        layout6.setOnClickListener(clickListener);


        layoutType2.setOnClickListener(clickListener);
        layout7.setOnClickListener(clickListener);
        layout8.setOnClickListener(clickListener);
        layout9.setOnClickListener(clickListener);
        layout10.setOnClickListener(clickListener);
        layout11.setOnClickListener(clickListener);

        layoutType3.setOnClickListener(clickListener);
        layout12.setOnClickListener(clickListener);
        layout13.setOnClickListener(clickListener);
        layout14.setOnClickListener(clickListener);
        layout15.setOnClickListener(clickListener);
        layout16.setOnClickListener(clickListener);


        layoutType4.setOnClickListener(clickListener);
        layout17.setOnClickListener(clickListener);
        layout18.setOnClickListener(clickListener);
        layout19.setOnClickListener(clickListener);
        layout20.setOnClickListener(clickListener);


        layoutType5.setOnClickListener(clickListener);
        layout21.setOnClickListener(clickListener);
        layout22.setOnClickListener(clickListener);
        layout23.setOnClickListener(clickListener);

        layoutType6.setOnClickListener(clickListener);
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