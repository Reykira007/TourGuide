package ac.id.atmaluhur.mhs.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter.CategoriesAdapter;
import ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter.CategoriesHelperClass;
import ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter.MostviwedAdapter;
import ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter.MostviwedHelperClass;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variable
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, mostviwedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    LinearLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostviwedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        naviagtionDrawer();


        //Recycle Views Function Calls
        featuredRecycler();
        mostviwedRecycler();
        categoriesRecycler();

    }


    //Navigation Drawer Functions
    private void naviagtionDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.lightwhite));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    //on click
    public void callRetailerScreens(View view){

        startActivity(new Intent(getApplicationContext(),RetailerStartUpScreen.class));

    }

    public void callMakanan(View view){

        startActivity(new Intent(getApplicationContext(),Makanan.class));

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.paggoda, "Tri Puri Agung", "Pemandangan perbukitan yang megah dan terdapat panorama pantai di sekitar."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.penyusuk, "Pantai Penyusuk", "Air yang tenang dan terdapat pulau diseberang menjadikan view yang indah."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.pasir_padi, "Pantai Pasir Padi", "Memiliki Berbagai aktifitas olahraga pantai yang menarik."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }
    private void mostviwedRecycler() {

        mostviwedRecycler.setHasFixedSize(true);
        mostviwedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostviwedHelperClass> mostviwedLocations = new ArrayList<>();

        mostviwedLocations.add(new MostviwedHelperClass(R.drawable.paggoda, "Tri Puri Agung","Pemandangan perbukitan yang megah dan terdapat panorama pantai di sekitar."));
        mostviwedLocations.add(new MostviwedHelperClass(R.drawable.penyusuk, "Pantai Penyusuk","Air yang tenang dan terdapat pulau diseberang menjadikan view yang indah."));
        mostviwedLocations.add(new MostviwedHelperClass(R.drawable.pasir_padi, "Pantai Pasir Padi","Memiliki Berbagai aktifitas olahraga pantai yang menarik."));

        adapter = new MostviwedAdapter(mostviwedLocations);
        mostviwedRecycler.setAdapter(adapter);

    }
    private void categoriesRecycler() {

        //All Gradients
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.restaurant, "Makanan Khas Bangka"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.penginapan, "Penginapan Bangka"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.beach, "Wisata Bangka"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.kebun, "Kebun Binatang"));

        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }



}