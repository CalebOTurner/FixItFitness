package com.example.fixitfitness;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge(); // Manually enable edge-to-edge
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // Create an Intent to navigate to SecondActivity when the user clicks the button
    public void onContinueClicked(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    // Manually enable edge-to-edge display
    private void enableEdgeToEdge() {
        // Make system bars transparent (except for 3-button navigation mode)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }
}
