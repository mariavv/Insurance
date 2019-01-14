package mariav.insurance.ui.main.list.mainlistviewtypes;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import mariav.insurance.model.entity.InsuranceType;
import mariav.insurance.model.entity.Policies;
import mariav.insurance.model.entity.Policy;
import mariav.insurance.ui.main.cards.PagerAdapter;
import mariav.insurance.ui.main.list.ItemType;
import mariav.insurance.ui.main.list.ViewHolderFactory;

public class Cards implements ItemType {

    List<Policy> policies;

    public Cards(Policies policies) {
        this.policies = new ArrayList<>();
        for (InsuranceType type : policies.getCategories()) {
            for (Policy p : policies.getPolicies()) {
                if (Objects.equals(p.getCategoryCode(), type.getCode())) {
                    this.policies.add(p);
                }
            }
        }
    }

    @Override
    public int getItemViewType() {
        return ItemType.CARDS;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        ViewHolderFactory.CardsViewHolder holder = (ViewHolderFactory.CardsViewHolder) viewHolder;

        final PagerAdapter pagerAdapter = new PagerAdapter(holder.fragmentManager);
        holder.viewPager.setAdapter(pagerAdapter);
    }
}
