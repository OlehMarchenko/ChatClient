package ghh0stex.chatclient.api;

import android.app.FragmentTransaction;

import org.java_websocket.client.WebSocketClient;

import ghh0stex.chatclient.R;
import ghh0stex.chatclient.ui.activity.MainActivity;
import ghh0stex.chatclient.ui.fragments.FragmentChat;
import ghh0stex.chatclient.ui.fragments.FragmentDialogList;
import ghh0stex.chatclient.ui.fragments.FragmentLobby;
import ghh0stex.chatclient.ui.fragments.FragmentRA;
import ghh0stex.chatclient.ui.fragments.FragmentReg;

/**
 * Created by GHhos on 01.03.2017.
 */

public class FragmentManager {

    public static WebSocketClient ws;
    public static FragmentLobby lobbyFrag;
    public static FragmentRA    raFrag;
    public static FragmentReg   regFrag;
    public static FragmentChat  chatFrag;
    public static FragmentDialogList dialogListFrag;
    public static MainActivity activity;
    public static Dispatcher dispatcher;
    public static String UserName = null;
    public static String SessionKey = null;

    static {
        lobbyFrag = new FragmentLobby();
        raFrag = new FragmentRA();
        regFrag = new FragmentReg();
        chatFrag = new FragmentChat();
        dialogListFrag = new FragmentDialogList();
    }

    public static void CloseWebSocket(){
        ws.close();
    }

    public static void ShowLobby(FragmentTransaction transaction){
        transaction.replace(R.id.main_activity_fragment_placeholder,
                FragmentManager.lobbyFrag);
        transaction.commit();
    }

    public static void ShowRegAuth(FragmentTransaction transaction){
        transaction.replace(R.id.main_activity_fragment_placeholder,
                FragmentManager.raFrag);
        transaction.commit();
    }

    public static void ShowReg(FragmentTransaction transaction){
        transaction.replace(R.id.main_activity_fragment_placeholder,
                FragmentManager.regFrag);
        transaction.commit();
    }

    public static void ShowChat(FragmentTransaction transaction){
        transaction.replace(R.id.main_activity_fragment_placeholder,
                FragmentManager.chatFrag);
        transaction.commit();
    }

    public static void ShowDialogList(FragmentTransaction transaction){
        transaction.replace(R.id.main_activity_fragment_placeholder,
                FragmentManager.dialogListFrag);
        transaction.commit();
    }

    public static void InitWebSocket(WebSocketClient webSocket) {
        ws = webSocket;
    }

    public static void Send(String message)
    {
        ws.send(message);
    }

    public static void SendLogin(String name, String pass)
    {
        Send("auth:" + name + "," + pass);
    }

    public static void SendReg(String name, String pass)
    {
        Send("reg:" + name + "," + pass);
    }

    public static void SendLogout()
    {
        Send("logout:");
    }

    public static void SendChangePassword(String login, String password, String newPassword) {
        Send("changepass:" + login + "," + password + "," + newPassword);
    }

    public static void SendForgotPassword(String username, String email) {
        Send("forgotpass:" + username + "," + email);
    }

    public static void SendInviteResponse(String response) {
        Send(response);
    }

    public static void SendInviteRequest(String name) {
        Send("invite:" + name);
    }

}

