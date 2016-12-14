package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.kadirkertis.jokeviewer.JokeViewer;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {
    ProgressBar mProgressBar;

    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button btn = (Button) root.findViewById(R.id.paid_btn);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });
        return root;
    }

    public void tellJoke() {
//        Part 1&2
//        Intent intent = new Intent(this, JokeViewer.class);
//        intent.putExtra("JOKE",JokeProvider.makeMeLough());
//        startActivity(intent);
//        Toast.makeText(this, funnyBoy.makeMeLough(), Toast.LENGTH_SHORT).show();

        //Part 3
        mProgressBar.setVisibility(View.VISIBLE);
        GetJokeTask task = new GetJokeTask(new GetJokeTask.OnJokeReceivedListener() {
            @Override
            public void onJokeReceived(String result) {
                mProgressBar.setVisibility(View.GONE);
                Intent intent = new Intent(getActivity(),JokeViewer.class);
                intent.putExtra("JOKE",result);
                startActivity(intent);
            }
        });
        task.execute();
    }

}
