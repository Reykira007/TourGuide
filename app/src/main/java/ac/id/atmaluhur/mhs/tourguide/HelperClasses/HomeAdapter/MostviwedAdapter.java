package ac.id.atmaluhur.mhs.tourguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ac.id.atmaluhur.mhs.tourguide.R;

public class MostviwedAdapter extends RecyclerView.Adapter<MostviwedAdapter.MostviewedViewHolder> {

    ArrayList<MostviwedHelperClass> mostviwedLocations;

    public MostviwedAdapter(ArrayList<MostviwedHelperClass> mostviwedLocations) {
        this.mostviwedLocations = mostviwedLocations;
    }

    @NonNull
    @Override
    public MostviewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MostviewedViewHolder mostviewedViewHolder = new MostviewedViewHolder(view);
        return mostviewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostviewedViewHolder holder, int position) {

        MostviwedHelperClass mostviwedHelperClass = mostviwedLocations.get(position);

        holder.imageView.setImageResource(mostviwedHelperClass.getImageView());
        holder.textView.setText(mostviwedHelperClass.getTextView());
        holder.description.setText(mostviwedHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return mostviwedLocations.size();
    }

    public static class MostviewedViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView, description;

        public MostviewedViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            imageView = itemView.findViewById(R.id.mostviwed_image);
            textView = itemView.findViewById(R.id.mostviwed_title);
            description = itemView.findViewById(R.id.mostviwed_desc);

        }
    }

}
