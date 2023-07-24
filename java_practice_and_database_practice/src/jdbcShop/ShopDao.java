package jdbcShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopDao {

	Connection getConnection() {
		Connection con  = null;

		String url="jdbc:oracle:thin:@//localhost:1521/xe"; 
	    String userid="jhs_dba"; 
	    String userpw="1212";
	    
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection(url, userid, userpw);
		
		}
		catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;	
	}

	public int insertMember(Member member) {

		Connection con = getConnection();
		int result = 0;
		
		if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		} 
		
		
		String sql = "insert into members(mid,mpw,mname,mphone,mbirth) " + "values(?,?,?,?,?)";
		
		try {
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1, member.getMid());
			pst.setString(2, member.getMpw());
			pst.setString(3, member.getMname());
			pst.setString(4, member.getMphone());
			pst.setString(5, member.getMbirth());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	//public ArrayList<Member> select_memberInfo(String loginId) {
		
		public Member select_memberInfo(String loginId) {
		Connection con = getConnection();
	
		if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 
		Member mList =null;
		//ArrayList<Member> mList = new ArrayList<Member>();
		String sql = "select mid,mpw,mname,mphone,mbirth,to_char(mbirth, 'yyyy-mm-dd') from members " + "where mid = ?"; // mid 는 primary key 
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loginId); // 맵핑
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				mList = new Member();
				
				mList.setMid(rs.getString(1));
				mList.setMpw(rs.getString("mpw"));
				mList.setMname(rs.getString("mname"));
				mList.setMphone(rs.getString("mphone"));
				mList.setMbirth(rs.getString("mbirth"));
				mList.setMstate(rs.getString("mstate"));
			/*	member.setMid(rs.getString(1));
				member.setMpw(rs.getString(2));
				member.setMname(rs.getString(3));
				member.setMphone(rs.getString(4));
				member.setMbirth(rs.getString(5));
				mList.add(member);*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mList;
	}

	public Member select_login(String inputId, String inputPw) {
		
		Connection con = getConnection();
		
		Member loginMember = null;
		
		if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 
		
		String sql = "select * from members "+ "where mid=? and mpw=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, inputId);
			pst.setString(2, inputPw);
			
			ResultSet rs = pst.executeQuery();
		
			while(rs.next()) {
				loginMember = new Member();
				loginMember.setMid(rs.getString(1));
				loginMember.setMpw(rs.getString(2));
				loginMember.setMstate(rs.getString("mstate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return loginMember;
	}

	public String select_idcheck(String id) {
Connection con = getConnection();
		

	    String idCheck = null;
	    
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 

	    String sql = "select mid from members "+ "where mid=?";
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,id);
			 ResultSet rs= pst.executeQuery();
			 while(rs.next()) {
				idCheck=rs.getString(1); 
			 } // id가 중복이면 while문이 실행 안됨 
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return idCheck;
	}

	public ArrayList<Goods> selectGoods_all() {

Connection con = getConnection();
		
		
		if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 
		
		String sql = "select * from goods "+"where gstock > 0";
		ArrayList<Goods> gList = new ArrayList<Goods>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			
				Goods goods = new Goods();
				
				goods.setGcode(rs.getString("gcode"));
				goods.setGname(rs.getString("gname"));
				goods.setGprice(rs.getInt("gprice"));
				goods.setGtype(rs.getString("gtype"));
				goods.setGstock(rs.getInt("gstock"));
				goods.setGstate(rs.getString("gstate"));
				gList.add(goods);
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gList;
	}

	public ArrayList<Goods> selectGtype() {
	
	    Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 
	    
	    String sql = "select gtype from goods group by gtype";
	    ArrayList<Goods> gtypeList = new ArrayList<Goods>();
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setGtype(rs.getString("gtype"));
				gtypeList.add(goods);
			}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gtypeList;
	}
	
	
	public ArrayList<Goods> selectGoods_type(String gtype) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 
	    
	    String sql = "select * from goods where gtype = ? and gstock > 0";
	    ArrayList<Goods> goodsList = new ArrayList<Goods>();
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, gtype);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGcode(rs.getString("gcode"));
				goods.setGname(rs.getString("gname"));
				goods.setGprice(rs.getInt("gprice"));
				goods.setGtype(rs.getString("gtype"));
				goods.setGstock(rs.getInt("gstock"));
				goodsList.add(goods);
			}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return goodsList;
	}

	public ArrayList<Goods> selectGoods_best() {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
	    }
			String sql="select * from goods gd inner join (select odgcode, sum(odqty) as totalqty from orders group by odgcode) od "+
	    "on gd.gcode=od.odgcode order by od.totalqty desc";
			
			ArrayList<Goods> goodsList  = new ArrayList<Goods>();
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Goods goods = new Goods();
					goods.setGcode(rs.getString("gcode"));
					goods.setGname(rs.getString("gname"));
					goods.setGprice(rs.getInt("gprice"));
					goods.setGtype(rs.getString("gtype"));
					goods.setGstock(rs.getInt("gstock"));
					goodsList.add(goods);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return goodsList;
	}

	public String selectMaxOdcode() {
Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 
	    
	    String sql="select nvl(max(odcode),'O0000') "+"from orders";
	    String maxOdcode=null;
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				maxOdcode=rs.getString(1);
			}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return maxOdcode;
	}

	public int insertOrder(Order od) {
Connection con = getConnection();
	
	    
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}
	    int insertResult =0;
	    String sql="insert into orders(odcode,odmid,odgcode,odqty,oddate) "
	    +"values(?,?,?,?,sysdate)";
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, od.getOdcode());
			pst.setString(2, od.getOdmid());
			pst.setString(3, od.getOdgcode());
			pst.setInt(4, od.getOdqty());
			insertResult=pst.executeUpdate();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return insertResult;
	}

	public int updateGoods(String odgcode, int odqty) {
Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}
	    
	    String sql = "update goods "+ "set gstock = gstock - ? "+"where gcode = ?";
	    int updateResult = 0;
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, odqty);
			pst.setString(2, odgcode);
			updateResult=pst.executeUpdate();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateResult;
	}

	public ArrayList<HashMap<String, String>> selectGoods_Map() {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		}
	    
	    
	    String sql = "select * from goods";
	    ArrayList<HashMap<String, String>> goodsList = new ArrayList<>();
	    try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				HashMap<String, String> goods = new HashMap<String,String>();
			goods.put("gcode", rs.getString("gcode"));
			goods.put("gname", rs.getString("gname"));
			goods.put("gprice", rs.getString("gprice"));
			goods.put("gtpye", rs.getString("gtype"));
			goods.put("gstock", rs.getString("gstock"));
			
			goodsList.add(goods);
			}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodsList;
	}

	public int selectCountOrder(String loginId) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}		
	    
	    int countResult = 0;
	    
	    String sql="select count(*) "+"from orders "+"where odmid=?";
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loginId); // 첫번쩨 물음표에 대입
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				countResult=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    return countResult;
	    
	    
	}

	public int selectTotalOrder(String loginId) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}	
	    
	    int sumResult =0;
	    
	    String sql = "select sum(gd.gprice*od.odqty) "
	    +"from orders od, goods gd "
	    		+"where (od.odgcode=gd.gcode) and (od.odmid = ?) ";
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loginId);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				sumResult=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return sumResult;
	}

	public ArrayList<HashMap<String, String>> selectOrders_Map(String loginId, int selectOption) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		}	
	    
	    String sql = "select od.odcode, gd.gcode, gd.gname, gd.gprice, od.odqty, (gd.gprice*od.odqty) as totalprice, od.oddate "+
	    "from orders od inner join goods gd on (od.odgcode=gd.gcode) "+
	    		"where od.odmid=?";
	    
	    if(selectOption == 1) {
	    	sql+="order by od.oddate desc";
	    }
	    else if(selectOption == 2) {
	    	sql+="order by totalprice desc";
	    }
	    else {
	    	System.out.println("");
	    }
	   
	    ArrayList<HashMap<String, String>> orderList = new ArrayList<>();
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loginId);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				HashMap<String, String> orderInfo = new HashMap<>();
				orderInfo.put("odcode", rs.getString("odcode")); 
				// od.odcode 가 아님 테이블의 컬럼명이 odcode이므로 odcode라 써야된다
				orderInfo.put("gname", rs.getString("gname")); 
				orderInfo.put("gprice", rs.getString("gprice")); 
				orderInfo.put("odqty", rs.getString("odqty")); 
				orderInfo.put("totalprice", rs.getString("totalprice"));
				orderInfo.put("oddate", rs.getString("oddate"));
				orderInfo.put("gcode", rs.getString("gcode"));
				orderList.add(orderInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
		return orderList;
	}

	public int cancelOrder(String odcode, int gstock, String gcode) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}
	    
	    int deleteResult = 0;
	    int updateResult=0;
	    
	    String delsql = "delete from orders where odcode = ?";
	    String upsql = "update goods set gstock=gstock+? where gcode=?";
	    
	    try {
	    	con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(delsql);
			pst.setString(1, odcode);
			deleteResult=pst.executeUpdate();
			
			pst = con.prepareStatement(upsql);
			pst.setInt(1, gstock);
			pst.setString(2, gcode);
			updateResult=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    int result=0;
	    
	    try {
			if(deleteResult > 0 && updateResult > 0) {
				con.commit();
				result = 1;
				
			}else {
				con.rollback();
			}
		} catch (Exception e) {
			
		}
	    
		return result;
	}





	
	


	
}
