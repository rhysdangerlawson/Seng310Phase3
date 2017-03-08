package com.rhys.logol.seng310phase3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraphPage extends AppCompatActivity implements View.OnClickListener {

    PieChart pieChart;
    Button backButton;
    Button plusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_page);

        getSupportActionBar().hide();

        pieChart = (PieChart) findViewById(R.id.graph);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(55f, "School"));
        entries.add(new PieEntry(20f, "Work"));
        entries.add(new PieEntry(10f, "Soccer Practice"));
        entries.add(new PieEntry(15f, "Leisure"));

        PieDataSet set = new PieDataSet(entries, null);
        set.setColors(ColorTemplate.VORDIPLOM_COLORS);

        pieChart.setDescription(null);

        PieData data = new PieData(set);

        pieChart.setDrawSliceText(false);
        set.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(15);

        //pieChart.setDrawSliceText(true);
        //pieChart.setUsePercentValues(true);
        set.setSliceSpace(5);

        pieChart.animateX(1000);

        pieChart.setData(data);
        pieChart.invalidate(); // refresh

        backButton = (Button) findViewById(R.id.back_button);
        plusButton = (Button) findViewById(R.id.plus_button);

        backButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.back_button){
            finish();
        }if(i == R.id.plus_button){
            startActivity(new Intent(this,Settings.class));
        }
    }
}