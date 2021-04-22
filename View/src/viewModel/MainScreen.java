package viewModel;
	
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import basePkg.IMainScreen;
import basePkg.IModel;
import basePkg.Position;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class MainScreen implements IMainScreen, Initializable
{
	IModel mModel;
	private Parent mRoot;
	private Scene mScene;
	//fields
	private Stage mStage;

    @FXML
    private Button MoveBtn;
    @FXML
    private Button CancelBtn;

    @FXML
    private Button L_GoatBtn;
    @FXML
    private Button M_GoatBtn;
    @FXML
    private Button R_GoatBtn;

    @FXML
    private Button L_CabbageBtn;
    @FXML
    private Button M_CabbageBtn;
    @FXML
    private Button R_CabbageBtn;

    @FXML
    private Button L_WolfBtn;
    @FXML
    private Button M_WolfBtn;
    @FXML
    private Button R_WolfBtn;

	//functions
	public MainScreen( Stage aStage )
	{
		mStage = aStage;
	}
	
	@Override
	public void DisplayMain()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader( getClass().getResource("/view/MainScrene.fxml") );
			loader.setController( this );
			mRoot = loader.load();
			mScene = new Scene( mRoot );
			mStage.setScene(mScene);
			mStage.show();
			mStage.setResizable(false);
			System.out.println("The Program Started...");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void MoveGoat(Position aPos)
	{
		MovePlayer( aPos, L_GoatBtn, M_GoatBtn, R_GoatBtn );
	}

	@Override
	public void MoveWolf(Position aPos)
	{
		MovePlayer( aPos, L_WolfBtn, M_WolfBtn, R_WolfBtn );
	}

	@Override
	public void MoveCabbage(Position aPos)
	{
		MovePlayer( aPos, L_CabbageBtn, M_CabbageBtn, R_CabbageBtn );
	}
	
	private void MovePlayer( Position aPos, Button aLeft, Button aMiddle, Button aRight )
	{
		switch( aPos )
		{
		case LEFT_SIDE:
			{
				aLeft.setVisible(true);
				aMiddle.setVisible(false);
				aRight.setVisible(false);
			} break;
		case BOAT:
			{
				aLeft.setVisible(false);
				aMiddle.setVisible(true);
				aRight.setVisible(false);
			} break;
		case RIGHT_SIDE:
			{
				aLeft.setVisible(false);
				aMiddle.setVisible(false);
				aRight.setVisible(true);
			} break;
		}
	}
	
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		Boolean b = true;
	}

	@Override
	public void SetModel(IModel aModel)
	{
		mModel = aModel;
	}
}
