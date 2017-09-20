package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

public class PlaceholderActivity extends AppCompatActivity {

    // add button member
    private Button mButton_To_Story;
    private Button mButtonOK;

    // add tag for debugging
    public static final String TAG = "StoryApp";

    private String storyNames[];

    // add story member
    public static Story story;

    // add other variables
    private TextView mWorldsLeft;
    public EditText mGiveWord;


    // string for key-value pair for use with Intent Extra
    public static final String EXTRA_PASS_STORY = "marrit.marritLeenstra_pset2.PassStory";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // initiate buttons
        mButton_To_Story = (Button) findViewById(R.id.button_To_Story);
        mButtonOK = (Button) findViewById(R.id.button_OK);

        // set listener on button
        mButton_To_Story.setOnClickListener(new MyActivityListener());
        Log.d(TAG, "Listener on Button_To_Story set" );

        // initiate storyNames[]
        storyNames = new String[] {"madlib0_simple.txt", "madlib1_tarzan.txt",
                "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};

        // get a random number
        Random rand = new Random();
        int i = rand.nextInt(5);

        // initialise random story
        InitialiseStory(storyNames[i]);

        // initiate TextView
        mWorldsLeft = (TextView) findViewById(R.id.Words_Left);
        mWorldsLeft.setText("Still "+story.getPlaceholderRemainingCount()+" word(s) left");

        // initiate EditText with hint of the placeholder
        mGiveWord = (EditText) findViewById(R.id.Give_Word);
        mGiveWord.setHint(story.getNextPlaceholder());

        // implement buttonOK
        mButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story.fillInPlaceholder(mGiveWord.getText().toString());
                mGiveWord.setHint(story.getNextPlaceholder());
                mWorldsLeft.setText("Still "+story.getPlaceholderRemainingCount()+" word(s) left");
                mGiveWord.setText("");
            }
        });

    }

    public void InitialiseStory(String storyName) {
        try {
            story = new Story(getAssets().open(storyName));
            Log.d(TAG, "created story");
        }
        catch (IOException e) {
            Log.e(TAG, e.getClass().getName());
        }
    }

}
