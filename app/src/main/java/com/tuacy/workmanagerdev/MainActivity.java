package com.tuacy.workmanagerdev;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		findViewById(R.id.button_output).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				InputOutputWorkerActivity.startUp(mContext);
			}
		});
		findViewById(R.id.button_intervals).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PeriodicWorkerActivity.startUp(mContext);
			}
		});
		findViewById(R.id.button_constraints).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ConstraintsWorkerActivity.startUp(mContext);
			}
		});
	}

	private void initEvent() {

	}

	private void initData() {

	}
}
