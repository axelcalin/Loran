package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOLife{
	private final Connection connection;
	public DAOLife(final Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	protected Connection getConnection() {
		return this.connection;
	}
	
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
	
	public void addLife(){
		try{
			String sql = "{call Give_two_lives()}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void removeLife(){
		try{
			String sql = "{call Remove_life()}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
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
