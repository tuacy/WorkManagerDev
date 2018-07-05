package com.tuacy.workmanagerdev;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

public class CompressWorker extends Worker {

	@NonNull
	@Override
	public Result doWork() {
		Log.d("tuacy", Thread.currentThread().getName());
		return Result.SUCCESS;
	}
}
