package com.weixingwang.threepomelo.frament;

import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.weixingwang.threepomelo.R;


/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class EveryDayDataFragment extends BaseFragment {


    private WebView web;
    private ProgressBar progress;
    private View view;

    @Override
    protected int getLayoutId() {
        return R.layout.every_day_frament_layout;
    }

    @Override
    protected void initView(View view) {
        this.view = view;
        web = (WebView) view.findViewById(R.id.every_day_fragment_web);
        progress = (ProgressBar) view.findViewById(R.id.every_day_fragment_progressBar);
        setTitle("每日数据");
    }

    @Override
    protected void initData() {
        progress.setMax(100);
        web.loadUrl("http://www.baidu.com");
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setLoadsImagesAutomatically(true);
        web.setWebViewClient(new WebViewClient());
        web.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progress.setProgress(newProgress);
                if(newProgress==100){
                    progress.setVisibility(View.GONE);
                }else {
                    progress.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    @Override
    protected void initLisener() {
        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoBack()){
                    web.goBack();
                }
            }
        });
        view.findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoForward()){
                    web.goForward();
                }
            }
        });
        view.findViewById(R.id.fresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               web.reload();
            }
        });

    }
}
