package mariav.insurance.model.repo;

import io.reactivex.Observable;
import mariav.insurance.model.entity.Profile;

public class ProfileRepo extends Repo {

    public Observable<Profile> getProfile() {
        return restService().getProfile();
    }
}
