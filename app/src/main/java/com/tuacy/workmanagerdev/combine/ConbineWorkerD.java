package com.tuacy.workmanagerdev.combine;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

public class ConbineWorkerD extends Worker{

	@NonNull
	@Override
	public Result doWork() {
		try {
			//模拟耗时任务
			Thread.sleep(1000);
			Log.d("tuacy", "ConbineWorkerD work");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return Result.SUCCESS;
	}
}
