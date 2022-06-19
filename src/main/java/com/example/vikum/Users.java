package com.example.vikum;

// Model file equivalent
// to MySQL table Users
public class Users {
    private int id;
    private int im;
    private String name, dob,path,company;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIm() { return im; }

    public void setIm(int im)
    {
        this.im = im;
    }

    public String getDob()
    {
        return dob;
    }

    public void
    setDob(String dob)
    {
        this.dob = dob;
    }

    public String getPath()
    {
        return path;
    }

    public void
    setPath(String path)
    {
        this.path = path;
    }

    public String getCompany()
    {
        return company;
    }

    public void
    setCompany(String company)
    {
        this.company = company;
    }
}
