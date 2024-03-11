package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    private static Long nextId = 1L;
    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDateTime time;
    private String category;

    public Evento() {}
    public Evento(String name, String description, String address, LocalDateTime time, String category) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.address = address;
        this.category = category;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return this.time.format(formatter);
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", time=" + time +
                ", category='" + category + '\'' +
                '}';
    }
}
