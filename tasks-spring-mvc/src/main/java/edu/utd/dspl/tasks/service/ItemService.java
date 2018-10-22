package edu.utd.dspl.tasks.service;

import edu.utd.dspl.tasks.domain.Item;
import edu.utd.dspl.tasks.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ItemService {

    private static Logger log = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemRepository itemRepository;

    public Item save(Item item, Long taskId) {

        item.setItemType(Item.ITEM_TYPE_TODO);
        item.setTaskId(taskId);

        log.info("Saved item " + item);

        itemRepository.save(item);

        return item;
    }

    public Item findOne(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item findOrFail(Long id) {

        Item item = findOne(id);

        if (item == null) {
            throw new EntityNotFoundException("Item with id " + id + " not found.");
        }

        return item;
    }

    public Item changeState(Long itemId, Integer newState) {

        if (newState != Item.ITEM_TYPE_TODO && newState != Item.ITEM_TYPE_DONE) {
            throw new RuntimeException("Invalid item type; valid values are [ "
                    + Item.ITEM_TYPE_TODO + ", " + Item.ITEM_TYPE_DONE + " ]");
        }

        Item item = findOrFail(itemId);

        log.info("Changing status of item id " + itemId + " from " + item.getItemType() + " to " + newState);
        item.setItemType(newState);

        return itemRepository.save(item);
    }
}
