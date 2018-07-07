package com.tuacy.workmanagerdev.inputoutput;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tuacy.workmanagerdev.R;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.State;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class InputOutputWorkerActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, InputOutputWorkerActivity.class));
	}

	private Button   mButtonStart;
	private TextView mTextOut;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_worker);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mButtonStart = findViewById(R.id.button_input);
		mTextOut = findViewById(R.id.text_out);
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

	private void startWorker() {
		// 定义一个OneTimeWorkRequest，并且关联InputOutputWorker。设置输入参数
		Data inputData = new Data.Builder().putString("key_name", "江西高安").build();
		OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(InputOutputWorker.class).setInputData(inputData).build();
		// 任务入队，WorkManager调度执行
		WorkManager.getInstance().enqueue(request);
		// 获取到LiveData然后监听数据变化
		WorkManager.getInstance().getStatusById(request.getId()).observe(this, new Observer<WorkStatus>() {
			@Override
			public void onChanged(@Nullable WorkStatus workStatus) {
				if (workStatus == null) {
					return;
				}
				if (workStatus.getState() == State.ENQUEUED) {
					mTextOut.setText("任务入队");
				}
				if (workStatus.getState() == State.RUNNING) {
					mTextOut.setText("任务正在执行");
				}
				if (workStatus.getState().isFinished()) {
					Data data = workStatus.getOutputData();
					mTextOut.setText("任务完成" + "-结果：" + data.getString("key_name", "null"));
				}
			}
		});
	}
}
