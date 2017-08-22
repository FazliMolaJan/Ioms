package com.hy.ioms.view.video;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hy.ioms.R;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoActivity extends AppCompatActivity {

    private static final String TAG = "VideoActivity";

    String mVideoPath = "rtsp://117.48.202.207:554/EmdRealTimeVideo-HY_OLMS_YS_000023-Emd.Service.VideoSender.E0-2.sdp";
    IjkMediaPlayer mediaPlayer;
    SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        SurfaceView surfaceRenderView = (SurfaceView) findViewById(R.id.video_view);
        surfaceHolder = surfaceRenderView.getHolder();
        surfaceRenderView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                initMediaPlayer();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        findViewById(R.id.floatingActionButton).setOnClickListener(view -> mediaPlayer.prepareAsync());
    }

    private void initMediaPlayer() {
        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mediaPlayer = new IjkMediaPlayer();

//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "start-on-prepared", 0);
//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "http-detect-range-support", 0);
//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "rtsp_transport", "tcp ");
//
//        mediaPlayer.setOption(1, "analyzemaxduration", 100L);
//        mediaPlayer.setOption(1, "probesize", 10240L);
//        mediaPlayer.setOption(1, "flush_packets", 1L);
//        mediaPlayer.setOption(4, "packet-buffering", 0L);
//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "max_cached_duration", 3000);
//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "infbuf", 1);

//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "analyzeduration", 50000);
//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 0);
//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_frame", 0);

//        mediaPlayer.setOption(4, "framedrop", 1L);



        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "start-on-prepared", 0);
        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "http-detect-range-support", 0);
        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 48);
//        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 8);
        mediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "rtsp_transport", "tcp ");

        Log.i(TAG, "yyh debug .... set ok...");
//YYH add
        mediaPlayer.setOption(1, "analyzemaxduration", 100L);
        mediaPlayer.setOption(1, "probesize", 10240L);
        mediaPlayer.setOption(1, "flush_packets", 1L);
        mediaPlayer.setOption(4, "packet-buffering", 0L);
        mediaPlayer.setOption(4, "framedrop", 1L);

        mediaPlayer.setDisplay(surfaceHolder);

        try {
            //数据源
            mediaPlayer.setDataSource(this, Uri.parse(mVideoPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

//缓冲
        mediaPlayer.setOnBufferingUpdateListener(new IMediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                Log.d(TAG, "onBufferingUpdate" + i);
            }
        });
//常亮
        mediaPlayer.setScreenOnWhilePlaying(true);
//加载完毕
        mediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                mediaPlayer.start();
            }
        });
//失败
        mediaPlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                Log.e(TAG, "onError" + i + "+" + i1);
                return false;
            }
        });
//视频相关信息-重要
        mediaPlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                Log.i(TAG, "onInfo" + i + ":+" + i1);
                return false;
            }
        });

//        开始加载

    }

    @Override
    protected void onStop() {
        super.onStop();
        IjkMediaPlayer.native_profileEnd();
    }


}
