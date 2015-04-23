package stmarkdetroit.stmarkdetroit;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;



public class VideoPage extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        VideoView stream1 = (VideoView)findViewById(R.id.stream1);

        MediaController mc = new MediaController(this);
        final String LINK1 = "http://wpc.511C.edgecastcdn.net/00511C/common-player-files/jw_player-5.6-licensed/player.swf";
        stream1.setVideoURI(Uri.parse(LINK1));
        stream1.start();
        mc.setMediaPlayer(stream1);
        stream1.getBufferPercentage();
        stream1.canSeekBackward();
        stream1.canSeekBackward();
        stream1.setMediaController(mc);
        mc.setAnchorView(stream1);



    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
