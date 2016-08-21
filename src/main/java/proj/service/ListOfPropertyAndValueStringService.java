package proj.service;

import proj.entity.ListOfPropertyAndValueInteger;

import java.util.List;

/**
 * Created by SCIP on 19.08.2016.
 */
public interface ListOfPropertyAndValueStringService {
    void save();
    ListOfPropertyAndValueInteger findByCategoryName(String name);
    void delete(String name);
    List<ListOfPropertyAndValueInteger> findAll();
}
