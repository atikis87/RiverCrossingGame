package modelPkg;

import basePkg.Position;

public class Player implements IPlayer
{
	private Position mPosition;

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
	}

}
