package tour;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.travelapplication.R;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder>{

    private List<Tour> lTours;

    public  void setData(List<Tour> list){
        this.lTours = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour,parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = lTours.get(position);
        if(tour==null){
            return;
        }
        holder.imgTour.setImageResource(tour.getPicture());
        holder.tvName.setText(tour.getName());
        holder.tvProvinceName.setText(tour.getNameProvince());
        holder.tvPrice.setText(tour.getPrice());
    }

    @Override
    public int getItemCount() {
        if(lTours != null){
            return lTours.size();
        }
        return 0;
    }

    public class TourViewHolder  extends RecyclerView.ViewHolder {

        private ImageView imgTour;
        private TextView tvName, tvProvinceName, tvPrice;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTour = (ImageView) itemView.findViewById(R.id.imageview_tour);
            tvName = (TextView) itemView.findViewById(R.id.textView_name1);
            tvProvinceName = (TextView) itemView.findViewById(R.id.textView_provinceName);
            tvPrice = (TextView) itemView.findViewById(R.id.textView_price);
        }
    }
}
