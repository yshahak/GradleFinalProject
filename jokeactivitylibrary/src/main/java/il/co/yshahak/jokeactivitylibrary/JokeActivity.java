package il.co.yshahak.jokeactivitylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {


    public static final String EXTRA_JOKE = "extraJoke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity_main);
        TextView textViewJokeDisplay = (TextView) findViewById(R.id.joke_text_view);
        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        if (joke != null){
            textViewJokeDisplay.setText(joke);
        }

    }
}
