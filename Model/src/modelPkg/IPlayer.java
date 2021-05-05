package modelPkg;

import basePkg.PlayerMoved;
import basePkg.Position;

public interface IPlayer
{
	public Position GetPosition();
	public void SetPosition( Position aNewPosition );
	public void SetBoat( Boat aBoat );
	public void Clicked();
	public PlayerMoved Moved();
}
