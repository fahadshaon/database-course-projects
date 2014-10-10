package edu.utd.dspl.tasks.rowmapper;

import edu.utd.dspl.tasks.domain.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Fahad Shaon
 */
public class ItemRowMapper implements  RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {

        Item item = new Item();

        item.setItemId(rs.getInt("item_id"));
        item.setTitle(rs.getString("title"));
        item.setItemType(rs.getInt("item_type"));
        item.setOrder(rs.getInt("order"));
        item.setTaskId(rs.getInt("task_id"));

        return item;
    }
}
