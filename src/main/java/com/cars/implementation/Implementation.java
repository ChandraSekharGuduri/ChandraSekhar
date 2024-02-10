package com.cars.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servlet.encapsulatedclass.Carsentity;
import com.servlet.jdbc.Jdbc;

public class Implementation {

	Connection connect;
	PreparedStatement prep;
	ResultSet resultset;
	Statement state;
	
	public Implementation() {
		connect=Jdbc.getinstance();
	}
	public int Insertmethod(Carsentity entity) {
		int result=0;
		System.out.println("Implementation class triggered");
		String query="insert into mercedesbenz values(?,?,?,?,?)";
		
		try {
			prep=connect.prepareStatement(query);
			prep.setString(1,entity.getModelname());
			prep.setInt(2,entity.getVariant());
			prep.setString(3,entity.getPrice());
			prep.setString(4,entity.getTopspeed());
			prep.setString(5,entity.getFueltype());
			result=prep.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Read-Search
		public Carsentity Search(String ec) {
			Carsentity entity =null;
			System.out.println("Implementation Class Read Method Triggered");
			
			
			
			try {
				String query ="select * from mercedesbenz where Modelname =  ?";
				prep = connect.prepareStatement(query);
				prep.setString(1, ec);
				resultset = prep.executeQuery();

				while(resultset.next()) {
					entity = new Carsentity();
					entity.setModelname(resultset.getString(1));
					entity.setVariant(resultset.getInt(2));
					entity.setPrice(resultset.getString(3));
					entity.setTopspeed(resultset.getString(4));
					entity.setFueltype(resultset.getString(5));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return entity;

		}
		
		//Read-Fetch
		public List<Carsentity>Fetch(){
			List<Carsentity> listproduct=new ArrayList<Carsentity>();
			System.out.println("Fetch data triggered");
			String query = "select * from mercedesbenz";
			Carsentity entity=null;
			try {
				state=connect.createStatement();
				resultset=state.executeQuery(query);
				
				while(resultset.next()) {
					entity=new Carsentity();
					entity.setModelname(resultset.getString(1));
					entity.setVariant(resultset.getInt(2));
					entity.setPrice(resultset.getString(3));
					entity.setTopspeed(resultset.getString(4));
					entity.setFueltype(resultset.getString(5));
					listproduct.add(entity);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listproduct;
			
		}
}
