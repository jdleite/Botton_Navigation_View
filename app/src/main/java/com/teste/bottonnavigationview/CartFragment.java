package com.teste.bottonnavigationview;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;



public class CartFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {


    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private Context context;
    private Button btnData;
    private TextView txtData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        btnData = view.findViewById(R.id.id_data);
        txtData = view.findViewById(R.id.id_txt_data);


        listener();
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.id_data) {
            inserirData();
            Mensagem.toast(context,getString(R.string.data_inserida));
        }

    }

    private void inserirData() {
        Calendar calendar = Calendar.getInstance();

        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH);
        int ano = calendar.get(Calendar.YEAR);

        new DatePickerDialog(context, this, ano, mes, dia).show();
    }

    public void listener() {
        btnData.setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);

        String date = SDF.format(calendar.getTime());
        txtData.setText(date);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
