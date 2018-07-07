package com.tuacy.workmanagerdev.taskchainstream;

import android.support.annotation.NonNull;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * A任务的输出中只有一个key： a_key -> 100
 */
public class StreamCombineWorkerA extends Worker {

	@NonNull
	@Override
	public Result doWork() {
		Data data = new Data.Builder().putInt("a_key", 100).build();
		setOutputData(data);
		return Result.SUCCESS;
	}
}
