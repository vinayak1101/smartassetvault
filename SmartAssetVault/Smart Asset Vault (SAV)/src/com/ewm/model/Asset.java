package com.ewm.model;

public class Asset {
    private String assetId;
    private String assetName;
    private String category;
    private String status;        // AVAILABLE / PENDING / ASSIGNED
    private String assignedTo;    // user email (or empty)
    private String assignedDate;  // simple string for UI

    public Asset() {}

    public Asset(String assetId, String assetName, String category,
                 String status, String assignedTo, String assignedDate) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.category = category;
        this.status = status;
        this.assignedTo = assignedTo;
        this.assignedDate = assignedDate;
    }

    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    public String getAssetName() { return assetName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }

    public String getAssignedDate() { return assignedDate; }
    public void setAssignedDate(String assignedDate) { this.assignedDate = assignedDate; }
}
