package ctec.roshambo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import ctec.state.model.RoshamboState;

public class RoshamboActivity extends Activity
{
	private Button startButton, helpButton, creditsButton; 
	
	private RoshamboState appState;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_roshambo);
		
		startButton = (Button) findViewById(R.id.startButton);
		helpButton = (Button) findViewById(R.id.helpButton);
		creditsButton = (Button) findViewById(R.id.creditsButton);
		
		appState = (RoshamboState) this.getApplication();
		
		setupListeners();
	
	}
	
	public void setupListeners()
	{
		startButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				Intent transferIntent = new Intent (currentView.getContext(), GameActivity.class);
				startActivityForResult(transferIntent, 0);
				
			}
		});
		
		helpButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				Intent transferIntent = new Intent (currentView.getContext(), HelpActivity.class);
				startActivityForResult(transferIntent, 0);
				
			}
		});
		
		creditsButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				Intent transferIntent = new Intent (currentView.getContext(), CreditsActivity.class);
				startActivityForResult(transferIntent, 0);
				
			}
		});
	}
}
