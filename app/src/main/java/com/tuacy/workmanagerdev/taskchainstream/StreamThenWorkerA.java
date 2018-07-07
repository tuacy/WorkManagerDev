package com.tuacy.workmanagerdev.taskchainstream;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * A任务输出10
 */
public class StreamThenWorkerA extends Worker {

	@NonNull
	@Override
	public Result doWork() {
		Data data = new Data.Builder().putInt("a_out", 10).build();
		setOutputData(data);
		return Result.SUCCESS;
	}
}
