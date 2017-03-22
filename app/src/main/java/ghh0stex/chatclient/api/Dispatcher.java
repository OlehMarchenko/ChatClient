package ghh0stex.chatclient.api;

import ghh0stex.chatclient.api.collections.CollectionOfAllDialogsOnServer;
import ghh0stex.chatclient.api.collections.ListOfDialogs;
import ghh0stex.chatclient.api.collections.ListOfUsers;
import ghh0stex.chatclient.api.model.Client;
import ghh0stex.chatclient.api.model.MessageContent;

/**
 * Created by Grishin on 05.03.2017.
 */

public class Dispatcher
{
    private MessageContent contentFromServer;


    private ListOfDialogs dialogs;
    private ListOfUsers users;
    private CollectionOfAllDialogsOnServer allDialogs;


    private static Dispatcher unique;

    public static Dispatcher GetInstance()
    {
        if(unique == null)
        {
            return unique = new Dispatcher();
        }
        else
        {
            return unique;
        }
    }

    private  Dispatcher()
    {
        dialogs = ListOfDialogs.GetInstance();
        users = ListOfUsers.GetInstance();
        allDialogs = CollectionOfAllDialogsOnServer.GetInstance();

        contentFromServer = new MessageContent();
    }

    public void OnMessageRecieved(String content)
    {
        contentFromServer = contentFromServer.SetContent(content);

        switch(contentFromServer.Action)
        {
            case "Authorization":
            {
/*  + Пустить клиента в чат, но сообщить что он забанен,
он сможет ТОЛЬКО отправлять приватные сообщения*/
                Client.Name = contentFromServer.Name;
                FragmentManager.raFrag.MessageBox("Authorization successful", "Authorization");
                if (contentFromServer.Message == "True"){
                    Client.Ban = true;
                    FragmentManager.raFrag.MessageBox("You are banned!", "Authorization issue");
                }
                break;
            }

            case "SignUP":
            {
                if (contentFromServer.Message == "Success")
                    /*  + Добавить действие связанное с юайкой,
                    что произойдет если регистрация успешна*/
                    FragmentManager.raFrag.MessageBox("Registration successful!", "Registration");
                else if (contentFromServer.Message == "No success")
                    /* + Что произойдет если регистрация НЕ успешна*/
                    FragmentManager.raFrag.MessageBox("Login already exists!", "Registration issue");
                break;
            }

            case "Invite":
            {
                dialogs.CreateDialog(contentFromServer.NameDialog);
                FragmentManager.lobbyFrag.InvitationBox(contentFromServer.NameDialog);
                /*  + Вывести push клиенту, что его пригласили в диалог*/
                break;
            }

            case "SendMessage":
            {
                if (contentFromServer.Login != Client.Login)
                    dialogs.NewMessageSet(contentFromServer.NameDialog,
                            contentFromServer.Login, contentFromServer.Message);
                break;
            }

            case "ShowOnlineUsers":
            {
                String[] collectionUsers = contentFromServer.Message.split(";");
                users.SetUsersInLis(collectionUsers);
                break;
            }

            case "ShowAllDialogs":
            {
                String[] collectionDialogs = contentFromServer.Message.split(";");
                allDialogs.SetAllDiaogsInCollection(collectionDialogs);
                break;
            }

            case "PrivatMessage":
            {
                dialogs.PrivatDialog(contentFromServer.NameDialog,
                        contentFromServer.Message);
                break;
            }

            case "Banned": {
                Client.Ban = true;
                break;
            }

            case "Unbaned": {
                Client.Ban = false;
                break;
            }

            case "ChangePassword":
            {
                /*("Your password has been changed" , "Success"); */
                break;
            }

            default:
                break;
        }

    }

}

