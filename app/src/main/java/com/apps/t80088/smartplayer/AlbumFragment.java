package com.apps.t80088.smartplayer;

import android.app.ActionBar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlbumFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlbumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbumFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public AlbumFragment() {
        // Setup
    }

    public static AlbumFragment newInstance() {
        AlbumFragment fragment = new AlbumFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Fill the table with albums
        TableLayout table = getView().findViewById(R.id.table);

        ArrayList<String> albums = new ArrayList<String>();

        // Temp for testing
        for(int i=0;i<30;i++)
            albums.add("One");


        for(int i=0;i<albums.size();i+=2){
            // 2 albums per row, so do 2 at a time
            TableRow row = new TableRow(getContext());
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            ImageButton leftAlbum = new ImageButton(getContext());
            leftAlbum.setImageResource(R.drawable.ic_jtgsafetravels);
            leftAlbum.setLayoutParams(new ViewGroup.LayoutParams(1000, 1000));

            ImageButton rightAlbum = new ImageButton(getContext());
            rightAlbum.setImageResource(R.drawable.ic_album);       // In final version replace this with album art
            rightAlbum.setLayoutParams(new ViewGroup.LayoutParams(1000, 1000));

            row.addView(leftAlbum, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)));
            row.addView(rightAlbum, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)));

            table.addView(row, i%2);
        }
    }

    // Touch later
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
