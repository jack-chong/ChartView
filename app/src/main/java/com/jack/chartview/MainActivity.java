package com.jack.chartview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initDevice();

        setContentView(R.layout.activity_main);

        DeviceChartView chartView = (DeviceChartView) findViewById(R.id.deviceChartView);
        chartView.setParam(DeviceChartView.StateOrder.day, 0, 300, "30");

        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            list.add(String.valueOf(random.nextInt(500)));
        }
        chartView.setData(list);
    }

    private void initDevice() {
        WindowManager wm = ((WindowManager) getSystemService(Context.WINDOW_SERVICE));
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        DeviceInfo.sScreenWidth = outMetrics.widthPixels;
        DeviceInfo.sScreenHeight = outMetrics.heightPixels;
        DeviceInfo.sAutoScaleX = DeviceInfo.sScreenWidth * 1.0f / DeviceInfo.UI_WIDTH;
        DeviceInfo.sAutoScaleY = DeviceInfo.sScreenHeight * 1.0f / DeviceInfo.UI_HEIGHT;
    }

}
