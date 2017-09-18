package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class PlaceholderActivity extends AppCompatActivity {

    // add button member
    private Button mButton_To_Story;

    // add tag for debugging
    public static final String TAG = "StoryApp";

    // add story member
    public Story mSimple;

    // add other variables
    private int mCount;
    private int mRemainingCount;
    private TextView mWorldsLeft;
    public EditText mGiveWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // initiate button
        mButton_To_Story = (Button) findViewById(R.id.button_To_Story);

        // set listener on button
        mButton_To_Story.setOnClickListener(new MyListener());
        Log.d(TAG, "Listener on Button_To_Story set" );

        // initialise story
        InitialiseStory();

        // initiate TextView
        mWorldsLeft = (TextView) findViewById(R.id.Words_Left);
        mRemainingCount = mSimple.getPlaceholderRemainingCount();
        mWorldsLeft.setText("Still "+mRemainingCount+" word(s) left");

        // initiate EditText with hint of the placeholder
        mGiveWord = (EditText) findViewById(R.id.Give_Word);
        mGiveWord.setHint(mSimple.getNextPlaceholder());

        // check how many placeholders
        //mCount = mSimple.getPlaceholderCount();
        // TODO delete?
        //System.out.println(mCount);
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


}
