package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bean.Parola;

public class Dao {
	
	
	public int getNumeroIniziano(String caratteri){                         //ok             
		String query="select *   from parola p   where  nome like ?";
		Connection conn = DBConnect.getConnection();
		List<Parola> queste = new LinkedList<>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,  caratteri+"%");
			ResultSet res = st.executeQuery();
			while(res.next()){
				Parola p = new Parola (res.getInt("id"), res.getString("nome"));
				queste.add(p);
			}
			conn.close();
			System.out.println(queste.size());
			return queste.size();
		}catch(SQLException e ){
			e.printStackTrace();
			return -1;
		}
	}
	
	
	public int getNumeroIniziano2(String caratteri){                                         //ok             
		String query="select count(*) as conta   from parola p   where  nome like ?";
		Connection conn = DBConnect.getConnection();
		int conta =-1;
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,  caratteri+"%");
			ResultSet res = st.executeQuery();
			if(res.next()){
				conta = res.getInt("conta");
			}
			conn.close();
			System.out.println(conta);
			return conta;
		}catch(SQLException e ){
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getNumeroFiniscono(String caratteri){                                         //ok             
		String query="select count(*) as conta   from parola p   where  nome like ?";
		Connection conn = DBConnect.getConnection();
		int conta =-1;
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,  "%"+caratteri);
			ResultSet res = st.executeQuery();
			if(res.next()){
				conta = res.getInt("conta");
			}
			conn.close();
			System.out.println(conta);
			return conta;
		}catch(SQLException e ){
			e.printStackTrace();
			return -1;
		}
	}


	public int getNumeroMezzo(String caratteri){                                         //ok             
		String query="select count(*) as conta   from parola p   where  nome like ?";
		Connection conn = DBConnect.getConnection();
		int conta =-1;
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,  "%"+caratteri+"%");
			ResultSet res = st.executeQuery();
			if(res.next()){
				conta = res.getInt("conta");
			}
			conn.close();
			System.out.println(conta);
			return conta;
		}catch(SQLException e ){
			e.printStackTrace();
			return -1;
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	//ritonano le parole:
	
	public List<Parola> getIniziano(String caratteri){                     //ok
		String query="select *   from parola p   where  nome like ?";
		Connection conn = DBConnect.getConnection();
		List<Parola> queste = new LinkedList<>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,  caratteri+"%");
			//st.setString(1,  "%"+ caratteri+"%");
			ResultSet res = st.executeQuery();
			while(res.next()){
				Parola p = new Parola (res.getInt("id"), res.getString("nome"));
				queste.add(p);
			}
			conn.close();
			System.out.println(queste);
			return queste;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public List<Parola> getFiniscono(String caratteri){                     //ok
		String query="select *   from parola p   where  nome like ?";
		Connection conn = DBConnect.getConnection();
		List<Parola> queste = new LinkedList<>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, "%"+caratteri);
			ResultSet res = st.executeQuery();
			while(res.next()){
				Parola p = new Parola (res.getInt("id"), res.getString("nome"));
				queste.add(p);
			}
			conn.close();
			System.out.println(queste);
			return queste;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}

	
	public List<Parola> getMezzo(String caratteri){                     //ok
		String query="select *   from parola p   where  nome like ?";
		Connection conn = DBConnect.getConnection();
		List<Parola> queste = new LinkedList<>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, "%"+caratteri+"%");
			ResultSet res = st.executeQuery();
			while(res.next()){
				Parola p = new Parola (res.getInt("id"), res.getString("nome"));
				queste.add(p);
			}
			conn.close();
			System.out.println(queste);
			return queste;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<Parola> getprovo(String caratteri){                    
//		String query="select *   from parola p   where  nome like '%'?  ";
//		Connection conn = DBConnect.getConnection();
//		List<Parola> que = new LinkedList<>();
//		try{
//			PreparedStatement st = conn.prepareStatement(query);
//        	st.setString(1,  "%"+caratteri);
//			ResultSet res = st.executeQuery();
//			while(res.next()){
//				Parola p = new Parola (res.getInt("id"), res.getString("nome"));
//				que.add(p);
//			}
//			conn.close();
//			System.out.println(que);
//			return que;
//		}catch(SQLException e ){
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	
	public static void main(String [] args){
		Dao dao = new Dao();
	//	dao.getIniziano("ch");
		//dao.getprovo("ch");
		//dao.getFiniscono("ch");
		//dao.getMezzo("ch");
		dao.getNumeroIniziano("ch");
		dao.getNumeroIniziano2("ch");
		dao.getNumeroFiniscono("ch");
		dao.getNumeroMezzo("ch");
	}

}
