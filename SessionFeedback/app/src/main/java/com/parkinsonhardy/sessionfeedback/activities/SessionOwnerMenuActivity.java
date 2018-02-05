package com.parkinsonhardy.sessionfeedback.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.parkinsonhardy.sessionfeedback.fragments.ExistingSessionFragment;
import com.parkinsonhardy.sessionfeedback.fragments.NewSessionFragment;
import com.parkinsonhardy.sessionfeedback.R;
import com.parkinsonhardy.sessionfeedback.fragments.SessionOwnerFragment;

public class SessionOwnerMenuActivity extends AppCompatActivity
        implements SessionOwnerFragment.OnFragmentInteractionListener,
        NewSessionFragment.OnFragmentInteractionListener,
        ExistingSessionFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_owner_menu);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = new SessionOwnerFragment();
        fragmentTransaction.add(R.id.session_owner_fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
