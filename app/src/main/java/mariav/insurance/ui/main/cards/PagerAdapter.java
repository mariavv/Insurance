package mariav.insurance.ui.main.cards;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mariav.insurance.model.repo.PoliciesRepo;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return PolicyCardFragment.newInstance(i);
    }

    @Override
    public int getCount() {
        //todo не из репозитория
        return PoliciesRepo.getInstance().getCount();
    }
}
