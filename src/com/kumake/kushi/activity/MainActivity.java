package com.kumake.kushi.activity;

import com.kumake.kushi.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity  {
	private FragmentManager fm;
	private FragmentTransaction ft;
	private RadioGroup rdbtgroup;
	
	private fragment1 fam1;
	private fragment2 fam2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		rdbtgroup = (RadioGroup) findViewById(R.id.rdbtgroup);
		
		fam1 = new fragment1();
		fam2 = new fragment2();
		
		
		fm = getSupportFragmentManager();
		
		
		
		rdbtgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				 ft =fm.beginTransaction();
						switch (group.getCheckedRadioButtonId()) {
						case R.id.rdbt_1:
							ft.replace(R.id.mancontent,fam1);
							break;
						case R.id.rdbt_2:
							ft.replace(R.id.mancontent,fam2);
							break;
		
						default:
							break;
						}

						ft.commit();
				
			}// onCheckedChanged
		});
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
