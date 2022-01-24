package ac.id.atmaluhur.mhs.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class Wisata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);
    }

    public void callDashboard(View view){

        startActivity(new Intent(getApplicationContext(),Dashboard.class));

    }

    public void callHistory(View view){

        startActivity(new Intent(getApplicationContext(),History.class));

    }

}