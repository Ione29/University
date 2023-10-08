class Author
{
    private String name,email,gender;

    public Author(String name, String email, String gender)
    {
        this.name=name;
        this.email=email;
        this.gender=gender;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getGender(){
        return gender;
    }
    public String toString(){
        return(this.name + " (" + this.gender + ") at " + this.email);
    }
}