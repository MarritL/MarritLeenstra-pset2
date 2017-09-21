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
    public static Button mButton_To_Story;
    public static Button mButtonOK;

    // add tag for debugging
    public static final String TAG = "StoryApp";

    // add array for all storynames
    //private String mstoryNames[];

    // add story member
    public static Story story;

    // add other variables
    public static TextView mWorldsLeft;
    public static EditText mGiveWord;
    public static Boolean mLast;

    // string for key-value pairs
    public static final String EXTRA_PASS_STORY = "marrit.marritLeenstra_pset2.PassStory";
    public static final String STORY = "StoryText";
    public static final String LAST = "LastWordFilledIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // initiate views
        mButton_To_Story = (Button) findViewById(R.id.button_To_Story);
        mButtonOK = (Button) findViewById(R.id.button_OK);
        mGiveWord = (EditText) findViewById(R.id.Give_Word);
        mWorldsLeft = (TextView) findViewById(R.id.Words_Left);

        // initiate variables
        mLast = false;

        // hide button to story until story is complete, and set the ActivityListener on it.
        mButton_To_Story.setVisibility(View.INVISIBLE);
        mButton_To_Story.setOnClickListener(new MyActivityListener());


        // save story and whether last word is filled in on rotation
        if (savedInstanceState != null) {
            story = (Story) savedInstanceState.getSerializable(STORY);
            mLast = savedInstanceState.getBoolean(LAST);

            // hide some views and make the button visible if the last word is filled in already
            if (mLast) {
                mGiveWord.setVisibility(View.INVISIBLE);
                mButtonOK.setVisibility(View.INVISIBLE);
                mButton_To_Story.setVisibility(View.VISIBLE);
            }
        }
        else {
            // initialise new random story if there is none started yet
            InitialiseStory();
        }

        // set text/hint in Views
        mWorldsLeft.setText("Still "+ story.getPlaceholderRemainingCount() +" word(s) left");
        mGiveWord.setHint(story.getNextPlaceholder());

        // set listener on OK-button
        mButtonOK.setOnClickListener(new MyOKListener());

    }

    // method to initialise a random Story
    public void InitialiseStory() {
        String[] mstoryNames = new String[] {"madlib0_simple.txt", "madlib1_tarzan.txt",
                "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};

        // get a random number
        Random rand = new Random();
        int i = rand.nextInt(5);

        String mStoryName;
        mStoryName = mstoryNames[i];

        // create the story
        try {
            story = new Story(getAssets().open(mStoryName));
        }
        catch (IOException e) {
            Log.e(TAG, e.getClass().getName());
        }
    }

    // support rotation
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable(STORY, story);
        savedInstanceState.putBoolean(LAST, mLast);
    }

}
