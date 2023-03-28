package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {

    //generic methodlar devreye giriyor test classında exception istemiyoruz bu yuzden baska bir class da exception ı try
    //catch ile handle edecegiz
    //readvalue(1,2)  --> 1. datayi alir 2. data tipine cevirir

    //<T> T ==> Herhangi bir data tipi
    //ObjectMapper().readValue(json, cls) methodu birinci parametrede aldığı String formatındaki Json datyı
    // ijkinci parametrede belitilen Java objesine çevirir.

    public static <T> T convertJsonToJava(String json, Class<T> cls) {//Generic Method

        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
