 import java.io.*;
import weka.core.*;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;
import weka.core.Instance;
import weka.core.Instances;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Num_Ranked_Coding {

	public List<String> ProcessByRank(Instances input)
	{
		TransFormString ts=new TransFormString();
		List<String> Code=new ArrayList<String>();		
		for(int i=0;i<input.numAttributes();i++)
		{
			if(input.attribute(i).numValues()>5)
			{
						
				int [] valueCount=new int[input.attribute(i).numValues()];
				int [] valueCountP=new int[input.attribute(i).numValues()];
			//	for(int j=0;j<input.attribute(i).numValues();j++)
			//	{
					Enumeration<?> enumInsts = input.enumerateInstances();
					while (enumInsts.hasMoreElements()) 
					{
						Instance instance = (Instance) enumInsts.nextElement();
						String s1=instance.stringValue(i);
						for(int j=0;j<input.attribute(i).numValues();j++)
						{
							String s2=input.attribute(i).value(j).toString();
							if(s1.equals(s2))
								valueCount[j]++;
						}
					}
					valueCountP=(int[]) valueCount.clone();
					Arrays.sort(valueCount);
					int restrict=0;
					String output="";
					for(int m=valueCount.length-5;m<valueCount.length;m++)
					{
						
						for(int n=0;n<valueCountP.length;n++)
						{
							
							if(valueCountP[n]==valueCount[m] && restrict<5)
							{
								restrict=restrict+1;
								output+=ts.Transform(input.attribute(i).value(n).toString());
							//	System.out.print(input.attribute(i).value(n).toString());
							}
						}
						
						
						
					}
			//	}
				//System.out.println(output);
					//if(!output.equals(""))
					Code.add(output);
			}
			else {
				String into="";
				for(int j=1;j<input.attribute(i).numValues();j++)
				{
					into+=ts.Transform(input.attribute(i).value(j).toString());
					
				}
			//	System.out.println(into);
				//if(!into.equals(""))
				Code.add(into);
			}
		}
		return Code;
	}
}
