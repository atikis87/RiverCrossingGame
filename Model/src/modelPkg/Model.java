package modelPkg;

import basePkg.GameResult;
import basePkg.IMainScreen;
import basePkg.IModel;
import basePkg.MoveDirection;
import basePkg.PlayerMoved;
import basePkg.PlayerType;
import basePkg.Position;

public class Model implements IModel
{
	private IMainScreen mMainScreen;
	IPlayer mGoat;
	IPlayer mWolf;
	IPlayer mCabbage;
	Boat mBoat;
	GameValidator mValidator;
	boolean mWasMoveClicked;
	
	// konstruktor ami tartalmaz egy Interface paramétert
	public Model( IMainScreen aMainScreen )
	{
		mMainScreen = aMainScreen;
		mMainScreen.SetModel( this );
		
		mGoat = new Player();
		mWolf = new Player();
		mCabbage = new Player();

		mBoat = new Boat();
		mGoat.SetBoat( mBoat );
		mWolf.SetBoat( mBoat );
		mCabbage.SetBoat( mBoat );

		mValidator = new GameValidator( mGoat, mWolf, mCabbage );
		mWasMoveClicked = false;
	}
	
	public void Start()
	{
		mMainScreen.DisplayMain();
		
		InitializePlayers();
		RefreshView();
	}

	private void InitializePlayers()
	{
		mGoat.SetPosition( Position.LEFT_SIDE );
		mWolf.SetPosition( Position.LEFT_SIDE );
		mCabbage.SetPosition( Position.LEFT_SIDE );
	}

	private void RefreshView()
	{
		mMainScreen.MovePlayer( PlayerType.GOAT, mGoat.GetPosition() );
		mMainScreen.MovePlayer( PlayerType.WOLF, mWolf.GetPosition() );
		mMainScreen.MovePlayer( PlayerType.CABBAGE, mCabbage.GetPosition() );
	}

	@Override
	public void OnPlayerClicked( PlayerType aType, Position aPos )
	{
		switch( aType )
		{
			case GOAT:
			{
				mGoat.Clicked();
				mMainScreen.MovePlayer( PlayerType.GOAT, mGoat.GetPosition() );

			} break;
			case WOLF:
			{
				mWolf.Clicked();
				mMainScreen.MovePlayer( PlayerType.WOLF, mWolf.GetPosition() );
			} break;
			case CABBAGE:
			{
				mCabbage.Clicked();
				mMainScreen.MovePlayer( PlayerType.CABBAGE, mCabbage.GetPosition() );
			}break;
		}

		if ( true == mWasMoveClicked )
		{
			IsGameLost();
			mWasMoveClicked = false;
		}
	}

	@Override
	public void OnMove()
	{
		if ( mBoat.IsEmpty() )
		{
			return;
		}

		MoveDirection direction = MovePlayers();
		RefreshView();

		if ( false == IsGameWon() && false == IsGameLost( direction ) )
		{
			mWasMoveClicked = true;
		}
	}

	private MoveDirection MovePlayers()
	{
		if ( PlayerMoved.NONE != mCabbage.Moved() )
		{
			if ( PlayerMoved.TO_LEFT == mCabbage.Moved() )
			{
				return MoveDirection.TO_LEFT;
			}
			else
			{
				return MoveDirection.TO_RIGHT;
			}
		}
		if ( PlayerMoved.NONE != mWolf.Moved() )
		{
			if ( PlayerMoved.TO_LEFT == mWolf.Moved() )
			{
				return MoveDirection.TO_LEFT;
			}
			else
			{
				return MoveDirection.TO_RIGHT;
			}
		}


		if ( PlayerMoved.TO_LEFT == mGoat.Moved() )
		{
			return MoveDirection.TO_LEFT;
		}
		else
		{
			return MoveDirection.TO_RIGHT;
		}
	}

	private boolean IsGameWon()
	{
		GameResult result = mValidator.IsGameWon();
		if ( GameResult.GAME_WON == result )
		{
			mMainScreen.OnWon();
			InitializePlayers();
			RefreshView();
			return true;
		}
		return false;
	}
	
	private boolean IsGameLost()
	{
		GameResult result = mValidator.IsGameLost();
		if ( GameResult.GAME_LOST == result )
		{
			mMainScreen.OnLost();
			InitializePlayers();
			RefreshView();
			return true;
		}
		return false;
	}
	
	private boolean IsGameLost( MoveDirection aMoveDir )
	{
		GameResult result = mValidator.IsGameLost( aMoveDir );
		if ( GameResult.GAME_LOST == result )
		{
			mMainScreen.OnLost();
			InitializePlayers();
			RefreshView();
			return true;
		}
		return false;
	}
}

