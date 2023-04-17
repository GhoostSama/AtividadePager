package com.example.projetopager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Primeiro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Primeiro extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText hF, mF, mI, hI;
    TextView rM, rH;
    Button soma, sub;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Primeiro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment primeiro.
     */
    // TODO: Rename and change types and number of parameters
    public static Primeiro newInstance(String param1, String param2) {
        Primeiro fragment = new Primeiro();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_primeiro, container, false);
        hF = v.findViewById(R.id.hf);
        hI = v.findViewById(R.id.hi);
        mF = v.findViewById(R.id.mf);
        mI = v.findViewById(R.id.mi);
        rH = v.findViewById(R.id.rh);
        rM = v.findViewById(R.id.rm);
        soma = v.findViewById(R.id.btnSoma);
        sub = v.findViewById(R.id.btnSub);

        soma.setOnClickListener(click -> {soma();});
        sub.setOnClickListener(click -> {subtracao();});

        return v;
    }

    public void soma(){
        try {
            int rm = 0;
            int rh = 0;
            int mi = Integer.parseInt(mI.getText().toString());
            int mf = Integer.parseInt(mF.getText().toString());
            int hi = Integer.parseInt(hI.getText().toString());
            int hf = Integer.parseInt(hF.getText().toString());
            rm = mi + mf;
            rh = hi + hf;

            while (rm > 59) {
                rm -= 60;
                rh++;
            }

            String mrm = String.valueOf(rm);
            String mrh = String.valueOf(rh);
            rM.setText(mrm);
            rH.setText(mrh);
        }catch(Exception e){
            Toast.makeText(getContext(),"Campo vazio",Toast.LENGTH_SHORT).show();
        }
    }

    public void subtracao(){
        try{
            int rh = 0;
            int rm = 0;
            int mi = Integer.parseInt(mI.getText().toString());
            int mf = Integer.parseInt(mF.getText().toString());
            int hi = Integer.parseInt(hI.getText().toString());
            int hf = Integer.parseInt(hF.getText().toString());

            int minIn = (hi*60)+mi;
            int minFn = (hf*60)+mf;
            rm = Math.abs(minIn - minFn);

            while (rm > 59) {
                rm -= 60;
                rh++;
            }

            String mrm = String.valueOf(rm);
            String mrh = String.valueOf(rh);
            rM.setText(mrm);
            rH.setText(mrh);
        }
        catch(Exception e){
            Toast.makeText(getContext(),"Campo vazio",Toast.LENGTH_SHORT).show();
        }
    }

}