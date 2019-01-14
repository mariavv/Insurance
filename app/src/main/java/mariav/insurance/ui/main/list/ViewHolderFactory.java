package mariav.insurance.ui.main.list;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mariav.insurance.R;

public class ViewHolderFactory {

    @NonNull
    static RecyclerView.ViewHolder create(ViewGroup parent, int viewType, FragmentManager fm) {
        switch (viewType) {
            case ItemType.CARDS:
                View cardsTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.policy_cards, parent, false);
                return new ViewHolderFactory.CardsViewHolder(cardsTypeView, fm);

            case ItemType.CATEGORY_HEADER:
                View policyTypeHeaderTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.policy_type_header, parent, false);
                return new ViewHolderFactory.PolicyHeaderViewHolder(policyTypeHeaderTypeView);

            case ItemType.POLICY:
                View policyTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.policy_list_item, parent, false);
                return new ViewHolderFactory.PolicyViewHolder(policyTypeView);

            default:
                return null;
        }
    }

    public static class CardsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.viewPager)
        public ViewPager viewPager;

        public FragmentManager fragmentManager;

        CardsViewHolder(View itemView, FragmentManager fm) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.fragmentManager = fm;
        }
    }

    public static class PolicyHeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.policy_type_tv)
        public TextView policyTypeTv;

        PolicyHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class PolicyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.policy_type_icon_iv)
        public ImageView policyTypeIconIv;

        @BindView(R.id.policy_name_tv)
        public TextView policyNameTv;

        @BindView(R.id.target_tv)
        public TextView targetTv;

        @BindView(R.id.info_header_tv)
        public TextView infoHeaderTv;

        @BindView(R.id.info_tv)
        public TextView infoTv;

        PolicyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
