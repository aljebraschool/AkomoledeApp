package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class GbolohunKukuruAtiItumoActivity extends AppCompatActivity {

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
        setContentView(R.layout.gbolohun_kukuru_ati_itumo);

        //store the audio files i want to use in an integer array
        int[] audioFiles = {R.raw.gbolohun_kukuru, R.raw.ebi_n_pami, R.raw.ile_ti_su, R.raw.ojo_ti_lo, R.raw.mo_fe_mu_omi,
                R.raw.mo_ti_keko_gboye, R.raw.mo_n_wa_ise, R.raw.ewa_wo_nnkan, R.raw.ile_wa_rewa, R.raw.iku_pa_olode,
                R.raw.ijoba_ti_kilo, R.raw.moni_ife_re, R.raw.omobinrin_naa, R.raw.ma_simi_gbo, R.raw.awon_oluko_wa,
                R.raw.elo_ni, R.raw.mo_fe_jeun, R.raw.mofe_sun, R.raw.e_sokale_wa, R.raw.e_sun_mobi,
                R.raw.e_dide_soke, R.raw.wa_jeun, R.raw.mo_nife_orile_ede_mi, R.raw.o_to_ge,};


        //find the layouts you wants to set events on
        TextView layoutType1 = findViewById(R.id.layout_oro_ati_itumo);
        LinearLayout layout = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_one);
        LinearLayout layout1 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_two);
        LinearLayout layout2 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_three);
        LinearLayout layout3 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_four);
        LinearLayout layout4 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_five);
        LinearLayout layout5 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_6);
        LinearLayout layout6 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_7);
        LinearLayout layout7 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_8);
        LinearLayout layout8 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_9);
        LinearLayout layout9 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_10);
        LinearLayout layout10 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_11);
        LinearLayout layout11 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_12);
        LinearLayout layout12 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_13);
        LinearLayout layout13 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_14);
        LinearLayout layout14 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_15);
        LinearLayout layout15 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_16);
        LinearLayout layout16 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_17);
        LinearLayout layout17 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_18);
        LinearLayout layout18 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_19);
        LinearLayout layout19 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_20);
        LinearLayout layout20 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_21);
        LinearLayout layout21 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_23);
        LinearLayout layout22 = findViewById(R.id.layout_gbolohun_kukuru_ati_itumo_24);


        //create an inner class object that will implement the onClick method
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the id(value) of the textView(s)
                int clickedLayoutId = view.getId();

                //use a switch case to find the textview that was clicked
                switch (clickedLayoutId) {
                    case R.id.layout_oro_ati_itumo:
                        playAudioFile(audioFiles[0]);
                        break;
                    case R.id.layout_gbolohun_kukuru_ati_itumo_one:
                        playAudioFile(audioFiles[1]);
                        break;
                    case R.id.layout_gbolohun_kukuru_ati_itumo_two:
                        playAudioFile(audioFiles[2]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_three:
                        playAudioFile(audioFiles[3]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_four:
                        playAudioFile(audioFiles[4]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_five:
                        playAudioFile(audioFiles[5]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_6:
                        playAudioFile(audioFiles[6]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_7:
                        playAudioFile(audioFiles[7]);
                        break;
                    case R.id.layout_gbolohun_kukuru_ati_itumo_8:
                        playAudioFile(audioFiles[8]);
                        break;
                    case R.id.layout_gbolohun_kukuru_ati_itumo_9:
                        playAudioFile(audioFiles[9]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_10:
                        playAudioFile(audioFiles[10]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_11:
                        playAudioFile(audioFiles[11]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_12:
                        playAudioFile(audioFiles[12]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_13:
                        playAudioFile(audioFiles[13]);
                        break;
                    case R.id.layout_gbolohun_kukuru_ati_itumo_14:
                        playAudioFile(audioFiles[14]);
                        break;
                    case R.id.layout_gbolohun_kukuru_ati_itumo_15:
                        playAudioFile(audioFiles[15]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_16:
                        playAudioFile(audioFiles[16]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_17:
                        playAudioFile(audioFiles[17]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_18:
                        playAudioFile(audioFiles[18]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_19:
                        playAudioFile(audioFiles[19]);
                        break;
                    case R.id.layout_gbolohun_kukuru_ati_itumo_20:
                        playAudioFile(audioFiles[20]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_21:
                        playAudioFile(audioFiles[21]);
                        break;

                    case R.id.layout_gbolohun_kukuru_ati_itumo_23:
                        playAudioFile(audioFiles[22]);
                        break;
                    case R.id.layout_gbolohun_kukuru_ati_itumo_24:
                        playAudioFile(audioFiles[23]);
                        break;


                }

            }
        };


        //used to display action button that will take this activity back to the main screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //set the onClicklistener method on the textview
        layoutType1.setOnClickListener(clickListener);
        layout.setOnClickListener(clickListener);
        layout1.setOnClickListener(clickListener);
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