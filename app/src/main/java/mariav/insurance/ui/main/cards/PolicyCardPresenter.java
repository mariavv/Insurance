package mariav.insurance.ui.main.cards;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Objects;

import mariav.insurance.R;
import mariav.insurance.model.Consts;
import mariav.insurance.model.entity.Policy;
import mariav.insurance.model.repo.PoliciesRepo;

@InjectViewState
public class PolicyCardPresenter extends MvpPresenter<PolicyCardView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    void onGetPolicyIdArg(int policyId) {
        Policy policy = PoliciesRepo.getInstance().getPolicy(policyId);
        if (policy != null) {
            getViewState().showInfo(policy);
            if (Objects.equals(policy.getCategoryCode(), Consts.CAR_CATEGORY_CODE)) {
                getViewState().hideDmsButtons();
            }
        } else {
            getViewState().showMessage(R.string.policy_not_found);
        }
    }
}
