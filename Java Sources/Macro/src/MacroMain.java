import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class MacroMain {

	 String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	 String id = "LEE";
	 String pwd = "1234";
	 Connection conn;
	 
	/*public static void main(String[] args) {
		// TODO Auto-generated method 	stub
		new MacroMain();
	}*/
	
	public MacroMain(){
		 try {
		       Class.forName("oracle.jdbc.driver.OracleDriver");
		       conn = DriverManager.getConnection(dbUrl, id, pwd);
		       PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MARKET_PRICE VALUES('LG',?,?,?,TO_TIMESTAMP(?,'YYYYMMDDHH24:MI:SS'))");		        
		       
		       
		       String lg[]={"옵티머스 2X"	,
		    		   "옵티머스 3D"	,
		    		   "옵티머스 3D 큐브"	,
		    		   "옵티머스 마하"	,
		    		   "옵티머스 뷰"	,
		    		   "옵티머스 뷰 II	"	,
		    		   "옵티머스 블랙"	,
		    		   "옵티머스 빅"	,
		    		   "옵티머스 시크"	,
		    		   "옵티머스 원"	,
		    		   "옵티머스 EX"	,
		    		   "옵티머스 F7"	,
		    		   "옵티머스 G"	,
		    		   "옵티머스 G Pro"	,
		    		   "옵티머스 GK"	,
		    		   "옵티머스 L7"	,
		    		   "옵티머스 L9"	,
		    		   "옵티머스 LTE"	,
		    		   "옵티머스 LTE II"	,
		    		   "옵티머스 LTE TAG"	,
		    		   "옵티머스 Q"	,
		    		   "옵티머스 Q2"	,
		    		   "옵티머스 Z"	,
		    		   "LG F70"	,
		    		   "LG G Flex"	,
		    		   "LG G Flex 2"	,
		    		   "LG G Pro 2"	,
		    		   "LG G Stylo"	,
		    		   "LG G2"	,
		    		   "LG G3"	,
		    		   "LG G3 A"	,
		    		   "LG G3 Beat"	,
		    		   "LG G3 Cat.6"	,
		    		   "LG G3 Screen"	,
		    		   "LG G4"	,
		    		   "LG G5"	,
		    		   "LG G6"	,
		    		   "LG Gx"	,
		    		   "LG Gx2"	,
		    		   "LG K10"	,
		    		   "LG L70"	,
		    		   "LG Q6"	,
		    		   "LG Q8"	,
		    		   "LG V10"	,
		    		   "LG V20"	,
		    		   "LG V30"	,
		    		   "LG V30+"	,
		    		   "LG Vu 3"	,
		    		   "LG X Cam"	,
		    		   "LG X Power"	,
		    		   "LG X Screen"	,
		    		   "LG X Skin"	,
		    		   "LG X300"	,
		    		   "LG X400"	,
		    		   "LG X5"	,
		    		   "LG X500"	};
		       
		       String samsung[]={"삼성 갤럭시 (I7500)"	,
		    		   "삼성 갤럭시 골든"	,
		    		   "삼성 갤럭시 네오"	,
		    		   "삼성 갤럭시 라이트"	,
		    		   "삼성 갤럭시 뮤직"	,
		    		   "삼성 갤럭시 미니 2"	,
		    		   "삼성 갤럭시 미니"	,
		    		   "삼성 갤럭시 빔 (I8520)"	,
		    		   "삼성 갤럭시 빔 (I8530)"	,
		    		   "삼성 갤럭시 빔 2"	,
		    		   "삼성 갤럭시 스타 프로"	,
		    		   "삼성 갤럭시 스타"	,
		    		   "삼성 갤럭시 스피카"	,
		    		   "삼성 갤럭시 아폴로"	,
		    		   "삼성 갤럭시 에이스 2"	,
		    		   "삼성 갤럭시 에이스 3"	,
		    		   "삼성 갤럭시 에이스 4 라이트"	,
		    		   "삼성 갤럭시 에이스 4"	,
		    		   "삼성 갤럭시 에이스 듀오스"	,
		    		   "삼성 갤럭시 에이스 플러스"	,
		    		   "삼성 갤럭시 에이스"	,
		    		   "삼성 갤럭시 엑스커버 2"	,
		    		   "삼성 갤럭시 엑스커버 3"	,
		    		   "삼성 갤럭시 엑스커버"	,
		    		   "삼성 갤럭시 영 2"	,
		    		   "삼성 갤럭시 영	",
		    		   "삼성 갤럭시 윈	",
		    		   "삼성 갤럭시 유로파"	,
		    		   "삼성 갤럭시 익스프레스 2"	,
		    		   "삼성 갤럭시 익스프레스"	,
		    		   "삼성 갤럭시 지오"	,
		    		   "삼성 갤럭시 챗"	,
		    		   "삼성 갤럭시 코어 2"	,
		    		   "삼성 갤럭시 코어 세이프"	,
		    		   "삼성 갤럭시 코어 어드밴스"	,
		    		   "삼성 갤럭시 코어 프라임"	,
		    		   "삼성 갤럭시 코어 LTE"	,
		    		   "삼성 갤럭시 코어"	,
		    		   "삼성 갤럭시 트렌드 2"	,
		    		   "삼성 갤럭시 트렌드 3"	,
		    		   "삼성 갤럭시 트렌드"	,
		    		   "삼성 갤럭시 팝"	,
		    		   "삼성 갤럭시 페임"	,
		    		   "삼성 갤럭시 포켓 네오"	,
		    		   "삼성 갤럭시 포켓"	,
		    		   "삼성 갤럭시 프로"	,
		    		   "삼성 갤럭시 프리미어"	,
		    		   "삼성 갤럭시 피트"	,
		    		   "삼성 갤럭시 A"	,
		    		   "삼성 갤럭시 A3"	,
		    		   "삼성 갤럭시 K 줌"	,
		    		   "삼성 갤럭시 K"	,
		    		   "삼성 갤럭시 M 스타일"	,
		    		   "삼성 갤럭시 M 프로"	,
		    		   "삼성 갤럭시 R 스타일"	,
		    		   "삼성 갤럭시 R"	,
		    		   "삼성 갤럭시 S 듀오스"	,
		    		   "삼성 갤럭시 S 어드밴스트"	,
		    		   "삼성 갤럭시 S 플러스"	,
		    		   "삼성 갤럭시 S2 듀오스"	,
		    		   "삼성 갤럭시 S2 플러스"	,
		    		   "삼성 갤럭시 S3 미니"	,
		    		   "삼성 갤럭시 S4 미니"	,
		    		   "삼성 갤럭시 S4 줌"	,
		    		   "삼성 갤럭시 S5 미니"	,
		    		   "삼성 갤럭시 SL"	,
		    		   "삼성 갤럭시 U"	,
		    		   "삼성 갤럭시 W"	,
		    		   "삼성 갤럭시 Y 듀오스"	,
		    		   "삼성 갤럭시 Y 프로 듀오스"	,
		    		   "삼성 갤럭시 Y 프로"	,
		    		   "삼성 갤럭시 Y 플러스"	,
		    		   "삼성 갤럭시 Y"	};
		       
		       
		       
		       
		       String apple[]={	"아이폰",	
		    			"아이폰 3G",	
		    			"아이폰 3GS",
		    			"아이폰 4",
		    			"아이폰 4S",	
		    			"아이폰 5",	
		    			"아이폰 5C",	
		    			"아이폰 5S",	
		    			"아이폰 6",
		    			"아이폰 6 플러스",	
		    			"아이폰 6S",
		    			"아이폰 6S 플러스",
		    			"아이폰 SE",
		    			"아이폰 7",
		    			"아이폰 7 플러스"};
		       
		       String itemClasses[]={"A","B","C"};
		       	       
		       
		       String date="";
		       
		       int maxIter=600;
		       
		       
		       
		       
		       
		       String itemNames[]=lg;
		       
		       for(int i=8;i<=12;i++){
		    	   for(int j=1;j<=30;j++){		    		   
		    		   date="";
		    		   if(Math.random()>0.3){
		    			   date=String.valueOf(i);
		    			   if(i<10){
		    				   date="0"+date;
		    			   }		    			   
		    			   if(j<10){
		    				   date=date+"0";
		    			   }
		    			   date=date+String.valueOf(j);
		    			   date=date+"00:00:00";
		    			   date="2016"+date;
		    			   
		    			  for(int k=0;k<maxIter;k++){
		    				 String itemName=itemNames[(int)(Math.random()*itemNames.length)].trim();
		    				 pstmt.setString(1, itemName);
		    				 String itemClass=itemClasses[(int)(Math.random()*itemClasses.length)];
		    				 pstmt.setString(2,itemClass);
		    				 
		    				 Random rd = new Random();
		    				 int itemCurPrice=(int)(rd.nextGaussian()*5000)+300000;
		    				 pstmt.setInt(3, itemCurPrice);
		    				 
		    				 pstmt.setString(4, date);
		    				 pstmt.executeUpdate();
		    				 
		    			  }
		    		   }
		    	   }
		       }
		        
		       
		       
		       
		       
		       
		       date="";
		       
		       for(int i=1;i<=8;i++){
		    	   int max=30;
		    	   if(i==2){
		    		   max=28;
		    	   }
		    	   for(int j=1;j<=max;j++){		    		   
		    		   date="";
		    		   if(Math.random()>0.3){
		    			   date=String.valueOf(i);
		    			   if(i<10){
		    				   date="0"+date;
		    			   }		    			   
		    			   if(j<10){
		    				   date=date+"0";
		    			   }
		    			   date=date+String.valueOf(j);
		    			   date=date+"00:00:00";
		    			   date="2017"+date;
		    			   
		    			  for(int k=0;k<maxIter;k++){
		    				 String itemName=itemNames[(int)(Math.random()*itemNames.length)].trim();
		    				 pstmt.setString(1, itemName);
		    				 String itemClass=itemClasses[(int)(Math.random()*itemClasses.length)];
		    				 pstmt.setString(2,itemClass);
		    				 
		    				 Random rd = new Random();
		    				 int itemCurPrice=(int)(rd.nextGaussian()*10000)+270000;
		    				 pstmt.setInt(3, itemCurPrice);
		    				 
		    				 pstmt.setString(4, date);
		    				 pstmt.executeUpdate();
		    				 
		    			  }
		    		   }
		    	   }
		       }
		       
		       
		       
		       
		       
		       
		       date="";
		       
		       for(int i=9;i<=9;i++){
		    	   int max=25;
		    	  
		    	   for(int j=1;j<=max;j++){		    		   
		    		   date="";
		    		   if(Math.random()>0.3){
		    			   date=String.valueOf(i);
		    			   if(i<10){
		    				   date="0"+date;
		    			   }		    			   
		    			   if(j<10){
		    				   date=date+"0";
		    			   }
		    			   date=date+String.valueOf(j);
		    			   date=date+"00:00:00";
		    			   date="2017"+date;
		    			   
		    			  for(int k=0;k<maxIter;k++){
		    				 String itemName=itemNames[(int)(Math.random()*itemNames.length)].trim();
		    				 pstmt.setString(1, itemName);
		    				 String itemClass=itemClasses[(int)(Math.random()*itemClasses.length)];
		    				 pstmt.setString(2,itemClass);
		    				 
		    				 Random rd = new Random();
		    				 int itemCurPrice=(int)(rd.nextGaussian()*10000)+150000;
		    				 pstmt.setInt(3, itemCurPrice);
		    				 
		    				 pstmt.setString(4, date);
		    				 pstmt.executeUpdate();
		    				 
		    			  }
		    		   }
		    	   }
		       }
		       
		       
		       
		       
		       
		       
		       pstmt.close();
		       
		       
		       
		       
		       
		       
		       
		       
		       
		       
		       
		       
		       
		       
		       
		        
		       
		        
		        
		        
		        
				 conn.close();
		 } catch (Exception e) {
		       e.printStackTrace();
		 }
		 
		 
		
	}

}
