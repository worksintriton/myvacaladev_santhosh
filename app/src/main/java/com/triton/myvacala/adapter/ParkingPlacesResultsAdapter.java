package com.triton.myvacala.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.triton.myvacala.R;
import com.triton.myvacala.activities.parking.maps.ParkingPlacesSearchActivity;
import com.triton.myvacala.interfaces.PlacesNameListener;
import com.triton.myvacala.listeners.OnLoadMoreListener;
import com.triton.myvacala.responsepojo.PlacesResultsResponse;

import java.util.List;


public class ParkingPlacesResultsAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ONE = 1;
    private static final int TYPE_LOADING = 5;
    private  String TAG = "ParkingPlacesResultsAdapter";
    private List<PlacesResultsResponse.PredictionsBean> predictionsBeanList;
    private Context context;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    PlacesResultsResponse.PredictionsBean currentItem;
    String strMSgdaystime;
    String strMsg;






    private PlacesNameListener placesNameListener;



    public ParkingPlacesResultsAdapter(Context context, List<PlacesResultsResponse.PredictionsBean> predictionsBeanList, RecyclerView inbox_list, ParkingPlacesSearchActivity parkingPlacesSearchActivity) {
        this.predictionsBeanList = predictionsBeanList;
        this.context = context;

       this.placesNameListener = (PlacesNameListener)parkingPlacesSearchActivity;



        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) inbox_list.getLayoutManager();
        inbox_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                assert linearLayoutManager != null;
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();


                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (mOnLoadMoreListener != null) {
                        mOnLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                handler.postDelayed(this, 120000); //now is every 2 minutes
                Log.i("Timer","Timer");
            }
        }, 120000);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_placesresults_cardview, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        initLayoutOne((ViewHolderOne) holder, position);


    }

    @SuppressLint("SetTextI18n")
    private void initLayoutOne(ViewHolderOne holder, final int position) {

             currentItem = predictionsBeanList.get(position);

            if(predictionsBeanList.get(position).getStructured_formatting().getMain_text() != null){
                Log.w(TAG,"MainPlaces-->"+predictionsBeanList.get(position).getStructured_formatting().getMain_text());
                holder.txt_mainplaces.setText(predictionsBeanList.get(position).getStructured_formatting().getMain_text());
            }
            if(predictionsBeanList.get(position).getStructured_formatting().getSecondary_text() != null) {
                holder.txt_secondaryplaces.setText(predictionsBeanList.get(position).getStructured_formatting().getSecondary_text());
                Log.w(TAG,"SecondaryPlaces-->"+predictionsBeanList.get(position).getStructured_formatting().getSecondary_text());

            }


            holder.ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placesNameListener.selectedPlacesName(predictionsBeanList.get(position).getDescription(),predictionsBeanList.get(position).getStructured_formatting().getMain_text());
                }




        });










    }












    @Override
    public int getItemCount() {
        return predictionsBeanList.size();
    }
    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView txt_mainplaces,txt_secondaryplaces;
        public LinearLayout ll_root;



        public ViewHolderOne(View itemView) {
            super(itemView);

            txt_mainplaces = itemView.findViewById(R.id.txt_mainplaces);
            txt_secondaryplaces = itemView.findViewById(R.id.txt_secondaryplaces);
            ll_root = itemView.findViewById(R.id.ll_root);



        }




    }







}
