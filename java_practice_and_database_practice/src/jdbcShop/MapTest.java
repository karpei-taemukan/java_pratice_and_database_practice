package jdbcShop;

import java.util.ArrayList;
import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		
		// key, value 쌍으로 데이터를 저장
		 ArrayList<HashMap<String, String>> odList = new ArrayList<HashMap<String, String>>();

		 HashMap<String/*key type*/, String/*value type*/> odInfo=new HashMap<>();
		 		 
		 // put(key, value); 
		// odInfo.put("gname", rs.getString("gname"));
		 //odInfo.put("gprice", rs.getInt(1500)+"");
		 //odInfo.put("odqty", rs.getInt("odqty")+"");
		 // get(key);
		 odList.add(odInfo);
		 
		 System.out.println("상품이름: " + odInfo.get("gname"));
		 System.out.println("주문수량: " + odInfo.get("odqty"));
	}

}
