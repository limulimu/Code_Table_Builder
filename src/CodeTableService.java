import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import weka.core.Instances;

public class CodeTableService  implements ICodeTableService {

	public int saveCodeTable(List<CodeTable> listColdeTable,Connection conn) throws ClassNotFoundException, SQLException
	{
	    for (CodeTable ct : listColdeTable)
        {
            String[] contant=new String[7];   
            contant[0]=Integer.toString(ct.getId());
            contant[1]=ct.getEventCode();
            contant[2]=ct.getRangeFrom();
            contant[3]=ct.getvType();
            contant[4]=ct.getLevel();
            contant[5]=ct.getFeatureName();
            contant[6]=ct.getEventName();
            Insert_Code_Table ict=new Insert_Code_Table();
            ict.insert(contant,conn);
	    	//System.out.println(ct.getEventCode());
        }
	   return 0;
	}
	public List<CodeTable> genCodeTable(String tableName, String Column,
			String binNum,Connection conn) {
		Weka_DB_Access db=new Weka_DB_Access();
		Instances ForDiscretize;
		  List<CodeTable> ct=new ArrayList<CodeTable>() ;
		try
		{
		String qString="select "+Column+" from "+tableName;
		ForDiscretize= db.GetInstancesFromSQL(qString,conn);
	
		Weka_Discretize dis=new Weka_Discretize();
		Instances Discretized;
		Discretized=dis.DiscretizeInstances(ForDiscretize);
		
//		for(int i=0;i<Discretized.numAttributes();i++)
//		{
//			if(Discretized.attribute(i).numValues()>1)
//				 System.out.println(Discretized.attribute(i).name());
//		}
//		
//		
		
		
		
		Num_Ranked_Coding cd=new Num_Ranked_Coding();
		
		List<String> codeTableRang= cd.ProcessByRank(Discretized);
	
		 Iterator it=codeTableRang.iterator();
         int ttt=0;
	        while(it.hasNext())
	        {
	          String value=(String)it.next();
	          ttt++;
	          CodeTable codeTable1=new CodeTable();
	        
	          codeTable1.setFeatureName(ForDiscretize.attribute(ttt-1).name());
	          codeTable1.setEventCode(Integer.toString(ttt+100));
	          codeTable1.setEventName("Transaction");
	          codeTable1.setId(ttt+100);
	          codeTable1.setLevel("2");
	          if(ForDiscretize.attribute(ttt-1).isNumeric())
	          {
	        	  codeTable1.setvType("2");
	        	  codeTable1.setRangeFrom("0,"+value);
	          }
	          else 
	          {
				codeTable1.setvType("1");
				  codeTable1.setRangeFrom(","+value);
	          }
	          ct.add(codeTable1);
	         // System.out.println(ttt+"*" +value);
	        }
	        CodeTable codeTable2=new CodeTable();
	        codeTable2.setFeatureName("1");
	          codeTable2.setEventCode("1");
	          codeTable2.setEventName("Transaction");
	          codeTable2.setId(1);
	          codeTable2.setLevel("1");
	          codeTable2.setvType("1");
        	  codeTable2.setRangeFrom("1");
	         ct.add(codeTable2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return ct; 
	}
	
}
