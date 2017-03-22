package ghh0stex.chatclient.ui.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ghh0stex.chatclient.R;
import ghh0stex.chatclient.api.FragmentManager;
import ghh0stex.chatclient.api.ServerComands;
import ghh0stex.chatclient.api.model.Client;
import ghh0stex.chatclient.ui.adapter.AdapterChat;

/**
 * Created by GHhos on 01.03.2017.
 */

public class FragmentLobby extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lobby, container, false);

        Button bDialogs = (Button) view.findViewById(R.id.fragment_lobby_bDialog);
        Button bMessages = (Button) view.findViewById(R.id.fragment_lobby_bMessages);

        Button bLogin = (Button) view.findViewById(R.id.fragment_lobby_bLogin);
        Button bLogout = (Button) view.findViewById(R.id.fragment_lobby_bLogout);

        bDialogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager.ShowDialogList(getFragmentManager().beginTransaction());
            }
        });

        bMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager.ShowDialogList(getFragmentManager().beginTransaction());
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FragmentManager.UserName == null || FragmentManager.UserName.equals("")) {
                    FragmentManager.activity.InitWebSocket();
                    FragmentManager.ShowRegAuth(getFragmentManager().beginTransaction());
                }
            }
        });

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FragmentManager.UserName != null || !FragmentManager.UserName.equals("")) {
                    ServerComands.LogOut(Client.Login);
                    FragmentManager.CloseWebSocket();
                    FragmentManager.UserName = "";
                }
            }
        });

        return view;
    }

    public void InvitationBox(String dialogName){
        final AlertDialog.Builder aDialogBuilder = new AlertDialog.Builder(this.getContext());
        aDialogBuilder.setTitle("Invitation");
        aDialogBuilder.setMessage("You've been invited to " + dialogName + " chat room");

        aDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        aDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        aDialogBuilder.setCancelable(false);
        aDialogBuilder.create();
        aDialogBuilder.show();
    }
}