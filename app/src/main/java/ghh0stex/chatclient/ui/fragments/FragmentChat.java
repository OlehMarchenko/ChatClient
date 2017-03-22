package ghh0stex.chatclient.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import ghh0stex.chatclient.R;

/**
 * Created by GHhos on 04.03.2017.
 */

public class FragmentChat extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        TextView tv_dialog_name = (TextView)view.findViewById(R.id.tv_dialog_name);
        ListView lv_messages = (ListView) view.findViewById(R.id.lv_messages);
        Button b_back = (Button) view.findViewById(R.id.b_back);
        Button b_send = (Button) view.findViewById(R.id.b_send);
        final EditText et_message_send = (EditText) view.findViewById(R.id.et_message_send);

        b_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;
    }
}
