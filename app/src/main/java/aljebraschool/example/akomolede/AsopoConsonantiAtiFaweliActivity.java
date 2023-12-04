package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class AsopoConsonantiAtiFaweliActivity extends AppCompatActivity {

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
        setContentView(R.layout.word_grid_view);


        //storing our numbers using an array list
        ArrayList<Word> words = new ArrayList<>();


        //adding each numbers 1-10 and its miwok translation to the words array list above
        //word.add("one")
        Word w = new Word(R.string.asopo_ba, R.string.asopo_b_a, R.raw.ba, R.drawable.baseline_play_arrow_white_48);
        words.add(w);


        //repeating the process for the remaining numbers
        words.add(new Word(R.string.asopo_be, R.string.asopo_b_e, R.raw.be, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_bee, R.string.asopo_b_ee, R.raw.bee, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_bi, R.string.asopo_b_i, R.raw.bi, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_bo, R.string.asopo_b_o, R.raw.bo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_boo, R.string.asopo_b_oo, R.raw.boo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_bu, R.string.asopo_b_u, R.raw.bu, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_da, R.string.asopo_d_a, R.raw.da, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_de, R.string.asopo_d_e, R.raw.de, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_dee, R.string.asopo_d_ee, R.raw.dee, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_di, R.string.asopo_d_i, R.raw.di, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_do, R.string.asopo_d_o, R.raw.doo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_doo, R.string.asopo_d_oo, R.raw.dooo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_du, R.string.asopo_d_u, R.raw.du, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_fa, R.string.asopo_f_a, R.raw.fa, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_fe, R.string.asopo_f_e, R.raw.fe, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_fee, R.string.asopo_f_ee, R.raw.fee, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_fi, R.string.asopo_f_i, R.raw.fi, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_fo, R.string.asopo_f_o, R.raw.fo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_foo, R.string.asopo_f_oo, R.raw.foo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_fu, R.string.asopo_f_u, R.raw.fu, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_ga, R.string.asopo_g_a, R.raw.ga, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_ge, R.string.asopo_g_e, R.raw.ge, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gee, R.string.asopo_g_ee, R.raw.gee, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gi, R.string.asopo_g_i, R.raw.gi, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_go, R.string.asopo_g_o, R.raw.go, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_goo, R.string.asopo_g_oo, R.raw.goo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gu, R.string.asopo_g_u, R.raw.gu, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gb, R.string.asopo_g_b, R.raw.gb, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gba, R.string.asopo_g_ba, R.raw.gba, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gbe, R.string.asopo_g_be, R.raw.gbe, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gbee, R.string.asopo_gb_ee, R.raw.gbee, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gbi, R.string.asopo_gb_i, R.raw.gbi, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gbo, R.string.asopo_gb_o, R.raw.gbo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gboo, R.string.asopo_gbo_O, R.raw.gboo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.asopo_gbu, R.string.asopo_gb_u, R.raw.gbu, R.drawable.baseline_play_arrow_white_48));




        /*
         * creates an Array Adapter object, itemsAdapter to convert the data source, Array list to a list view
         *  */

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.dark_blue_1_color);



        /*
         * search for a list view called list_item in the activity
         * number xml then store it as a list view in list view object
         * */

        GridView listView = findViewById(R.id.grid_list);

        /*
         * Attached the Array Adapter object to the list view object created above
         *  */
        listView.setAdapter(itemsAdapter);


        //setting an event listener on each adapter on the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //get the position of each arraylist object created above
                //then store that in Word variable word
                Word word = words.get(position);

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
                    playmusic = MediaPlayer.create(AsopoConsonantiAtiFaweliActivity.this, word.getAudioFile());

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