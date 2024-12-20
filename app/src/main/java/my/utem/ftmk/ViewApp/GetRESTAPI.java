package my.utem.ftmk.ViewApp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import my.utem.ftmk.ViewApp.ui.main.SectionsPagerAdapter;
import my.utem.ftmk.ViewApp.databinding.ActivityGetRestapiBinding;

public class GetRESTAPI extends AppCompatActivity {

    private ActivityGetRestapiBinding binding;

    TabLayout tabs;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGetRestapiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Set and define the tabs
        tabs = binding.tabs;
        tabs.addTab(tabs.newTab().setText("Get Joke"));
        tabs.addTab(tabs.newTab().setText("Get University"));
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this,
                getSupportFragmentManager(), tabs.getTabCount());
        viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}