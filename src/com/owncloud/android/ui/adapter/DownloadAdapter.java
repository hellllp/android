package com.owncloud.android.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.owncloud.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.DownloadViewHolder> {

    private List<String> Filename;
    private Context mContext;
    private LayoutInflater inflater;
    private List<Long> progressRate;
    private List<Long> totalTransferredSoFar;
    private List<Long> totalToTransfer;

    public DownloadAdapter(Context context,List<String> data,List<Long>  progressRate,List<Long> totalTransferredSoFar,List<Long>  totalToTransfer)
    {
        this.mContext=context;
        this.Filename=data;
        this.progressRate=progressRate;
        this.totalToTransfer=totalToTransfer;
        this.totalTransferredSoFar=totalTransferredSoFar;
        inflater=LayoutInflater.from(mContext);
    }

    public int getItemCount()
    {
        return Filename.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(DownloadViewHolder holder, final int position) {

        holder.download_name.setText(Filename.get(position));
        //holder.download_progress_bar.setMax(totalToTransfer.get(position).intValue());
        holder.download_progress_bar.setProgress((int)totalTransferredSoFar.get(position).intValue());

    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public DownloadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout. item_down,parent, false);
        DownloadViewHolder holder= new DownloadViewHolder(view);
        return holder;
    }

    class DownloadViewHolder extends RecyclerView.ViewHolder {

        TextView download_name;
        TextView download_file_size;
        ProgressBar download_progress_bar;
        TextView download_account;
        TextView download_remote_path;
        ImageButton download_right_button;


        public DownloadViewHolder(View view) {
            super(view);
            download_name=(TextView) view.findViewById(R.id.download_name);
            download_file_size=(TextView) view.findViewById(R.id.download_file_size);
            download_progress_bar= (ProgressBar) view.findViewById(R.id.download_progress_bar);
            download_account=(TextView) view.findViewById(R.id.download_account);
            download_remote_path=(TextView) view.findViewById(R.id.download_remote_path);
            download_right_button=(ImageButton) view.findViewById(R.id.download_right_button);

        }

    }


}
