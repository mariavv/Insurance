package mariav.insurance.ui.main;

import java.util.List;

import mariav.insurance.ui.IView;
import mariav.insurance.ui.main.list.ItemType;

interface MainView extends IView {

    void showFeed(List<ItemType> dataSet);
}
