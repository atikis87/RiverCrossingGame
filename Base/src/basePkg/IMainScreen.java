package basePkg;
/*
 *  Ez az interfész tartalmazza a kijelzőt és a hozzá tartozó mozgásokat
 */
public interface IMainScreen
{
	public void DisplayMain();
	public void MovePlayer( PlayerType aPlayerType, Position aPos );
	
	public void SetModel( IModel aModel );
	public void OnWon();
	public void OnLost();
}