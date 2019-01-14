package mariav.insurance.ui.navigate;

import mariav.insurance.ui.IView;

interface NavigateView extends IView {
    void showDefaultFragment();

    void setProfileInfo(String title, String iconPath);
}
