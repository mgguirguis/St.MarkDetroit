package stmarkdetroit.stmarkdetroit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VideoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {
    MediaController mc;
    VideoView stream1;
    ProgressDialog progressDialog;
    int position = 0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onViewCreated(View view, Bundle SavedInstanceState)
    {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);

        stream1 = (VideoView)getActivity().findViewById(R.id.stream1);
        mc = new MediaController(getActivity());
        final String LINK1 = "https://redirector.googlevideo.com/videoplayback?requiressl=yes&shardbypass=yes&cmbypass=yes&id=ff2dae37cc712aad&itag=18&source=picasa&cmo=secure_transport%3Dyes&ip=0.0.0.0&ipbits=0&expire=1432917884&sparams=requiressl,shardbypass,cmbypass,id,itag,source,ip,ipbits,expire&signature=9BA8E8DFEF5A56A42CC517B4F25BC1BFA76CCADE.D39E1996A21B22645FD29620F885E1F604615D37&key=lh1";
        stream1.setVideoURI(Uri.parse(LINK1));
        stream1.start();
        mc.setMediaPlayer(stream1);
        stream1.getBufferPercentage();
        stream1.canSeekBackward();
        stream1.canSeekBackward();
        stream1.setMediaController(mc);
        mc.setAnchorView(stream1);
        stream1.getBufferPercentage();
        stream1.requestFocus();
        while (stream1.isPlaying()==true)
        {
            progressDialog.dismiss();
            progressDialog.hide();
        }
        if (stream1.isPlaying() && progressDialog.isShowing())
        {
            progressDialog.hide();
        }


         stream1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
             public void onPrepared(MediaPlayer mediaPlayer) {
                 progressDialog.dismiss();
                 stream1.seekTo(position);
                 if (position == 0) {
                     stream1.start();
                 } else {
                     stream1.pause();
                 }
             }
         });





    }

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Video.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
        //Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);

    }

    // TODO: Rename method, update argument and hook method into UI event
    // public void onButtonPressed(Uri uri) {
    //if (mListener != null) {
    //     mListener.onFragmentInteraction(uri);
    //   }
    // }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}