package com.suping.navifragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 入栈
 * 		public void addToBackStack(String name);
 * 
 * 出栈：
 * 		public void popBackStack(); //异步
 * 		
 * 		public boolean popBackStackImmediate();//同步（立刻）
 * 
 * 		public void popBackStack(String name , int flags);
 * 
 * 		public boolean popBackStackImmediate(String name , int flags);
 * 
 * 		public void popBackStack(int id , int flags);
 * 		
 * 		public boolean popBackStackImmediate(int id , int flags);
 * 
 * 			flags = 0 时 当前栈不会出栈。
 * 			flags = FragmentManager.POP_BACK+STACK_INCLUSIVE时，当前栈也要出栈
 * 	
 * 栈的个数:
 * 		getBackStackEntryCount()
 * 
 * 添加/删除/替换 fragment
 * 		add() remove() replace()
 * 
 * 分离/附加
 * 		当fragment未加入回退栈，（fragment不活动）
 * 		detach()完可以attach()恢复使用
 * 		remove()完就不可再用
 *		如果当前fragment加入回退栈，2个方法功能一样 
 * 
 * @author Administrator
 *
 */
public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button back = (Button) findViewById(R.id.back);
		Button next = (Button) findViewById(R.id.next);
		nextFragment(true);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//出栈
				getFragmentManager().popBackStack();
			}
		});
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				nextFragment(false);
			}
		});
	}
	
	private void nextFragment(boolean isfirst){
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		NavigateFragment navi = new NavigateFragment();
		transaction.add(R.id.navi,navi);
		//不是第一个时
		if(!isfirst){
			//将该fragment入栈
			transaction.addToBackStack(null);
		}
		transaction.commit();
		
		manager.addOnBackStackChangedListener(new OnBackStackChangedListener() {
			@Override
			public void onBackStackChanged() {
				setTitle("当前第"+(getFragmentManager().getBackStackEntryCount()+1)+"页");
			}
		});
	}
}
