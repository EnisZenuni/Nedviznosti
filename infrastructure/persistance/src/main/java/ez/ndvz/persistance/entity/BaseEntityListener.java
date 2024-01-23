package ez.ndvz.persistance.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class BaseEntityListener {
    @PrePersist
    public void prePersist(BaseEntity entity) {
        System.out.println("Entity is being persisted: " + entity);
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        System.out.println("Entity is being updated: " + entity);
    }
}
