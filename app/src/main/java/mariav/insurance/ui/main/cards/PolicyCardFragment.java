package mariav.insurance.ui.main.cards;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mariav.insurance.R;
import mariav.insurance.model.entity.Policy;
import mariav.insurance.ui.UiTools;

import static mariav.insurance.model.Consts.WORDS_SEPARATE;

public class PolicyCardFragment extends MvpAppCompatFragment implements PolicyCardView {

    private static final String ARG_POLICY_ID = "policyId";

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.balance_tv)
    TextView balanceTv;
    @BindView(R.id.date_tv)
    TextView dateTv;

    @BindView(R.id.call_doc_round_iv)
    ImageView callDocRoundIv;
    @BindView(R.id.call_doc_iv)
    ImageView callDocIv;
    @BindView(R.id.call_doc_tv)
    TextView callDocTv;

    @BindView(R.id.ambulance_round_iv)
    ImageView ambulanceRoundIv;
    @BindView(R.id.ambulance_iv)
    ImageView ambulanceIv;
    @BindView(R.id.ambulance_tv)
    TextView ambulanceTv;

    @InjectPresenter
    PolicyCardPresenter presenter;

    private Unbinder unbinder;

    //todo policyId это индекс
    public static PolicyCardFragment newInstance(int policyId) {
        PolicyCardFragment fragment = new PolicyCardFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_POLICY_ID, policyId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_policy_card, container, false);

        unbinder = ButterKnife.bind(this, view);

        Bundle args = getArguments();
        if (args != null) {
            int policyId = (int) args.getSerializable(ARG_POLICY_ID);
            presenter.onGetPolicyIdArg(policyId);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showInfo(Policy policy) {
        titleTv.setText(policy.getFullDescription());
        balanceTv.setText(policy.getFormattedBalanceWithDecimalPoint());
        dateTv.setText(MessageFormat.format("{0}{1}{2}", getString(R.string.to), WORDS_SEPARATE, policy.getFormattedDate()));
    }

    @Override
    public void showMessage(int messageRes) {
        showMessage(getString(messageRes));
    }

    @Override
    public void hideDmsButtons() {
        callDocRoundIv.setVisibility(View.INVISIBLE);
        callDocIv.setVisibility(View.INVISIBLE);
        callDocTv.setVisibility(View.INVISIBLE);

        ambulanceRoundIv.setVisibility(View.INVISIBLE);
        ambulanceIv.setVisibility(View.INVISIBLE);
        ambulanceTv.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {
        UiTools.showMessage(message, getContext());
    }
}
