package ch.heigvd.amt.gamification.dto.stats;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author michelle
 */
public class StatsEndUserBadgesDTO {
    
    /**
     * List of winned badges (name and number)
     */
    private List< Entry<Integer, String> > badgesAwarded
            = new LinkedList<>();

    public List<Entry<Integer, String>> getBadgesAwarded() {
        return badgesAwarded;
    }

    public void setBadgesAwarded(List<Entry<Integer, String>> badgesAwarded) {
        this.badgesAwarded = badgesAwarded;
    }    
    
}
