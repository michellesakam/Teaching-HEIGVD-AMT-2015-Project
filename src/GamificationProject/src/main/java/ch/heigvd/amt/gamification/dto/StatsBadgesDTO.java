package ch.heigvd.amt.gamification.dto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Samira
 */
public class StatsBadgesDTO {
    
    private List<BadgeDTO> badges = new LinkedList<>();

    public List<BadgeDTO> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeDTO> badges) {
        this.badges = badges;
    }
    
    
}
