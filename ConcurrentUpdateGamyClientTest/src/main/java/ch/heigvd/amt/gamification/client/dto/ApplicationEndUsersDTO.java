package ch.heigvd.amt.gamification.client.dto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author michelle
 */
public class ApplicationEndUsersDTO {
    
    private List<EndUserDTO> endUsers = new LinkedList<>();

    public long getNbEndUsers() {
        return endUsers.size();
    } 
    
    public List<EndUserDTO> getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(List<EndUserDTO> endUsers) {
        this.endUsers = endUsers;
    }    

}
