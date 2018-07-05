package com.tuacy.workmanagerdev;

import android.support.annotation.NonNull;

import java.util.Set;
import java.util.UUID;

import androidx.work.impl.model.WorkSpec;

public class TestAbac {

	/**
	 * 构造函数
	 * @param id
	 * @param workSpec
	 * @param tags
	 */
	protected WorkRequest(@NonNull UUID id, @NonNull WorkSpec workSpec, @NonNull Set<String> tags);

}
