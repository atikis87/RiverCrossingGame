package viewModel;


import java.io.IOException;

import basePkg.PlayerType;
import basePkg.Position;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class SideButtons
{
	private final Position mMyPosition;
	private IButtonClickHandler mBtnHandler;
    @FXML
    private Pane VerticalBtnPane;

    @FXML
    private Button S_GoatBtn;

    @FXML
    private Button S_CabbageBtn;

    @FXML
    private Button S_WolfBtn;

	public SideButtons( Position aPos, IButtonClickHandler aBtnHandler )
	{
		mMyPosition = aPos;
		mBtnHandler = aBtnHandler;
		try
		{
			FXMLLoader loader = new FXMLLoader( getClass().getResource("/view/SideButtons.fxml") );
			loader.setController( this );
			loader.load();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public Pane GetPane()
	{
		return VerticalBtnPane;
	}

	public void SetGoatVisible( boolean aIsVisible )
	{
		S_GoatBtn.setVisible( aIsVisible );
	}
	
	public void SetWolfVisible( boolean aIsVisible )
	{
		S_WolfBtn.setVisible( aIsVisible );
	}
	
	public void SetCabbageVisible( boolean aIsVisible )
	{
		S_CabbageBtn.setVisible( aIsVisible );
	}

	@FXML
    void OnCabbageClicked(ActionEvent event)
	{
		mBtnHandler.OnPlayerClicked( PlayerType.CABBAGE, mMyPosition );
    }

    @FXML
    void OnGoatClicked(ActionEvent event)
    {
    	mBtnHandler.OnPlayerClicked( PlayerType.GOAT, mMyPosition );
    }

    @FXML
    void OnWolfClicked(ActionEvent event)
    {
    	mBtnHandler.OnPlayerClicked( PlayerType.WOLF, mMyPosition );
    }
}
