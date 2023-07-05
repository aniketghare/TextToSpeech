package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import com.example.texttospeech.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private ActivityMainBinding binding;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


         textToSpeech = new TextToSpeech(this,this);

        binding.button.setOnClickListener(
                v -> {
                    textToSpeech.speak(
                            binding.editTextTextMultiLine.getText().toString() ,
                            TextToSpeech.QUEUE_FLUSH,
                            null
                    );
                }
        );
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){

            int result = textToSpeech.setLanguage(Locale.ENGLISH);

            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                Toast.makeText(this, "missing language", Toast.LENGTH_SHORT).show();
            }
            else {
                //success
            }
        }

    }
}