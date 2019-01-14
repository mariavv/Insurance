package mariav.insurance.model.repo;

import io.reactivex.Observable;
import mariav.insurance.model.entity.Policies;
import mariav.insurance.model.entity.Policy;

public class PoliciesRepo extends Repo {

    private static final PoliciesRepo INSTANCE = new PoliciesRepo();

    private Policies policies;

    public static PoliciesRepo getInstance() {
        return INSTANCE;
    }

    public Observable<Policies> getPolicies() {
        //todo сортировка где?
        return restService().getPolicies().doOnNext(policies1 -> policies = policies1);
    }

    public Policy getPolicy(int policyId) {
        return policies.getPolicies().get(policyId);
        /*for (Policy p : policies.getPolicies()) {
            if (p.getId() == policyId) {
                return p;
            }
        }
        return null;*/
    }

    public int getCount() {
        return policies.getPolicies().size();
    }
}
