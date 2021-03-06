package com.tuacy.workmanagerdev.unique;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tuacy.workmanagerdev.R;
import com.tuacy.workmanagerdev.then.OrderWorkerA;
import com.tuacy.workmanagerdev.then.OrderWorkerB;
import com.tuacy.workmanagerdev.then.OrderWorkerC;

import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class UniqueWorkerActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, UniqueWorkerActivity.class));
	}

	private Button mButtonStart;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unique_worker);
		initView();
		initEvent();
		initData();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		WorkManager.getInstance().cancelAllWork();
	}

	private void initView() {
		mButtonStart = findViewById(R.id.button_start);
	}

	private void initEvent() {
		mButtonStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startWorker();
			}
		});
	}

	private void initData() {

	}

	/**
	 * A,B,C三个任务加入到唯一工作队列中去
	 */
	private void startWorker() {
		// A
		OneTimeWorkRequest requestA = new OneTimeWorkRequest.Builder(OrderWorkerA.class).build();
		// B
		OneTimeWorkRequest requestB = new OneTimeWorkRequest.Builder(OrderWorkerB.class).build();
		// C
		OneTimeWorkRequest requestC = new OneTimeWorkRequest.Builder(OrderWorkerC.class).build();
		// 任务入队，WorkManager调度执行
		WorkManager.getInstance().beginUniqueWork("unique", ExistingWorkPolicy.KEEP, requestA)
				   .then(requestB)
				   .then(requestC)
				   .enqueue();
	}


}
