package aljebraschool.example.akomolede;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class OroAropoOrukoActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list_view);

        //storing our numbers using an array list
        ArrayList<Word> words = new ArrayList<>();

        //adding each numbers 1-10 and its miwok translation to the words array list above
        //word.add("one")
        Word w = new Word(R.string.oriki_oro_aropo_oruko, R.string.definition, R.drawable.baseline_arrow_forward_ios_white_48);
        words.add(w);

        //repeating the process for the remaining numbers
        words.add(new Word(R.string.apeere_oro_aropo_oruko, R.string.example_pronoun, R.drawable.baseline_arrow_forward_ios_white_48));
        words.add(new Word(R.string.ise_ifikora, R.string.Exercise, R.drawable.baseline_arrow_forward_ios_white_48));


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


                switch (position) {

                    case 0:
                        //explicitly creating an intent to call another activity
                        intent = new Intent(getApplicationContext(), OrikiOroAropoOrukoActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        //explicitly creating an intent to call another activity
                        intent = new Intent(getApplicationContext(), ApeereOroAropoOrukoActivity.class);
                        startActivity(intent);
                        break;

                    case 2:
                        //explicitly creating an intent to call another activity
                        intent = new Intent(getApplicationContext(), IseIfikoraOroAropoOrukoActivity.class);
                        startActivity(intent);
                        break;


                }


            }
        });

        //used to display action button that will take this activity back to the main screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}
