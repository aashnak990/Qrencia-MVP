package com.qrencia.competitions.common;

import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractTransactionalDao extends AbstractQueryDao {

	/**
	 * Method to insert and return integer column
	 * @param insertSql
	 * @param parameters
	 * @param keyColumnName
	 * @return primary key of the inserted record
	 */
		public int insert(String insertSql, Map<String,Object> parameters,
			String keyColumnName) {
			MapSqlParameterSource mapSqlPatMapqlParameterSource = new MapSqlParameterSource(parameters);
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		 getJdbcTemplate().update(insertSql, mapSqlPatMapqlParameterSource, generatedKeyHolder,
				new String[] { keyColumnName });
		return generatedKeyHolder.getKey().intValue();
	}
		/**
		 * Method to insert value and return string value 
		 * @param insertSql
		 * @param parameters
		 * @param keyColumnName
		 * @return String value of the generated key
		 */
		public String insertString(String insertSql, Map<String,Object> parameters,
				String keyColumnName) {
				MapSqlParameterSource mapSqlPatMapqlParameterSource = new MapSqlParameterSource(parameters);
			KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
			 getJdbcTemplate().update(insertSql, mapSqlPatMapqlParameterSource, generatedKeyHolder,
					new String[] { keyColumnName });
			return generatedKeyHolder.getKey().toString();
		}
}
