package mariav.insurance.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mariav.insurance.R;
import mariav.insurance.ui.UiTools;
import mariav.insurance.ui.main.list.ItemType;
import mariav.insurance.ui.main.list.ListFeedAdapter;

public class MainFragment extends MvpAppCompatFragment implements MainView, ListFeedAdapter.OnItemClickListener {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    private Unbinder unbinder;

    private ListFeedAdapter adapter;

    @InjectPresenter
    MainPresenter presenter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        unbinder = ButterKnife.bind(this, view);

        configureViews();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                // todo show kakoito info();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(int policyId) {
        //todo
    }

    private void configureViews() {
        configureRecyclerView();
    }

    private void configureRecyclerView() {
        adapter = new ListFeedAdapter(this, getChildFragmentManager());
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration decoration = new DividerItemDecoration(recycler.getContext(), DividerItemDecoration.VERTICAL);
        //recycler.addItemDecoration(decoration);
    }

    @Override
    public void showFeed(List<ItemType> dataSet) {
        adapter.updateItems(dataSet);
    }

    @Override
    public void showMessage(String message) {
        UiTools.showMessage(message, getContext());
    }
}
