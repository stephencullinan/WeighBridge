package Models;

import Entities.Administrator;
import Entities.User;
import Database.*;
import java.util.ArrayList;
import java.util.HashMap;
public class LogOn
{
    private Database main;
    private Administrator anAdministrator;
    private User anUser;
    public LogOn()
    {
        main = new Database();
    }
    public Administrator getAdministrator()
    {
        return anAdministrator;
    }
    public User getUser()
    {
        return anUser;
    }
    public Boolean isValidAdministrator(String username, String password)
    {
        anAdministrator = new Administrator("", "");
        anAdministrator.setUsername(username);
        HashMap<String, String> selectedParameters = new HashMap<>();
        selectedParameters.put("username", anAdministrator.getUsername());
        ArrayList<ArrayList<String>> selectedAdministrator = main.getTableRows("administrators", selectedParameters, new ArrayList<>(), "");
        if (selectedAdministrator.size() == 1)
        {
            anAdministrator.setPassword(password);
            if (selectedAdministrator.get(0).get(1).trim().equals(anAdministrator.getUsername().trim())
            && selectedAdministrator.get(0).get(2).trim().equals(anAdministrator.getPassword()))
                return true;
        }
        return false;
    }
    public Boolean isValidUser(String username, String password)
    {
        anUser = new User(0, "", "", "", "", "", "");
        anUser.setUsername(username);
        HashMap<String, String> selectedParameters = new HashMap<>();
        selectedParameters.put("username", anUser.getUsername());
        ArrayList<ArrayList<String>> selectedUser = main.getTableRows("users", selectedParameters, new ArrayList<>(), "");
        if(selectedUser.size() == 1)
        {
            anUser.setPassword(password);
            if(selectedUser.get(0).get(1).trim().equals(anUser.getUsername().trim()) && selectedUser.get(0).get(2).trim().equals(anUser.getPassword()))
                return true;
        }
        return false;
    }
}