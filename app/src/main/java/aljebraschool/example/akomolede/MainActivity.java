package aljebraschool.example.akomolede;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //find the testview component to call intent on
        LinearLayout numberOneTextView = findViewById(R.id.number_one_text_view);


        //using anonymous inner class signature to implement the intent call
        numberOneTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), AlifabetiYoruba.class);
                        startActivity(intent);
                    }
                });

        //find the testview component to call intent on
        LinearLayout numberTwoTextView = findViewById(R.id.number_two_text_view);


        //using anonymous inner class signature to implement the intent call
        numberTwoTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), AsopoConsonantiAtiFaweliActivity.class);
                        startActivity(intent);
                    }
                });


        //find the testview component to call intent on
        LinearLayout numberThreeTextView = findViewById(R.id.number_three_text_view);


        //using anonymous inner class signature to implement the intent call
        numberThreeTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), AmiOhunActivity.class);
                        startActivity(intent);
                    }
                });

        //find the testview component to call intent on
        LinearLayout numberFourTextView = findViewById(R.id.number_four_text_view);


        //using anonymous inner class signature to implement the intent call
        numberFourTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), SisoOroPoActivity.class);
                        startActivity(intent);
                    }
                });

        //find the testview component to call intent on
        LinearLayout numberFiveTextView = findViewById(R.id.number_five_text_view);


        //using anonymous inner class signature to implement the intent call
        numberFiveTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), IkiniActivity.class);
                        startActivity(intent);
                    }
                });


        //find the testview component to call intent on
        LinearLayout numberSixTextView = findViewById(R.id.number_six_text_view);


        //using anonymous inner class signature to implement the intent call
        numberSixTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), OroIseActivity.class);
                        startActivity(intent);
                    }
                });


        //find the testview component to call intent on
        LinearLayout numberSevenTextView = findViewById(R.id.number_seven_text_view);


        //using anonymous inner class signature to implement the intent call
        numberSevenTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), OroOrukoActivity.class);
                        startActivity(intent);
                    }
                });


        //find the testview component to call intent on
        LinearLayout numberEightTextView = findViewById(R.id.number_eight_text_view);


        //using anonymous inner class signature to implement the intent call
        numberEightTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), OroAropoOrukoActivity.class);
                        startActivity(intent);
                    }
                });


        //find the testview component to call intent on
        LinearLayout numberNineTextView = findViewById(R.id.number_nine_text_view);


        //using anonymous inner class signature to implement the intent call
        numberNineTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), OroAropoAfarajerukoActivity.class);
                        startActivity(intent);
                    }
                });


        //find the testview component to call intent on
        LinearLayout numberTenTextView = findViewById(R.id.number_ten_text_view);


        //using anonymous inner class signature to implement the intent call
        numberTenTextView.setOnClickListener(
                new View.OnClickListener() {

                    //Implementing the onClick method when component is called
                    @Override
                    public void onClick(View view) {

                        //explicitly creating an intent to call another activity
                        Intent intent = new Intent(getApplicationContext(), OroAtiItumoActivity.class);
                        startActivity(intent);
                    }
                });


    }
}