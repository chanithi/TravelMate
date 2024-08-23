//package com.example.travelmate;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
//
//    private List<User> userList;
//    private Context context;
//
//    public UserAdapter(List<User> userList, Context context) {
//        this.userList = userList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
//        return new UserViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
//        User user = userList.get(position);
//        holder.nameTextView.setText(user.getName());
//        holder.districtTextView.setText(user.getDistrict());
//    }
//
//    @Override
//    public int getItemCount() {
//        return userList.size();
//    }
//
//    public static class UserViewHolder extends RecyclerView.ViewHolder {
//        TextView nameTextView, districtTextView;
//
//        public UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTextView = itemView.findViewById(R.id.user_name);
//            districtTextView = itemView.findViewById(R.id.user_district);
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
//
//    private List<User> userList;
//    private Context context;
//
//    public UserAdapter(List<User> userList, Context context) {
//        this.userList = userList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
//        return new UserViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
//        User user = userList.get(position);
//        holder.nameTextView.setText(user.getName());
//        holder.districtTextView.setText(user.getDistrict());
//    }
//
//    @Override
//    public int getItemCount() {
//        return userList.size();
//    }
//
//    public void updateData(List<User> newUserList) {
//        this.userList = newUserList;
//        notifyDataSetChanged();
//    }
//
//    public static class UserViewHolder extends RecyclerView.ViewHolder {
//        TextView nameTextView, districtTextView;
//
//        public UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTextView = itemView.findViewById(R.id.user_name);
//            districtTextView = itemView.findViewById(R.id.user_district);
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
//
//    private List<User> userList;
//    private Context context;
//
//    public UserAdapter(List<User> userList, Context context) {
//        this.userList = userList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
//        return new UserViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
//        User user = userList.get(position);
//        holder.nameTextView.setText(user.getName());
//        holder.districtTextView.setText(user.getDistrict());
//    }
//
//    @Override
//    public int getItemCount() {
//        return userList.size();
//    }
//
//    public void updateData(List<User> newUserList) {
//        this.userList = newUserList;
//        notifyDataSetChanged();
//    }
//
//    public static class UserViewHolder extends RecyclerView.ViewHolder {
//        TextView nameTextView, districtTextView;
//
//        public UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTextView = itemView.findViewById(R.id.user_name);
//            districtTextView = itemView.findViewById(R.id.user_district);
//        }
//    }
//}

//package com.example.travelmate;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//import java.util.List;
//
//public class UserAdapter extends ArrayAdapter<User> {
//
//    private Context context;
//    private List<User> userList;
//
//    public UserAdapter(List<User> userList, Context context) {
//        super(context, 0, userList);
//        this.userList = userList;
//        this.context = context;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
//        }
//
//        User user = userList.get(position);
//        TextView nameTextView = convertView.findViewById(R.id.user_name);
//        TextView districtTextView = convertView.findViewById(R.id.user_district);
//
//        nameTextView.setText(user.getName());
//        districtTextView.setText(user.getDistrict());
//
//        return convertView;
//    }
//
//    public void updateData(List<User> newUserList) {
//        this.userList = newUserList;
//        notifyDataSetChanged();
//    }
//}
package com.example.travelmate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private Context context;
    private List<User> userList;

    public UserAdapter(List<User> userList, Context context) {
        super(context, 0, userList);
        this.userList = userList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        // Check if the position is within the bounds of the userList
        if (position >= userList.size()) {
            // Log or handle the out-of-bounds scenario
            return convertView; // or you can throw an exception or log an error
        }

        User user = userList.get(position);
        TextView nameTextView = convertView.findViewById(R.id.user_name);
        TextView districtTextView = convertView.findViewById(R.id.user_district);

        // Set user data to the TextViews
        nameTextView.setText(user.getName());
        districtTextView.setText(user.getDistrict());

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UserDriverView.class);
            intent.putExtra("userName", user.getName());
            intent.putExtra("userDistrict", user.getDistrict());
            intent.putExtra("userContact", user.getContact()); // Assuming contact number is available
            context.startActivity(intent);
        });


        return convertView;
    }

    public void updateData(List<User> newUserList) {
        if (newUserList != null) {
            this.userList.clear();
            this.userList.addAll(newUserList);
        } else {
            this.userList.clear();
        }
        notifyDataSetChanged();
    }
}