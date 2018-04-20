package com.example.rodneytressler.week3assessmentkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AccountFragment.ActivityCallback {

    @BindView(R.id.welcome_text)
    protected TextView welcomeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AccountFragment accountFragment = AccountFragment.newInstance();
        accountFragment.setCallback(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, accountFragment).commit();
        welcomeText.setVisibility(View.INVISIBLE);

    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        AccountFragment accountFragment = AccountFragment().newInstance();
//        accountFragment.attachParent(this);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, accountFragment).commit();
//    }

    @Override
    public void AccountCreated(String name, String accountClass) {
        welcomeText.setVisibility(View.VISIBLE);
        welcomeText.setText(getString(R.string.welcome, name));
        getSupportFragmentManager().beginTransaction().remove(R.id.fragment_holder, AccountFragment).commit();

    }

}
