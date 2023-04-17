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

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Segundo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Segundo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText numero;
    TextView resu;
    Button facil, medio, dificil, gerar, clique;
    int numero_secreto;
    int total_tentativas = 0;

    public Segundo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment segundo.
     */
    // TODO: Rename and change types and number of parameters
    public static Segundo newInstance(String param1, String param2) {
        Segundo fragment = new Segundo();
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
        View v = inflater.inflate(R.layout.fragment_segundo, container, false);
        numero = v.findViewById(R.id.btnNum);
        resu = v.findViewById(R.id.resultado);
        facil = v.findViewById(R.id.btnFacil);
        medio = v.findViewById(R.id.btnMedio);
        dificil = v.findViewById(R.id.btnDificil);
        gerar = v.findViewById(R.id.btnGerar);
        clique = v.findViewById(R.id.btnClique);

        facil.setOnClickListener(click -> {facil();});
        medio.setOnClickListener(click -> {medio();});
        dificil.setOnClickListener(click -> {dificil();});

        gerar.setOnClickListener(click -> {gerar();});
        clique.setOnClickListener(click -> {clicado();});


        return v;
    }

    public void facil(){
        total_tentativas = 20;
        resu.setText("Você tem: "+total_tentativas);
    }

    public void medio(){
        total_tentativas = 10;
        resu.setText("Você tem: "+total_tentativas);
    }

    public void dificil(){
        total_tentativas = 5;
        resu.setText("Você tem: "+total_tentativas);
    }

    public void gerar(){
        Random gerador = new Random();
        numero_secreto = gerador.nextInt(100)+1;
        if(total_tentativas == 0){
            total_tentativas = 0;
        }
        else{total_tentativas = total_tentativas;}
    }

    public void clicado(){
        try {

            int i = 1;
            if (i <= total_tentativas) {
                int chute = Integer.parseInt(numero.getText().toString());

                if (chute < 1) {
                    Toast.makeText(getContext(), "Chute algo acima de 100", Toast.LENGTH_SHORT).show();
                } else if (chute > 100) {
                    Toast.makeText(getContext(), "Chute algo abaixo de 100", Toast.LENGTH_SHORT).show();
                }

                if (chute == numero_secreto) {
                    Toast.makeText(getContext(), "Parabéns, você acertou o número", Toast.LENGTH_SHORT).show();
                    resu.setText("Você terminou o jogo com: " + total_tentativas+" tentativas!");
                    total_tentativas = 0;
                } else if (chute < numero_secreto) {
                    Toast.makeText(getContext(), "O número secreto é maior", Toast.LENGTH_SHORT).show();
                    total_tentativas -= 1;
                    resu.setText("Você tem: " + total_tentativas);
                } else if (chute > numero_secreto) {
                    Toast.makeText(getContext(), "O número secreto é menor", Toast.LENGTH_SHORT).show();
                    total_tentativas -= 1;
                    resu.setText("Você tem: " + total_tentativas);
                }

            } else {
                Toast.makeText(getContext(), "Acabou suas tentativas", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(getContext(), "Insira um valor válido", Toast.LENGTH_SHORT).show();}
    }

}