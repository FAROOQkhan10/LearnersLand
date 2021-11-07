package com.farooqkhan.learnersland.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.farooqkhan.learnersland.R;
import com.farooqkhan.learnersland.databinding.FragmentFtab3Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ftab3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ftab3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ftab3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ftab3.
     */
    // TODO: Rename and change types and number of parameters
    public static ftab3 newInstance(String param1, String param2) {
        ftab3 fragment = new ftab3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    FragmentFtab3Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFtab3Binding.inflate(inflater,container,false);

          // Arrays Link
          binding.arrayHyperText1.setMovementMethod(LinkMovementMethod.getInstance());
          binding.arrayHyperText2.setMovementMethod(LinkMovementMethod.getInstance());
          binding.arrayHyperText3.setMovementMethod(LinkMovementMethod.getInstance());
          binding.arrayHyperText4.setMovementMethod(LinkMovementMethod.getInstance());

        // Stack Link
        binding.stackHyperText1.setMovementMethod(LinkMovementMethod.getInstance());
        binding.stackHyperText2.setMovementMethod(LinkMovementMethod.getInstance());
        binding.stackHyperText3.setMovementMethod(LinkMovementMethod.getInstance());
        binding.stackHyperText4.setMovementMethod(LinkMovementMethod.getInstance());
        binding.stackHyperText5.setMovementMethod(LinkMovementMethod.getInstance());

        // Queue Link
        binding.queueHyperText1.setMovementMethod(LinkMovementMethod.getInstance());
        binding.queueHyperText2.setMovementMethod(LinkMovementMethod.getInstance());
        binding.queueHyperText3.setMovementMethod(LinkMovementMethod.getInstance());
        binding.queueHyperText4.setMovementMethod(LinkMovementMethod.getInstance());
        binding.queueHyperText5.setMovementMethod(LinkMovementMethod.getInstance());

        // Linked list Link
        binding.linkedlistHyperText1.setMovementMethod(LinkMovementMethod.getInstance());
        binding.linkedlistHyperText2.setMovementMethod(LinkMovementMethod.getInstance());
        binding.linkedlistHyperText3.setMovementMethod(LinkMovementMethod.getInstance());
        binding.linkedlistHyperText4.setMovementMethod(LinkMovementMethod.getInstance());
        binding.linkedlistHyperText5.setMovementMethod(LinkMovementMethod.getInstance());

        // Dynamic Programming Link
        binding.dpHyperText1.setMovementMethod(LinkMovementMethod.getInstance());
        binding.dpHyperText2.setMovementMethod(LinkMovementMethod.getInstance());
        binding.dpHyperText3.setMovementMethod(LinkMovementMethod.getInstance());
        binding.dpHyperText4.setMovementMethod(LinkMovementMethod.getInstance());


        // Recursion and Backtracking Link
        binding.recursionHyperText1.setMovementMethod(LinkMovementMethod.getInstance());
        binding.recursionHyperText2.setMovementMethod(LinkMovementMethod.getInstance());
        binding.recursionHyperText3.setMovementMethod(LinkMovementMethod.getInstance());

        // Tree Link
        binding.treeHyperText1.setMovementMethod(LinkMovementMethod.getInstance());
        binding.treeHyperText2.setMovementMethod(LinkMovementMethod.getInstance());
        binding.treeHyperText3.setMovementMethod(LinkMovementMethod.getInstance());
        binding.treeHyperText4.setMovementMethod(LinkMovementMethod.getInstance());
        binding.treeHyperText5.setMovementMethod(LinkMovementMethod.getInstance());
        binding.treeHyperText6.setMovementMethod(LinkMovementMethod.getInstance());


        // Graph Link
        binding.graphHyperText1.setMovementMethod(LinkMovementMethod.getInstance());
        binding.graphHyperText2.setMovementMethod(LinkMovementMethod.getInstance());
        binding.graphHyperText3.setMovementMethod(LinkMovementMethod.getInstance());
        binding.graphHyperText4.setMovementMethod(LinkMovementMethod.getInstance());





        return binding.getRoot();
    }
}