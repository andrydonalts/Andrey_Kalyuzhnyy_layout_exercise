package com.andry.andrey_kalyuzhnyy_layout_exercise;

import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // задаем корневой элемент rootLayout (красный прямоугольник)
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_linearLayout);

        // первый дочерний View - rightLinearLayout - правый зеленый прямоугольник
        LinearLayout rightLinearLayout = new LinearLayout(this);
        rightLinearLayout.setOrientation(LinearLayout.VERTICAL);
        int padding = getResources().getDimensionPixelOffset(R.dimen.padding);
        rightLinearLayout.setPadding(padding, padding, padding, padding);
        LinearLayout.LayoutParams paramsLinRight = new LinearLayout
                .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        rightLinearLayout.setBackgroundColor(Color.parseColor("#669900"));
        int marginInPX = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
        paramsLinRight.setMargins(marginInPX, 0, 0, 0);

        //LinearLayout.LayoutParams paramsLinForRelat =

        // используем цикл для создания 3-х одинаковых вьюшек с чудиком
        for (int i = 0; i < 3; i++) {
            // relativeLayout - дочерний элемент к rightLinearLayout - былый прямоугольник
            RelativeLayout relativeLayout = new RelativeLayout(this);
            // используем LinearLayout.LayoutParams для relativeLayout, так как родительский класс LinearLayout
            LinearLayout.LayoutParams paramsRelative = new LinearLayout
                    .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            relativeLayout.setBackgroundColor(Color.WHITE);
            // в методе setMargin() отступ задается в px. нужное нам значение отступления мы берем из ресурсов
            int marginBottom = getResources().getDimensionPixelOffset(R.dimen.activity_vertical_margin);
            paramsRelative.setMargins(0, 0, 0, marginBottom);
            relativeLayout.setLayoutParams(paramsRelative);


            // вставляем картинку
            ImageView image = new ImageView(this);
            int imageSize = getResources().getDimensionPixelSize(R.dimen.image_size);
            // параметры дочернего элемента задаем в LayoutParams для родительского элемента
            RelativeLayout.LayoutParams paramsImage = new RelativeLayout.LayoutParams(imageSize, imageSize);
            image.setLayoutParams(paramsImage);
            image.setImageResource(R.mipmap.ic_launcher);
            relativeLayout.addView(image, paramsImage);

            // вставляем текст
            TextView textView = new TextView(this);
            textView.setText("Some text");
            RelativeLayout.LayoutParams paramsText = new RelativeLayout
                    .LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            paramsText.addRule(RelativeLayout.CENTER_VERTICAL);
            paramsText.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            // с отступлениями для textView я немного схалявил. в xml я делал отступ от картинки, но в этом случае возникает проблема, чтобы программно
            // задать id для image, так что я сделал отступ на глаз.
            int marginText = getResources().getDimensionPixelOffset(R.dimen.margin_text);
            paramsText.setMargins(0, 0, marginText, 0);
            textView.setLayoutParams(paramsText);
            textView.setLayoutParams(paramsText);


            relativeLayout.addView(textView);
            rightLinearLayout.addView(relativeLayout, paramsRelative);
        }

        rootLayout.addView(rightLinearLayout, paramsLinRight);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
