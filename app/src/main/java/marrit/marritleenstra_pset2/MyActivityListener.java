package marrit.marritleenstra_pset2;

import android.content.Intent;
import android.view.View;


/**
 * Created by Marrit on 14-9-2017.
 * Non-Anonymous OnClick listener to go to another activity within the app.
 */

public class MyActivityListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        Intent intent;

        // check which element is clicked
        if (view == view.findViewById(R.id.button_To_Story)) {
            // start StoryActivity
            intent = new Intent(view.getContext(), StoryActivity.class);
            // put story as intent Extra
            intent.putExtra(PlaceholderActivity.EXTRA_PASS_STORY,PlaceholderActivity.story.toString());
        }
        else  {
            // start PlaceholderActivity to make a new story (both from mainActivity and storyActivity)
            intent = new Intent(view.getContext(), PlaceholderActivity.class);
        }

        view.getContext().startActivity(intent);
    }



}


