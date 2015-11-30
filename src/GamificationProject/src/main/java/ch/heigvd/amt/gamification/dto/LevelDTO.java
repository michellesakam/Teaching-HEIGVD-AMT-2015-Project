package ch.heigvd.amt.gamification.dto;

/**
 *
 * @author Raphaël Racine
 */
public class LevelDTO implements IGamificationDTO {
    
    private Long id;
    private String name;
    private int minimumPoints;
    
    public LevelDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumPoints() {
        return minimumPoints;
    }

    public void setMinimumPoints(int minimumPoints) {
        this.minimumPoints = minimumPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }       
    
}
