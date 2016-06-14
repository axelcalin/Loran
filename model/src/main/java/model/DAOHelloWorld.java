package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.Element;

import org.Element.STONE;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOHelloWorld extends DAOEntity<HelloWorld> {

	private int width;
	private int height;
	private org.Element.Element elements[][];

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
	public HelloWorld find(final String keywords,final int width, final int height) {
		this.width = width;
		this.height = height;
		this.elements = new org.Element.Element[this.getWidth()][this.getHeight()];
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
			BufferedReader in;
			String S = resultSet.getString("map");
			ArrayList<String> map = new ArrayList<String>();
			for(String temp : S.split("\n")) map.add(temp);

for (int y = 0; y < map.size(); y++) {
			for (int x = 0; x < map.get(y).length(); x++) {
				switch(map.get(y).charAt(x)){
				case 'P' :
					addElement(new STONE(), x, y);
					break;
				}
			}
}
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;

}
private void addElement(org.Element.Element element, int x, int y) {
		this.elements[x][y] = element;
		
	}

public int getWidth() {
	return this.width;
}

public int getHeight() {
	return this.height;
}

public org.Element.Element getElements(final int x, final int y) {
	if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
		return null;
	}
	return this.elements[x][y];
}

@Override
public HelloWorld find(String key) {
	// TODO Auto-generated method stub
	return null;
}


}

	
