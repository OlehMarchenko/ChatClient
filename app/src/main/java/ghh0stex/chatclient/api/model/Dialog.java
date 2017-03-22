package ghh0stex.chatclient.api.model;

import java.util.List;

/**
 * Created by Grishin on 05.03.2017.
 */

public class Dialog
{
    public String NameDialog;
    public List<String> Messages;

    public Dialog(String nameDialog)
    {
        this.NameDialog = nameDialog;
    }
}
