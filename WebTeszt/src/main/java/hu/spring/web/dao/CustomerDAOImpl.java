package hu.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import hu.spring.web.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private JdbcTemplate jdbcTemplate;

	public CustomerDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		if (customer.getVasarloID() > 0) {

			String sql = "UPDATE vasarlo SET Vasarlo_nev=?, Vasarlo_pont=?, Vasarlot_osszeg=?, "
					+ "Vasarlo_adatok=? WHERE Vasarlo_id=?";
			jdbcTemplate.update(sql, customer.getVasarloNev(), customer.getVasarloPont(), customer.getVasarlotOsszeg(),
					customer.getVasarloAdatok(), customer.getVasarloID());
		} else {
			
			String sql = "INSERT INTO vasarlo (Vasarlo_nev, Vasarlo_pont, Vasarlot_osszeg, Vasarlo_adatok)"
					+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, customer.getVasarloNev(), customer.getVasarloPont(), customer.getVasarlotOsszeg(),
					customer.getVasarloAdatok());
		}

	}

	@Override
	public void delete(int customerId) {
		String sql = "DELETE FROM vasarlo WHERE Vasarlo_id=?";
		jdbcTemplate.update(sql, customerId);

	}

	@Override
	public Customer get(int customerId) {
		String sql = "SELECT * FROM vasarlo WHERE Vasarlo_id=" + customerId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Customer>() {

			@Override
			public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Customer customer = new Customer();
					customer.setVasarloID(rs.getInt("Vasarlo_id"));
					customer.setVasarloNev(rs.getString("Vasarlo_nev"));
					customer.setVasarloPont(rs.getInt("Vasarlo_pont"));
					customer.setVasarlotOsszeg(rs.getInt("Vasarlot_osszeg"));
					customer.setVasarloAdatok(rs.getString("Vasarlo_adatok"));
					return customer;
				}

				return null;
			}

		});
	}

	@Override
	public List<Customer> list() {
		String sql = "SELECT * FROM contact";
		List<Customer> listCustomer = jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer aCustomer = new Customer();
				aCustomer.setVasarloID(rs.getInt("Vasarlo_id"));
				aCustomer.setVasarloNev(rs.getString("Vasarlo_nev"));
				aCustomer.setVasarloPont(rs.getInt("Vasarlo_pont"));
				aCustomer.setVasarlotOsszeg(rs.getInt("Vasarlot_osszeg"));
				aCustomer.setVasarloAdatok(rs.getString("Vasarlo_adatok"));
				return aCustomer;
			}

		});

		return listCustomer;
	}

}
