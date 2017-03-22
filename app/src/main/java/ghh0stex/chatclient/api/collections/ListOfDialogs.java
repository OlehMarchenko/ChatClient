package ghh0stex.chatclient.api.collections;

import java.util.ArrayList;
import java.util.List;

import ghh0stex.chatclient.api.model.Dialog;

/**
 * Created by Grishin on 05.03.2017.
 */

public class ListOfDialogs
{
    private static ListOfDialogs unique;
    public List<Dialog> listOfDialogs;

    public static ListOfDialogs GetInstance()
    {
        if(unique==null)
        {
            return unique = new ListOfDialogs();
        }
        else
        {
            return unique;
        }
    }

    private ListOfDialogs()
    {
       listOfDialogs = new ArrayList<Dialog>();
    }



    public  void NewMessageSet(String nameDialog,String senderLogin, String message)
    {
        for (Dialog d : listOfDialogs )
        {
            if(d.NameDialog==nameDialog)
            {
                String str = senderLogin+";"+ message;
                d.Messages.add(str);
                return;
            }
        }
    }

    public List<Dialog> GetList()
    {
        return listOfDialogs;
    }


    public void CreateDialog(String nameDialog)
    {
        Dialog dialog = new Dialog(nameDialog);
        listOfDialogs.add(dialog);
    }

    public void PrivatDialog(String nameDialog, String message)
    {
        for (Dialog d: listOfDialogs)
        {
            if(d.NameDialog == nameDialog)
            {
                d.Messages.add(nameDialog+";"+message);
                return;
            }
        }
        Dialog dialog = new Dialog(nameDialog);
        listOfDialogs.add(dialog);
        PrivatDialog(nameDialog, message);
    }
}
