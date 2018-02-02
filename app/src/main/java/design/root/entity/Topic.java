package design.root.entity;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    String id;
    String order;
    String title;
    String siteName;
    String authorName;
    String url;
    String mobileUrl;
    String summary;
    ArrayList<Topic> newsArray;
    String publishDate;
    Extra extra;

    public Topic() {
    }

    public String getSiteName() {
        return siteName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getUrl() {
        if (!TextUtils.isEmpty(mobileUrl)) return mobileUrl;
        return url;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return TextUtils.isEmpty(title) ? null : title.trim();
    }

    public String getSummary() {
        return TextUtils.isEmpty(summary) ? null : summary.trim();
    }

    public List<Topic> getNewsArray() {
        return newsArray;
    }

    public String getPublishDateCountDown() {
        return publishDate;
    }

    public String getFormatPublishDate() {
        return publishDate;
    }

    public String getOrder() {
        return order;
    }

    public String getLastCursor() {
        if (TextUtils.isEmpty(order)) {
            return String.valueOf(publishDate);
        } else {
            return order;
        }
    }

    public boolean hasInstantView() {
        if (extra != null) return extra.instantView;
        return false;
    }

    public static class Extra {
        boolean instantView;
    }
}
