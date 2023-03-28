package test_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZippopotamTestData {
//     "place name": "Vitoria-Gasteiz",
//             "longitude": "-2.6667",
//             "state": "Pais Vasco",
//             "state abbreviation": "PV",
//             "latitude": "42.85"

    public List<Map<String,String>> expectedInMethod(String placename , String longitude, String state, String latitude){
     Map<String,String> map= new HashMap<>();
     map.put("place name","placename");
     map.put("longitude","longitude");
        map.put("state","state");
        map.put("latitude","latitude");

        List<Map<String,String>> list= new ArrayList<>();
        list.add(map);

        return list;

    }

    public Map<String,Object> expectedDataMethod (String postcode,String country, String countryabbreviation, List<Map<String,String>> places ) {

        Map<String, Object> expectedData = new HashMap<>();

        expectedData.put("post code", postcode);
        expectedData.put("country", country);
        expectedData.put("country abbreviation", countryabbreviation);
        expectedData.put("places", places);
        return expectedData;

    }
}

