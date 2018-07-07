package com.tuacy.workmanagerdev.constraints;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

public class ConstraintsWorker extends Worker {

	@NonNull
	@Override
	public Result doWork() {
		try {
			//模拟耗时任务
			Thread.sleep(1000);
			Log.d("tuacy", "ConstraintsWorker doWork");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return Result.SUCCESS;
	}
}
