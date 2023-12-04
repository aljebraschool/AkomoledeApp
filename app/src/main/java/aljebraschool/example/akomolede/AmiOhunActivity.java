/* The activity implements the content covered under "tonal sign in yoruba" */
package aljebraschool.example.akomolede;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class AmiOhunActivity extends AppCompatActivity {

    private AdView mAdView;

    //created an object of the intent class to implement intent
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_view);

        //creating ads
        mAdView = findViewById(R.id.alifabet_yoruba_adView_banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //storing our numbers using an array list
        ArrayList<Word> words = new ArrayList<>();

        //adding each numbers 1-10 and its miwok translation to the words array list above
        //word.add("one")
        Word w = new Word(R.string.oriki_ami, R.string.definition, R.drawable.baseline_arrow_forward_ios_white_48);
        words.add(w);

        //repeating the process for the remaining numbers
        words.add(new Word(R.string.iran_ami, R.string.types_of__ami, R.drawable.baseline_arrow_forward_ios_white_48));
        words.add(new Word(R.string.akiye_lori_ami, R.string.notice_on_sign, R.drawable.baseline_arrow_forward_ios_white_48));
        words.add(new Word(R.string.apeere_lilo_ami, R.string.example_ami, R.drawable.baseline_arrow_forward_ios_white_48));
        words.add(new Word(R.string.ise_ifikora, R.string.Exercise, R.drawable.baseline_arrow_forward_ios_white_48));


        /*
         * creates an Array Adapter object, itemsAdapter to convert the data source, Array list to a list view
         *  */

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.dark_blue_1_color);


        /*
         * search for a list view called list_item in the activity
         * number xml then store it as a list view in list view object
         * */

        ListView listView =  findViewById(R.id.list);


        /*
         * Attached the Array Adapter object to the list view object created above
         *  */
        listView.setAdapter(itemsAdapter);


        //setting an event listener on each adapter on the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                switch (position){

                    case 0:
                        //explicitly creating an intent to call another activity
                         intent = new Intent(getApplicationContext(), OrikiAmiActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        //explicitly creating an intent to call another activity
                         intent = new Intent(getApplicationContext(), OrisiiAmiOhunActivity.class);
                        startActivity(intent);
                        break;

                    case 2:
                        //explicitly creating an intent to call another activity
                        intent = new Intent(getApplicationContext(), AkiyesiLoriAmiActivity.class);
                        startActivity(intent);
                        break;

                    case 3:
                        //explicitly creating an intent to call another activity
                        intent = new Intent(getApplicationContext(), ApeereAmiActivity.class);
                        startActivity(intent);
                        break;

                    case 4:
                        //explicitly creating an intent to call another activity
                        intent = new Intent(getApplicationContext(), IseIfikoraAmiActivity.class);
                        startActivity(intent);
                        break;


                }



            }
        });

        //used to display action button that will take this activity back to the main screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}
