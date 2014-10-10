package edu.utd.dspl.tasks.rowmapper;

import edu.utd.dspl.tasks.domain.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Fahad Shaon
 */
public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {

        Task task = new Task();

        task.setTaskId(resultSet.getInt("task_id"));
        task.setTitle(resultSet.getString("title"));
        task.setCreatedAt(resultSet.getDate("created_at"));

        return task;
    }
}
