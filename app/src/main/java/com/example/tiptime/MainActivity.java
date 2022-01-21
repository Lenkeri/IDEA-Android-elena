package com.example.tiptime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.tiptime.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.calculateButton.setOnClickListener((v)-> {calculteTip();});
    }

    private void calculteTip() {
        String stringCost = binding.costOfService.getText().toString();
        if ("".equals(stringCost)) {
            return;
        }
        Double cost = Double.valueOf((stringCost));

        int percentId = binding.tipOption.getCheckedRadioButtonId();
        double percentValue = 1;
        switch (percentId) {
            case R.id.twenty_percent: percentValue = .2; break;
            case R.id.eighteen_percent: percentValue = .18; break;
            case R.id.fifteen_percent: percentValue = .15; break;
        }

        double tip = cost * percentValue;

        if (binding.roundOfTip.isChecked()) {
            tip = Math.ceil(tip);
        }

        binding.resultTip.setText("Tip amount: $" + tip);
    }
}