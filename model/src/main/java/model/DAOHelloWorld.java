package model;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Element.Bag;
import org.Element.Candlestick;
import org.Element.Chesskull;
import org.Element.CrystalBall;
import org.Element.Element;
import org.Element.GateClosed;
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
import contract.IMobile;
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
	public List<List<IElement>> loadMap(final String map, List<IElement> dynamicElements){
		List<List<IElement>> array = new ArrayList<List<IElement>>();
		dynamicElements = new ArrayList<IElement>();
		try{
			final String sql = "{call mapByKey(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, map);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			resultSet.next();
			String s = resultSet.getString("map");
			array.add(new ArrayList<IElement>());
			int i = 0;
			int j = 0;
			for(char c : s.toCharArray()){
				switch (c){
				case 'P':
					array.get(i).add(new Stone());
					j++;
					break;
				case 'O':
					array.get(i).add(new HorizontalBone());
					j++;
					break;
				case 'I':
					array.get(i).add(new VerticalBone());
					j++;
					break;
				case 'U':
					array.get(i).add(new onion());
					j++;
					break;
				case 'C':
					array.get(i).add(new Candlestick());
					j++;
					break;
				case 'W':
					array.get(i).add(new White());
					j++;
					break;
				case 'S':
					array.get(i).add(new Bag());
					j++;
					break;
				case 'B':
					array.get(i).add(new CrystalBall());
					j++;
					break;
				case 'L':
					array.get(i).add(new Lorann( j, i));
					dynamicElements.add(array.get(i).get(j));
					j++;
					break;
				case 'D':
					array.get(i).add(new GateClosed());
					j++;
					break;
				case 'Z':
					array.get(i).add(new Statue());
					j++;
					break;
				case 'T':
					array.get(i).add(new Monster_1());
					dynamicElements.add(array.get(i).get(j));
					j++;
					break;
				case 'Y':
					array.get(i).add(new YellowMen());
					dynamicElements.add(array.get(i).get(j));
					j++;
					break;
				case 'K':
					array.get(i).add(new Korn());
					dynamicElements.add(array.get(i).get(j));
					j++;
					break;
				case 'A':
					array.get(i).add(new Chesskull());
					dynamicElements.add(array.get(i).get(j));
					j++;
					break;
				case 'G':
					array.get(i).add(new Glass());
					j++;
					break;
				case 'E':
					array.get(i).add(new GateOpen());
					j++;
					break;
				case '\n':
					array.add(new ArrayList<IElement>());
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

	
