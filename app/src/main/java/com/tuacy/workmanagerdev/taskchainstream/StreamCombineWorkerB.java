package com.tuacy.workmanagerdev.taskchainstream;

import android.support.annotation.NonNull;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * B任务的输出中有两个key：b_key -> 100、a_key -> 200
 * 有个key在A任务中也出现了
 */
public class StreamCombineWorkerB extends Worker {

	@NonNull
	@Override
	public Result doWork() {
		Data data = new Data.Builder().putInt("b_key", 100).putInt("a_key", 200).build();
		setOutputData(data);
		return Result.SUCCESS;
	}
}
