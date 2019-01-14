package mariav.insurance.model.entity;

import java.util.List;

public class Policies {

    private List<Policy> policies;
    private List<InsuranceType> categories;

    public List<Policy> getPolicies() {
        return policies;
    }

    public List<InsuranceType> getCategories() {
        return categories;
    }
}
