package marqus.jaravata.lab6;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsFragment extends Fragment {

    private TextView clockTextView;
    private TextView selectedProvinceTextView;
    private TextView orderTextView;

    private final Handler handler = new Handler();
    private final Runnable updateClock = new Runnable() {
        @Override
        public void run() {
            updateClock();
            handler.postDelayed(this, 1000);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        clockTextView = view.findViewById(R.id.clock_text_view);
        selectedProvinceTextView = view.findViewById(R.id.selected_province_text_view);
        orderTextView = view.findViewById(R.id.order_text_view);

        String selectedProvince = ((MainActivity) getActivity()).getSelectedProvince();
        int selectedIndex = ((MainActivity) getActivity()).getSelectedIndex();

        if (selectedProvince != null) {
            selectedProvinceTextView.setText(selectedProvince);
            orderTextView.setText(String.valueOf(selectedIndex + 1));
        }

        updateClock();
        handler.postDelayed(updateClock, 1000);

        return view;
    }

    private void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        clockTextView.setText(currentTime);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(updateClock);
    }
}
