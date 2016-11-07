package com.example.abhi.mcassignment4;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * create an instance of this fragment.
 */
public class PagerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ITEM_TITLE = "param1";
    private static final String ARG_ITEM_DESC = "param2";

    // TODO: Rename and change types of parameters
    private String itemTitle;
    private String itemDesc;


    public PagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static PagerFragment newInstance(String itemTitle, String itemDesc) {
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_TITLE, itemTitle);
        args.putString(ARG_ITEM_DESC, itemDesc);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            itemTitle = getArguments().getString(ARG_ITEM_TITLE);
            itemDesc = getArguments().getString(ARG_ITEM_DESC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        TextView itemTitleTextView = (TextView) view.findViewById(R.id.PagerItemTitleTextView);
        TextView itemDescTextView = (TextView) view.findViewById(R.id.PagerItemDescTextView);
        itemTitleTextView.setText(itemTitle);
        itemDescTextView.setText(itemDesc);
        return view;
    }

}
