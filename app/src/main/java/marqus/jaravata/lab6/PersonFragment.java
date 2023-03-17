package marqus.jaravata.lab6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PersonFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);

        listView = view.findViewById(R.id.list_view);

        String[] provinces = getResources().getStringArray(R.array.provinces_and_territories);

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_activated_1, provinces);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = provinces[position];
                ((MainActivity) getActivity()).updateSelectedProvince(selectedItem, position);
            }
        });

        return view;
    }
}

