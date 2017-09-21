package marrit.marritleenstra_pset2;

import android.view.View;
import android.widget.Toast;

import static marrit.marritleenstra_pset2.PlaceholderActivity.story;
import static marrit.marritleenstra_pset2.PlaceholderActivity.mGiveWord;
import static marrit.marritleenstra_pset2.PlaceholderActivity.mWorldsLeft;
import static marrit.marritleenstra_pset2.PlaceholderActivity.mButtonOK;
import static marrit.marritleenstra_pset2.PlaceholderActivity.mButton_To_Story;
import static marrit.marritleenstra_pset2.PlaceholderActivity.mLast;

/**
 * Created by Marrit on 18-9-2017.
 * Non-Anonymous OnclickListener for the OK button in PlaceholderActivity
 * By clicking OK (Next) the word will be filled in into the story and the next placeholder will
 * appear to be filled in next.
 */

public class MyOKListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        // fill in the word in the text or ask for a word via a toast
        if (!mGiveWord.getText().toString().matches("")) {
            story.fillInPlaceholder(mGiveWord.getText().toString());

            // update placeholder in all views
            if (story.getPlaceholderRemainingCount() > 0) {
                mGiveWord.setHint(PlaceholderActivity.story.getNextPlaceholder());
                mGiveWord.setText("");
            }
            // if last word is filled in enable the button to read the full story
            else {
                mLast = true;
                mGiveWord.setVisibility(View.INVISIBLE);
                mButtonOK.setVisibility(View.INVISIBLE);
                mButton_To_Story.setVisibility(View.VISIBLE);
            }

            // update mWordsLeft text
            mWorldsLeft.setText("Still " + story.getPlaceholderRemainingCount() + " word(s) left");
        }
        else {
            Toast.makeText(view.getContext(), R.string.Toast_fill_in, Toast.LENGTH_SHORT).show();
        }

    }
}
