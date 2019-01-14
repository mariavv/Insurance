package mariav.insurance.ui.main.list.mainlistviewtypes;

import android.support.v7.widget.RecyclerView;

import mariav.insurance.R;
import mariav.insurance.model.Consts;
import mariav.insurance.model.entity.Policy;
import mariav.insurance.ui.main.list.ItemType;
import mariav.insurance.ui.main.list.ViewHolderFactory;

public class PolicyListItem implements ItemType {

    private Policy item;

    public PolicyListItem(Policy item) {
        this.item = item;
    }

    @Override
    public int getItemViewType() {
        return ItemType.POLICY;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.PolicyViewHolder holder = (ViewHolderFactory.PolicyViewHolder) viewHolder;
        //holder.itemView.setOnClickListener(getOnClickListener());
        holder.targetTv.setText(item.getDescription());
        switch (item.getCategoryCode()) {
            case Consts.HEALTH_CATEGORY_CODE:
                holder.policyTypeIconIv.setImageResource(R.drawable.icon_lca_insurance_3);
                holder.policyNameTv.setText(Consts.DMS);
                holder.infoHeaderTv.setText(R.string.balance);
                holder.infoTv.setText(item.getFormattedBalance());
                break;
            case Consts.CAR_CATEGORY_CODE:
                holder.policyTypeIconIv.setImageResource(R.drawable.icon_lca_insurance);
                holder.policyNameTv.setText(Consts.CASCO);
                holder.infoHeaderTv.setText(R.string.to);
                holder.infoTv.setText(item.getFormattedDate());
                holder.infoTv.setTextSize(12f);

                //holder.devider.setBackgroundColor(context.getResources().getColor(R.color.colorItemCarDevider));

                //holder.devider.setLayoutParams(new ConstraintLayout.LayoutParams(holder.devider.getWidth(), holder.devider.getHeight() / 2));
                break;
            default:
                break;
        }
    }
}
