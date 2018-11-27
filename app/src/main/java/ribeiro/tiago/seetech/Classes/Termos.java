package ribeiro.tiago.seetech.Classes;

public class Termos {
    private int img;
    private int video;
    private String nome;
    private String descricao;

    public Termos(String nome, String descricao, int img, int video){
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setImg(img);
        this.setVideo(video);
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
