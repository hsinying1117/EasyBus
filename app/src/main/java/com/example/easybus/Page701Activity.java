package com.example.easybus;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Page701Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page701);
        //隱藏title bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //跳選擇頁

        //播放video
        final VideoView videoView = (VideoView)this.findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.one));
        videoView.requestFocus();
        videoView.start();


        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(Page701Activity.this,"影片播完了！",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(Page701Activity.this,Page702Activity.class);
                startActivity(it);
            }
        });

        //影片播放時發生錯誤時觸發的方法
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.i("通知","播放中出現錯誤");
                return false;
            }
        });

    }


}
