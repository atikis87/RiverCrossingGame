package viewModel;

import basePkg.PlayerType;
import basePkg.Position;

public interface IButtonClickHandler
{
	public void OnPlayerClicked( PlayerType aType, Position aPos );
}
