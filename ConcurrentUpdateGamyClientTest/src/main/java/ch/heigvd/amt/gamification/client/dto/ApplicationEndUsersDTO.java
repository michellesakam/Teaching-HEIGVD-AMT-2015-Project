package ch.heigvd.amt.gamification.client.dto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author michelle
 */
public class ApplicationEndUsersDTO {
    
    private long nbEndUsers;
    private List<EndUserDTO> endUsers = new LinkedList<>();

    public long getNbEndUsers() {
        return nbEndUsers;
    }

    public void setNbEndUsers(long nbEndUsers) {
        this.nbEndUsers = nbEndUsers;
    }   
    
    public List<EndUserDTO> getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(List<EndUserDTO> endUsers) {
        this.endUsers = endUsers;
    }    

}
