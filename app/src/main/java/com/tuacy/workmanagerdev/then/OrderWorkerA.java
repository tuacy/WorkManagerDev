package com.tuacy.workmanagerdev.then;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

public class OrderWorkerA extends Worker{

	@NonNull
	@Override
	public Result doWork() {
		try {
			//模拟耗时任务
			Thread.sleep(1000);
			Log.d("tuacy", "OrderWorkerA work");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return Result.SUCCESS;
	}
}
