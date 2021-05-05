package viewModel;
	
import java.io.IOException;
import basePkg.IMainScreen;
import basePkg.IModel;
import basePkg.PlayerType;
import basePkg.Position;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class MainScreen implements IMainScreen, IButtonClickHandler
{
	IModel mModel;
	private Parent mRoot;
	private Scene mScene;
	
	//fields
	private Stage mStage;

	@FXML
    private GridPane LeftGrid;
	
	@FXML
    private GridPane RightGrid;
	
	@FXML
    private Button MoveBtn;								
    @FXML
    private Button CancelBtn;

    @FXML
    private Button M_GoatBtn;

    @FXML
    private Button M_CabbageBtn;

    @FXML
    private Button M_WolfBtn;

    
    private SideButtons mLeftButtons;
    private SideButtons mRightButtons;

	//functions
	public MainScreen( Stage aStage )
	{
		this.mStage = aStage;
	}
	
	@Override
	public void DisplayMain()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader( getClass().getResource("/view/MainScreen.fxml") );
			loader.setController( this );
			mRoot = loader.load();
			mScene = new Scene( mRoot );
			mStage.setScene(mScene);
			mStage.show();
			mStage.setResizable(false);
			mStage.setTitle("The River Crossing");
			
			mLeftButtons = new SideButtons( Position.LEFT_SIDE, this );
			LeftGrid.add( mLeftButtons.GetPane(), 0, 1 );
			
			mRightButtons = new SideButtons( Position.RIGHT_SIDE, this );
			RightGrid.add( mRightButtons.GetPane(), 0, 1 );
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * Ez a IMainScreen Interfacben lévő dolgok. Ezeket overrideolom.
	 */
	
	@Override
	public void MovePlayer( PlayerType aPlayerType, Position aPos)
	{
		switch ( aPlayerType )
		{
			case GOAT:
				{
					MoveGoat( aPos );
				} break;
			case WOLF:
				{
					MoveWolf( aPos );
				} break;
			case CABBAGE:
				{
					MoveCabbage( aPos );
				} break;
		}
	}

	private void MoveGoat(Position aPos)
	{
		switch ( aPos )
		{
			case LEFT_SIDE:
				{
					mLeftButtons.SetGoatVisible(true);
					M_GoatBtn.setVisible(false);
					mRightButtons.SetGoatVisible(false);
				} break;
			case BOAT:
				{
					mLeftButtons.SetGoatVisible(false);
					M_GoatBtn.setVisible(true);
					mRightButtons.SetGoatVisible(false);
				} break;
			case RIGHT_SIDE:
				{
					mLeftButtons.SetGoatVisible(false);
					M_GoatBtn.setVisible(false);
					mRightButtons.SetGoatVisible(true);
				} break;
		}
	}

	private void MoveWolf(Position aPos)
	{
		switch ( aPos )
		{
			case LEFT_SIDE:
				{
					mLeftButtons.SetWolfVisible(true);
					M_WolfBtn.setVisible(false);
					mRightButtons.SetWolfVisible(false);
				} break;
			case BOAT:
				{
					mLeftButtons.SetWolfVisible(false);
					M_WolfBtn.setVisible(true);
					mRightButtons.SetWolfVisible(false);
				} break;
			case RIGHT_SIDE:
				{
					mLeftButtons.SetWolfVisible(false);
					M_WolfBtn.setVisible(false);
					mRightButtons.SetWolfVisible(true);
				} break;
		}
	}

	private void MoveCabbage( Position aPos )
	{
		switch ( aPos )
		{
			case LEFT_SIDE:
				{
					mLeftButtons.SetCabbageVisible(true);
					M_CabbageBtn.setVisible(false);
					mRightButtons.SetCabbageVisible(false);
				} break;
			case BOAT:
				{
					mLeftButtons.SetCabbageVisible(false);
					M_CabbageBtn.setVisible(true);
					mRightButtons.SetCabbageVisible(false);
				} break;
			case RIGHT_SIDE:
				{
					mLeftButtons.SetCabbageVisible(false);
					M_CabbageBtn.setVisible(false);
					mRightButtons.SetCabbageVisible(true);
				} break;
		}
	}
	
	
	@Override
	public void SetModel(IModel aModel)
	{
		this.mModel = aModel;
	}

	@Override
	public void OnPlayerClicked(PlayerType aType, Position aPos)
	{
		mModel.OnPlayerClicked( aType, aPos );
	}

	@FXML
    void OnMiddleCabbageClicked(ActionEvent event)
	{
		OnPlayerClicked( PlayerType.CABBAGE, Position.BOAT );
    }

    @FXML
    void OnMiddleGoatClicked(ActionEvent event)
    {
    	OnPlayerClicked( PlayerType.GOAT, Position.BOAT );
    }

    @FXML
    void OnMiddleWolfClicked(ActionEvent event)
    {
    	OnPlayerClicked( PlayerType.WOLF, Position.BOAT );
    }

    @FXML
    void OnMoveClicked(ActionEvent event)
    {
    	mModel.OnMove();
    }

	@Override
	public void OnWon()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnLost()
	{
		// TODO Auto-generated method stub
		
	}
}
