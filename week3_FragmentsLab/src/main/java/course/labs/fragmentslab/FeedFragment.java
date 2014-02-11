package course.labs.fragmentslab;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeedFragment extends Fragment {

    private static final String TAG = "Lab-Fragments";

    private TextView mTextView;
    private static FeedFragmentData feedFragmentData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed, container, false);
        mTextView = (TextView) view.findViewById(R.id.feed_view);
        if (null == feedFragmentData) {
            feedFragmentData = new FeedFragmentData(container.getContext());
        }
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Read in all Twitter feeds
        if (null == feedFragmentData) {
            feedFragmentData = new FeedFragmentData(getActivity());
        }
    }

    // Display Twitter feed for selected feed

    void updateFeedDisplay(int position) {
        Log.i(TAG, "Entered updateFeedDisplay()");
        mTextView.setText(feedFragmentData.getFeed(position));
    }

}
