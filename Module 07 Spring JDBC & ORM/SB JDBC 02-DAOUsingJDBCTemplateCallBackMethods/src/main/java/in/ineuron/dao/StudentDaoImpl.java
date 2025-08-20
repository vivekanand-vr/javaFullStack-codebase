package in.ineuron.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;

@Repository
public class StudentDaoImpl implements IStudentDao {

	private static final String GET_STUDENT_BY_NO = "SELECT SID,SNAME,AVG,SADDRESS FROM PLAYERS WHERE SID=?";
	private static final String GET_STUDENT_BY_NAME = "SELECT SID,SNAME,AVG,SADDRESS FROM PLAYERS WHERE SNAME IN (?,?)";
	private static final String GET_STUDENT_BY_CITY = "SELECT SID,SNAME,AVG,SADDRESS FROM PLAYERS WHERE SADDRESS IN (?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public StudentBO getStudentByNo(int sno) {
		return jdbcTemplate.queryForObject(GET_STUDENT_BY_NO, new BeanPropertyRowMapper<StudentBO>(StudentBO.class),
				sno);

	}

	@Override
	public List<StudentBO> getStudentByName(String name1, String name2) {
		List<StudentBO> listBO = jdbcTemplate.query(GET_STUDENT_BY_NAME, (rs, num) -> {
			System.out.println("StudentDaoImpl.StudentMapper.mapRow()");
			StudentBO bo = null;
			bo = new StudentBO();
			bo.setSid(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setAvg(rs.getFloat(3));
			bo.setSaddress(rs.getString(4));
			return bo;
		}, name1, name2);
		System.out.println(listBO);
		return listBO;
	}

	@Override
	public List<StudentBO> fetchStudentByCitites(String city1, String city2, String city3) {
		
		/*	Approach one: ResultSetExtractor
		 * ---------------------------------
		 * 
			 * return jdbcTemplate.query(GET_STUDENT_BY_CITY, new
			 * ResultSetExtractor<List<StudentBO>>() {
			 * 
			 * @Override public List<StudentBO> extractData(ResultSet rs) throws
			 * SQLException, DataAccessException { List<StudentBO> bo = null; bo = new
			 * ArrayList<StudentBO>();
			 * 
			 * StudentBO stdBo =null; while (rs.next()) { stdBo = new StudentBO();
			 * stdBo.setSid(rs.getInt(1)); stdBo.setSname(rs.getString(2));
			 * stdBo.setAvg(rs.getFloat(3)); stdBo.setSaddress(rs.getString(4));
			 * bo.add(stdBo); }
			 * 
			 * return bo; } }, city1, city2, city3);
		 */

		
		/*	
		 * 	Approach two: ResultSetExtractor shortened
		 * ---------------------------------------------
		 * 
			 * return jdbcTemplate.query(GET_STUDENT_BY_CITY, new
			 * RowMapperResultSetExtractor<StudentBO>(new
			 * BeanPropertyRowMapper<StudentBO>(StudentBO.class)), city1, city2, city3);
		 */

		List<StudentBO> listBo = new ArrayList<StudentBO>();
		jdbcTemplate.query(GET_STUDENT_BY_CITY, new RowCallbackHandler() {
			
			/*
			 *  Anonymous implementation to the RowCallbackHandler()
			 */
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				System.out.println(
				"StudentDaoImpl.fetchStudentByCitites(...).new RowCallbackHandler() {...}.processRow()");
				
				/* all objects that comes in result set are looped, performed all 
				 *	the actions here and given
				 */
				
				StudentBO bo = new StudentBO();
				bo.setSid(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setAvg(rs.getFloat(3));
				bo.setSaddress(rs.getString(4));
				listBo.add(bo);
			}
		}, city1, city2, city3);
		return listBo;
	}

}
