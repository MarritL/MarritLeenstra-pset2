package marrit.marritleenstra_pset2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Marrit on 14-9-2017.
 */

public class MyListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        Intent intent;

        // check which element is clicked
        if (view == view.findViewById(R.id.button_start)) {
            // start PlaceholderActivity
            intent = new Intent(view.getContext(), PlaceholderActivity.class);
        }
        else if (view == view.findViewById(R.id.button_To_Story)) {
            // start StoryActivity
            intent = new Intent(view.getContext(), StoryActivity.class);
        }
        else  {
            intent = new Intent (view.getContext(), MainActivity.class);
        }

        view.getContext().startActivity(intent);
    }

}
