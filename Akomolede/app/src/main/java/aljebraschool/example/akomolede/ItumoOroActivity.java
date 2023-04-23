package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ItumoOroActivity extends AppCompatActivity {

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
        setContentView(R.layout.oro_ati_itumo);

        //store the audio files i want to use in an integer array
        int[] audioFiles = {R.raw.atumo, R.raw.ile, R.raw.ati, R.raw.ojuse, R.raw.ilekun, R.raw.aso,
                R.raw.ise, R.raw.ilee, R.raw.egbe, R.raw.ojo_rain, R.raw.oorun,
                R.raw.osupa, R.raw.irawo, R.raw.ofurufu, R.raw.aye, R.raw.omi,
                R.raw.aga, R.raw.agbalagba, R.raw.igbimo, R.raw.alaga, R.raw.ololufe,
                R.raw.iya, R.raw.baba, R.raw.aburo, R.raw.egbon, R.raw.ijinle,
                R.raw.oko_oju_omi, R.raw.oko_oju_irin, R.raw.akoonu, R.raw.asamo, R.raw.apejo,
                R.raw.ayeye, R.raw.odun, R.raw.ilu_town, R.raw.ilu_drum, R.raw.oluko,
                R.raw.akeeko, R.raw.oga_ile_ise, R.raw.osise, R.raw.oluso_aguntan, R.raw.aguntan,
                R.raw.ewure, R.raw.ori, R.raw.ese, R.raw.oju_eye, R.raw.imero, R.raw.sayensi,
                R.raw.itakun_agbaye, R.raw.ero_ibanisoro, R.raw.ipa_force, R.raw.ipa_impact,};


        //find the layouts you wants to set events on
        TextView layoutType1 = findViewById(R.id.textview_oro_ati_itumo);
        LinearLayout layout = findViewById(R.id.layout_oro_ati_itumo_one);
        LinearLayout layout1 = findViewById(R.id.layout_oro_ati_itumo_two);
        LinearLayout layout2 = findViewById(R.id.layout_oro_ati_itumo_three);
        LinearLayout layout3 = findViewById(R.id.layout_oro_ati_itumo_four);
        LinearLayout layout4 = findViewById(R.id.layout_oro_ati_itumo_five);
        LinearLayout layout5 = findViewById(R.id.layout_oro_ati_itumo_6);
        LinearLayout layout6 = findViewById(R.id.layout_oro_ati_itumo_7);
        LinearLayout layout7 = findViewById(R.id.layout_oro_ati_itumo_8);
        LinearLayout layout8 = findViewById(R.id.layout_oro_ati_itumo_9);
        LinearLayout layout9 = findViewById(R.id.layout_oro_ati_itumo_10);
        LinearLayout layout10 = findViewById(R.id.layout_oro_ati_itumo_11);
        LinearLayout layout11 = findViewById(R.id.layout_oro_ati_itumo_12);
        LinearLayout layout12 = findViewById(R.id.layout_oro_ati_itumo_13);
        LinearLayout layout13 = findViewById(R.id.layout_oro_ati_itumo_14);
        LinearLayout layout14 = findViewById(R.id.layout_oro_ati_itumo_15);
        LinearLayout layout15 = findViewById(R.id.layout_oro_ati_itumo_16);
        LinearLayout layout16 = findViewById(R.id.layout_oro_ati_itumo_17);
        LinearLayout layout17 = findViewById(R.id.layout_oro_ati_itumo_18);
        LinearLayout layout18 = findViewById(R.id.layout_oro_ati_itumo_19);
        LinearLayout layout19 = findViewById(R.id.layout_oro_ati_itumo_20);
        LinearLayout layout20 = findViewById(R.id.layout_oro_ati_itumo_21);
        LinearLayout layout21 = findViewById(R.id.layout_oro_ati_itumo_22);
        LinearLayout layout22 = findViewById(R.id.layout_oro_ati_itumo_23);
        LinearLayout layout23 = findViewById(R.id.layout_oro_ati_itumo_24);
        LinearLayout layout24 = findViewById(R.id.layout_oro_ati_itumo_25);
        LinearLayout layout25 = findViewById(R.id.layout_oro_ati_itumo_26);
        LinearLayout layout26 = findViewById(R.id.layout_oro_ati_itumo_27);
        LinearLayout layout27 = findViewById(R.id.layout_oro_ati_itumo_28);
        LinearLayout layout28 = findViewById(R.id.layout_oro_ati_itumo_29);
        LinearLayout layout29 = findViewById(R.id.layout_oro_ati_itumo_30);
        LinearLayout layout30 = findViewById(R.id.layout_oro_ati_itumo_31);
        LinearLayout layout31 = findViewById(R.id.layout_oro_ati_itumo_32);
        LinearLayout layout32 = findViewById(R.id.layout_oro_ati_itumo_33);
        LinearLayout layout33 = findViewById(R.id.layout_oro_ati_itumo_34);
        LinearLayout layout34 = findViewById(R.id.layout_oro_ati_itumo_35);
        LinearLayout layout35 = findViewById(R.id.layout_oro_ati_itumo_36);
        LinearLayout layout36 = findViewById(R.id.layout_oro_ati_itumo_37);
        LinearLayout layout37 = findViewById(R.id.layout_oro_ati_itumo_38);
        LinearLayout layout38 = findViewById(R.id.layout_oro_ati_itumo_39);
        LinearLayout layout39 = findViewById(R.id.layout_oro_ati_itumo_40);
        LinearLayout layout40 = findViewById(R.id.layout_oro_ati_itumo_41);
        LinearLayout layout41 = findViewById(R.id.layout_oro_ati_itumo_42);
        LinearLayout layout42 = findViewById(R.id.layout_oro_ati_itumo_43);
        LinearLayout layout43 = findViewById(R.id.layout_oro_ati_itumo_44);
        LinearLayout layout44 = findViewById(R.id.layout_oro_ati_itumo_45);
        LinearLayout layout45 = findViewById(R.id.layout_oro_ati_itumo_46);
        LinearLayout layout46 = findViewById(R.id.layout_oro_ati_itumo_47);
        LinearLayout layout47 = findViewById(R.id.layout_oro_ati_itumo_48);
        LinearLayout layout48 = findViewById(R.id.layout_oro_ati_itumo_49);
        LinearLayout layout49 = findViewById(R.id.layout_oro_ati_itumo_50);


        //create an inner class object that will implement the onClick method
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the id(value) of the textView(s)
                int clickedLayoutId = view.getId();

                //use a switch case to find the textview that was clicked
                switch (clickedLayoutId) {
                    case R.id.textview_oro_ati_itumo:
                        playAudioFile(audioFiles[0]);
                        break;
                    case R.id.layout_oro_ati_itumo_one:
                        playAudioFile(audioFiles[1]);
                        break;
                    case R.id.layout_oro_ati_itumo_two:
                        playAudioFile(audioFiles[2]);
                        break;

                    case R.id.layout_oro_ati_itumo_three:
                        playAudioFile(audioFiles[3]);
                        break;

                    case R.id.layout_oro_ati_itumo_four:
                        playAudioFile(audioFiles[4]);
                        break;

                    case R.id.layout_oro_ati_itumo_five:
                        playAudioFile(audioFiles[5]);
                        break;

                    case R.id.layout_oro_ati_itumo_6:
                        playAudioFile(audioFiles[6]);
                        break;

                    case R.id.layout_oro_ati_itumo_7:
                        playAudioFile(audioFiles[7]);
                        break;
                    case R.id.layout_oro_ati_itumo_8:
                        playAudioFile(audioFiles[8]);
                        break;
                    case R.id.layout_oro_ati_itumo_9:
                        playAudioFile(audioFiles[9]);
                        break;

                    case R.id.layout_oro_ati_itumo_10:
                        playAudioFile(audioFiles[10]);
                        break;

                    case R.id.layout_oro_ati_itumo_11:
                        playAudioFile(audioFiles[11]);
                        break;

                    case R.id.layout_oro_ati_itumo_12:
                        playAudioFile(audioFiles[12]);
                        break;

                    case R.id.layout_oro_ati_itumo_13:
                        playAudioFile(audioFiles[13]);
                        break;
                    case R.id.layout_oro_ati_itumo_14:
                        playAudioFile(audioFiles[14]);
                        break;
                    case R.id.layout_oro_ati_itumo_15:
                        playAudioFile(audioFiles[15]);
                        break;

                    case R.id.layout_oro_ati_itumo_16:
                        playAudioFile(audioFiles[16]);
                        break;

                    case R.id.layout_oro_ati_itumo_17:
                        playAudioFile(audioFiles[17]);
                        break;

                    case R.id.layout_oro_ati_itumo_18:
                        playAudioFile(audioFiles[18]);
                        break;

                    case R.id.layout_oro_ati_itumo_19:
                        playAudioFile(audioFiles[19]);
                        break;
                    case R.id.layout_oro_ati_itumo_20:
                        playAudioFile(audioFiles[20]);
                        break;

                    case R.id.layout_oro_ati_itumo_21:
                        playAudioFile(audioFiles[21]);
                        break;

                    case R.id.layout_oro_ati_itumo_22:
                        playAudioFile(audioFiles[22]);
                        break;

                    case R.id.layout_oro_ati_itumo_23:
                        playAudioFile(audioFiles[23]);
                        break;
                    case R.id.layout_oro_ati_itumo_24:
                        playAudioFile(audioFiles[24]);
                        break;
                    case R.id.layout_oro_ati_itumo_25:
                        playAudioFile(audioFiles[25]);
                        break;

                    case R.id.layout_oro_ati_itumo_26:
                        playAudioFile(audioFiles[26]);
                        break;

                    case R.id.layout_oro_ati_itumo_27:
                        playAudioFile(audioFiles[27]);
                        break;
                    case R.id.layout_oro_ati_itumo_28:
                        playAudioFile(audioFiles[28]);
                        break;
                    case R.id.layout_oro_ati_itumo_29:
                        playAudioFile(audioFiles[29]);
                        break;

                    case R.id.layout_oro_ati_itumo_30:
                        playAudioFile(audioFiles[30]);
                        break;

                    case R.id.layout_oro_ati_itumo_31:
                        playAudioFile(audioFiles[31]);
                        break;

                    case R.id.layout_oro_ati_itumo_32:
                        playAudioFile(audioFiles[32]);
                        break;
                    case R.id.layout_oro_ati_itumo_33:
                        playAudioFile(audioFiles[33]);
                        break;
                    case R.id.layout_oro_ati_itumo_34:
                        playAudioFile(audioFiles[34]);
                        break;

                    case R.id.layout_oro_ati_itumo_35:
                        playAudioFile(audioFiles[35]);
                        break;

                    case R.id.layout_oro_ati_itumo_36:
                        playAudioFile(audioFiles[36]);
                        break;


                    case R.id.layout_oro_ati_itumo_37:
                        playAudioFile(audioFiles[37]);
                        break;
                    case R.id.layout_oro_ati_itumo_38:
                        playAudioFile(audioFiles[38]);
                        break;
                    case R.id.layout_oro_ati_itumo_39:
                        playAudioFile(audioFiles[39]);
                        break;

                    case R.id.layout_oro_ati_itumo_40:
                        playAudioFile(audioFiles[40]);
                        break;

                    case R.id.layout_oro_ati_itumo_41:
                        playAudioFile(audioFiles[41]);
                        break;


                    case R.id.layout_oro_ati_itumo_42:
                        playAudioFile(audioFiles[42]);
                        break;
                    case R.id.layout_oro_ati_itumo_43:
                        playAudioFile(audioFiles[43]);
                        break;
                    case R.id.layout_oro_ati_itumo_44:
                        playAudioFile(audioFiles[44]);
                        break;

                    case R.id.layout_oro_ati_itumo_45:
                        playAudioFile(audioFiles[45]);
                        break;

                    case R.id.layout_oro_ati_itumo_46:
                        playAudioFile(audioFiles[46]);
                        break;


                    case R.id.layout_oro_ati_itumo_47:
                        playAudioFile(audioFiles[47]);
                        break;
                    case R.id.layout_oro_ati_itumo_48:
                        playAudioFile(audioFiles[48]);
                        break;
                    case R.id.layout_oro_ati_itumo_49:
                        playAudioFile(audioFiles[49]);
                        break;

                    case R.id.layout_oro_ati_itumo_50:
                        playAudioFile(audioFiles[50]);
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
        layout23.setOnClickListener(clickListener);
        layout24.setOnClickListener(clickListener);
        layout25.setOnClickListener(clickListener);
        layout26.setOnClickListener(clickListener);
        layout27.setOnClickListener(clickListener);
        layout28.setOnClickListener(clickListener);
        layout29.setOnClickListener(clickListener);
        layout30.setOnClickListener(clickListener);
        layout31.setOnClickListener(clickListener);
        layout32.setOnClickListener(clickListener);
        layout33.setOnClickListener(clickListener);
        layout34.setOnClickListener(clickListener);
        layout35.setOnClickListener(clickListener);
        layout36.setOnClickListener(clickListener);
        layout37.setOnClickListener(clickListener);
        layout38.setOnClickListener(clickListener);
        layout39.setOnClickListener(clickListener);
        layout40.setOnClickListener(clickListener);
        layout41.setOnClickListener(clickListener);
        layout42.setOnClickListener(clickListener);
        layout43.setOnClickListener(clickListener);
        layout44.setOnClickListener(clickListener);
        layout45.setOnClickListener(clickListener);
        layout46.setOnClickListener(clickListener);
        layout47.setOnClickListener(clickListener);
        layout48.setOnClickListener(clickListener);
        layout49.setOnClickListener(clickListener);


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