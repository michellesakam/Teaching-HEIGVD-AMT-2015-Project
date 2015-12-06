package ch.heigvd.amt.gamification.dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Raphaël Racine
 */
public class StatsPointsDTO {    
    
    private long totalPoints;
    private Map<Integer, Long> pointsPerPeriod = new HashMap<>();

    public long getTotalPeriods() {
        long total = 0;
        
        for(Long l : pointsPerPeriod.values())
            total += l;
        
        return total;
    }

    public long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Map<Integer, Long> getPointsPerPeriod() {
        return pointsPerPeriod;
    }

    public void setPointsPerPeriod(Map<Integer, Long> pointsPerPeriod) {
        this.pointsPerPeriod = pointsPerPeriod;
    }
    
        
            
}
