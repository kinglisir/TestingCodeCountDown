package com.example.testingcodecountdown;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	private Button btn_register_code;
	private EditText et_register_password;
	private CaptchaTimeCount captchaTimeCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		captchaTimeCount = new CaptchaTimeCount(Constants.Times.MILLIS_IN_TOTAL, Constants.Times.COUNT_DOWN_INTERVAL,btn_register_code,this);
	}

	private void initView() {
		btn_register_code = (Button) findViewById(R.id.btn_register_code);
		btn_register_code.setOnClickListener(this);
		et_register_password = (EditText) findViewById(R.id.et_register_password);
		et_register_password.setEnabled(false);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_register_code://项目中这里要请求网络 获取验证码
			captchaTimeCount.start();
			et_register_password.setEnabled(true);
			break;

		default:
			break;
		}
		
	}

	
}
