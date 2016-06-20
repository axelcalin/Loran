package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The DAOEntity class
 *
 * @author Florent, Axel, Luc, Romain;
 *
 * 
 */
abstract class DAOEntity {

	/** The databse connection. */
	private final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection
	 *          the database connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOEntity(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the database connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}
}
