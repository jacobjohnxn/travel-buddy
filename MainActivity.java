package com.microproject.travel_buddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;



import com.microproject.travel_buddy.databinding.ActivityMainBinding;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new homeFragment());   //home frag is deafault acan change iwth this
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.camera:
                replaceFragment(new cameraFragment());
                break;
                case R.id.search:
                    replaceFragment(new searchFragment());
                    break;
                case R.id.location:
                    startActivity(new Intent(MainActivity.this, MapsActivity.class));
                    break;
                case R.id.hotel:
                    replaceFragment(new hotelFragment());
                    break;
                case R.id.taxi:
                    replaceFragment(new taxiFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();


    }
}

