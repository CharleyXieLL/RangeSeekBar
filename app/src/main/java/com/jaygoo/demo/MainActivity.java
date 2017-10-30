package com.jaygoo.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jaygoo.widget.RangeSeekBar;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private RangeSeekBar seekbar1;
    private RangeSeekBar seekbar2;
    private RangeSeekBar seekbar3;
    private TextView tv2;
    private TextView tvProgress;
    private DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar1 = (RangeSeekBar)findViewById(R.id.seekbar1);
        seekbar2 = (RangeSeekBar)findViewById(R.id.seekbar2);
        seekbar3 = (RangeSeekBar)findViewById(R.id.seekbar3);
        tvProgress = (TextView)findViewById(R.id.tvProgress);
        tv2 = (TextView)findViewById(R.id.progress2_tv);

        seekbar1.setValue(10);
        seekbar2.setValue(4,7);
        seekbar3.setValue(350,950);
        seekbar1.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                seekbar1.setProgressDescription((int)min+"%");
            }
        });

        seekbar2.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                if (isFromUser) {
                    tv2.setText(min + "-" + max);
                    seekbar2.setLeftProgressDescription(df.format(min));
                    seekbar2.setRightProgressDescription(df.format(max));
                }
            }
        });

        seekbar3.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override public void onRangeChanged(RangeSeekBar view, float min, float max,
                boolean isFromUser) {
                tvProgress.setText((int) min+"～"+(int) max);
            }
        });

    }

}
