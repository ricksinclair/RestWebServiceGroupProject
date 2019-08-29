package com.company.U1M6Summative.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private int itemId;
    @NotEmpty(message = "must include name")
    @Size(max = 50, message = "must be at most 50")
    private String name;
    @NotEmpty(message = "must include description")
    @Size(max=255, message = "description length must be 255 characters or lower")
    private String description;
    @NotEmpty(message = "Must include dailyRate")
    private BigDecimal dailyRate;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId == item.itemId &&
                name.equals(item.name) &&
                description.equals(item.description) &&
                dailyRate.equals(item.dailyRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, description, dailyRate);
    }
}
