package mariav.insurance.ui.main;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mariav.insurance.model.entity.InsuranceType;
import mariav.insurance.model.entity.Policies;
import mariav.insurance.model.entity.Policy;
import mariav.insurance.model.repo.PoliciesRepo;
import mariav.insurance.ui.main.list.ItemType;
import mariav.insurance.ui.main.list.mainlistviewtypes.Cards;
import mariav.insurance.ui.main.list.mainlistviewtypes.PolicyListItem;
import mariav.insurance.ui.main.list.mainlistviewtypes.PolicyTypeHeader;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private PoliciesRepo repo = PoliciesRepo.getInstance();

    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        repo.getPolicies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetPolicies, this::onGetPoliciesError);
    }

    private void onGetPolicies(Policies policies) {
        List<ItemType> dataSet = new ArrayList<>();

        dataSet.add(new Cards(policies));

        for (InsuranceType type : policies.getCategories()) {
            dataSet.add(new PolicyTypeHeader(type.getName()));
            for (Policy p : policies.getPolicies()) {
                if (Objects.equals(p.getCategoryCode(), type.getCode())) {
                    dataSet.add(new PolicyListItem(p));
                }
            }
        }

        getViewState().showFeed(dataSet);
    }

    private void onGetPoliciesError(Throwable throwable) {
        getViewState().showMessage(throwable.getMessage());
    }
}
