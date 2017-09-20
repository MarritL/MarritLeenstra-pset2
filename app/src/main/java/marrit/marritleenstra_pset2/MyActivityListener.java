package marrit.marritleenstra_pset2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;


/**
 * Created by Marrit on 14-9-2017.
 */

public class MyActivityListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        Intent intent;

        // check which element is clicked
        if (view == view.findViewById(R.id.button_start)) {
            // start PlaceholderActivity
            intent = new Intent(view.getContext(), PlaceholderActivity.class);
            // put story as intent Extra
            intent.putExtra(PlaceholderActivity.EXTRA_PASS_STORY, PlaceholderActivity.mSimple.toString() );
        }
        else if (view == view.findViewById(R.id.button_To_Story)) {
            // start StoryActivity
            intent = new Intent(view.getContext(), StoryActivity.class);
        }
        else  {
            // go back to MainActivity
            intent = new Intent (view.getContext(), MainActivity.class);
        }

        view.getContext().startActivity(intent);
    }



}


