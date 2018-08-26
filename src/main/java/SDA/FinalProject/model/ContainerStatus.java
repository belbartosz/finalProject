package SDA.FinalProject.model;

public enum ContainerStatus {
    ORDERED("ordered"),PLANNED("planned"),DEPARTURED("departured"),DISCHARGED("discharged"),DELIVERED("delivered");

    private final String displayName;

    ContainerStatus(String displayName) {
        this.displayName = displayName;
    }
}
