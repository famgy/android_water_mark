package com.famgy.android.watermarktest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, null);
		TextView tv11 = (TextView) view.findViewById(R.id.fragment_tag11);
		String tag = this.getArguments().getString("key");
		tv11.setText(tag);

		return view;
	}

}
