package model;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Element.Element;
import org.Element.Stone;

import model.HelloWorld;



/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOHelloWorld extends DAOEntity<HelloWorld> {

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOHelloWorld(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	@Override
	public HelloWorld find(final int id) {
		HelloWorld helloWorld = new HelloWorld();

		try {
			final String sql = "{call mapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				helloWorld = new HelloWorld(id, resultSet.getString("keywords"), resultSet.getString("map"));
			}
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	public HelloWorld find(final String keywords) {
		HelloWorld helloWorld = new HelloWorld();
		try {
			final String sql = "{call mapByKey(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, keywords);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				helloWorld = new HelloWorld(resultSet.getInt("id"), keywords, resultSet.getString("map"));
			}
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;

}
	public List<List<Element>> loadMap(final String map){
		List<List<Element>> array = new ArrayList<List<Element>>();
		try{
			final String sql = "{call mapByKey(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, map);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			String s = resultSet.getString("map");
			array.add(new ArrayList<Element>());
			int i = 0;
			for(char c : s.toCharArray()){
				switch (c){
				case 'P':
					array.get(i).add(new Stone());
					break;
				case 'O':
					break;
				case 'I':
					break;
				case 'U':
					break;
				case 'C':
					break;
				case 'W':
					array.get(i).add(null);
					break;
				case 'S':
					break;
				case 'B':
					break;
				case 'L':
					break;
				case 'D':
					break;
				case 'Z':
					break;
				case 'T':
					break;
				case 'Y':
					break;
				case 'K':
					break;
				case 'A':
					break;
				case 'G':
					break;
				case '\n':
					array.add(new ArrayList<Element>());
					break;
				default:
					break;
				}
			}
			return array;
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}

	
