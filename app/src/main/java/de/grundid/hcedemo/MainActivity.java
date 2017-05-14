package de.grundid.hcedemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button button;
	private SharedPreferences salvar;
	private EditText text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button);
		text = (EditText) findViewById(R.id.text);
		salvar = getSharedPreferences("notes",MODE_PRIVATE);

		text.setText(salvar.getString("tag", "Default Value"));

		button.setOnClickListener(guardar);
	}

	private void makeTag(String tag){
		String or = salvar.getString(tag, null);
		SharedPreferences.Editor preferencesEditor = salvar.edit();
		preferencesEditor.putString("tag",tag); //change this line to this
		preferencesEditor.commit();
	}

	View.OnClickListener guardar= new View.OnClickListener(){
		public void onClick(View v)
		{
			if( v==button)
			{
				makeTag(text.getText().toString());
				global.texto=salvar.toString();
				((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(text.getWindowToken(),0);

			}
		}
	};
}
