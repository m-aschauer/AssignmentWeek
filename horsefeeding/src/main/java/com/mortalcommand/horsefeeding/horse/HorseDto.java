package com.mortalcommand.horsefeeding.horse;

/**
 * Data Transfer Object (DTO) representing information about a horse.
 */
public class HorseDto {

    private Long id; // The unique identifier of the horse.
    private String guid; // Global Unique Identifier (GUID) for the horse.
    private String name; // The name of the horse.
    private String nickname; // The nickname of the horse.
    private String owner; // The owner of the horse.
    private String breed; // The breed of the horse.
    private String stableName; // The name of the stable where the horse is kept.

    /**
     * Get the unique identifier of the horse.
     * @return The unique identifier of the horse.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the horse.
     * @param id The unique identifier of the horse.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the Global Unique Identifier (GUID) for the horse.
     * @return The Global Unique Identifier (GUID) for the horse.
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Set the Global Unique Identifier (GUID) for the horse.
     * @param guid The Global Unique Identifier (GUID) for the horse.
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * Get the name of the horse.
     * @return The name of the horse.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the horse.
     * @param name The name of the horse.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the nickname of the horse.
     * @return The nickname of the horse.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Set the nickname of the horse.
     * @param nickname The nickname of the horse.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Get the owner of the horse.
     * @return The owner of the horse.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set the owner of the horse.
     * @param owner The owner of the horse.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get the breed of the horse.
     * @return The breed of the horse.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Set the breed of the horse.
     * @param breed The breed of the horse.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Get the name of the stable where the horse is kept.
     * @return The name of the stable where the horse is kept.
     */
    public String getStableName() {
        return stableName;
    }

    /**
     * Set the name of the stable where the horse is kept.
     * @param stableName The name of the stable.
     */
    public void setStableName(String stableName) {
        this.stableName = stableName;
    }
}
