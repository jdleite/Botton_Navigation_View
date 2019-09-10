package com.teste.bottonnavigationview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Mensagem{



    public static void toast(Context context,String mensagem){
        Toast.makeText(context,mensagem,Toast.LENGTH_SHORT).show();
    }

}
