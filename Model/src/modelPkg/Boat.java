package modelPkg;

public class Boat {
	private boolean mIsEmpty;

	public Boat()
	{
		mIsEmpty = true;
	}
	
	public boolean IsEmpty()
	{
		return mIsEmpty;
	}

	public void BoardIn()
	{
		mIsEmpty = false;
	}

	public void Land()
	{
		mIsEmpty = true;
	}
}
