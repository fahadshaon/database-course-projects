package edu.utd.dspl.tasks.dao;

import edu.utd.dspl.tasks.domain.Item;
import edu.utd.dspl.tasks.rowmapper.ItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Fahad Shaon
 */
@Repository
public class ItemDao {

    public static final String QUERY_SELECT_ITEM_OF_TASK = "SELECT * FROM item WHERE task_id = ?";
    public static final String QUERY_DELETE_ITEM_OF_TASK = "DELETE FROM item WHERE task_id = ?";
    public static final String QUERY_INSERT_ITEM = "INSERT INTO item (title, task_id, item_type) VALUES (?, ?, ?)";
    public static final String QUERY_UPDATE_ITEM_STATUS = "UPDATE item SET item_type = ? WHERE item_id = ? AND task_id = ?";
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Item> getTaskItems(int taskId) {
        return jdbcTemplate.query(QUERY_SELECT_ITEM_OF_TASK, new Integer[]{taskId}, new ItemRowMapper());
    }

    public int deleteItemsOfTask(int taskId) {
        return jdbcTemplate.update(QUERY_DELETE_ITEM_OF_TASK, new Integer(taskId));
    }

    public void insertItem(Item item) {
        // not interested about generated id, so just using jdbcTemplate.update.
        // Look at TaskDao.insert() for how to get generated ids back.
        jdbcTemplate.update(QUERY_INSERT_ITEM, new Object[]{item.getTitle(), item.getTaskId(), item.getItemType()});
    }

    public void updateItemType(int itemId, int taskId, int itemType) {
        if (itemType != 0 && itemType != 1) {
            throw new RuntimeException("Item type must be 0 or 1");
        }

        jdbcTemplate.update(QUERY_UPDATE_ITEM_STATUS, new Object[]{itemType, itemId, taskId});
    }
}
