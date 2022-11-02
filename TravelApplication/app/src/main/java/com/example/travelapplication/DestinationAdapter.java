package com.example.travelapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class DestinationAdapter  extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Destination> destinationList;

    public DestinationAdapter(Context context, int layout, List<Destination> destinationList) {
        this.context = context;
        this.layout = layout;
        this.destinationList = destinationList;
    }

    @Override
    public int getCount() {
        return destinationList.size();//tra ve so luong item
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgPicture;
        TextView txtName,txtNameProvince, txtPrice ;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null ){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(layout ,null);
            holder = new ViewHolder();
            // ánh xạ view
            //anh xa
            holder = new ViewHolder();
            holder.txtName = (TextView) view.findViewById(R.id.textviewName);
            holder.txtNameProvince = (TextView) view.findViewById(R.id.textviewNameProvince);
            holder.txtPrice = (TextView) view.findViewById(R.id.textviewPrice);
            holder.imgPicture = (ImageView) view.findViewById(R.id.imageViewPicture);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
//gan gia tri
        Destination destination = destinationList.get(i);
        holder.txtName.setText(destination.getName());
        holder.txtNameProvince.setText(destination.getNameProvince());
        holder.txtPrice.setText(destination.getPrice());
        holder.imgPicture.setImageResource(destination.getPicture());

        return view;
    }
}
