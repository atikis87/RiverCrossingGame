package modelPkg;

import basePkg.PlayerMoved;
import basePkg.Position;

public class Player implements IPlayer
{
	private Position mPosition;
	private Position mLastPosition;
	private Boat mBoat;

	public Player()
	{
	}

	
	@Override
	public Position GetPosition()
	{
		return mPosition;
	}

	@Override
	public void SetPosition( Position aNewPosition )
	{
		mPosition = aNewPosition;
		mLastPosition = aNewPosition;
	}

	@Override
	public void Clicked()
	{
		boolean amIOnBoat = Position.BOAT == mPosition;
		
		if ( !amIOnBoat && mBoat.IsEmpty() )
		{
			mPosition = Position.BOAT;
			mBoat.BoardIn();
			return;
		}
		if ( amIOnBoat )
		{
			mBoat.Land();
			mPosition = mLastPosition;
		}
		
		/*if ( !amIOnBoat  )
		{
			if ( mBoat.IsEmpty() )
			{
				mPosition = Position.BOAT;
				mBoat.BoardIn();
			}
			else
			{
				
			}
		}
		else if ( amIOnBoat )
		{
			if ( mBoat.IsEmpty() )
			{
				
			}
			else
			{
				mBoat.Land();
				mPosition = mLastPosition;
			}
		}*/
	}

	
	@Override
	public PlayerMoved Moved()
	{
		if ( Position.BOAT != mPosition )
		{
			return PlayerMoved.NONE;
		}

		/*
		mPosition = mLastPosition == Position.LEFT_SIDE ? Position.RIGHT_SIDE : Position.LEFT_SIDE;
		mLastPosition = mPosition;
		*/
		if ( Position.LEFT_SIDE == mLastPosition )
		{
			SetPosition( Position.RIGHT_SIDE );
		}
		else
		{
			SetPosition( Position.LEFT_SIDE );
		}
		mBoat.Land();

		if ( Position.RIGHT_SIDE == mPosition )
		{
			return PlayerMoved.TO_RIGHT;
		}
		else
		{
			return PlayerMoved.TO_LEFT;
		}
	}


	@Override
	public void SetBoat(Boat aBoat)
	{
		mBoat = aBoat;
	}

}