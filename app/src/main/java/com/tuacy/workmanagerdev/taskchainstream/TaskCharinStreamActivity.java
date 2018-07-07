package com.tuacy.workmanagerdev.taskchainstream;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tuacy.workmanagerdev.R;

import java.util.List;

import androidx.work.ArrayCreatingInputMerger;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OverwritingInputMerger;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class TaskCharinStreamActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, TaskCharinStreamActivity.class));
	}

	private Button mButtonThen;
	private Button mButtonCombine;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conbine_worker);
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
		mButtonThen = findViewById(R.id.button_stream_then);
		mButtonCombine = findViewById(R.id.button_stream_combine);
	}

	private void initEvent() {
		mButtonThen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startThenWorker();
			}
		});
		mButtonCombine.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startCombineWorker();
			}
		});
	}

	private void initData() {

	}

	/**
	 * 顺序任务的数据流
	 * A,B,C三个任务。A,输出10，B任务得到A任务的值×10，最后给到C任务。
	 */
	private void startThenWorker() {
		OneTimeWorkRequest requestA = new OneTimeWorkRequest.Builder(StreamThenWorkerA.class).build();
		OneTimeWorkRequest requestB = new OneTimeWorkRequest.Builder(StreamThenWorkerB.class).build();
		Data inputData = new Data.Builder().putInt("abc", 1).build();
		OneTimeWorkRequest requestC = new OneTimeWorkRequest.Builder(StreamThenWorkerC.class).setInputData(inputData).build();
		WorkManager.getInstance().beginWith(requestA).then(requestB).then(requestC).enqueue();
	}

	/**
	 * 在C任务中获取到A,B任务的输出
	 */
	private void startCombineWorker() {
		OneTimeWorkRequest requestA = new OneTimeWorkRequest.Builder(StreamCombineWorkerA.class).build();
		OneTimeWorkRequest requestB = new OneTimeWorkRequest.Builder(StreamCombineWorkerB.class).build();
		// 设置合并规则OverwritingInputMerger
		OneTimeWorkRequest requestC = new OneTimeWorkRequest.Builder(StreamCombineWorkerC.class).setInputMerger(
			OverwritingInputMerger.class).build();
		//A任务链
		WorkContinuation continuationA = WorkManager.getInstance().beginWith(requestA);
		//B任务链
		WorkContinuation continuationB = WorkManager.getInstance().beginWith(requestB);
		//合并上面两个任务链，在接入requestE任务，入队执行
		WorkContinuation continuation = WorkContinuation.combine(continuationA, continuationB).then(requestC);
		continuation.enqueue();
	}

}
