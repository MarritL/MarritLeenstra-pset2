package marrit.marritleenstra_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import static marrit.marritleenstra_pset2.PlaceholderActivity.EXTRA_PASS_STORY;

public class StoryActivity extends AppCompatActivity {

    // add variables
    private TextView mStoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // Initiate button and TextView
        Button mButton_Restart = (Button) findViewById(R.id.button_restart);
        mStoryTextView = (TextView) findViewById(R.id.Story);

        // add listener to button
        mButton_Restart.setOnClickListener(new MyActivityListener());

        //load story
        String storyText = getIntent().getStringExtra(EXTRA_PASS_STORY);
        mStoryTextView.setText(storyText);

    }

    // With the back on the phone go to mainActivity and start from 0
    // source: https://stackoverflow.com/questions/27129353/android-back-navigation
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(StoryActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}
