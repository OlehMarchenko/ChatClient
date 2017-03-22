package ghh0stex.chatclient.api.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grishin on 05.03.2017.
 */

public class CollectionOfAllDialogsOnServer
{
    private static CollectionOfAllDialogsOnServer unique;
    private List<String> allDialogs;

    public static CollectionOfAllDialogsOnServer GetInstance()
    {
        if(unique==null)
        {
            return unique = new CollectionOfAllDialogsOnServer();
        }
        else
        {
            return unique;
        }
    }

    private  CollectionOfAllDialogsOnServer()
    {
        allDialogs = new ArrayList<String>();
    }

    public List<String> GetList()
    {
        return allDialogs;
    }

    public void SetAllDiaogsInCollection(String[] col)
    {
        for(int i=0;i<col.length;i++)
        {
            allDialogs.add(col[i]);
        }
    }

}
