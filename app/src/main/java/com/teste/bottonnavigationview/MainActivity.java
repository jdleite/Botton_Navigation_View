package com.teste.bottonnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private MusicFragment musicFragment;
    private CartFragment cartFragment;
    private Menu1Fragment menu1Fragment;
    private Menu2Fragment menu2Fragment;
    private Menu3Fragment menu3Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.buttonBar);

        homeFragment = new HomeFragment();
        cartFragment = new CartFragment();
        musicFragment = new MusicFragment();
        menu1Fragment = new Menu1Fragment();
        menu2Fragment = new Menu2Fragment();
        menu3Fragment = new Menu3Fragment();

        setOurFragment(homeFragment);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        bottomNavigationView.setItemBackgroundResource(R.color.home);
                        setOurFragment(homeFragment);
                        return true;
                    case R.id.music:
                        bottomNavigationView.setItemBackgroundResource(R.color.music);
                        setOurFragment(musicFragment);
                        return true;
                    case R.id.cart:
                        bottomNavigationView.setItemBackgroundResource(R.color.cart);
                        setOurFragment(cartFragment);
                    default:
                        return false;

                }

            }
        });
    }

    public void setOurFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        switch (item.getItemId()) {
            case R.id.menu1:
                setOurFragment(menu1Fragment);
                break;
            case R.id.menu2:
                setOurFragment(menu2Fragment);
                break;
            case R.id.menu3:
                setOurFragment(menu3Fragment);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
