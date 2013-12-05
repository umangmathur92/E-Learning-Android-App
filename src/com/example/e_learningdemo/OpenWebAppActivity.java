package com.example.e_learningdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class OpenWebAppActivity extends Activity {
   
	
	WebView web;
	ProgressBar progressBar;
	
    @SuppressLint("SetJavaScriptEnabled")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.openwebapp);
        web = (WebView) findViewById(R.id.webview01);
        
        //overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
        
        Intent i=getIntent();
        String urlx=i.getStringExtra("myurl");
       
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        
        web.getSettings().setBuiltInZoomControls(true);
        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.clearFormData();
        web.clearHistory();
                
        web.getSettings().setDatabaseEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        
        web.setWebChromeClient(new WebChromeClient());
        
        System.out.println("The url is : "+urlx);

        web.loadUrl(urlx);
        
        web.setDownloadListener(new DownloadListener() 
        {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,long contentLength) 
            {            	
                System.out.println("hello people");
                Uri uri = Uri.parse(url);
                System.out.println("The uri is : "+uri);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }
    
    public class myWebClient extends WebViewClient
    {
    	@Override
    	public void onPageStarted(WebView view, String url, Bitmap favicon) 
    	{
    		// TODO Auto-generated method stub
    		super.onPageStarted(view, url, favicon);
    		progressBar.setVisibility(View.VISIBLE);
    	}
    	
    	@Override
    	public boolean shouldOverrideUrlLoading(WebView view, String url) 
    	{
    		// TODO Auto-generated method stub
    			view.loadUrl(url);
        		return true;
    	}
    	
    	@Override
    	public void onPageFinished(WebView view, String url) 
    	{
    		// TODO Auto-generated method stub
    		super.onPageFinished(view, url);
    		
    		progressBar.setVisibility(View.GONE);
    	}
    }
    
    
    // To handle "Back" key press event go back to previous screen.
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) 
		{
			web.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}

