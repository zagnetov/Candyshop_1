package com.example.zagne_000.candysop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ItemListFragment firstFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragment = new ItemListFragment();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_id, firstFragment)
                    .commit();
        }
    }

    public void replaceSecondFragment(Candy candy){
        Bundle bundles = new Bundle();
        bundles.putSerializable("object", candy);
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(bundles);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_id, fragment)
                .commit();
    }

    public void replaceFirstFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_id, firstFragment)
                .commit();
    }
}
