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



/**
 * The DAOModel class. Although the filename says otherwise.
 *
 * @author Florent, Axel, Luc, Romain;
 */
class DAOModel extends DAOEntity {

	/**
	 * Instantiates a new DAO Model
	 *
	 * @param connection
	 *          the database connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOModel(final Connection connection) throws SQLException {
		super(connection);
	}
	
	/**
	 * Saves the given score in the database.
	 * 
	 * @param scoreToSave
	 * 			The score to save.
	 */
	public void saveScoreToDB(int scoreToSave){
		try{
			final String sql ="{call High_Scores(?,?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, 19);
			call.setInt(2, scoreToSave);
			call.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}


	/**
	 * Loads the chosen map.
	 * @param map
	 * 			The chosen map.
	 * @param dynamicElements
	 * 			The map's dynamic elements.
	 * @return The loaded map.
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

	
