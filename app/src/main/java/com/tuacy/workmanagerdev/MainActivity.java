package com.tuacy.workmanagerdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

	private Button mButtonStartWork;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mButtonStartWork = findViewById(R.id.button_one);
	}

	private void initEvent() {
		mButtonStartWork.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OneTimeWorkRequest compressionWork = new OneTimeWorkRequest.Builder(CompressWorker.class).build();
				WorkManager.getInstance().enqueue(compressionWork);
			}
		});
	}

	private void initData() {

	}
}
