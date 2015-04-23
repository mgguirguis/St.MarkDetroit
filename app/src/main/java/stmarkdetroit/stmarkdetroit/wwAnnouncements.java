package stmarkdetroit.stmarkdetroit;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;


public class wwAnnouncements extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("http:") || url.startsWith("https:"))
        {
            try
            {
                URL urlObj = new URL(url);
                if (urlObj.getHost().endsWith("http://wpc.511C.edgecastcdn.net/00511C/common-player-files/jw_player-5.6-licensed/player.swf"))  {
                    view.loadUrl(url);
                }
                else
                {
                    view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }

                return true;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}

