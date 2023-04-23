/* The activity implements the content covered under "small and big alphabets in yoruba" */
package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class AlifabeNlaAtiKekereActivity extends AppCompatActivity {

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
        setContentView(R.layout.word_grid_view);

        //storing our numbers using an array list
        ArrayList<Word> words = new ArrayList<>();


        //adding each numbers 1-10 and its miwok translation to the words array list above
        //word.add("one")
        Word w = new Word(R.string.A, R.string.sound_a, R.raw.a, R.drawable.baseline_play_arrow_white_48);
        words.add(w);


        //repeating the process for the remaining numbers
        words.add(new Word(R.string.B, R.string.sound_b, R.raw.b, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.D, R.string.sound_d, R.raw.d, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.E, R.string.sound_e, R.raw.e, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.Ee, R.string.sound_Ee, R.raw.ee, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.F, R.string.sound_F, R.raw.f, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.G, R.string.sound_g, R.raw.g, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.Gb, R.string.sound_gb, R.raw.gb, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.H, R.string.sound_In, R.raw.i, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.I, R.string.sound_He, R.raw.h, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.J, R.string.sound_J, R.raw.j, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.K, R.string.sound_K, R.raw.k, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.L, R.string.sound_L, R.raw.l, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.M, R.string.sound_M, R.raw.m, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.N, R.string.sound_N, R.raw.n, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.O, R.string.sound_O, R.raw.o, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.Oo, R.string.sound_Oo, R.raw.oo, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.P, R.string.sound_P, R.raw.p, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.R, R.string.sound_R, R.raw.r, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.S, R.string.sound_S, R.raw.s, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.Ss, R.string.sound_Ss, R.raw.ss, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.T, R.string.sound_T, R.raw.t, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.U, R.string.sound_U, R.raw.u, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.W, R.string.sound_W, R.raw.w, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.Y, R.string.sound_y, R.raw.y, R.drawable.baseline_play_arrow_white_48));


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
                    playmusic = MediaPlayer.create(AlifabeNlaAtiKekereActivity.this, word.getAudioFile());

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