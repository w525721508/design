package design.root.entity;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.HashMap;

import design.root.entity.annotation.FishColumn;
import design.root.entity.annotation.FishTable;


/**
 * @author fish.leong@msn.com
 */
public class SuperBean {
    public static Gson gson = new Gson();

    public String getAddData() throws IllegalArgumentException, IllegalAccessException {
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();

        SendBean sendBean = new SendBean();
        sendBean.tableName = object.getAnnotation(FishTable.class).tableName();
        sendBean.cols = new HashMap<>();
        sendBean.pks = new HashMap<>();
        sendBean.action = SendBean.ACTION_ADD;
        String colName;
        String colVal = "";
        for (Field field : fields) {
            FishColumn fishSupport = field.getAnnotation(FishColumn.class);
            field.setAccessible(true);
            if (fishSupport.canBeNull() && (colVal = field.get(this).toString()) == null) {
                continue;
            }
            colName = fishSupport.column();
            sendBean.cols.put(colName, colVal);
            if (fishSupport.pk()) {
                sendBean.pks.put(colName, colVal);
            }
        }
        return gson.toJson(sendBean);
    }

    public String getDeleteData() throws IllegalArgumentException, IllegalAccessException {
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();
        SendBean sendBean = new SendBean();
        sendBean.action = SendBean.ACTION_DELETE;
        sendBean.tableName = object.getAnnotation(FishTable.class).tableName();
        sendBean.pks = new HashMap<>();
        String colName;
        String colVal = "";
        for (Field field : fields) {
            FishColumn fishSupport = field.getAnnotation(FishColumn.class);
            field.setAccessible(true);
            colName = fishSupport.column();
            if (fishSupport.pk()) {
                sendBean.pks.put(colName, colVal);
            }
        }
        return gson.toJson(sendBean);
    }

    public String getUpdateData() throws IllegalArgumentException, IllegalAccessException {
        Class<? extends SuperBean> object = getClass();
        Field[] fields = object.getDeclaredFields();

        SendBean sendBean = new SendBean();
        sendBean.tableName = object.getAnnotation(FishTable.class).tableName();
        sendBean.cols = new HashMap<>();
        sendBean.pks = new HashMap<>();
        sendBean.action = SendBean.ACTION_UPDATE;
        String colName;
        String colVal = "";
        for (Field field : fields) {
            FishColumn fishSupport = field.getAnnotation(FishColumn.class);
            field.setAccessible(true);
            if (fishSupport.canBeNull() && (colVal = field.get(this).toString()) == null) {
                continue;
            }
            colName = fishSupport.column();
            sendBean.cols.put(colName, colVal);
            if (fishSupport.pk()) {
                sendBean.pks.put(colName, colVal);
            }
        }
        return gson.toJson(sendBean);
    }
}
