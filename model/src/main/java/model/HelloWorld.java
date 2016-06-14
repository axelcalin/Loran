package model;

/**
 * The Class HelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class HelloWorld extends Entity {

	/** The id. */
	private int			id;

	/** The key. */
	private String	keywords;

	/** The message. */
	private String	map;

	/**
	 * Instantiates a new hello world.
	 *
	 * @param id
	 *          the id
	 * @param key
	 *          the key
	 * @param message
	 *          the message
	 */
	public HelloWorld(final int id, final String keywords, final String map) {
		this.setId(id);
		this.setKeywords(keywords);
		this.setMap(map);
	}

	/**
	 * Instantiates a new hello world.
	 */
	public HelloWorld() {
		this(0, "", "");
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKeywords() {
		return this.keywords;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *          the new key
	 */
	public void setKeywords(final String key) {
		this.keywords = key;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMap() {
		return this.map;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	public void setMap(final String map) {
		this.map = map;
	}

}
