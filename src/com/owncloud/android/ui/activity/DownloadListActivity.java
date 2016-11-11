package com.owncloud.android.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.owncloud.android.R;
import com.owncloud.android.db.OCUpload;
import com.owncloud.android.files.services.FileDownloader;
import com.owncloud.android.ui.adapter.DownloadAdapter;
import com.owncloud.android.ui.fragment.UploadListFragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DownloadListActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private List<ProgressBar> mProgressBar;
    private List<String> mFilename;
    private List<Long> mprogressRate;
    private List<Long> mtotalTransferredSoFar;
    private List<Long> mtotalToTransfer;
    private DownloadAdapter mDownloadAdapter;
    //private TextView TextView1=null;
    //private MyReceiver receiver=null;
    //private ProgressBar pb=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_list);


       // TextView1=(TextView) findViewById(R.id.TextView1);
       // pb=(ProgressBar)findViewById(R.id.pb_progressbar);


        mRecyclerView=(RecyclerView) findViewById(R.id.id_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        initData();
        mDownloadAdapter=new DownloadAdapter(this,mFilename,mprogressRate,mtotalTransferredSoFar,mtotalToTransfer);
        //设置Adapter
        mRecyclerView.setAdapter(mDownloadAdapter);
        /*
        startService(new Intent(this, FileDownloader.class));
        //注册广播接收器
        receiver=new MyReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.owncloud.android.files.services");
        this.registerReceiver(receiver,filter);*/

    }

    @Override
    protected void onDestroy() {
        //结束服务
        super.onDestroy();
    }

    /*public class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context,Intent intent)
        {
            Bundle mbundle=intent.getExtras();
            long progressRate=mbundle.getLong("progressRate");
            long totalTransferredSoFar=mbundle.getLong("totalTransferredSoFar");
            long totalToTransfer=mbundle.getLong("totalToTransfer");
            String fileName=mbundle.getString("fileName");
            TextView1.setText("filename="+fileName);
            pb.setMax((int)totalToTransfer);
            pb.setProgress((int)totalTransferredSoFar);
        }
    }*/

    private void initData() {
        mFilename = new ArrayList<String>();
        for ( int i=0; i < 40; i++) {
            mFilename.add( "item"+i);
        }

        mprogressRate=new ArrayList<Long>();
        for(int i=0;i<40;i++){
            Long it=new Long(10);
            mprogressRate.add(it);
        }
        mtotalTransferredSoFar=new ArrayList<Long>();
        for(int i=0;i<40;i++){
            Long it=new Long(10);
            mtotalTransferredSoFar.add(it);
        }

        mtotalToTransfer=new ArrayList<Long>();
        for(int i=0;i<40;i++){
            Long it=new Long(10);
            mtotalToTransfer.add(it);
        }
    }

}

