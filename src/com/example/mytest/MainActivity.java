package com.example.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt = (Button)findViewById(R.id.button1);
		bt.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Log.i("qujc", "-------------------");
			try {
				String[] command = { "source","/mnt/sdcard/qujuncai/demo1.sh"};
				Runtime. getRuntime().exec("su");
				//Runtime. getRuntime().exec("source /mnt/sdcard/qujuncai/demo1.sh");
				new CmdProcess().exceut("source /mnt/sdcard/qujuncai/demo1.sh");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.i("qujc", e.getMessage());
			}
			break;

		default:
			break;
		}
		
	}
}
