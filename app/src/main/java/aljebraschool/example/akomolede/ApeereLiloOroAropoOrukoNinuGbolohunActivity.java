/* The activity implements the content covered under "examples of using pronouns in sentences in yoruba" */
package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class ApeereLiloOroAropoOrukoNinuGbolohunActivity extends AppCompatActivity {

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
        setContentView(R.layout.apeere_lilo_oro_aropo_oruko);

        //store the audio files i want to use in an integer array
        int[] audioFiles = {R.raw.apeere_lilo_oro_aropo_oruko_oluwa,
                R.raw.mo_lo_si_oja, R.raw.o_opon_omi,
                R.raw.a_lo_si_ile_eko, R.raw.apeere_lilo_oro_aropo_oruko_abo,
                R.raw.o_kimi, R.raw.o_wa_si_ile_wa, R.raw.mo_n_ki_oo,
                R.raw.apeere_lilo_oro_aropo_oruko_eyan, R.raw.aja_mi_ni,
                R.raw.ile_wa_niyi, R.raw.omo_won_niyen,
                R.raw.apeere_lilo_oro_oruko_ninu_gbolohun,
                R.raw.ade_lo_si_oko, R.raw.o_lo_si_oko};


        //find the layouts you wants to set events on
        TextView layoutType1 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_oluwa);
        LinearLayout layout1 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_oluwa_1);
        LinearLayout layout2 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_oluwa_2);
        LinearLayout layout3 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_oluwa_3);


        TextView layoutType2 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_abo);
        LinearLayout layout4 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_abo_1);
        LinearLayout layout5 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_abo_2);
        LinearLayout layout6 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_abo_3);

        TextView layoutType3 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_eyan);
        LinearLayout layout7 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_eyan_1);
        LinearLayout layout8 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_eyan_2);
        LinearLayout layout9 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_eyan_3);


        TextView layoutType4 = findViewById(R.id.layout_apeere_lilo_oro_aropo_oruko_ninu_gbolohun);
        LinearLayout layout10 = findViewById(R.id.layout_apeere_aropo_oruko_ninu_gbolohun_one);
        LinearLayout layout11 = findViewById(R.id.layout_apeere_aropo_oruko_ninu_gbolohun_two);


        //create an inner class object that will implement the onClick method
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the id(value) of the textView(s)
                int clickedLayoutId = view.getId();

                //use a switch case to find the textview that was clicked
                switch (clickedLayoutId) {
                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_oluwa:
                        playAudioFile(audioFiles[0]);
                        break;
                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_oluwa_1:
                        playAudioFile(audioFiles[1]);
                        break;
                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_oluwa_2:
                        playAudioFile(audioFiles[2]);
                        break;

                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_oluwa_3:
                        playAudioFile(audioFiles[3]);
                        break;

                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_abo:
                        playAudioFile(audioFiles[4]);
                        break;

                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_abo_1:
                        playAudioFile(audioFiles[5]);
                        break;

                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_abo_2:
                        playAudioFile(audioFiles[6]);
                        break;

                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_abo_3:
                        playAudioFile(audioFiles[7]);
                        break;
                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_eyan:
                        playAudioFile(audioFiles[8]);
                        break;
                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_eyan_1:
                        playAudioFile(audioFiles[9]);
                        break;

                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_eyan_2:
                        playAudioFile(audioFiles[10]);
                        break;

                    case R.id.layout_apeere_lilo_oro_aropo_oruko_oluwa_ni_ipo_eyan_3:
                        playAudioFile(audioFiles[11]);
                        break;

                    case R.id.layout_apeere_lilo_oro_aropo_oruko_ninu_gbolohun:
                        playAudioFile(audioFiles[12]);
                        break;

                    case R.id.layout_apeere_aropo_oruko_ninu_gbolohun_one:
                        playAudioFile(audioFiles[13]);
                        break;
                    case R.id.layout_apeere_aropo_oruko_ninu_gbolohun_two:
                        playAudioFile(audioFiles[14]);
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
        layoutType4.setOnClickListener(clickListener);


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