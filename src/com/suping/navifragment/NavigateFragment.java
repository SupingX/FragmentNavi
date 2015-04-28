package com.suping.navifragment;

import java.util.Random;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class NavigateFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.navi, container,false);
		EditText ed = (EditText) view.findViewById(R.id.tv_navi);
		ed.setText(String.valueOf(new Random().nextLong()));
		return view;
	}
}
