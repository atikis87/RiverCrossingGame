package modelPkg;

import basePkg.IMainScreen;
import basePkg.IModel;
import basePkg.Position;

public class Model implements IModel
{
	private IMainScreen mMainScreen;
	IPlayer mGoat;
	IPlayer mWolf;
	IPlayer mCabbage;
	

	public Model( IMainScreen aMainScreen )
	{
		mMainScreen = aMainScreen;
		mMainScreen.SetModel( this );
		
		mGoat = new Player();
		mWolf = new Player();
		mCabbage = new Player();
	}
	
	public void Start()
	{
		mMainScreen.DisplayMain();
		InitializePlayers();
		InitializeView();
	}

	private void InitializePlayers()
	{
		mGoat.SetPosition( Position.LEFT_SIDE );
		mWolf.SetPosition( Position.LEFT_SIDE );
		mCabbage.SetPosition( Position.LEFT_SIDE );
	}

	private void InitializeView()
	{
		mMainScreen.MoveGoat( mGoat.GetPosition() );
		mMainScreen.MoveWolf( mWolf.GetPosition() );
		mMainScreen.MoveCabbage( mCabbage.GetPosition() );
	}
}
