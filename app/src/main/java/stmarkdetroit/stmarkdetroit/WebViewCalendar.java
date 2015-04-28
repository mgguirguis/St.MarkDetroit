package stmarkdetroit.stmarkdetroit;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;


public class WebViewCalendar extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("http:") || url.startsWith("https:"))
        {
            try
            {
                URL urlObj = new URL(url);
                if (urlObj.getHost().endsWith("www.google.com/calendar/embed?src=q72776mes31pqfdbgscks3q1e8%40group.calendar.google.com&ctz=America/New_York")&& urlObj.getPath().startsWith("") )  {
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

