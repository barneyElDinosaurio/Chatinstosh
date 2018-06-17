package xx.xxx.xxxx.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Date;

import xx.xxx.xxxx.R;

/**
 * Created by x on 16/10/17.
 */

public class Calendar extends Activity {

    CalendarView calendar;
    int diaTocado,mesTocado,dia,mes;
    boolean primerPaso,segundoPaso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calendar);

        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#01dfd7")));

        startActivity(new Intent(getApplicationContext(),ConversationActivity.class));


        calendar = (CalendarView) findViewById(R.id.calendar1);
        calendar.setBackgroundColor(Color.parseColor("#f5fdfd"));
        calendar.setWeekDayTextAppearance(R.style.TextAp);
        calendar.setDateTextAppearance(R.style.TextAp);
        calendar.setWeekNumberColor(Color.parseColor("#f5fdfd"));
        calendar.setWeekSeparatorLineColor(Color.parseColor("#f5fdfd"));
        calendar.setSelectedWeekBackgroundColor(Color.parseColor("#f5fdfd"));
        calendar.setFirstDayOfWeek(2);

        primerPaso = false;
        segundoPaso = false;

        dia=new Date().getDay();
        mes=new Date().getMonth();



        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {


                 diaTocado = dayOfMonth;
                 mesTocado = month;

                if(mesTocado > 12) mesTocado = mesTocado - 12;//reseteo cada año //durante dos años
                if(diaTocado == 15 && mesTocado == mes+1){
                    primerPaso = true;
                   // Toast.makeText(Calendar.this, "primer paso", Toast.LENGTH_SHORT).show();

                }else {
                    primerPaso = false;
                    segundoPaso = false;
                }



                if (primerPaso = true && diaTocado == calendar.getFirstDayOfWeek()) {


                   startActivity(new Intent(getApplicationContext(),ConversationActivity.class));

                }else {
                    primerPaso = false;
                    segundoPaso = false;
                }




            }



        });

    }
}
