 import java.io.*;
import weka.core.*;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;
import weka.core.Instance;
import weka.core.Instances;
public class Transforation {

	public void Transfrom(Instances Discretized)
	{
		for(int i=0;i<Discretized.numAttributes();i++)
			{
				for(int j=1;j<Discretized.attribute(i).numValues();j++)
				{
					String into=Discretized.attribute(i).value(j).toString();
					into=into.replace('(', ' ');
					into=into.replace('\'', ' ');
					into=into.replace(']', ' ');
					String[] s=into.trim().split("-");
					if(j!=Discretized.attribute(i).numValues()-1)
						System.out.print(s[0]+",");
					else
						System.out.print(s[0]);	
					//System.out.print(Discretized.attribute(i).value(j).toString()+"*");
				}
				System.out.println();
			}
	}
}
