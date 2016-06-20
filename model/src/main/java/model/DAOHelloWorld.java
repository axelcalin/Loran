package model;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.Element.Bag;
import org.Element.Candlestick;
import org.Element.Chesskull;
import org.Element.CrystalBall;
import org.Element.Element;
import org.Element.Gate;
import org.Element.GateOpen;
import org.Element.Glass;
import org.Element.HorizontalBone;
import org.Element.Korn;
import org.Element.Lorann;
import org.Element.Monster_1;
import org.Element.Statue;
import org.Element.Stone;
import org.Element.VerticalBone;
import org.Element.White;
import org.Element.YellowMen;
import org.Element.onion;

import contract.IElement;
import model.HelloWorld;



/**
 * The Class DAOHelloWorld.
 *
 * @author florent, axel, luc, romain;
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
	/**
	 * @param map
	 * @param dynamicElements
	 * @return
	 */
	public synchronized IElement[][] loadMap(final String map, List<IElement> dynamicElements){
		IElement[][] array = new Element[12][20];
		dynamicElements.clear();
		try{
			final String sql = "{call mapByKey(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, map);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			resultSet.next();
			String s = resultSet.getString("map");
			int i = 0;
			int j = 0;
			for(char c : s.toCharArray()){
				switch (c){
				case 'P':
					array[i][j] = new Stone();
					j++;
					break;
				case 'O':
					array[i][j] = new HorizontalBone(); 
					j++;
					break;
				case 'I':
					array[i][j] = new VerticalBone();
					j++;
					break;
				case 'U':
					array[i][j] = new onion(j,i);
					j++;
					break;
				case 'C':
					array[i][j] = new Candlestick(j,i);
					j++;
					break;
				case 'W':
					array[i][j] = new White();
					j++;
					break;
				case 'S':
					array[i][j] = new Bag(j,i);
					j++;
					break;
				case 'B':
					array[i][j] = new CrystalBall(j,i);
					j++;
					break;
				case 'L':
					array[i][j] = new Lorann(j, i);;
					dynamicElements.add(array[i][j]);
					j++;
					break;
				case 'D':
					array[i][j] = new Gate(false);
					j++;
					break;
				case 'Z':
					array[i][j] = new Statue(j,i);
					j++;
					break;
				case 'T':
					array[i][j] = new Monster_1(i,j);
					dynamicElements.add(array[i][j]);
					j++;
					break;
				case 'Y':
					array[i][j] = new YellowMen(i,j);
					dynamicElements.add(array[i][j]);
					j++;
					break;
				case 'K':
					array[i][j] = new Korn(i,j);
					dynamicElements.add(array[i][j]);
					j++;
					break;
				case 'A':
					array[i][j] = new Chesskull(i,j);
					dynamicElements.add(array[i][j]);
					j++;
					break;
				case 'G':
					array[i][j] = new Glass(j,i);
					j++;
					break;
				case 'E':
					array[i][j] = new Gate(true);
					j++;
					break;
				case '\n':
					/*if(array[i].length >= j){
						array[i][j] = new White();
					}*/
					i++;
					j = 0;
					break;
				default:
					break;
				}
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return array;
	}
}

	
