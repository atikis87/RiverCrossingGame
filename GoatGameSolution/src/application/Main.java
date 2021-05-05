package application;

import javafx.application.Application;
import javafx.stage.Stage;
import modelPkg.Model;
import viewModel.MainScreen;

public class Main extends Application
{

	@Override
	public void start( Stage aStage )
	{

		MainScreen mainScreen = new MainScreen( aStage );
		Model model = new Model( mainScreen );
		model.Start();		
	}

	public static void main(String[] args)
	{
		launch(args);	
	}
}
