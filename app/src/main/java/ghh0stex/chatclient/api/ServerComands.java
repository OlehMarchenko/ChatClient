package ghh0stex.chatclient.api;

import ghh0stex.chatclient.api.model.MessageContent;

/**
 * Created by Grishin on 05.03.2017.
 */

public class ServerComands
{
    public static void Authorization(String myLogin, String password)
    {
        MessageContent content = new MessageContent("Authorization","*", myLogin, password, "User", "*", "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void SingUP(String name, String myLogin, String password)
    {
        MessageContent content = new MessageContent("SignUP", name, myLogin, password, "User", "*",  "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void InviteToDialog(String dialog, String nameUsers)
    {
        MessageContent content = new MessageContent("Invite", "*" ,nameUsers, "*", "User", dialog, "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void SendMessage(String dialog, String myLogin, String sms)
    {
        MessageContent content = new MessageContent("SendMessage","*", myLogin,"*", "User", dialog, sms);
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void SendPrivateMessage(String myLogin, String takerLogin, String sms)
    {
        MessageContent content = new MessageContent("PrivatMessage","*", myLogin,"*", "User", takerLogin, sms);
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void CloseDialog(String dialog, String myLogin)
    {
        MessageContent content = new MessageContent("CloseDialog","*", myLogin, "*",  "User", dialog, "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void ToComeIn_TheDialog(String dialog, String myLogin)
    {
        MessageContent content = new MessageContent("ToComeIn", "*", myLogin, "*", "User", dialog, "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void ShowAllDialogs(String myLogin)
    {
        MessageContent content = new MessageContent("ShowAllDialogs", "*", myLogin, "*", "User", "*", "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void ShowOnlineUsers(String myLogin)
    {
        MessageContent content = new MessageContent("ShowOnlineUsers", "*", myLogin, "*", "User", "*", "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void CreateDialog(String myLogin, String nameDialod)
    {
        MessageContent content = new MessageContent("CreateDialog", "*", myLogin, "*", "User", nameDialod, "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void LogOut(String myLogin)
    {
        MessageContent content = new MessageContent("LogOut", "*", myLogin, "*", "User", "*", "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void ForgotPassword(String myLogin, String email)
    {
        MessageContent content = new MessageContent("ForgotPassword", "*", myLogin, "*", "User", "*", email);
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void ChangePassword(String myLogin, String newPass)
    {
        MessageContent content = new MessageContent("ChangePassword", "*", myLogin, "*", "User", "*", newPass);
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void AuthorizationWithGoogle(String name, String login)
    {
        MessageContent content = new MessageContent("Google", name, login, "*", "User", "*", "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }

    public static void AuthorizationWithFaceBook(String name, String login)
    {
        MessageContent content = new MessageContent("FaceBook", name, login, "*", "User", "*", "*");
        String message = content.GetContent(content);
        FragmentManager.Send(message);
    }
}
