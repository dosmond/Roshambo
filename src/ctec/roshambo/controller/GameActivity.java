package ctec.roshambo.controller;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu.*;
import android.widget.*;

public class GameActivity extends Activity
{
	private Button rockButton, paperButton, scissorsButton, selectButton;
	
	private ImageView userImageView, comImageView;
	
	private TextView resultText;
	
	
	int userInput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		rockButton = (Button) findViewById(R.id.rockButton);
		paperButton = (Button) findViewById(R.id.paperButton);
		scissorsButton = (Button) findViewById(R.id.scissorsButton);
		selectButton = (Button) findViewById(R.id.selectButton);
		
		userImageView = (ImageView) findViewById(R.id.userImageView);
		comImageView = (ImageView) findViewById(R.id.comImageView);
		
		resultText = (TextView) findViewById(R.id.resultText);
		
		comImageView.setImageResource(R.drawable.questionmrk);
				
		setupListeners();
	}
	/**
	 * Determines what the computer chooses.
	 * @return The enemy choice.
	 */
	public int enemyChoice()
	{
		int enemyResponse = (int)(Math.random()*3);
		
		if (enemyResponse == 0)
		{
			comImageView.setImageResource(R.drawable.rock);
		}
		else if(enemyResponse == 1)
		{
			comImageView.setImageResource(R.drawable.paper);
		}
		else if(enemyResponse == 2)
		{
			comImageView.setImageResource(R.drawable.scissors);
		}
		
		return enemyResponse;
	}
	
	/**
	 * The buttons for the user's choice during the game.
	 */
	private void setupListeners()
	{
		rockButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				userInput = 0;
				userImageView.setImageResource(R.drawable.rock);
				resultText.setText("Select your Choice!");
				comImageView.setImageResource(R.drawable.questionmrk);
			}
		});
		
		paperButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				userInput = 1;
				userImageView.setImageResource(R.drawable.paper);
				resultText.setText("Select your Choice!");
				comImageView.setImageResource(R.drawable.questionmrk);
			}
		});
		
		scissorsButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				userInput = 2;
				userImageView.setImageResource(R.drawable.scissors);
				resultText.setText("Select your Choice!");
				comImageView.setImageResource(R.drawable.questionmrk);
			}
		});
		
		selectButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				//Intent transferIntent = new Intent (currentView.getContext(), RoshamboActivity.class);
				//startActivityForResult(transferIntent, 0);
				
				enemyChoice();
				
				if (userInput == 0)
				{
					if (enemyChoice() == 0)
					{
						resultText.setText("Tie! Try again!");
					}
					else if(enemyChoice() == 1)
					{
						resultText.setText("Ooooh you lose! Try again!");
					}
					else if(enemyChoice() == 2)
					{
						resultText.setText("You Win! Good Job!");
					}
				}
				if (userInput == 1)
				{
					if (enemyChoice() == 0)
					{
						resultText.setText("You Win! Good Job!");
					}
					else if(enemyChoice() == 1)
					{
						resultText.setText("Tie! Try again!");
					}
					else if(enemyChoice() == 2)
					{
						resultText.setText("Ooooh you lose! Try again!");
					}
				}
				else if (userInput == 2)
				{
					if (enemyChoice() == 0)
					{
						resultText.setText("Ooooh you lose! Try again!");
					}
					else if(enemyChoice() == 1)
					{
						resultText.setText("You Win! Good Job!");
					}
					else if(enemyChoice() == 2)
					{
						resultText.setText("Tie! Try again!");
					}
				}
			}
		});
	}
}
