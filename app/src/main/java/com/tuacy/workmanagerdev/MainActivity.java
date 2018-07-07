package com.tuacy.workmanagerdev;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tuacy.workmanagerdev.cancel.CancelWorkerActivity;
import com.tuacy.workmanagerdev.combine.CombineWorkerActivity;
import com.tuacy.workmanagerdev.constraints.ConstraintsWorkerActivity;
import com.tuacy.workmanagerdev.inputoutput.InputOutputWorkerActivity;
import com.tuacy.workmanagerdev.periodic.PeriodicWorkerActivity;
import com.tuacy.workmanagerdev.taskchainstream.TaskCharinStreamActivity;
import com.tuacy.workmanagerdev.then.OrderWorkerActivity;
import com.tuacy.workmanagerdev.unique.UniqueWorkerActivity;

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
		findViewById(R.id.button_intervals).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CancelWorkerActivity.startUp(mContext);
			}
		});
		findViewById(R.id.button_order).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OrderWorkerActivity.startUp(mContext);
			}
		});
		findViewById(R.id.button_combine).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CombineWorkerActivity.startUp(mContext);
			}
		});
		findViewById(R.id.button_task_charin_stream).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TaskCharinStreamActivity.startUp(mContext);
			}
		});
		findViewById(R.id.button_task_unique).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UniqueWorkerActivity.startUp(mContext);
			}
		});
	}

	private void initEvent() {

	}

	private void initData() {

	}
}
