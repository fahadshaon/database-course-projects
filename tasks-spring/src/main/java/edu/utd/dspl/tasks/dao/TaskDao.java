package edu.utd.dspl.tasks.dao;

import edu.utd.dspl.tasks.domain.Task;
import edu.utd.dspl.tasks.rowmapper.TaskRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Fahad Shaon
 */
@Repository
public class TaskDao {

    public static final String QUERY_SELECT_TASK = "SELECT * FROM task";
    public static final String QUERY_SELECT_TASK_BY_ID = "SELECT * FROM task WHERE task_id = ?";
    public static final String QUERY_INSERT_TASK = "INSERT INTO task(title) VALUES (?)";
    public static final String QUERY_UPDATE_TASK = "UPDATE task SET title=? WHERE task_id = ?";
    public static final String QUERY_COUNT_TASK = "SELECT COUNT(*) FROM task";
    public static final String QUERY_DELETE_TASK = "DELETE FROM task WHERE task_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Task> getTasks() {
        return jdbcTemplate.query(QUERY_SELECT_TASK, new TaskRowMapper());
    }

    public Task getTaskById(int taskId) {

        return jdbcTemplate.query(QUERY_SELECT_TASK_BY_ID, new Integer[]{taskId}, new ResultSetExtractor<Task>() {
            @Override
            public Task extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? new TaskRowMapper().mapRow(rs, 1) : null;
            }
        });
    }

    public Task getTaskByIdWithItems(int taskId) {

        Task task = jdbcTemplate.query(QUERY_SELECT_TASK_BY_ID, new Integer[]{taskId}, new ResultSetExtractor<Task>() {
            @Override
            public Task extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? new TaskRowMapper().mapRow(rs, 1) : null;
            }
        });

        if (task == null) {
            return null;
        }

        task.setItemList(itemDao.getTaskItems(taskId));

        return task;
    }

    public int insert(final Task task) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(QUERY_INSERT_TASK, new String[]{"task_id"});

                        ps.setString(1, task.getTitle());
                        return ps;
                    }
                },
                keyHolder
        );
        int taskId = keyHolder.getKey().intValue();
        task.setTaskId(taskId);

        return taskId;
    }

    public int update(final Task task) {
        return jdbcTemplate.update(QUERY_UPDATE_TASK, task.getTitle(), task.getTaskId());
    }

    public int count() {
        return jdbcTemplate.queryForObject(QUERY_COUNT_TASK, Integer.class);
    }

    public int delete(int taskId) {
        // Will throw DataIntegrityViolationException if linked items are not deleted first.
        return jdbcTemplate.update(QUERY_DELETE_TASK, new Integer(taskId));
    }

    @Transactional
    public int deleteWithItems(int taskId) {
        itemDao.deleteItemsOfTask(taskId);
        return delete(taskId);
    }
}


