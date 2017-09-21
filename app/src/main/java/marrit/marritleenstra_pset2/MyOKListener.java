package marrit.marritleenstra_pset2;

import android.view.View;

import static marrit.marritleenstra_pset2.PlaceholderActivity.story;
import static marrit.marritleenstra_pset2.PlaceholderActivity.mGiveWord;
import static marrit.marritleenstra_pset2.PlaceholderActivity.mWorldsLeft;
import static marrit.marritleenstra_pset2.PlaceholderActivity.mButtonOK;

/**
 * Created by Marrit on 18-9-2017.
 * Non-Anonymous OnclickListener for the OK button in PlaceholderActivity
 * By clicking OK (Next) the word will be filled in into the story and the next placeholder will
 * appear to be filled in next.
 */

public class MyOKListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        story.fillInPlaceholder(mGiveWord.getText().toString());

        if (story.getPlaceholderRemainingCount() > 0) {
            mGiveWord.setHint(PlaceholderActivity.story.getNextPlaceholder());
            mGiveWord.setText("");
            mWorldsLeft.setText("Still " + story.getPlaceholderRemainingCount() + " word(s) left");
        }
        else {
            mGiveWord.setVisibility(View.INVISIBLE);
            mButtonOK.setVisibility(View.INVISIBLE);
            mWorldsLeft.setText("Still " + story.getPlaceholderRemainingCount() + " word(s) left");
        }

    }
}
