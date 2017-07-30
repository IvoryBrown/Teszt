package hu.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Program {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost/teszt");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sqlSelect = "SELECT * FROM vasarlo";
		List<Vasarlo> listContact = jdbcTemplate.query(sqlSelect, new RowMapper<Vasarlo>() {

			public Vasarlo mapRow(ResultSet result, int rowNum) throws SQLException {
				Vasarlo contact = new Vasarlo();
				contact.setVasarlo_id(result.getInt("Vasarlo_id"));
				contact.setVasarlo_nev(result.getString("Vasarlo_nev"));
				contact.setVasarlo_pont(result.getInt("Vasarlo_pont"));
				contact.setVasarlot_osszeg(result.getInt("Vasarlot_osszeg"));
				contact.setVasarlo_adatok(result.getString("Vasarlo_adatok"));

				return contact;
			}

		});

		System.out.println("MySQL:");
		for (Vasarlo aContact : listContact) {
			System.out.println(aContact);
		}
		System.out.println("\nKérek egy számot:");

		do {
			Integer szam = GetAnInteger();
			Vasarlo vasar = find(szam);

			if (vasar == null) {
				System.err.println("Hiba van");
			} else {
				System.out.println(vasar);
			}
		} while (true);
	}

	public static int GetAnInteger() {
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				sc.next();
				System.err.print("Számot kértem!");
			}

		}
	}

	private static Vasarlo find(Integer id) throws SQLException {
		Vasarlo vasarlo = null;
		String select = "SELECT * FROM vasarlo WHERE vasarlo_id=" + id;
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost/teszt");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Vasarlo> listContact = jdbcTemplate.query(select, new RowMapper<Vasarlo>() {
			public Vasarlo mapRow(ResultSet result, int rowNum) throws SQLException {
				Vasarlo contact = new Vasarlo();
				contact.setVasarlo_id(result.getInt("Vasarlo_id"));
				contact.setVasarlo_nev(result.getString("Vasarlo_nev"));
				contact.setVasarlo_pont(result.getInt("Vasarlo_pont"));
				contact.setVasarlot_osszeg(result.getInt("Vasarlot_osszeg"));
				contact.setVasarlo_adatok(result.getString("Vasarlo_adatok"));
				return contact;
			}
		});
		if (listContact.size() == 1) {
			vasarlo = listContact.get(0);
		}
		return vasarlo;
	}
}