package me.pauln.voicesearchGa;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity {

    public static final String GOOGLE_ASSISTANT_PACKAGE_NAME = "com.google.android.googlequicksearchbox";
    public static final String GOOGLE_ASSISTANT_ACTIVITY_NAME = "com.google.android.voicesearch.handsfree.HandsFreeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        launchGoogleAssistant();

        finish();
    }

    private void launchGoogleAssistant() {
        Intent intent = new Intent(Intent.ACTION_VOICE_COMMAND);
        intent.setPackage(GOOGLE_ASSISTANT_PACKAGE_NAME);
        intent.setClassName(
                GOOGLE_ASSISTANT_PACKAGE_NAME,
                GOOGLE_ASSISTANT_ACTIVITY_NAME
        );
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Google assistant is not available on your device", LENGTH_SHORT)
                    .show();
        }
    }
}