package basePkg;

public interface IMainScreen
{
	public void DisplayMain();
	public void MoveGoat( Position aPos );
	public void MoveWolf( Position aPos );
	public void MoveCabbage( Position aPos );
	
	public void SetModel( IModel aModel );
}
