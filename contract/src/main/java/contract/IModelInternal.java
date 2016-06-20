package contract;

public interface IModelInternal extends IModel{
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	IElement getElementxy(int x, int y);
	
	/**
	 * @param x
	 * @param y
	 * @param targetx
	 * @param targety
	 */
	public void moveElement(int x, int y, int targetx, int targety);
	
	/**
	 * @return
	 */
	public IMobile getLorann();

	/**
	 * @param lorann
	 */
	void setLorann(IMobile lorann);
	

	

	
	public void setGate(IElement gate);
	
	public IElement getGate();

	void setForKill(IElement target);


	
	public void addScore(int score);
	
	public void removeLife();
	
	public void setAddLife();
}
