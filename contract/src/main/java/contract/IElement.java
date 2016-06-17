package contract;
/**
 * The Interface IElement.
 *
 * @author florent , axel , luc , romain
 */
public interface IElement {
	public ISprite getSprite();
	public Permeability getPermeability();
	public void animate();
	public void setModel(IModel model);
}
