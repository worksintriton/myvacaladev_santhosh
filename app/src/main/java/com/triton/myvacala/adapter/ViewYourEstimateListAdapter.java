package com.triton.myvacala.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.triton.myvacala.R;
import com.triton.myvacala.activities.EditMapsActivity;
import com.triton.myvacala.listeners.OnLoadMoreListener;
import com.triton.myvacala.responsepojo.BookingHistoryResponse;
import com.triton.myvacala.responsepojo.NotificationListResponse;

import java.util.List;


public class ViewYourEstimateListAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ONE = 1;
    private static final int TYPE_LOADING = 5;
    private  String TAG = "ViewYourEstimateListAdapter";
    private List<BookingHistoryResponse.DataBean.CustomerInvoiceBean> customerInvoiceBeanList  = null;
   //    private List<BookingHistoryResponse.DataBean.JobCardBean> jobCardBeanList = null;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading;
    private int visibleThreshold = 3;
    private int lastVisibleItem, totalItemCount;
    BookingHistoryResponse.DataBean.CustomerInvoiceBean currentItem;
   // BookingHistoryResponse.DataBean.JobCardBean currentJobCardItem;
    String strMSgdaystime;
    String strMsg;
    String type;
    Dialog dialog;

    public static String id = "";
    Context context;
    String booking_id;


    public ViewYourEstimateListAdapter(Context context, List<BookingHistoryResponse.DataBean.CustomerInvoiceBean> customerInvoiceBeanList, RecyclerView inbox_list, String booking_id) {
        this.context =context;
        this.customerInvoiceBeanList = customerInvoiceBeanList;
        this.booking_id=booking_id;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_view_your_estimate, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.w(TAG,"onBindViewHolder--->");
        initLayoutOne((ViewHolderOne) holder, position);


    }

    @SuppressLint("SetTextI18n")
    private void initLayoutOne(ViewHolderOne holder, final int position) {


        currentItem = customerInvoiceBeanList.get(position);

        holder.txt_bookid.setText(booking_id);

        holder.iv_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    try
                    {
                        String pdfUrl = customerInvoiceBeanList.get(position).getDoc_link();
                        Log.w("pdf_url",pdfUrl);
                        // String pdfUrl = "http://www.durgasoft.com/Android%20Interview%20Questions.pdf";
                        Intent intentUrl = new Intent(Intent.ACTION_VIEW);
                        intentUrl.setDataAndType(Uri.parse(pdfUrl), "application/pdf");
                        intentUrl.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intentUrl);
                    }
                    catch (ActivityNotFoundException e)
                    {
                        Toast.makeText(context, "No PDF Viewer Installed", Toast.LENGTH_LONG).show();
                    }



            }
        });




    }









    @Override
    public int getItemCount() {
        return customerInvoiceBeanList.size();
    }
    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView txt_bookid;
        public ImageView iv_download;


        public ViewHolderOne(View itemView) {
            super(itemView);
             txt_bookid = itemView.findViewById(R.id.tv_bookingid);
            iv_download = itemView.findViewById(R.id.img_download);


        }




    }












}
