package modelPkg;

import basePkg.GameResult;
import basePkg.MoveDirection;
import basePkg.Position;

public class GameValidator
{
	private IPlayer mGoat;
	private IPlayer mWolf;
	private IPlayer mCabbage;

	public GameValidator( IPlayer aGoat, IPlayer aWolf, IPlayer aCabbage )
	{
		mGoat = aGoat;
		mWolf = aWolf;
		mCabbage = aCabbage;
	}

	public GameResult IsGameWon()
	{
		boolean IsGoatOnTheRight = Position.RIGHT_SIDE == mGoat.GetPosition();
		boolean IsWolfOnTheRight = Position.RIGHT_SIDE == mWolf.GetPosition();
		boolean IsCabbageOnTheRight = Position.RIGHT_SIDE == mCabbage.GetPosition();
		
		if ( IsGoatOnTheRight && IsWolfOnTheRight && IsCabbageOnTheRight )
		{
			return GameResult.GAME_WON;
		}
		
		
		return GameResult.GAME_CONTINUE;
	}


	public GameResult IsGameLost( MoveDirection aMoveDirection )
	{
		if ( MoveDirection.TO_LEFT == aMoveDirection )
		{
			return IsGameLostOnTheRight();
		}

		return IsGameLostOnTheLeft();
	}

	public GameResult IsGameLost()
	{
		GameResult result = IsGameLostOnTheRight();
		if ( GameResult.GAME_CONTINUE == result )
		{
			result = IsGameLostOnTheLeft();
		}

		return result;
	}

	private GameResult IsGameLostOnTheRight()
	{
		if ( Position.RIGHT_SIDE == mGoat.GetPosition() && Position.RIGHT_SIDE == mCabbage.GetPosition() )
		{
			return GameResult.GAME_LOST;
		}

		if ( Position.RIGHT_SIDE == mGoat.GetPosition() && Position.RIGHT_SIDE == mWolf.GetPosition() )
		{
			return GameResult.GAME_LOST;
		}
		
		return GameResult.GAME_CONTINUE;
	}
	
	private GameResult IsGameLostOnTheLeft()
	{
		if ( Position.LEFT_SIDE == mGoat.GetPosition() && Position.LEFT_SIDE == mCabbage.GetPosition() )
		{
			return GameResult.GAME_LOST;
		}

		if ( Position.LEFT_SIDE == mGoat.GetPosition() &&  Position.LEFT_SIDE == mWolf.GetPosition() )
		{
			return GameResult.GAME_LOST;
		}
		
		return GameResult.GAME_CONTINUE;
	}
}
