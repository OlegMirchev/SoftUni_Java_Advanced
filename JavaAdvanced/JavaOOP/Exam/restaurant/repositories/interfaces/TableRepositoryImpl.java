package JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces;


import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TableRepositoryImpl implements TableRepository<Table> {
    private List<Table> listTable;

    public TableRepositoryImpl() {
        this.listTable = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableList(listTable);
    }

    @Override
    public void add(Table entity) {
        this.listTable.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        Table tables = null;
        for (Table tableFromList : listTable) {
            if (tableFromList.getTableNumber() == number) {
                tables = tableFromList;
            }
        }
        return tables;
    }
}
