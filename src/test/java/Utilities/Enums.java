package Utilities;
//enum is special class in java which has collection of constants and methods
public enum Enums{
    addPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    private String apiResource;
    Enums(String apiResource) {
        this.apiResource =apiResource;
    }
    public String getResource(){
        return apiResource;
    }
}
