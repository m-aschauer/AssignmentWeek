package com.mortalcommand.horsefeeding.horse;

import com.mortalcommand.horsefeeding.stable.Stable;
import jakarta.persistence.*;

/**
 * Represents a horse in the system.
 */
@Entity
@Table(name = "horse")
public class Horse {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the horse

    @Column(name = "horse_name")
    private String horseName; // The name of the horse

    @Column(name = "nickname")
    private String nickname; // The nickname of the horse

    @Column(name = "guid")
    private String guid; // Global Unique Identifier for the horse

    @Column(name = "owner")
    private String owner; // The owner of the horse

    @Column(name = "breed")
    private String breed; // The breed of the horse

    @ManyToOne
    @JoinColumn(name = "stable")
    private Stable stable; // The stable where the horse is kept

    /**
     * Get the unique identifier of the horse.
     * @return The horse's unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the horse.
     * @param id The horse's unique identifier.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the horse.
     * @return The horse's name.
     */
    public String getHorseName() {
        return horseName;
    }

    /**
     * Set the name of the horse.
     * @param horseName The horse's name.
     */
    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    /**
     * Get the nickname of the horse.
     * @return The horse's nickname.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Set the nickname of the horse.
     * @param nickname The horse's nickname.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Get the Global Unique Identifier (GUID) of the horse.
     * @return The horse's GUID.
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Set the Global Unique Identifier (GUID) of the horse.
     * @param guid The horse's GUID.
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * Get the owner of the horse.
     * @return The horse's owner.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set the owner of the horse.
     * @param owner The horse's owner.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get the breed of the horse.
     * @return The horse's breed.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Set the breed of the horse.
     * @param breed The horse's breed.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Get the stable where the horse is kept.
     * @return The stable where the horse is kept.
     */
    public Stable getStable() {
        return stable;
    }

    /**
     * Set the stable where the horse is kept.
     * @param stable The stable where the horse is kept.
     */
    public void setStable(Stable stable) {
        this.stable = stable;
    }
}
