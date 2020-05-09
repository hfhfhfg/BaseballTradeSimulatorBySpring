package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import dto.PitcherDto;
import dto.PlayerDto;

public class PitcherDao {
   DataSource dataSource;

   public PitcherDao() {
      try {
         Context context = new InitialContext();
         dataSource = (DataSource) context.lookup("java:comp/env/jdbc/final");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   //
   public ArrayList<PitcherDto> getPitcherList(int team) {
      ArrayList<PitcherDto> pdtos = new ArrayList<PitcherDto>();

      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = dataSource.getConnection();

         String query = "select idx, name, position, result from player_pitcher_2019 where team = ? order by name";
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, team);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            int idx = rs.getInt("idx");
            String name = rs.getString("name");
            String position = rs.getString("position");
            double result = rs.getDouble("result");

            PitcherDto pdto = new PitcherDto(idx, name, position, result);

            pdtos.add(pdto);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (rs != null)
               rs.close();
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return pdtos;

   }

public ArrayList<PitcherDto> getPitcherDetailInfo(int teamIdx, int idx) {
	ArrayList<PitcherDto> alpdto = new ArrayList<PitcherDto>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		conn = dataSource.getConnection();

		String query = "select player_pitcher_2019.idx, player_pitcher_2019.name, player_pitcher_2019.position, player_pitcher_2019.result from player_pitcher_2019 where player_pitcher_2019.team = "
				+ teamIdx + " and player_pitcher_2019.idx = " + idx + "";
		pstmt = conn.prepareStatement(query);
//		pstmt.setInt(1, teamIdx);
		System.out.println(query);

		rs = pstmt.executeQuery();
		while (rs.next()) {
			int idx2 = rs.getInt("idx");
			String name = rs.getString("name");
			String position = rs.getString("position");
			double result2 = rs.getDouble("result");

			PitcherDto pdto = new PitcherDto(idx2, name, position, result2);
			alpdto.add(pdto);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return alpdto;
}
public ArrayList<PitcherDto> getPitcherList_2019(int team) {
    ArrayList<PitcherDto> pdtos = new ArrayList<PitcherDto>();

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
       conn = dataSource.getConnection();

       String query = "select idx, name, position, result from player_pitcher_2019 where team = ?";
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, team);

       rs = pstmt.executeQuery();

       while (rs.next()) {
          int idx = rs.getInt("idx");
          String name = rs.getString("name");
          String position = rs.getString("position");
          double result = rs.getDouble("result");

          PitcherDto pdto = new PitcherDto(idx, name, position, result);

          pdtos.add(pdto);
       }
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       try {
          if (rs != null)
             rs.close();
          if (pstmt != null)
             pstmt.close();
          if (conn != null)
             conn.close();
       } catch (Exception e2) {
          e2.printStackTrace();
       }
    }
    return pdtos;

 }

public void tradePitcherToPitcher(int tname, int tname2, int idx, int idx2) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = dataSource.getConnection();

		String query = "update player_pitcher_2019 set team = ? where team = ? and idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, tname2);
		pstmt.setInt(2, tname);
		pstmt.setInt(3, idx);
		

		pstmt.executeUpdate();
		
		query = "update player_pitcher_2019 set team = ? where team = ? and idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, tname);
		pstmt.setInt(2, tname2);
		pstmt.setInt(3, idx2);

		pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}  finally {
	       try {
	           
	           if (pstmt != null)
	              pstmt.close();
	           if (conn != null)
	              conn.close();
	        } catch (Exception e2) {
	           e2.printStackTrace();
	        }
	}

	
	
}

public void tradePitcher(int tname, int tname2, int idx) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = dataSource.getConnection();

		String query = "update player_pitcher_2019 set team = ? where team = ? and idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, tname2);
		pstmt.setInt(2, tname);
		pstmt.setInt(3, idx);
		

		pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}  finally {
	       try {
	           
	           if (pstmt != null)
	              pstmt.close();
	           if (conn != null)
	              conn.close();
	        } catch (Exception e2) {
	           e2.printStackTrace();
	        }
	}

	
}

public double get2018TeamPitcherStat(int team) {
    double pitcherStat = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
       conn = dataSource.getConnection();

       String query = "select sum(result) from player_pitcher_2018 where team = ?";
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, team);

       rs = pstmt.executeQuery();

       while (rs.next()) {
          String sum = rs.getString(1);
          pitcherStat = Double.parseDouble(sum);
       }
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       try {
          if (rs != null)
             rs.close();
          if (pstmt != null)
             pstmt.close();
          if (conn != null)
             conn.close();
       } catch (Exception e2) {
          e2.printStackTrace();
       }
    }
    return pitcherStat;
 }
 
 public double get2019TeamPitcherStat(int team) {
    double pitcherStat = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
       conn = dataSource.getConnection();

       String query = "select sum(result) from player_pitcher_2019 where team = ?";
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, team);

       rs = pstmt.executeQuery();

       while (rs.next()) {
          String sum = rs.getString(1);
          pitcherStat = Double.parseDouble(sum);
       }
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       try {
          if (rs != null)
             rs.close();
          if (pstmt != null)
             pstmt.close();
          if (conn != null)
             conn.close();
       } catch (Exception e2) {
          e2.printStackTrace();
       }
    }
    return pitcherStat;
 }

public void reset2019() {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = dataSource.getConnection();

		String query = "drop table if exists final.player_pitcher_2019;";
		pstmt = conn.prepareStatement(query);
				
		pstmt.executeUpdate();
		
		query = "create table player_pitcher_2019 (select * from player_pitcher_2018)";
		pstmt = conn.prepareStatement(query);
		
		pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
	       try {
	           
	           if (pstmt != null)
	              pstmt.close();
	           if (conn != null)
	              conn.close();
	        } catch (Exception e2) {
	           e2.printStackTrace();
	        }
	}

	
}

public double getResult_2018(int idx2) {
	
	 double pitcherStat = 0;

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	       conn = dataSource.getConnection();

	       String query = "select result from player_pitcher_2018 where idx = ?";
	       pstmt = conn.prepareStatement(query);
	       pstmt.setInt(1, idx2);

	       rs = pstmt.executeQuery();

	       while (rs.next()) {
	          String sum = rs.getString(1);
	          System.out.println("getReusltToString : " + sum);
	          System.out.println("getResultToDouble :" +rs.getDouble(1));
	          pitcherStat = Double.parseDouble(sum);
	       }
	    } catch (Exception e) {
	       e.printStackTrace();
	    } finally {
	       try {
	          if (rs != null)
	             rs.close();
	          if (pstmt != null)
	             pstmt.close();
	          if (conn != null)
	             conn.close();
	       } catch (Exception e2) {
	          e2.printStackTrace();
	       }
	    }
	    return pitcherStat;
	 }

public void updateResult_2019(int idx2, double result) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = dataSource.getConnection();

		String query = "update player_pitcher_2019 set result = ? where idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setDouble(1, result);
		pstmt.setInt(2, idx2);
		

		pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}  finally {
	       try {
	           
	           if (pstmt != null)
	              pstmt.close();
	           if (conn != null)
	              conn.close();
	        } catch (Exception e2) {
	           e2.printStackTrace();
	        }
	}

	
}

public String getPlayerName(int idx) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String name ="";

	try {
		conn = dataSource.getConnection();

		String query = "select name from player_pitcher_2019 where idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, idx);
		System.out.println(query);
		

		rs = pstmt.executeQuery();
		while (rs.next()) {
			name = rs.getString("name");

		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return name;

}
}