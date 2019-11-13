package de.tum.in.www1.pse.rest.server;

public class RESTServer {

    public static void main(String[] args) {
    	
    	System.out.println("RESTServer started ...");
    	ModelStorage.createSampleModel();
    	BookResource.startResource();
    	LibraryResource.startResource();
    	UserResource.startResource();	
    }
}
