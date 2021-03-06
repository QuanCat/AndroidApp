package android.my_first_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	String classes[] = {"MainActivity", "TextPlay", "Email", "Camera", 
			"Data", "example5", "example6"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	//control the Menu
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		Class ourClass;
		try {
			ourClass = Class.forName("android.my_first_app." + cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("android_my_first_app.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent j = new Intent("android_my_first_app.PRESF");
			startActivity(j);
			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;
		
	}
	
}
