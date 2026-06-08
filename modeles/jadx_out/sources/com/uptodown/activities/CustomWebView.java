package com.uptodown.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import c4.d;
import c4.k0;
import c4.n0;
import f4.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class CustomWebView extends k0 {
    public static final /* synthetic */ int Q = 0;
    public String O;
    public String P;

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this).inflate(2131558465, (ViewGroup) null);
        inflate.getClass();
        setContentView(inflate);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("title")) {
                this.O = extras.getString("title");
            }
            if (extras.containsKey("url")) {
                this.P = extras.getString("url");
            }
        }
        ((ImageView) findViewById(2131362307)).setOnClickListener(new d(this, 1));
        TextView textView = (TextView) findViewById(2131364372);
        textView.setTypeface(c.f4883x);
        textView.setText(this.O);
        WebView webView = (WebView) findViewById(2131364674);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportZoom(true);
        webView.setScrollBarStyle(33554432);
        webView.setScrollbarFadingEnabled(true);
        webView.setInitialScale(80);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.setWebViewClient(new n0());
        String str = this.P;
        if (str != null) {
            webView.loadUrl(str);
        }
    }
}
