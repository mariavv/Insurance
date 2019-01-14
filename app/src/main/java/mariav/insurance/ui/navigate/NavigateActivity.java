package mariav.insurance.ui.navigate;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import mariav.insurance.R;
import mariav.insurance.ui.UiTools;
import mariav.insurance.ui.main.MainFragment;

//todo bottom bar template project
public class NavigateActivity extends MvpAppCompatActivity implements NavigateView {

    @InjectPresenter
    NavigatePresenter presenter;

    @BindView(R.id.avatar_iv)
    ImageView avatarIv;

    @BindView(R.id.name_tv)
    TextView nameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);

        ButterKnife.bind(this);

        configureViews();
    }

    private void configureViews() {
        //todo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            avatarIv.setClipToOutline(true);
        }
    }

    @Override
    public void showDefaultFragment() {
        showFragment(MainFragment.newInstance());
    }

    @Override
    public void setProfileInfo(String title, String iconPath) {
        nameTv.setText(title);

        Glide.with(this)
                .load(iconPath)
                .apply(RequestOptions.placeholderOf(R.drawable.oval).centerCrop())
                .into(avatarIv);
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.main_menu_tabs_containier, fragment);
        trans.commit();
    }

    @Override
    public void showMessage(String message) {
        UiTools.showMessage(message, this);
    }
}
