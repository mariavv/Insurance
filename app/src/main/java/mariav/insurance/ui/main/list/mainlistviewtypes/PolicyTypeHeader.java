package mariav.insurance.ui.main.list.mainlistviewtypes;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import mariav.insurance.ui.main.list.ItemType;
import mariav.insurance.ui.main.list.ViewHolderFactory;

public class PolicyTypeHeader implements ItemType {

    private View view;
    private String text;

    public PolicyTypeHeader(String type) {
        this.text = type;
    }

    @Override
    public int getItemViewType() {
        return ItemType.CATEGORY_HEADER;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.PolicyHeaderViewHolder holder = (ViewHolderFactory.PolicyHeaderViewHolder) viewHolder;
        //holder.policyTypeTv.setOnClickListener(getOnClickListener());
        holder.policyTypeTv.setText(text);
    }
}
