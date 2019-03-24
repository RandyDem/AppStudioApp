package com.example.appstudioapp;

import java.util.ArrayList;

public class ComputerBuild {

    private ComputerPart motherBoard = new ComputerPart(PartType.Motherboard);
    private ComputerPart processor = new ComputerPart(PartType.Processor);
    private ComputerPart memory = new ComputerPart(PartType.Memory);
    private ComputerPart gpu = new ComputerPart(PartType.GraphicsCard);

    private static ComputerBuild instance;

    public static ComputerBuild getInstance(){
        if(instance == null){
            instance = new ComputerBuild();
        }
        return instance;
    }

    private ComputerBuild(){
        initPartList();
    }

    private void initPartList() {
        motherBoard = new ComputerPart(PartType.Motherboard);
        processor = new ComputerPart(PartType.Processor);
        memory = new ComputerPart(PartType.Memory);
        gpu = new ComputerPart(PartType.GraphicsCard);
    }

    public ArrayList<ComputerPart> getAllParts(){
        ArrayList<ComputerPart> computerParts = new ArrayList();

        computerParts.add(motherBoard);
        computerParts.add(processor);
        computerParts.add(memory);
        computerParts.add(gpu);

        return computerParts;
    }

    public ComputerPart getMotherBoard(){
        return motherBoard;
    }

    public ComputerPart getMemory(){
        return memory;
    }

    public ComputerPart getProcessor(){
        return processor;
    }

    public ComputerPart getGraphicsCard(){
        return gpu;
    }

    public void addPart(ComputerPart part){
        switch(part.getPartType()){
            case Processor:
                processor = part;
                break;
            case Memory:
                memory = part;
                break;
            case Motherboard:
                motherBoard = part;
                break;
            case GraphicsCard:
                gpu = part;
                break;
            default:
                break;
        }
    }
}
