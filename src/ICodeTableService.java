
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Yuming Ou
 *
 */
public interface ICodeTableService {

	/**
	 * generate CodeTable for a given table
	 * @param tableName table name
	 * @param Column columns that are used for CodeTable generation, separated by comma
	 * @param binNum number of bin for each column, separated by comma
	 * @return
	 */
	public List<CodeTable> genCodeTable(String tableName, String Column, String binNum,Connection conn);
	
	public int saveCodeTable(List<CodeTable> listColdeTable,Connection conn) throws ClassNotFoundException, SQLException;
}
