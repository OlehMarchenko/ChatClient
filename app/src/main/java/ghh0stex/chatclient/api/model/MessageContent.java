package ghh0stex.chatclient.api.model;

import com.google.gson.Gson;

/**
 * Created by Grishin on 05.03.2017.
 */

public class MessageContent
{
    public String Action ;
    public String Name ;
    public String Login ;
    public String Password ;
    public String Role ;
    public String NameDialog ;
    public String Message ;

    public MessageContent()
    {

    }

    public MessageContent(String action, String name, String login, String password, String role, String nameDialog, String message)
    {
        this.Action = action;
        this.Name = name;
        this.Login = login;
        this.Password = password;
        this.Role = role;
        this.NameDialog = nameDialog;
        this.Message = message;
    }

    public MessageContent SetContent(String message)
    {
        Gson gson = new Gson();
        MessageContent content = gson.fromJson(message, MessageContent.class);
        return  content;
    }

    public String GetContent(MessageContent content)
    {
        Gson gson = new Gson();
        String message = gson.toJson(content);
        return  message;
    }
}
