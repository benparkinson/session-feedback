package com.parkinsonhardy.sessionfeedback.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parkinsonhardy.sessionfeedback.R;
import com.parkinsonhardy.sessionfeedback.activities.SessionController;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SessionOwnerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SessionOwnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SessionOwnerFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_SESSION_CONTROLLER = "sessionController";

    private SessionController sessionController;

    private OnFragmentInteractionListener mListener;

    public SessionOwnerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param sessionController Parameter 1.
     * @return A new instance of fragment SessionOwnerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SessionOwnerFragment newInstance(SessionController sessionController) {
        SessionOwnerFragment fragment = new SessionOwnerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SESSION_CONTROLLER, sessionController);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sessionController = (SessionController) getArguments().getSerializable(ARG_SESSION_CONTROLLER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_session_owner, container, false);

        View newSessionButton = rootView.findViewById(R.id.new_session);
        newSessionButton.setOnClickListener(this);

        View existingSessionButton = rootView.findViewById(R.id.existing_session);
        existingSessionButton.setOnClickListener(this);

        return rootView;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(R.id.session_owner_fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.new_session:
                fragment = new NewSessionFragment();
                break;
            case R.id.existing_session:
                fragment = new ExistingSessionFragment();
                break;
        }

        if (fragment != null) {
            replaceFragment(fragment);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
