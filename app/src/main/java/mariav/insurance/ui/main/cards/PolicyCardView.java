package mariav.insurance.ui.main.cards;

import android.support.annotation.StringRes;

import mariav.insurance.model.entity.Policy;
import mariav.insurance.ui.IView;

interface PolicyCardView extends IView {
    void showInfo(Policy policy);

    void showMessage(@StringRes int messageRes);

    void hideDmsButtons();
}
