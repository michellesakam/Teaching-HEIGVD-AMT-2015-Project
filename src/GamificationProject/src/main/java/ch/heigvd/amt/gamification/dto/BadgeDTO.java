package ch.heigvd.amt.gamification.dto;

/**
 *
 * @author Samira
 */
public class BadgeDTO extends GamificationDTO {
    
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
    
}
