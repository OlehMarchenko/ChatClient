package ghh0stex.chatclient.ui.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ghh0stex.chatclient.R;
import ghh0stex.chatclient.api.FragmentManager;

/**
 * Created by GHhos on 01.03.2017.
 */

public class AdapterChat extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<String> nameList;

    public AdapterChat(Context context, ArrayList<String> nameList) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.nameList = nameList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.dialog_item, parent, false);
        }

        final TextView tvName = (TextView) view.findViewById(R.id.tv_dialog_name);
        tvName.setText(nameList.get(position));

        tvName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                InvitationBox(tvName.getText().toString());
                return false;
            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int position) {
        return nameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private void InvitationBox(final String playerName){
        final AlertDialog.Builder aDialogBuilder = new AlertDialog.Builder(context);
        aDialogBuilder.setMessage("Invitation");
        aDialogBuilder.setMessage("Do you want to play with " + playerName + "?");

        aDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Invite(playerName);
                dialog.cancel();
            }
        });
        aDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        aDialogBuilder.setCancelable(false);
        aDialogBuilder.create();
        aDialogBuilder.show();
    }

    private void Invite(String playerName) {
        FragmentManager.SendInviteRequest(playerName);
    }

}

