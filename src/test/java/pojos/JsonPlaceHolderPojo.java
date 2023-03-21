package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)// id tanimlanmadi fazla data var diye hata almistik , burda ignore ediyoruz,asaidaki tanimlanan data disinda data istendigi zaman ignore diyoruz

public class JsonPlaceHolderPojo {
   private Integer userId ;
   private String title;
   private Boolean completed;

    public JsonPlaceHolderPojo() {   //Json JAckosn objectMapper gibi de serialization icin kullaniclak olan default constructor,  Parametreli constructor default constructorı siler

    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;   //obje olusturdum
        this.title = title;
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {  //alma yazdirma icin ,  terminalde görünen veri toString metodundan mı geliyor ,olmasaydi hashcpde gelirdi
        return
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
