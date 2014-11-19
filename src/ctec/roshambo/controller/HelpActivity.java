package ctec.roshambo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import ctec.state.model.RoshamboState;

public class HelpActivity extends Activity
{
	
	private Button helpReturnButton;
	
	private RoshamboState appState;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		
		helpReturnButton = (Button) findViewById(R.id.helpReturnButton);
		
		appState = (RoshamboState) this.getApplication();
		
		setupListeners();
	}
	
	private void setupListeners()
	{
		helpReturnButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent returnIntent = new Intent();
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}
}
