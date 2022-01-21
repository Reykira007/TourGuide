package ac.id.atmaluhur.mhs.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

public class RetailerStartUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_start_up_screen);
    }

    public void callLoginScreen(View view){

        Intent intent = new Intent(getApplicationContext(),Login.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.login_button),"transition_login");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this,pairs);
        startActivity(intent, options.toBundle());
    }

    public void callSignupScreen(View view){

        Intent intent = new Intent(getApplicationContext(),SignUp.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_button),"transition_signup");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this,pairs);
        startActivity(intent, options.toBundle());

    }

}