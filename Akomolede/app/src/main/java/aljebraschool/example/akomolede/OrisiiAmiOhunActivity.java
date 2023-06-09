package aljebraschool.example.akomolede;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class OrisiiAmiOhunActivity extends AppCompatActivity {

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
        setContentView(R.layout.word_list_view);

        //storing our numbers using an array list
        ArrayList<Word> words = new ArrayList<>();


        //adding each numbers 1-10 and its miwok translation to the words array list above
        //word.add("one")
        Word w = new Word(R.string.ami_oke, R.string.ami_mi, R.raw.mi, R.drawable.baseline_play_arrow_white_48);
        words.add(w);


        //repeating the process for the remaining numbers
        words.add(new Word(R.string.ami_aarin, R.string.ami_re, R.raw.re, R.drawable.baseline_play_arrow_white_48));
        words.add(new Word(R.string.ami_isale, R.string.ami_do, R.raw.do_do, R.drawable.baseline_play_arrow_white_48));

        /*
         * creates an Array Adapter object, itemsAdapter to convert the data source, Array list to a list view
         *  */

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.dark_blue_1_color);



        /*
         * search for a list view called list_item in the activity
         * number xml then store it as a list view in list view object
         * */

        ListView listView = findViewById(R.id.list);

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
                    playmusic = MediaPlayer.create(OrisiiAmiOhunActivity.this, word.getAudioFile());

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