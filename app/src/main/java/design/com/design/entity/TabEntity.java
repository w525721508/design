package design.com.design.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

import design.com.design.App;

public class TabEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(int title, int selectedIcon, int unSelectedIcon) {
        this.title = App.instance.getResources().getString(title);
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
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
