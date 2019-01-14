package mariav.insurance.ui.navigate;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mariav.insurance.model.entity.Profile;
import mariav.insurance.model.repo.ProfileRepo;

@InjectViewState
public class NavigatePresenter extends MvpPresenter<NavigateView> {

    private ProfileRepo repo = new ProfileRepo();

    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showDefaultFragment();

        repo.getProfile()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadProfile, this::onLoadError);
    }

    private void onLoadProfile(Profile profile) {
        getViewState().setProfileInfo(profile.getFullName(), profile.getAvatar());
    }

    private void onLoadError(Throwable throwable) {
        getViewState().showMessage(throwable.getMessage());
    }
}
