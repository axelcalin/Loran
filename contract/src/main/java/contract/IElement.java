package contract;

public interface IElement {
	public ISprite getSprite();
	public Permeability getPermeability();
	public void animate();
	public void setModel(IModel model);
}
