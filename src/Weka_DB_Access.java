import java.sql.Connection;

import weka.core.Instances;
import weka.experiment.InstanceQuery;
public class Weka_DB_Access {
	public Instances GetInstancesFromSQL(String sql,Connection conn) throws Exception
	{
		InstanceQuery query = new InstanceQuery();
		//query.setQuery(sql);
		 Instances data = query.retrieveInstances(sql,conn);
		 return data;
	}

}
