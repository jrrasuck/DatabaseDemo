package com.in28minutoes.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutoes.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from Person", new PersonRowMapper());
	}

	public Person findById(Integer id) {
		return jdbcTemplate.queryForObject("select * from Person where id = ?", new Object[] { id },
				new PersonRowMapper());
	}

	public int deleteById(Integer id) {
		int update = jdbcTemplate.update("delete from Person where id = ?", new Object[] { id });
		return update;
	}

	public int insert(Person person) {
		int update = jdbcTemplate.update("insert into Person (id, name, location, birth_date) values(?,  ?, ?, ?);",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
		return update;
	}

	public int update(Person person) {
		int update = jdbcTemplate.update("update Person set name = ?, location = ?, birth_date = ? where id = ?;",
				new Object[] { person.getName(), person.getLocation()
						, new Timestamp(person.getBirthDate().getTime())
						, person.getId()});
		return update;
	}

}
