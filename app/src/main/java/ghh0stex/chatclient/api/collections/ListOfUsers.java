package ghh0stex.chatclient.api.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grishin on 05.03.2017.
 */

public class ListOfUsers
{
    private static ListOfUsers unique;

    public static ListOfUsers GetInstance()
    {
        if(unique==null)
        {
            return unique = new ListOfUsers();
        }
        else
        {
            return unique;
        }
    }

    private  ListOfUsers()
    {
        listOfUsers = new ArrayList<String>();
    }

    public List<String> listOfUsers;

    public void SetUsersInLis(String[] users)
    {
        listOfUsers =  new ArrayList<String>();

        for(int i=0; i<users.length;i++)
        {
            listOfUsers.add(users[i]);
        }
    }

}
