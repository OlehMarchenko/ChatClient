package ghh0stex.chatclient.ui.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ghh0stex.chatclient.R;
import ghh0stex.chatclient.api.FragmentManager;
import ghh0stex.chatclient.api.ServerComands;

/**
 * Created by GHhos on 04.03.2017.
 */

public class FragmentReg extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reg, container, false);

        Button bReg = (Button) view.findViewById(R.id.fragment_reg_bReg);

        final EditText etUsername = (EditText) view.findViewById(R.id.fragment_reg_etUsername);
        final EditText etLogin = (EditText) view.findViewById(R.id.fragment_reg_etLogin);
        final EditText etPassword = (EditText) view.findViewById(R.id.fragment_reg_etPassword);

        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager.UserName = etUsername.getText().toString();
                ServerComands.SingUP(etUsername.getText().toString(),
                        etLogin.getText().toString(),
                        etPassword.getText().toString());
                FragmentManager.ShowRegAuth(getFragmentManager().beginTransaction());
            }
        });

        return view;
    }
}
