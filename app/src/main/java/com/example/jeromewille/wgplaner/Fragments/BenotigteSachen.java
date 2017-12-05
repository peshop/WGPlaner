package com.example.jeromewille.wgplaner.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeromewille.wgplaner.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BenotigteSachen.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BenotigteSachen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BenotigteSachen extends Fragment {
    private ArrayAdapter<String> stringArrayAdapter;
    private List<String> stringList;
    private ListView listView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BenotigteSachen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BenotigteSachen.
     */
    // TODO: Rename and change types and number of parameters
    public static BenotigteSachen newInstance(String param1, String param2) {
        BenotigteSachen fragment = new BenotigteSachen();
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

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_benotigte_sachen, container, false);


        this.stringList = new ArrayList<>();
        this.stringList.add("Toilettenpapier");
        this.stringList.add("Seife");
        this.stringList.add("Geschirrtücher");
        this.stringList.add("Milch");
        this.stringList.add("Öl");
        this.stringList.add("Salz");
        this.stringList.add("Fit");
        this.stringList.add("Waschpulver");
        this.stringList.add("Mikrowelle");

        this.stringArrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.benotigte_sachen_list_view_item, this.stringList)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                final View view1;

                LayoutInflater inflater1 = LayoutInflater.from(getContext());
                if (convertView == null)
                    convertView = inflater.inflate(R.layout.benotigte_sachen_list_view_item, parent, false);

                view1 = convertView;

                TextView tvname = (TextView) convertView.findViewById(R.id.textView);

                CheckBox cbgekauft = (CheckBox) convertView.findViewById(R.id.checkBox);
                cbgekauft.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b)
                            view1.setBackgroundResource(R.color.colorPrimary);
                        else
                            view1.setBackgroundResource(android.R.color.transparent);
                    }
                });

                tvname.setText(getItem(position));
                if (getItem(position).length() > 4)
                    cbgekauft.setChecked(true);
                else
                    cbgekauft.setChecked(false);

                 return convertView;
            }
        };

        this.listView = (ListView) view.findViewById(R.id.BenotigteSachen);
        this.listView.setAdapter(this.stringArrayAdapter);
        this.listView.setChoiceMode(ListView.CHOICE_MODE_NONE);

        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
