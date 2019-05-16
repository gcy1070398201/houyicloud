package com.hlsk.mine.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.mine.R;
import com.hlsk.mine.R2;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;

import butterknife.BindView;

/**
 * 首页-专题
 *
 * @author guchenyang
 * @Date 2019/5/16
 * @time 16:36
 */
@Route(path = RouterHub.MINE_MAIN_WEBVIEW_ACTIVITY)
public class PublicWebViewActivity extends BaseActivity {

    @BindView(R2.id.mine_webView_fy)
    FrameLayout mFrameLayout;
    AgentWeb mAgentWeb;
    private WebView webView;
    @BindView(R2.id.mine_web_title)
    TextView mWebTitle;

    @Autowired(name = "url")
    String url;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.mine_webview_layout;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Log.e("url",url);
        initWebView(url);
    }
    private void initWebView(String url){
        if (url!=null&&!url.equals("")){
            mAgentWeb = AgentWeb.with(this)
                    .setAgentWebParent(mFrameLayout, new LinearLayout.LayoutParams(-1, -1))
                    .useDefaultIndicator()
                    .setWebChromeClient(new CropWebChromeClient(mWebTitle))
                    .createAgentWeb()
                    .ready()
                    .go(url);
            webView = mAgentWeb.getWebCreator().getWebView();
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }else{
            Toast.makeText(PublicWebViewActivity.this,"加载路径错误",Toast.LENGTH_LONG).show();
        }


    }
    public class CropWebChromeClient extends WebChromeClient {
        private TextView textView;

        public CropWebChromeClient(TextView textView) {
            this.textView = textView;
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (!TextUtils.isEmpty(title)) {
                textView.setText(title);
            }
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mAgentWeb != null) {
                if (!mAgentWeb.back()) {
                    this.finish();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onPause();
        }
        super.onPause();

    }

    @Override
    protected void onResume() {
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onResume();
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onDestroy();
        }
        super.onDestroy();
    }

}
