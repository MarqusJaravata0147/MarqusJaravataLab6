package marqus.jaravata.lab6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private ProgressBar progressBar;
    private ImageButton imageButton;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        progressBar = view.findViewById(R.id.progress_bar);
        imageButton = view.findViewById(R.id.image_button);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                String message = getString(R.string.first_name) + " " + counter;
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                progressBar.setProgress(counter);

                if (counter >= 5) {
                    progressBar.setVisibility(View.GONE);
                }

                if (counter >= 8) {
                    getActivity().finish();
                }
            }
        });

        return view;
    }
}


