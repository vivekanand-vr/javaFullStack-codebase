package in.ineuron.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
		System.out.println("StudentGenerator.generate()");
		String id = " ";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = si.connection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select sid_seq.nextval from dual");
			while (resultSet.next()) {
				int i = resultSet.getInt(1);

				if (i <= 9)
					id = "C00" + i;
				else if (i > 9 && i <= 99)
					id = "C0" + i;
				else
					id = "C" + i;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
