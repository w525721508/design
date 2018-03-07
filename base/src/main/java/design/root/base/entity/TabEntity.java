package design.root.base.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

import design.root.base.App;
import design.root.base.R;
import design.root.base.base.BaseEntity;


public class TabEntity extends BaseEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(int title, int selectedIcon, int unSelectedIcon) {
        this.title = App.instance.getResources().getString(title);
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    public TabEntity(String title) {
        this.title = title;
        this.selectedIcon = R.mipmap.ic_launcher;
        this.unSelectedIcon = R.mipmap.ic_launcher;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
