package mariav.insurance.model.remote;

import io.reactivex.Observable;
import mariav.insurance.model.entity.Policies;
import mariav.insurance.model.entity.Profile;
import retrofit2.http.GET;

public interface RestService {

    String BASE_URL = "https://raw.githubusercontent.com/VladShturma/testTask/master/";

    @GET("profile")
    Observable<Profile> getProfile();

    @GET("policies")
    Observable<Policies> getPolicies();
}
