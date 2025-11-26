package edu.ucu.task3;

public class ProxyImage implements MyImage{
    private String filename;
    private RealImage realImage;

    public ProxyImage(String file){
        this.filename = file;
    }

    @Override
    public void display(){
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }

}
