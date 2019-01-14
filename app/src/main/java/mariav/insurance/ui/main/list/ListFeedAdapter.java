package mariav.insurance.ui.main.list;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListFeedAdapter extends RecyclerView.Adapter {

    private List<ItemType> dataSet = new ArrayList<>();
    FragmentManager fragmentManager;
    private OnItemClickListener onItemClickListener;

    public ListFeedAdapter(OnItemClickListener onItemClickListener, FragmentManager fm) {
        this.fragmentManager = fm;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolderFactory.create(parent, viewType, fragmentManager);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        dataSet.get(position).onBindViewHolder(viewHolder);
    }

    @Override
    public int getItemViewType(int position) {
        return dataSet.get(position).getItemViewType();
    }

    @Override
    public int getItemCount() {
        if (dataSet != null) {
            return dataSet.size();
        }
        return 0;
    }

    /*@Override
    public void itemClick(int position) {
        //todo
        //onItemClickListener.onItemClick(dataSet.get(position).getId());
    }*/

    public void updateItems(List<ItemType> entities) {
        if (entities != null) {
            dataSet = entities;
            notifyDataSetChanged();
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int policyId);
    }
}