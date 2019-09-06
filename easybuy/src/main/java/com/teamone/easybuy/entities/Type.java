package com.teamone.easybuy.entities;

public class Type {
    private  int id;
    private String name;
    private int pid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setName(String typeName) {
        this.name = typeName;
    }
    public Type(){

    }
    public Type(String typeName,int pid){
        this.name=typeName;
        this.pid=pid;
    }
    public Type(int id,String typeName,int pid){
        this.id=id;
        this.name=typeName;
        this.pid=pid;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                '}'+"\n";
    }
}
