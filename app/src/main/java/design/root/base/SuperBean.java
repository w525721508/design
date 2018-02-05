package design.root.base;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;



/**
 * @author fish.leong@msn.com
 */
public class SuperBean {
    private static final int ACTION_ADD = 0;
    private static final int ACTION_UPDATE = 1;
    private static final int ACTION_DELETE = 2;
    @Ignore
    private String tableName;
    @Ignore
    private int action = ACTION_ADD;
    @Ignore
    private HashMap<String, String> pks;
    @Ignore
    private HashMap<String, String> cols;

    public void toAddData() throws IllegalArgumentException, IllegalAccessException {
        action = ACTION_ADD;
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();
        tableName = object.getAnnotation(Entity.class).tableName();
        pks = new HashMap<>();
        Vector<String> isPk = new Vector<>();//寻找表头主键声明
        Collections.addAll(isPk, object.getAnnotation(Entity.class).primaryKeys());
        cols = new HashMap<>();
        String colName;
        String colVal = "";
        for (Field field : fields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if (primaryKey != null) {
                //按主键处理
                field.setAccessible(true);
                colVal = field.get(this) == null ? null : field.get(this).toString();
                colName = field.getName();
                cols.put(colName, colVal);
                pks.put(colName, colVal);//主键
            } else {
                ColumnInfo columnInfo = field.getAnnotation(ColumnInfo.class);
                if (columnInfo != null) {
                    field.setAccessible(true);
                    colVal = field.get(this) == null ? null : field.get(this).toString();
                    colName = columnInfo.name();
                    cols.put(colName, colVal);
                    if (isPk.indexOf(colName) != -1) {
                        //判断主键
                        pks.put(colName, colVal);
                    }
                }
            }
        }
    }

    public void toDeleteData() throws IllegalArgumentException, IllegalAccessException {
        action = ACTION_DELETE;
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();
        tableName = object.getAnnotation(Entity.class).tableName();
        pks = new HashMap<>();
        Vector<String> isPk = new Vector<>();//寻找表头主键声明
        Collections.addAll(isPk, object.getAnnotation(Entity.class).primaryKeys());
        cols = new HashMap<>();
        String colName;
        String colVal = "";
        for (Field field : fields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);//先找主键声明
            if (primaryKey != null) {
                //按主键处理
                field.setAccessible(true);
                colVal = field.get(this) == null ? null : field.get(this).toString();
                colName = field.getName();
                pks.put(colName, colVal);//主键
            } else {
                ColumnInfo columnInfo = field.getAnnotation(ColumnInfo.class);
                if (columnInfo != null) {
                    field.setAccessible(true);
                    colVal = field.get(this) == null ? null : field.get(this).toString();
                    colName = columnInfo.name();
                    if (isPk.indexOf(colName) != -1) {
                        //判断主键
                        pks.put(colName, colVal);
                    }
                }
            }
        }
    }

    public void toUpdateData() throws IllegalArgumentException, IllegalAccessException {
        action = ACTION_UPDATE;
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();
        tableName = object.getAnnotation(Entity.class).tableName();
        pks = new HashMap<>();
        Vector<String> isPk = new Vector<>();//寻找表头主键声明
        Collections.addAll(isPk, object.getAnnotation(Entity.class).primaryKeys());
        cols = new HashMap<>();
        String colName;
        String colVal = "";
        for (Field field : fields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if (primaryKey != null) {
                //按主键处理
                field.setAccessible(true);
                colVal = field.get(this) == null ? null : field.get(this).toString();
                colName = field.getName();
                pks.put(colName, colVal);//主键
            } else {
                ColumnInfo columnInfo = field.getAnnotation(ColumnInfo.class);
                if (columnInfo != null) {
                    field.setAccessible(true);
                    colVal = field.get(this) == null ? null : field.get(this).toString();
                    colName = columnInfo.name();
                    if (isPk.indexOf(colName) != -1) {
                        //判断主键
                        pks.put(colName, colVal);
                    }
                }
            }
        }
    }

    public static int getActionAdd() {
        return ACTION_ADD;
    }

    public static int getActionUpdate() {
        return ACTION_UPDATE;
    }

    public static int getActionDelete() {
        return ACTION_DELETE;
    }

    public String getTableName() {
        return tableName;
    }

    public int getAction() {
        return action;
    }

    public HashMap<String, String> getPks() {
        return pks;
    }

    public HashMap<String, String> getCols() {
        return cols;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public void setPks(HashMap<String, String> pks) {
        this.pks = pks;
    }

    public void setCols(HashMap<String, String> cols) {
        this.cols = cols;
    }
}
