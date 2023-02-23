package edu.sjsu.android.fitnessify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class Fitness extends Fragment {

    // Fitness view, contain bmi, diet, music, and tops button
    ImageView bmi, diet, music, tips;
    public Fitness() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // fragment view field for music, bmi, tips, diet
        View fragment_view = inflater.inflate(R.layout.fragment_fitness, container, false);
        music = fragment_view.findViewById(R.id.music_button);
        bmi = fragment_view.findViewById(R.id.bmi_button);
        tips = fragment_view.findViewById(R.id.tips_button);
        diet = fragment_view.findViewById(R.id.diet_button);
        music.setOnClickListener(res -> {
            Toast.makeText(getActivity(), R.string.spotify, Toast.LENGTH_SHORT).show();
            navigate_to_spotify();
        });
        tips.setOnClickListener(res -> startActivity(new Intent(getActivity(),Tips.class)));
        diet.setOnClickListener(res -> startActivity(new Intent(getActivity(),Diet.class)));
        bmi.setOnClickListener(res -> startActivity(new Intent(getActivity(),BMI.class)));
        return fragment_view;
    }

    // when user click on music button then it will take them to spotify
    private void navigate_to_spotify() {
        Uri x = Uri.parse(getString(R.string.spotify_url));
        startActivity(new Intent(Intent.ACTION_VIEW,x));
    }
}