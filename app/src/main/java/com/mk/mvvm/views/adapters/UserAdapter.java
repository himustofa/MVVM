package com.mk.mvvm.views.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mk.mvvm.R;
import com.mk.mvvm.models.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private static final String TAG = "UserAdapter";
    private Context mContext;
    private ArrayList<User> arrayList;

    public UserAdapter(Context mContext, ArrayList<User> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_recycler_item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        final User model = arrayList.get(position);
        Log.d(TAG, model.getAvatarUrl());
        Picasso.get().load(model.getAvatarUrl()).into((holder.userImage));
        //Glide.with(mContext).asBitmap().load(model.getAvatarUrl()).into(holder.imageView);

        holder.userLogin.setText(model.getLogin());
        holder.userNodeId.setText(model.getNodeId());
        holder.userType.setText(model.getType());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout;
        CircleImageView userImage;
        TextView userLogin, userNodeId, userType;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.user_list_layout_id);
            userImage = (CircleImageView) itemView.findViewById(R.id.user_avatar_url);
            userLogin = (TextView) itemView.findViewById(R.id.user_login);
            userNodeId = (TextView) itemView.findViewById(R.id.user_node_id);
            userType = (TextView) itemView.findViewById(R.id.user_type);
        }
    }
}
