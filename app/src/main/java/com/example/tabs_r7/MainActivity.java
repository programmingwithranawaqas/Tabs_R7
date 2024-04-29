package com.example.tabs_r7;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);


        TabLayoutMediator tlm = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                switch (i)
                {
                    case 0:
                        tab.setText("Chats");
                        tab.setIcon(R.drawable.ic_call);
                        BadgeDrawable bd =  tab.getOrCreateBadge();
                        bd.setNumber(102);
                        bd.setMaxCharacterCount(3);
                        bd.setVisible(true);
                        break;
                    case 1:
                        tab.setText("Updates");
                        tab.setIcon(R.drawable.ic_call);
                        break;
                    case 2:
                        tab.setText("Community");
                        tab.setIcon(R.drawable.ic_call);
                        BadgeDrawable bd1 =  tab.getOrCreateBadge();
                        bd1.setNumber(12);
                        bd1.setMaxCharacterCount(3);
                        bd1.setVisible(true);
                        break;
                    default:
                        tab.setText("Calls");
                        tab.setIcon(R.drawable.ic_call);
                        break;
                }
            }
        });

        tlm.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                BadgeDrawable bd = tabLayout.getTabAt(position).getOrCreateBadge();
                bd.setVisible(false);
                bd.setNumber(0);
            }
        });

    }
}