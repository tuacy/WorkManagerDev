package com.tuacy.workmanagerdev.taskchainstream;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * 得到A任务的输出在乘以10，做为输出
 */
public class StreamThenWorkerB extends Worker {

	@NonNull
	@Override
	public Result doWork() {
		//先得到A任务的输出值
		Data inputData = getInputData();
		int a_out = inputData.getInt("a_out", 0);
		//把A任务的输出×10在给到C任务
		Data data = new Data.Builder().putInt("b_out", a_out * 10).build();
		setOutputData(data);
		return Result.SUCCESS;
	}
}
