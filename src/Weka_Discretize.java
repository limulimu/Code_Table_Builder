 import java.io.*;
import weka.core.*;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;
import weka.core.Instance;
import weka.core.Instances;
public class Weka_Discretize {
	
	public Instances DiscretizeInstances(Instances input) throws Exception
	{
		
	     Instances     output = null;
	     Discretize    filter;
	 
	     // load data (class attribute is assumed to be last attribute)
	     input.setClassIndex(input.numAttributes()-1);
	    
	     // setup filter
	     filter = new Discretize();
	     String[] option={"-E","-K","-RFirst-Last"};
	     filter.setOptions(option);
	     filter.setInputFormat(input);
	 
	     // apply filter
	    
	     output = Filter.useFilter(input, filter);
	    
	 
	    return output;
		
	}

}
