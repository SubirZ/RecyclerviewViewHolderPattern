package com.example.home;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.R;
import com.example.CustomItemClickListener;

import java.util.ArrayList;

public class AdapterEmail extends RecyclerView.Adapter<AdapterEmail.ViewHolder> {
    private final Context context;
    private final ArrayList<String> arrListContacts;
    private final CustomItemClickListener listener;


    AdapterEmail(final Context context, final ArrayList<String> arrListContacts, final CustomItemClickListener listener) {
        this.context = context;
        this.arrListContacts = arrListContacts;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final ViewHolder holder;
        final LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View convertView = layoutInflater != null ? layoutInflater
        .inflate(R.layout.row_contacts, parent, false) : null;
        holder = new ViewHolder(convertView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvContact.setText(arrListContacts.get(position));
        holder.tvContact
        .setBackground(ContextCompat.getDrawable(context, R.drawable.drawable_email_background));
        holder.ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrListContacts.size();
    }

    @Override
    public long getItemId(final int position) {
        return super.getItemId(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvContact;
        private final ImageView ivRemove;

        ViewHolder(final View itemView) {
            super(itemView);
            tvContact = itemView.findViewById(R.id.row_contacts_tvContact);
            ivRemove = itemView.findViewById(R.id.row_contacts_ivRemove);
        }
    }
}
