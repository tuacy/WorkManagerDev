package com.tuacy.workmanagerdev.taskchainstream;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * 只是做一个简单的打印
 */
public class StreamThenWorkerC extends Worker{

	@NonNull
	@Override
	public Result doWork() {
		Data inputData = getInputData();
		int b_out = inputData.getInt("b_out", 0);
		//获取到B任务的输出，我们只是做一个简单的输出。
		Log.d("tuacy", "value = " + b_out);
		return Result.SUCCESS;
	}
}
