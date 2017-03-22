package ghh0stex.chatclient.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.drafts.Draft_75;
import org.java_websocket.drafts.Draft_76;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

import ghh0stex.chatclient.R;
import ghh0stex.chatclient.api.Dispatcher;
import ghh0stex.chatclient.api.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private WebSocketClient webSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager.activity = this;
        setContentView(R.layout.activity_main);

        FragmentManager.dispatcher = Dispatcher.GetInstance();
        InitWebSocket();

        FragmentManager.ShowRegAuth(getFragmentManager().beginTransaction());
    }

    public void InitWebSocket(){
        URI uri;
        try {
            uri = new URI("ws://10.0.3.2:62935/Server.ashx/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        webSocket = new WebSocketClient(uri, new Draft_17()) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
            }

            @Override
            public void onMessage(String s) {
                final String message = s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentManager.dispatcher.OnMessageRecieved(message);
                        Log.i("Websocket", message);
                    }
                });
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        webSocket.connect();
        FragmentManager.InitWebSocket(webSocket);
    }
}
