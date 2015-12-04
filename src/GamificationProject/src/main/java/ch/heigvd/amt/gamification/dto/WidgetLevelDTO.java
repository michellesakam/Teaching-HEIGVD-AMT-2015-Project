package ch.heigvd.amt.gamification.dto;

/**
 *
 * @author Samira
 */
public class WidgetLevelDTO {
    private String nextLevelName;
    private String currentLevelName;
    private long currentPoints;
    private long pointsForNextLevel;

    public String getNextLevelName() {
        return nextLevelName;
    }

    public void setNextLevelName(String nextLevelName) {
        this.nextLevelName = nextLevelName;
    }

    public String getCurrentLevelName() {
        return currentLevelName;
    }

    public void setCurrentLevelName(String currentLevelName) {
        this.currentLevelName = currentLevelName;
    }

    public long getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(long currentPoints) {
        this.currentPoints = currentPoints;
    }

    public long getPointsForNextLevel() {
        return pointsForNextLevel;
    }

    public void setPointsForNextLevel(long pointsForNextLevel) {
        this.pointsForNextLevel = pointsForNextLevel;
    }
    
    
}
