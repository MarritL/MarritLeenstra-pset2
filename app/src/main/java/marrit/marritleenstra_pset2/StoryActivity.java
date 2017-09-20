package marrit.marritleenstra_pset2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import static marrit.marritleenstra_pset2.PlaceholderActivity.EXTRA_PASS_STORY;

public class StoryActivity extends AppCompatActivity {

    // add button member
    private Button mButton_Restart;

    // add variables
    private TextView mStoryTextView;
    private String text;
    public static final String TAG = "StoryApp";
    private Story mSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Log.d(TAG, "Created StoryActivity");

        // Initiate button and TextView
        mButton_Restart = (Button) findViewById(R.id.button_restart);
        mStoryTextView = (TextView) findViewById(R.id.Story);

        // add listener to button
        mButton_Restart.setOnClickListener(new MyActivityListener());

        //load story
        text = getIntent().getStringExtra(EXTRA_PASS_STORY);
        mStoryTextView.setText(text);

    }

}
