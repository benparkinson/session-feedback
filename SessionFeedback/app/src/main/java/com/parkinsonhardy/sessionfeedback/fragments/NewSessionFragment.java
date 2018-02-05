package com.parkinsonhardy.sessionfeedback.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.parkinsonhardy.sessionfeedback.R;
import com.parkinsonhardy.sessionfeedback.activities.SessionController;
import com.parkinsonhardy.sessionfeedback.model.SessionCreationArgs;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewSessionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewSessionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewSessionFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_SESSION_CONTROLLER = "sessionController";

    private SessionController sessionController;

    private OnFragmentInteractionListener mListener;

    public NewSessionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param sessionController
     * @return A new instance of fragment NewSessionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewSessionFragment newInstance(SessionController sessionController) {
        NewSessionFragment fragment = new NewSessionFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_new_session, container, false);

        View createSessionButton = rootView.findViewById(R.id.create_session_button);
        createSessionButton.setOnClickListener(this);

        return rootView;
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
        switch (view.getId()) {
            case R.id.create_session_button:
                EditText pinEditText = getActivity().findViewById(R.id.new_session_pin_edit_text);
                EditText confirmPinEditText = getActivity().findViewById(R.id.new_session_confirm_pin_edit_text);
                String pin = pinEditText.getText().toString();
                String confirmPin = confirmPinEditText.getText().toString();

                // todo: compare pins

                EditText emailEditText = getActivity().findViewById(R.id.new_session_email_edit_text);
                String email = emailEditText.getText().toString();

                SessionCreationArgs args = new SessionCreationArgs(email, Integer.parseInt(pin));
                sessionController.createNewSession(args);
                // todo show loading screen whilst going to server to get new session info
                break;
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
