package com.tuacy.workmanagerdev.combine;

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

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

public class CombineWorkerActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, CombineWorkerActivity.class));
	}

	private Button mButtonStart;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_worker);
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
	 * 组合任务
	 */
	private void startWorker() {
		OneTimeWorkRequest requestA = new OneTimeWorkRequest.Builder(ConbineWorkerA.class).build();
		OneTimeWorkRequest requestB = new OneTimeWorkRequest.Builder(ConbineWorkerB.class).build();
		OneTimeWorkRequest requestC = new OneTimeWorkRequest.Builder(ConbineWorkerC.class).build();
		OneTimeWorkRequest requestD = new OneTimeWorkRequest.Builder(ConbineWorkerD.class).build();
		OneTimeWorkRequest requestE = new OneTimeWorkRequest.Builder(ConbineWorkerE.class).build();
		//A,B任务链
		WorkContinuation continuationAB = WorkManager.getInstance().beginWith(requestA).then(requestB);
		//C,D任务链
		WorkContinuation continuationCD = WorkManager.getInstance().beginWith(requestC).then(requestD);
		//合并上面两个任务链，在接入requestE任务，入队执行
		WorkContinuation.combine(continuationAB, continuationCD).then(requestE).enqueue();
	}


}
