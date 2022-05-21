package get_http_request.day08;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest19 extends DummyBaseUrl {
    /*
     http://dummy.restapiexample.com/api/v1/employees
    1) Status kodunun 200,
    2) 10'dan büyük tüm id'leri ekrana yazdırın ve 10'dan büyük id olduğunu
    3) 30'dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaxın 23 olduğunu
    4) Maaşı 350000 den büyük olan tüm employee name'leri ekrana yazdırın ve bunların içerisinde "Charde Marshall" olduğunu test edin
     */

@Test
    public void test19(){
  // URL OLUSTUR
    spek02.pathParams("1", "api", "2", "v1", "3", "employees");

    //http://dummy.restapiexample.com requesten önceki adresimiz.
    Response response = given().spec(spek02).when().get("/{1}/{2}/{3}");
    //"/{1}/{2}/{3}" -> /api/v1/employees
    //http://dummy.restapiexample.com/api/v1/employees

    response.prettyPrint();

    //1) Status kodunun 200,
    Assert.assertEquals(200,response.statusCode());
    response.then().assertThat().statusCode(200); //bu şekilde de olabilir
    // 2) 10'dan büyük tüm id'leri ekrana yazdırın ve 10'dan büyük id olduğunu
                 // Not:  API de basit groovy komutları kullanıp if kullanmadan for each kullanmadan bu işlemleri bir cümleyle yapabiliyorum.

    JsonPath json = response.jsonPath();
    List<Integer> idList=json.getList("data.findAll{it.id>10}.id");
    //"data.id.findAll{it>10}" bu şekilde de yazılabilir
    System.out.println("İd List:"+ idList);

            //groovy dilinde data.fintAll data icersindeki hepsini bul demek. sonra bir fonksiyon tanımlıyoruz javanın bir alt dili olan groovy dili ile data.findAll{it.id<10} id si
            //10 dan büyükleri getir demek "it" başlangıç için kullanılır if yerine bu "data.findAll{it.id<10}" basit kodu kullanıyoruz
            // Groovy java platformu üzerinde calışan bir bilgisayar dilidir.
            //Groovy ile loop kullanmadan response'dan gelen değerleri bir şarta göre alabiliriz.


    // 3) 30'dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu

    List<Integer> yasList=json.getList("data.findAll{it.employee_age<30}.employee_age");
    System.out.println(yasList);

    Collections.sort(yasList);
    Assert.assertEquals(23, (int) yasList.get(yasList.size()-1));
    //Assert.assertEquals((Integer) 23,  yasList.get(yasList.size()-1)); böyle de olur
    // Assert.assertTrue(yasList.get(yasList.size()-1)==23); bu da olur


    // 4) Maaşı 350000 den büyük olan tüm employee name'leri ekrana yazdırın ve bunların içerisinde "Charde Marshall" olduğunu test edin

    List<Integer> salaryList= json.getList("data.findAll{it.employee_salary>350000}.employee_name");
    System.out.println(salaryList);

    Assert.assertTrue(salaryList.contains("Charde Marshall"));
}
}
