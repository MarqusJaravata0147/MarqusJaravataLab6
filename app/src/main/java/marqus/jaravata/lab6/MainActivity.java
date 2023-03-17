package marqus.jaravata.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private String selectedProvince;
    private int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_marqus:
                    selectedFragment = new MarqusFragment();
                    break;
                case R.id.navigation_person:
                    selectedFragment = new PersonFragment();
                    break;
                case R.id.navigation_settings:
                    selectedFragment = new SettingsFragment();
                    break;
                default:
                    selectedFragment = new HomeFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        });

        // Set initial fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void updateSelectedProvince(String province, int index) {
        selectedProvince = province;
        selectedIndex = index;
    }

    public String getSelectedProvince() {
        return selectedProvince;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }
}

