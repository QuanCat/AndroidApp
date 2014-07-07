package android.my_first_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{
	
	TextView question, test;
	Button returnData;
	RadioGroup selectionList;
	String gotBread;
	String setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		//Bundle gotBasket = getIntent().getExtras();
		//gotBread = gotBasket.getString("key");
		//question.setText(gotBread);
	}
	
	private void initialize() {
		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		selectionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		//return button, send the data back
		Intent carry = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		carry.putExtras(backpack);
		setResult(RESULT_OK, carry);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch (arg1) {
		case R.id.rCrazy:
			setData = "Probably right!";
			break;
		case R.id.rCool:
			setData = "Definately right!";
			break;
		case R.id.rBoth:
			setData = "Spot On!";
			break;
		}
		test.setText(setData);
	}

}
