package design.root.entity;

import java.util.HashMap;

/**
 * @author fish.leong@msn.com
 */
public class SendBean {
	public static final int ACTION_ADD = 0;
	public static final int ACTION_UPDATE = 1;
	public static final int ACTION_DELETE = 2;
	public String tableName;
	public int action = ACTION_ADD;
	public HashMap<String, String> pks;
	public HashMap<String, String> cols;
}
