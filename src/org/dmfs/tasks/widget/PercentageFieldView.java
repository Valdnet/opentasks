/*
 * Copyright (C) 2012 Marten Gajda <marten@dmfs.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.dmfs.tasks.widget;

import org.dmfs.tasks.R;
import org.dmfs.tasks.model.ContentSet;
import org.dmfs.tasks.model.FieldDescriptor;
import org.dmfs.tasks.model.adapters.IntegerFieldAdapter;
import org.dmfs.tasks.model.layout.LayoutOptions;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Widget to display Integer values.
 * 
 * @author Arjun Naik <arjun@arjunnaik.in>
 * 
 */

public class PercentageFieldView extends AbstractFieldView
{

	private static final String TAG = "PercentageFieldView";
	private IntegerFieldAdapter mAdapter;
	private TextView mText;
	private ProgressBar mProgress;


	public PercentageFieldView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);

	}


	public PercentageFieldView(Context context, AttributeSet attrs)
	{
		super(context, attrs);

	}


	public PercentageFieldView(Context context)
	{
		super(context);

	}


	@Override
	protected void onFinishInflate()
	{
		super.onFinishInflate();
		mText = (TextView) findViewById(R.id.text);
		mProgress = (ProgressBar) findViewById(R.id.percentage_progress_bar);
	}


	@Override
	public void setFieldDescription(FieldDescriptor descriptor, LayoutOptions layoutOptions)
	{
		super.setFieldDescription(descriptor, layoutOptions);
		mAdapter = (IntegerFieldAdapter) descriptor.getFieldAdapter();
	}


	@Override
	public void onContentChanged(ContentSet contentSet, String key)
	{
		Log.d(TAG, "mValues : " + mValues);
		Log.d(TAG, "Adapter Value : " + mAdapter.get(mValues));
		Log.d(TAG, "mText:" + mText);

		if (mValues != null && mAdapter.get(mValues) != null)
		{
			int percentage = mAdapter.get(mValues);
			Log.d(TAG, "Percentage : " + percentage);
			mProgress.setProgress(percentage);
			mText.setText(Integer.toString(percentage) + "%");
		}
		else
		{
			setVisibility(View.GONE);
		}
	}

}
