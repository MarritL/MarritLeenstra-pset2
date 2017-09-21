package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

public class PlaceholderActivity extends AppCompatActivity {

    // add button member
    private Button mButton_To_Story;
    public static Button mButtonOK;

    // add tag for debugging
    public static final String TAG = "StoryApp";

    // add array for all storynames
    private String mstoryNames[];

    // add story member
    public static Story story;

    // add other variables
    public static TextView mWorldsLeft;
    public static EditText mGiveWord;


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

        // initialise random story
        InitialiseStory();

        // initiate TextView
        mWorldsLeft = (TextView) findViewById(R.id.Words_Left);
        mWorldsLeft.setText("Still "+ story.getPlaceholderCount() +" word(s) left");

        // initiate EditText with hint of the placeholder
        mGiveWord = (EditText) findViewById(R.id.Give_Word);
        mGiveWord.setHint(story.getNextPlaceholder());


        // set listener on OK-button
        mButtonOK.setOnClickListener(new MyOKListener());

    }

    // method to initialse a random Story
    public void InitialiseStory() {
        mstoryNames = new String[] {"madlib0_simple.txt", "madlib1_tarzan.txt",
                "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};

        // get a random number
        Random rand = new Random();
        int i = rand.nextInt(5);

        String mStoryName;
        mStoryName = mstoryNames[i];

        try {
            story = new Story(getAssets().open(mStoryName));
            Log.d(TAG, "created story");
        }
        catch (IOException e) {
            Log.e(TAG, e.getClass().getName());
        }
    }

    //TODO
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

    }

}
