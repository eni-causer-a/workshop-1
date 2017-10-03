package com.gfi.appcommercial.model;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Need {

    /**
     * Commercial name who created the sheet
     */
    private String commercialName;

    /**
     * Client company name
     */
    private String client;

    /**
     * Client name
     */
    private String contactName;

    /**
     * Need sheet title
     */
    private String title;

    /**
     * Need description
     */
    private String fullDescription;

    /**
     * Client location (manual input)
     */
    private String location;

    /**
     * Client location (GPS coordinates)
     */
    private String geolocation;

    /**
     * Need status ("Open", "Won" or "Lost")
     */
    private String status;

    /**
     * List of success factors (max 3)
     */
    private List<String> mainKeyFactors;

    /**
     * List of consultant names (max 5)
     */
    private List<String> consultants;

    /**
     * Need duration in months
     */
    private int durationMonths;

    /**
     * Frequence of days per week for the need to be satisfied
     */
    private int durationDaysPerWeek;

    /**
     * Latest date when the consultants must start working on the need
     */
    private Date startAtLastest;

    /**
     * Need sheet creation date
     */
    private Date date;

    /**
     * Map of files associatied with the need
     */
    private Map<String, File> descriptionFiles;

    public Need(String commercialName, String client, String contactName, String title, String fullDescription, String location, String geolocation, String status, List<String> mainKeyFactors, List<String> consultants, int durationMonths, int durationDaysPerWeek, Date startAtLastest, Date date, Map<String, File> descriptionFiles) {
        this.commercialName = commercialName;
        this.client = client;
        this.contactName = contactName;
        this.title = title;
        this.fullDescription = fullDescription;
        this.location = location;
        this.geolocation = geolocation;
        this.status = status;
        this.mainKeyFactors = mainKeyFactors;
        this.consultants = consultants;
        this.durationMonths = durationMonths;
        this.durationDaysPerWeek = durationDaysPerWeek;
        this.startAtLastest = startAtLastest;
        this.date = date;
        this.descriptionFiles = descriptionFiles;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getMainKeyFactors() {
        return mainKeyFactors;
    }

    public boolean addMainKeyFactor(String mainKeyFactor) {
        if (mainKeyFactors.size() < 3) {
            mainKeyFactors.add(mainKeyFactor);
            return true;
        }

        return false;
    }

    public boolean removeMainKeyFactor(String mainKeyFactor) {
        return mainKeyFactors.remove(mainKeyFactor);
    }

    public boolean setMainKeyFactors(List<String> mainKeyFactors) {
        if (mainKeyFactors.size() <= 3) {
            this.mainKeyFactors = mainKeyFactors;
            return true;
        }

        return false;
    }

    public List<String> getConsultants() {
        return consultants;
    }

    public boolean addConsultant(String consultant) {
        if (consultants.size() < 5) {
            consultants.add(consultant);
            return true;
        }

        return false;
    }

    public boolean removeConsultant(String consultant) {
        return consultants.remove(consultant);
    }

    public boolean setConsultants(List<String> consultants) {
        if (consultants.size() <= 5) {
            this.consultants = consultants;
            return true;
        }

        return false;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public int getDurationDaysPerWeek() {
        return durationDaysPerWeek;
    }

    public void setDurationDaysPerWeek(int durationDaysPerWeek) {
        this.durationDaysPerWeek = durationDaysPerWeek;
    }

    public Date getStartAtLastest() {
        return startAtLastest;
    }

    public void setStartAtLastest(Date startAtLastest) {
        this.startAtLastest = startAtLastest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, File> getDescriptionFiles() {
        return descriptionFiles;
    }

    public void setDescriptionFiles(Map<String, File> descriptionFiles) {
        this.descriptionFiles = descriptionFiles;
    }
}
