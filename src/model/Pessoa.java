package model;

public class Pessoa {
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private static int cont=0;

    public Pessoa() {
    }

    public Pessoa(String name, String cpf, String email) {
        cont+=1;
        this.id=cont;
        this.name = name;
        this.cpf = cpf;
        this.email = email;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
        if(name==null){
        throw new Exception("Nome invalido");
    }else{
        this.name = name;
    }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
