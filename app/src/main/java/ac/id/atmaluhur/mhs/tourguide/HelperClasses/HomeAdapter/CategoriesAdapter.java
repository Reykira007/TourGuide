package ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ac.id.atmaluhur.mhs.tourguide.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesHolder> {

    ArrayList<CategoriesHelperClass> mostViewedLocations;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public AdapterAllCategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        AdapterAllCategoriesHolder lvh = new AdapterAllCategoriesHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesHolder holder, int position) {

        CategoriesHelperClass helperClass = mostViewedLocations.get(position);
        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitle());
        holder.relativeLayout.setBackground(helperClass.getGradient());


    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class AdapterAllCategoriesHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public AdapterAllCategoriesHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            relativeLayout = itemView.findViewById(R.id.background_gradient);
            imageView = itemView.findViewById(R.id.categories_image);
            textView = itemView.findViewById(R.id.categories_title);

        }
    }



}
