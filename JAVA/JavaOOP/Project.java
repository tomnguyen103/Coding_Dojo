class Project {
    private String name;
    private String description;
    private Double cost;
    
    public String elevatorPitch(){
        return (this.getName() + " ($" + Double.toString(getCost()) + ")" + " : " + this.getDescription() );
    }
    public Project(){
        this.name = "";
        this.description = "";
        this.cost = 0.00;
    }


    public Project(String name){
        this.name = name;
        this.description = "";
        this.cost = 0.00;
    }

    public Project(String name, String description){
        this.name = name;
        this.description = description;
        this.cost = 0.00;
    }

    public Project(String name, String description, Double cost){
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Double getCost(){
        return this.cost;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
    
    public void setCost(Double cost){
        this.cost = cost;
    }
    
}