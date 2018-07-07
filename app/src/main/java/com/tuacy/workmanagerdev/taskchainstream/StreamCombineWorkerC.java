package com.tuacy.workmanagerdev.taskchainstream;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * 在C任务中获取到A,B任务的输出。
 *
 */
public class StreamCombineWorkerC extends Worker {

	@NonNull
	@Override
	public Result doWork() {
		Data data = getInputData();

		// 注意;这里我用的是getIntArray
		int[] aKeyValueList = data.getIntArray("a_key");
		int[] bKeyValueList = data.getIntArray("b_key");
		Log.d("tuacy", "a_key = " + aKeyValueList[0]);
		Log.d("tuacy", "b_key = " + bKeyValueList[0]);

		return Result.SUCCESS;
	}
}
