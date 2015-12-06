package ch.heigvd.amt.gamification.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name = "awards")
public abstract class Action<T> extends AbstractDomainModelEntity<Long> {  

    public abstract T getAwardValue();
    public abstract String getType();
    
}
