package design.root.base;


import java.lang.reflect.Field;
import java.util.HashMap;

import design.root.supers.annotation.FishColumn;
import design.root.supers.annotation.FishTable;


/**
 * @author fish.leong@msn.com
 */
public class SuperBean {
    private static final int ACTION_ADD = 0;
    private static final int ACTION_UPDATE = 1;
    private static final int ACTION_DELETE = 2;
    private String tableName;
    private int action = ACTION_ADD;
    private HashMap<String, String> pks;
    private HashMap<String, String> cols;

    public void toAddData() throws IllegalArgumentException, IllegalAccessException {
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();
        tableName = object.getAnnotation(FishTable.class).tableName();
        cols = new HashMap<>();
        pks = new HashMap<>();
        action = ACTION_ADD;
        String colName;
        String colVal = "";
        for (Field field : fields) {
            FishColumn fishSupport = field.getAnnotation(FishColumn.class);
            field.setAccessible(true);
            if (fishSupport.canBeNull() && (colVal = field.get(this).toString()) == null) {
                continue;
            }
            colName = fishSupport.column();
            cols.put(colName, colVal);
            if (fishSupport.pk()) {
                pks.put(colName, colVal);
            }
        }
    }

    public void toDeleteData() throws IllegalArgumentException, IllegalAccessException {
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();
        action = ACTION_DELETE;
        tableName = object.getAnnotation(FishTable.class).tableName();
        pks = new HashMap<>();
        String colName;
        String colVal = "";
        for (Field field : fields) {
            FishColumn fishSupport = field.getAnnotation(FishColumn.class);
            field.setAccessible(true);
            colName = fishSupport.column();
            if (fishSupport.pk()) {
                pks.put(colName, colVal);
            }
        }
    }

    public void toUpdateData() throws IllegalArgumentException, IllegalAccessException {
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();
        tableName = object.getAnnotation(FishTable.class).tableName();
        cols = new HashMap<>();
        pks = new HashMap<>();
        action = ACTION_UPDATE;
        String colName;
        String colVal = "";
        for (Field field : fields) {
            FishColumn fishSupport = field.getAnnotation(FishColumn.class);
            field.setAccessible(true);
            if (fishSupport.canBeNull() && (colVal = field.get(this).toString()) == null) {
                continue;
            }
            colName = fishSupport.column();
            cols.put(colName, colVal);
            if (fishSupport.pk()) {
                pks.put(colName, colVal);
            }
        }
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public HashMap<String, String> getPks() {
        return pks;
    }

    public void setPks(HashMap<String, String> pks) {
        this.pks = pks;
    }

    public HashMap<String, String> getCols() {
        return cols;
    }

    public void setCols(HashMap<String, String> cols) {
        this.cols = cols;
    }

}
