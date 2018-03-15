
public class Cliente {

    private String nome;
    private String cpf;
    private String endereco;
    private String sexo;
    private String tipo;
    private String comunicados;
    private String obs;

    public Cliente(String nome, String cpf, String endereco, String sexo, String tipo, String comunicados, String obs) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.sexo = sexo;
        this.tipo = tipo;
        this.comunicados = comunicados;
        this.obs = obs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComunicados() {
        return comunicados;
    }

    public void setComunicados(String comunicados) {
        this.comunicados = comunicados;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }     
}
