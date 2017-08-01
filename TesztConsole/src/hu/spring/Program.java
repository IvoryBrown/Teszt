package hu.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import hu.spring.util.Operation;

public class Program {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		List<Vasarlo> listContact = connect();
		Map<Integer, Integer> map = new HashMap<>();

		System.out.println("MySQL:");
		for (Vasarlo aContact : listContact) {
			System.out.println(aContact);
		}
		System.out.println("\nKérek egy számot:");
		
		do {
			String input = sc.nextLine();
			Integer operation = getOperation(input);
			Vasarlo vasa = null;
			String message;
			switch (operation) {
			case  Operation.OKAY:
				Integer index = Integer.parseInt(input);
				if (index >= 0 && index < listContact.size()) {
					vasa = listContact.get(index);
					increase(map, index);
				} else {
					message = "Nincs ilyen elem";
				}
				break;
			case Operation.RECONNECT:
				listContact = connect();
				message = "Sikeres Csatlakozás";
				break;
			case Operation.CLOSE:
				stats(map);
				break;

			default:

				break;
				
			// }
			// Vasarlo vasar = listContact.get(input);
			//
			// if (vasar == null) {
			// System.err.println("Hiba van");
			// } else {
			// System.out.println(vasar);
			}
		} while (true);
	}

	// public static int GetAnInteger() {
	// while (true) {
	// try {
	// return sc.nextInt();
	// } catch (InputMismatchException e) {
	// sc.next();
	// System.err.print("Számot kértem!");
	// }
	//
	// }
	// }

	public static Integer getOperation(String input) {
		try {
			Integer.parseInt(input);
			return Operation.OKAY;

		} catch (Exception e) {
			switch (input) {
			case "*":
				return Operation.CLOSE;
			case "+":
				return Operation.RECONNECT;
			default:
				return Operation.ERROR;
			}
		}
	}

	public static List<Vasarlo> connect() throws SQLException {
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
		return listContact;
	}

	public static void stats(Map<Integer, Integer> map) {
		for (Map.Entry<Integer, Integer> element : map.entrySet()) {
			System.out.println(element.getKey() + ": " + element.getValue());
		}
	}

	public static void increase(Map<Integer, Integer> map, Integer key) {
		Integer value = map.get(key);
		if (value == null) {
			map.put(key, 1);
		} else {
			map.put(key, map.get(key) + 1);
		}
	}

}
