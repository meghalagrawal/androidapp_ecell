package app.startups.nitrr.ecell.ecellapp.events.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.startups.nitrr.ecell.ecellapp.R;
import app.startups.nitrr.ecell.ecellapp.helper.image_loaders.GlideImageLoader;
import app.startups.nitrr.ecell.ecellapp.helper.image_loaders.ImageLoader;

/**
 * Created by Iket on 7/27/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<EventsData> EventDataList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public Adapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
       imageLoader = new GlideImageLoader(context);
    }

    public void setData(List<EventsData> EventDataList) {
        this.EventDataList = EventDataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(R.layout.activity_events_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        EventsData eventData = EventDataList.get(position);
        holder.event_name.setText(eventData.getEventName());
        holder.date_time.setText(eventData.getDate());
        holder.venue.setText(eventData.getVenue());
        holder.description.setText(eventData.getDescription());
        imageLoader.loadImage(eventData.getImage(), holder.imageView);

    }

    @Override
    public int getItemCount() {
        return this.EventDataList.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView event_name, date_time, venue, description;


        private ImageView imageView;


        private MyViewHolder(View itemView) {
            super(itemView);
            event_name = (TextView) itemView.findViewById(R.id.event_name);
            date_time = (TextView) itemView.findViewById(R.id.date_time);
            venue = (TextView) itemView.findViewById(R.id.venue);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.imgview1);

        }

    }
}

