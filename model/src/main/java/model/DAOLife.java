package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The DAOLife class.
 * This class is made specially to manage Lorann's lives.
 * 
 * @author Florent, Axel, Luc, Romain
 *
 */
public class DAOLife{
	
	/**
	 * The database connection.
	 */
	private final Connection connection;
	
	/**
	 * Creates a DAOLife object.
	 * @param connection
	 * 			The database connection.
	 * @throws SQLException
	 * 			A SQL exception.
	 */
	public DAOLife(final Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	/**
	 * @return The database connection.
	 */
	protected Connection getConnection() {
		return this.connection;
	}
	
	/**
	 * Fetches the number of lives left from the DB.
	 * 
	 * @return Number of lives left.
	 */
	public int getLife(){
		try{
			String sql = "{call Get_lives()}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.executeQuery();
			ResultSet result = call.getResultSet();
			result.next();
			return result.getInt(1);
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Adds two lives to Lorann.
	 */
	public void addLife(){
		try{
			String sql = "{call Give_two_lives()}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes one life from Lorann.
	 */
	public void removeLife(){
		try{
			String sql = "{call Remove_life()}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 *  Resets Lorann's lives.
	 */
	public void resetLife(){
		try{
			String sql = "{call Reset_lives(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, "Lorann");
			call.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
