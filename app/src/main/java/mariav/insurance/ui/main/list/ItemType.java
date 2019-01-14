package mariav.insurance.ui.main.list;

import android.support.v7.widget.RecyclerView;

public interface ItemType {
    int CARDS = 0;
    int CATEGORY_HEADER = 1;
    //int DEVIDER = 2;
    int POLICY = 3;

    int getItemViewType();

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder);
}
