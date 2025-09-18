Public class Aluno{
  private int id;
  private String nome;
  private String email;

public Aluno(int id, String nome, String email){
  this.id = id;
  this.nome = nome;
  this.email = email;
  }
  public int getID(){
    return id
  }
  public void setID(int id){
    this.id = id;
  }
}
