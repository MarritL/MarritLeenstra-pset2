package marrit.marritleenstra_pset2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class PlaceholderActivity extends AppCompatActivity {

    // add button member
    private Button mButton_To_Story;
    private Button mButtonOK;

    // add tag for debugging
    public static final String TAG = "StoryApp";

    // add story member
    public Story mSimple;

    // add other variables
    private int mCount;
    private int mRemainingCount;
    private TextView mWorldsLeft;
    public EditText mGiveWord;
    private String mWord;

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

        // initialise story
        InitialiseStory();

        // initiate TextView
        mWorldsLeft = (TextView) findViewById(R.id.Words_Left);
        mWorldsLeft.setText("Still "+mSimple.getPlaceholderRemainingCount()+" word(s) left");

        // initiate EditText with hint of the placeholder
        mGiveWord = (EditText) findViewById(R.id.Give_Word);
        mGiveWord.setHint(mSimple.getNextPlaceholder());

        // implement buttonOK
        mButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSimple.fillInPlaceholder(mGiveWord.getText().toString());
                mGiveWord.setHint(mSimple.getNextPlaceholder());
                mWorldsLeft.setText("Still "+mSimple.getPlaceholderRemainingCount()+" word(s) left");
                mGiveWord.setText("");
            }
        });


        // poging om story static te maken, zelfde foutmelding
        public static final String STORY_FINAL = mSimple.toString();

    }

    public void InitialiseStory() {
        try {
            mSimple = new Story(getAssets().open("madlib0_simple.txt"));
            Log.d(TAG, "created story");
        }
        catch (IOException e) {
            Log.e(TAG, e.getClass().getName());
        }
    }

    // poging om de story beschikbaar te maken in de Listener, maar werkte niet.
    // method from https://developer.android.com/training/basics/data-storage/shared-preferences.html
    public void ShareStory() {
        // put story in schared preferences
        SharedPreferences preferences = getPreferences(Context.MODE_APPEND);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(EXTRA_PASS_STORY, mSimple.toString());
        editor.commit();
    }



}
