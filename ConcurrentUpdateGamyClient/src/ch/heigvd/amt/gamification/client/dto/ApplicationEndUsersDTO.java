package ch.heigvd.amt.gamification.client.dto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author michelle
 */
public class ApplicationEndUsersDTO {
    
    private long nbEndUsers;
    private List<EndUserDTO> endusers = new LinkedList<>();

    public long getNbEndUsers() {
        return nbEndUsers;
    }

    public void setNbEndUsers(long nbEndUsers) {
        this.nbEndUsers = nbEndUsers;
    }
    
    public void setEndUsers(EndUserDTO enduser){
        if(!endusers.contains(enduser))
        endusers.add(enduser);
    }
    
    public List<EndUserDTO> getEndUsers(){
        return endusers;
    }

}
