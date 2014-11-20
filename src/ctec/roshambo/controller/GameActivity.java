package ctec.roshambo.controller;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu.*;
import android.widget.*;
import ctec.state.model.RoshamboState;

public class GameActivity extends Activity
{
	
	
	/***************************************
	 * 
	 * Declaration Section
	 * 
	 ***************************************/
	
	
	
	private Button rockButton, paperButton, scissorsButton, selectButton, gameReturnButton;
	
	private ImageView userImageView, comImageView;
	
	private TextView resultText, winCount, lossCount, winText, lossText;
	
	/**
	 * The state being saved for wins/losses
	 */
	private RoshamboState appState;
	
	/**
	 * The user's choice to be compared to the comp choice.
	 */
	int userInput;
	
	
	
	/*************************************************************
	 * 
	 * Method Section
	 * 
	 *************************************************************/
	
	
	
	/**
	 * Setting up all of the objects and calling the setupListeners().
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		rockButton = (Button) findViewById(R.id.rockButton);
		paperButton = (Button) findViewById(R.id.paperButton);
		scissorsButton = (Button) findViewById(R.id.scissorsButton);
		selectButton = (Button) findViewById(R.id.selectButton);
		gameReturnButton = (Button) findViewById(R.id.gameReturnButton);
		
		userImageView = (ImageView) findViewById(R.id.userImageView);
		comImageView = (ImageView) findViewById(R.id.comImageView);
		
		resultText = (TextView) findViewById(R.id.resultText);
		winCount = (TextView) findViewById(R.id.winCount);
		lossCount = (TextView) findViewById(R.id.lossCount);
		winText = (TextView) findViewById(R.id.winText);
		lossText = (TextView) findViewById(R.id.lossText);
		
		
		comImageView.setImageResource(R.drawable.questionmrk);
		
		appState = (RoshamboState) this.getApplication();
				
		setupListeners();
		
		//winCount.setText(appState.getWin());
		//lossCount.setText(appState.getLoss());
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
	 * Logic behind the RPS winner.
	 */
	public void findWinner()
	{
		if (userInput == 0)
		{
			if (enemyChoice() == 0)
			{
				resultText.setText("Tie! Try again!");
			}
			else if(enemyChoice() == 1)
			{
				resultText.setText("Ooooh you lose! Try again!");
				appState.setLoss(appState.getLoss() + 1);
				lossCount.setText(Integer.toString(appState.getLoss()));
			}
			else if(enemyChoice() == 2)
			{
				resultText.setText("You Win! Good Job!");
				appState.setWin(appState.getWin() + 1);
				winCount.setText(Integer.toString(appState.getWin()));
			}
		}
		if (userInput == 1)
		{
			if (enemyChoice() == 0)
			{
				resultText.setText("You Win! Good Job!");
				appState.setWin(appState.getWin() + 1);
				winCount.setText(Integer.toString(appState.getWin()));
			}
			else if(enemyChoice() == 1)
			{
				resultText.setText("Tie! Try again!");
			}
			else if(enemyChoice() == 2)
			{
				resultText.setText("Ooooh you lose! Try again!");
				appState.setLoss(appState.getLoss() + 1);
				lossCount.setText(Integer.toString(appState.getLoss()));
			}
		}
		else if (userInput == 2)
		{
			if (enemyChoice() == 0)
			{
				resultText.setText("Ooooh you lose! Try again!");
				appState.setLoss(appState.getLoss() + 1);
				lossCount.setText(Integer.toString(appState.getLoss()));
			}
			else if(enemyChoice() == 1)
			{
				resultText.setText("You Win! Good Job!");
				appState.setWin(appState.getWin() + 1);
				winCount.setText(Integer.toString(appState.getWin()));
			}
			else if(enemyChoice() == 2)
			{
				resultText.setText("Tie! Try again!");
			}
		}
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
		
		gameReturnButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				
				Intent returnIntent = new Intent();
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
		
		selectButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{	
				enemyChoice();
				findWinner();
			}
		});
	}
}