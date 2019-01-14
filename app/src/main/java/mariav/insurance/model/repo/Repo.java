package mariav.insurance.model.repo;

import mariav.insurance.model.remote.RestService;
import mariav.insurance.model.remote.RestServiceProvider;

class Repo {

    RestService restService() {
        return RestServiceProvider.getInstance().getRestService();
    }
}
