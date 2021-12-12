package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner filmGenre, filmCountry;
    TextView filmsResult;
    int films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmGenre = findViewById(R.id.filmGenre);
        filmCountry = findViewById(R.id.filmCountry);
        filmsResult = findViewById(R.id.filmsResult);
        if (savedInstanceState != null) {
            films = savedInstanceState.getInt("films");
            filmsResult.setText(films);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("films", films);
        super.onSaveInstanceState(bundle);
    }


    public void setFilmsResult(View v) {
        String selectedGenre = filmGenre.getSelectedItem().toString();
        String selectedCountry = filmCountry.getSelectedItem().toString();

        if (selectedCountry.equals("Отечественное")) {
            if (selectedGenre.equals("Комедия")){
                films = R.string.Comedy;
                filmsResult.setText(R.string.Comedy);
            } else if (selectedGenre.equals("Мелодрама")) {
                films = R.string.Melodrama;
                filmsResult.setText(R.string.Melodrama);
            } else if (selectedGenre.equals("Боевик")) {
                films = R.string.Action;
                filmsResult.setText(R.string.Action);
            } else if (selectedGenre.equals("Детектив")) {
                films = R.string.Detective;
                filmsResult.setText(R.string.Detective);
            } else  {
                films = R.string.Adventures;
                filmsResult.setText(R.string.Adventures);
            }
        } else filmsResult.setText("");

    }

}