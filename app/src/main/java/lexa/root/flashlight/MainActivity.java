package lexa.root.flashlight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this,MyService.class);

        startService(intent);

    }


    @Override
    protected void onDestroy() {
        final Intent intent = new Intent(this,MyService.class);
        stopService(intent);
        super.onDestroy();
    }
}
