package MainPackage;

public class SubClass extends ParentClass{
    public void reassign(){
        this.var = "Assigned in Subclass";
        System.out.println(var);
    }
}
